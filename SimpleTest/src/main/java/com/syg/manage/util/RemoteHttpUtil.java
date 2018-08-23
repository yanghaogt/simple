package com.syg.manage.util;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class RemoteHttpUtil {
	
	private final static int READ_BODY_SIZE = 5120;
	
	public static String urlPost(String strUrl, String content){
		return urlPost(strUrl, content, "UTF-8");
	  }

	public static String urlPost(String strUrl, String content, String charset){
		try {
			URL url = new URL(strUrl);
		    HttpURLConnection con = (HttpURLConnection) url.openConnection();
		    con.setDoInput(true);
		    con.setDoOutput(true);
		    con.setAllowUserInteraction(false);
		    con.setUseCaches(false);
		    con.setRequestMethod("POST");
		    con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset="  + charset);
		    BufferedWriter bout = new BufferedWriter(new OutputStreamWriter(con.getOutputStream()));
		    bout.write(content);
		    bout.flush();
		    bout.close();
		    return streamReadHtml(con.getInputStream());
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		
	  }
	
    public static String urlGet(String strUrl){
        try {
            URL url = new URL(strUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setDoInput(true);
            con.setDoOutput(true);
            con.setAllowUserInteraction(false);
            con.setUseCaches(false);
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
            BufferedWriter bout = new BufferedWriter(new OutputStreamWriter(con.
                    getOutputStream()));
            bout.flush();
            bout.close();
            return streamReadHtml(con.getInputStream());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }
	
	private static String streamReadHtml(InputStream istream) throws UnsupportedEncodingException{
		String html = "";
		byte[] responseBody = new byte[READ_BODY_SIZE];
		int npos = 0;
		int nread = 0;
		try {
			while ((nread = istream.read(responseBody, npos,
					responseBody.length - npos)) >= 0) {
				npos += nread;
				byte[] tmpBuf = new byte[npos + READ_BODY_SIZE];
				System.arraycopy(responseBody, 0, tmpBuf, 0, npos);
				responseBody = tmpBuf;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try{
				if(istream != null){
					istream.close();
				}
				istream = null;
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		html = new String(responseBody, 0, npos , "UTF-8");
		return html;
	}
	
	public static String getStringByRegex(String html , String regex){
		 String sensitive = "";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(html);
        while (matcher.find()) {
           sensitive += matcher.group(1);
        }
        return sensitive;
	}
}
