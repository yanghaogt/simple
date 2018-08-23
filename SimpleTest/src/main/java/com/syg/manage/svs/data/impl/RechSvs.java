package com.syg.manage.svs.data.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.syg.manage.dao.manage.CdkeyMapper;
import com.syg.manage.dao.manage.HolidayMpr;
import com.syg.manage.dao.manage.MailMpr;
import com.syg.manage.dao.manage.PlayerMapper;
import com.syg.manage.dao.manage.PointMapMapper;
import com.syg.manage.dao.manage.PointMapper;
import com.syg.manage.exception.BaseException;
import com.syg.manage.model.manage.Cdkey;
import com.syg.manage.model.manage.Holiday;
import com.syg.manage.model.manage.Mail;
import com.syg.manage.model.manage.Point;
import com.syg.manage.model.manage.PointMap;
import com.syg.manage.model.manage.RedisUser;
import com.syg.manage.pagination.Pagination;
import com.syg.manage.svs.data.IRechSvs;
import com.syg.manage.util.Excel;
import com.syg.manage.util.ExcelUtil;
import com.syg.manage.util.MailHelper;
import com.syg.manage.util.redis.RedisUserMapper;

@Service
public class RechSvs implements IRechSvs {
	
	private final static Logger logger = LoggerFactory.getLogger(RechSvs.class);
	@Resource
	private CdkeyMapper cdkeyMapper;
	@Resource
	private PlayerMapper playerMapper;
	@Resource
	private PointMapper pointMapper;
	@Resource
	private PointMapMapper pointMapMapper;
	@Resource
	private HolidayMpr holidayMpr;
	@Resource
	private RedisUserMapper redisUserMapper;
	@Resource
	private MailMpr mailMpr;
	private static String mailActTemp;
	
	static{
		try {
			org.springframework.core.io.Resource res = new ClassPathResource("mail_act.conf");
			byte[] bytes = new byte[10240];
			int len = res.getInputStream().read(bytes);
			mailActTemp = new String(Arrays.copyOf(bytes, len) , "utf-8");
		} catch (Exception e) {
		}
	}
	@Override
	public List<Cdkey> searchCdkey() {
		List<Cdkey> items=cdkeyMapper.queryAll();
		return items;
	}

	@Override
	public void searchCdkey(Pagination page, Cdkey example) {
		page.getItems().addAll(cdkeyMapper.queryListPageSearch(page, example));
	}

	@Override
	public void searchPoint(Pagination page, Point example) {
		page.getItems().addAll(pointMapper.queryListPageSearch(page, example));
	}

	@Override
	public void searchPointMap(Pagination page, PointMap example) {
		page.getItems().addAll(pointMapMapper.queryListPageSearch(page, example));
	}

	@Override
	public void createCdkeyExcel(Cdkey example, HttpServletResponse resp) {
		Pagination pagination = new Pagination();
		pagination.setShowCount(65535);
		//1.查询数据
		List<Cdkey> codeLists = cdkeyMapper.queryListPageSearch(pagination, example);
		//2.创建excel对象
		Excel[] excels = new Excel[6];
		excels[0] = new Excel(1, 30 , "key" , "key");
		excels[1] = new Excel(2, 30 , "classId" , "类ID");
		excels[2] = new Excel(3, 30 , "createDate" , "生成时间");
		excels[3] = new Excel(4, 30 , "stateStr" , "当前状态");
		excels[4] = new Excel(5, 30 , "useDate" , "使用时间");
		excels[5] = new Excel(6, 30 , "uid" , "使用者id");
		//3.导出数据
		ExcelUtil.createExcel(excels, codeLists, this.getClass(), "礼包码", resp);
	}

	@Override
	public void searchHoliday(Pagination page, Holiday example) {
		page.getItems().addAll(holidayMpr.queryListPageSearch(page, example));
	}

	@Override
	public void addUser(RedisUser example) {
		example.setRegTime(new Date());
		example.setLastLoginUpdateTime(new Date());
		example.setLastLoginTime(new Date());
		redisUserMapper.saveUser(example.getLastLoginLogId(), example);
	}

	@Override
	public void searchUser(String Id, ModelMap mm) {
		RedisUser ru = redisUserMapper.findUser(Id);
		mm.put("example", ru);
		mm.put("Id", Id);
	}

	@Override
	public void addMail(Mail mail) {
		if (mail.getEmail() == null || mail.getEmail().equals("")) {
			throw new BaseException("请输入邮箱号");
		}
		String content = mail.getContent();
		logger.info("测试用激活连接[{}]",content);
		String msgCtn = String.format(mailActTemp, content);
		String title = mail.getTitle();
		mail.setSendTime(new Date());
		try {
			mailMpr.saveItem(mail);
			MailHelper.sendMail(mail.getEmail(),msgCtn, title);
		} catch (Exception e) {
			throw new BaseException("发送失败!");
		}
	}

	@Override
	public void searchMail(Pagination page, Mail example) {
		page.getItems().addAll(mailMpr.queryListPageSearch(page, example));
	}

}
