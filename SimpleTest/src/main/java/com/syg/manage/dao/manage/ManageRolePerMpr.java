package com.syg.manage.dao.manage;

import java.util.List;

import com.syg.manage.model.manage.ManageRolePer;


public interface ManageRolePerMpr {
	public void saveItem(ManageRolePer item);
	public List<ManageRolePer> queryByMrId(Integer mrId);
	public int deleteByMrpId(int mprId);
}
