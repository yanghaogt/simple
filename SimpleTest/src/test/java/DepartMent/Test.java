package DepartMent;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.alibaba.fastjson.JSONArray;

public class Test {
	public final static int LIMIT = 2000 ;
	public static void main(String[] args) {
//		int cur =1000;
//		Scanner input = new Scanner(System.in);
//		while (input.hasNextInt()) {
//			int order = input.nextInt();
//			int sum = order+cur;
//			if (order >0 && sum<=LIMIT && sum>0) {
//				System.out.println("预定成功"+order+"个");
//			}else {
//				System.out.println("超过期限，预定失败！");
//			}
//		}
		
		List<Dept> listDepts = new ArrayList<>();
		List<Dept> listchildrens = new ArrayList<>();
		Dept dept1 = new Dept();
		dept1.setId(1);
		dept1.setName("公司");
		Dept dept2 = new Dept();
		dept2.setId(2);
		dept2.setName("财务部");
		dept2.setParent(dept1);
		Dept dept3 = new Dept();
		dept3.setId(3);
		dept3.setName("IT部");
		dept3.setParent(dept1);
		listDepts.add(dept1);
		listchildrens.add(dept2);
		listchildrens.add(dept3);
		dept1.setChildren(listchildrens);
		JSONArray jsonArray = new JSONArray();
		jsonArray.add(dept1);
		System.out.println(jsonArray);
	}
}
