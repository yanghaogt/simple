package com.syg.manage.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import redis.clients.jedis.Jedis;

public class Redis {

	public static void main(String[] args) {
	      //连接本地的 Redis 服务
	      Jedis jedis = new Jedis("192.168.2.124",6380);//默认端口6379
	      jedis.auth("pksg2011");
	      //string
	      jedis.set("runoobkey", "Redis tutorial");
	      System.out.println("runoobkey: "+ jedis.get("runoobkey"));
	      
	      //list
	      jedis.lpush("tutorial-list", "Redis");
	      jedis.lpush("tutorial-list", "Mongodb");
	      jedis.lpush("tutorial-list", "Mysql");
	      List<String> list = jedis.lrange("tutorial-list", 0 ,5);
	      for(int i = 0; i<list.size(); i++) {
	         System.out.println("tutorial-list: "+list.get(i));
	      }
	      
	      //Hash
	      jedis.hset("web:4", "google", "www.google.cn");
	      jedis.hset("web:4", "baidu", "www.baidu.com");
	      jedis.hset("web:4", "sina", "www.sina.com");
	      List list4 = jedis.hmget("web:4","google","baidu","sina");
	      for(int i=0;i<list4.size();i++){
	    	  System.out.println(list4.get(i));
	      }
	      //Hash all
	      Map<String,String> map = jedis.hgetAll("web:4");
	      for(Map.Entry entry: map.entrySet()) {
	    	  System.out.print(entry.getKey() + ":" + entry.getValue() + "\n");
	      }
	      
	      //Hash map
	      Map map5 = new HashMap();   
	      map5.put("cardid", "123456");
	      map5.put("username", "jzkangta");
	      jedis.hmset("web:5", map5);
	      System.out.println(jedis.hget("web:5", "username"));
	 }
	
}
