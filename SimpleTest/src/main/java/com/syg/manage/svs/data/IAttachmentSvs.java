/**
 * 
 */
package com.syg.manage.svs.data;

import java.util.Date;

import com.syg.manage.model.manage.Attachment;

public interface IAttachmentSvs {

	public void insert(Integer refId, Integer createUserId, String path, String name,Integer status, String title,Integer attachType,Date createTime);
	
	public void delete(Integer empId, Integer attachId, Integer attachType);
	
	public Attachment selectAttachment(int refId,int attachType);
}
