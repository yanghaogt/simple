/**
 * 
 */
package com.syg.manage.svs.data.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.syg.manage.dao.manage.AttachmentMapper;
import com.syg.manage.model.manage.Attachment;
import com.syg.manage.svs.data.IAttachmentSvs;

/**
 * 
 * @author Jarry
 * @created 2015-8-12 下午7:53:48
 */
@Service
public class AttachmentSvs implements IAttachmentSvs {

	@Resource
	private AttachmentMapper attachmentMapper;
	@Override
	public void insert(Integer refId, Integer createUserId, String path,String name, Integer status, String title,Integer attachType, Date createTime) {
		Attachment attachment = attachmentMapper.selectByRefId(refId, attachType);
		if (attachment == null) {
			Attachment record = new Attachment();
			record.setRefId(refId);
			record.setCreateUserId(createUserId);
			record.setPath(path);
			record.setName(name);
			record.setTitle(title);
			record.setStatus(status);
			record.setCreateTime(createTime);
			record.setAttachType(attachType);
			attachmentMapper.insert(record);
		}else if (attachment.getName() != name) {
			attachmentMapper.updateByRefId(refId, attachType, name);
		}
	}

	@Override
	public void delete(Integer empId, Integer attachId, Integer attachType) {
		attachmentMapper.deleteByPrimaryKey(empId, attachId, attachType);
	}

	@Override
	public Attachment selectAttachment(int refId, int attachType) {
		return attachmentMapper.selectByRefId(refId, attachType);
	}

}
