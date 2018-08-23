package com.syg.manage.dao.manage;

import java.util.List;

import com.syg.manage.model.manage.Cdkey;
import com.syg.manage.model.manage.Point;
import com.syg.manage.model.manage.PointMap;
import com.syg.manage.pagination.Pagination;

public interface PointMapMapper {

	public List<PointMap> queryListPageSearch(Pagination page,PointMap example);
}
