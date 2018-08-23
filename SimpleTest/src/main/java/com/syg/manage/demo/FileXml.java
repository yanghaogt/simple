package com.syg.manage.demo;

import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.syg.manage.util.FileUtil;

public class FileXml {
	
	private final static Logger logger = LoggerFactory.getLogger(FileXml.class);
	
	public static final String regex = "\\$\\{[a-zA-Z0-9#.]*?\\}";
	
	/**替换xml中字符串*/
	private static void replaceXmlPageName(File f,String replaceName,String packName){
		String str = FileUtil.readFileStr(f.getAbsolutePath());
		//com.slot.lebian
		if(str.contains(packName)){
			//替换包名的
			logger.info("authorities=\""+replaceName);
			logger.info("authorities=\""+packName);
			str = str.replaceAll("authorities=\""+replaceName, "authorities=\""+packName);
			logger.info("{}","replaceXmlPageName 文件：\n"+str);
		}
		FileUtil.write2File(str, f.getAbsolutePath());
	}
	
	private static void findAndReplace(File f,String replaceParam){
		String str = FileUtil.readFileStr(f.getAbsolutePath());
		if (str.contains("quicksdk_packName")) {
			str = str.replaceAll("quicksdk_packName", replaceParam);
		}
		if(str.contains("com.slot.lebian")){
			str = str.replaceAll("com.slot.lebian", replaceParam);
			logger.info("{}","替换后文件：\n"+str);
		}
		//写回去
		logger.info(f.getAbsolutePath());
		FileUtil.write2File(str, f.getAbsolutePath());
	}
	
	/**写xml */
	public boolean doc2XmlFile(Document document, String filename) {
		boolean flag = true;
		try {
			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer transformer = tFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(new File(filename));
			transformer.transform(source, result);
		} catch (Exception ex) {
			flag = false;
			ex.printStackTrace();
		}
		return flag;
	}
	
	/**获取xml节点*/
	public static Document load(String filename) {
		Document document = null;
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			document = builder.parse(new File(filename));
			document.normalize();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return document;
	}
	
	/**解析xml文件*/
	public static String toFormatedXML(Document object) throws Exception {  
        Document doc = (Document) object;
        TransformerFactory transFactory = TransformerFactory.newInstance();
        Transformer transFormer = transFactory.newTransformer();
        transFormer.setOutputProperty(OutputKeys.ENCODING, "GB2312");
        DOMSource domSource = new DOMSource(doc);
        StringWriter sw = new StringWriter();
        StreamResult xmlResult = new StreamResult(sw);
        transFormer.transform(domSource, xmlResult);
        return sw.toString();
    }
	
	/** 操作xml节点 */
	public static void getGamePerMapAndDel(Document docGame) {
		Map<String, String> perMap = new HashMap<String, String>();
		//获取根节点  manifest
		Node root = docGame.getDocumentElement();
		Node pkgAttr = root.getAttributes().getNamedItem("package");
		pkgAttr.setTextContent("www.baidu.com");
		if (root.hasChildNodes()) {
			List<Node> delNode = new ArrayList<Node>();
			//获取子节点 application uses-permission
			NodeList oneList = root.getChildNodes();
			for (int o = 0; o < oneList.getLength(); o++) {
				Node one = oneList.item(o);
				if (one.getNodeName().toLowerCase().equals("uses-permission".toLowerCase())) {
					perMap.put(one.getAttributes().item(0).getTextContent(), "");
					delNode.add(one);
				}
			}
			//删除节点
			for (Node node : delNode) {
				root.removeChild(node);
			}
		}
	}
	
	/** 加入权限节点 */
	public void addGamePer(Document docGame,Map<String, String> perMap,Map<String, String> appMetaMap){
		Node root = docGame.getDocumentElement();
		//根节点 添加节点
		for (String perStr : perMap.keySet()) {
			Element ele = docGame.createElement("uses-permission");
			ele.setAttribute("android:name", perStr);
			root.appendChild(ele);
		}
		//子节点 添加节点
		if (root.hasChildNodes()) {
			NodeList oneList = root.getChildNodes();
			for (int o = 0; o < oneList.getLength(); o++) {
				Node one = oneList.item(o);
				if (one.getNodeName().toLowerCase().equals("application".toLowerCase())) {
					for (String metaKey : appMetaMap.keySet()) {
						Element ele = docGame.createElement("meta-data");
						ele.setAttribute("android:name", metaKey);
						ele.setAttribute("android:value", appMetaMap.get(metaKey));
						one.appendChild(ele);
					}
					break;
				}
			}
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		//findAndReplace(new File("E:\\测试结果\\AndroidManifest.xml"), "com.slot.alert");
		//Document docGame = load("E:\\测试结果\\AndroidManifest.xml");
		//logger.info("{}","第二次处理："+toFormatedXML(docGame));
		//replaceXmlPageName(new File("E:\\测试结果\\AndroidManifest.xml"), "com.kuaiyu","com.kuaiyu.wmdsc");
		
		Document docGame = load("E:\\测试结果\\AndroidManifest.xml");
		getGamePerMapAndDel(docGame);
		
	}
	
}
