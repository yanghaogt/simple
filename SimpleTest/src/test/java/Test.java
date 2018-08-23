

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.syg.common.util.CaesarUtil;

public class Test {

	public static void main(String[] args) {
		CaesarUtil util = new CaesarUtil(4);
		Resource res = new ClassPathResource("init.cla");
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(res.getInputStream()));
			String content;
			while ((content = reader.readLine()) != null) {
//				System.out.println(util.encrypt(content));
				System.out.println(util.decrypt(content));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
