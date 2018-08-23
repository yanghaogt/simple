package com.syg.manage.demo;

/**
 * 批处理
 * @author yanghao
 */
public class BatchProces {
	
	/**
	int dataLimit = 200;//限制条数
	Integer dataSize = codelist.size();
	int part = dataSize/dataLimit;//分批数
	System.out.println("共有： "+dataSize+"条，！"+"分为："+part+"批");
	for (int i = 0; i <= part; i++) {
		int maxSize=dataLimit*(i+1);
		if (i==part || maxSize ==dataSize) {
			maxSize=dataSize;
		}
		if (maxSize > i*dataLimit) {
			System.out.println(i+"次："+(i*dataLimit)+","+maxSize);
			List<String> listpart = codelist.subList(i*dataLimit, maxSize);
			//插入ZActivationCode
			activationCodeMpr.addZActivationCode(example,listpart);	
			//插入MActivityCode
			Mactivitycode record=new Mactivitycode();
			record.setCardid(cId);
			mactivitycodeMapper.insert(record,listpart);
		}
	}
	*/
	
	/**
	 * 批量插入
	<insert id="addZActivationCode">
		INSERT INTO ZActivationCode
		(
		id,
		code,
		type,
		channel,
		rewardA,
		rewardB,
		rewardC,
		cardId
		)VALUES
		<foreach collection="codeList" item="item" index="index" separator="," >
	    (
			#{example.id},
			#{item},
			#{example.type},
			#{example.channel},
			#{example.rewardA},
			#{example.rewardB},
			#{example.rewardC},
			#{example.cardId}
		)
		</foreach>
	</insert>
	*/
}
