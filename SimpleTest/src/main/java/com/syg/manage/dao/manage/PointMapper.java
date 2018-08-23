package com.syg.manage.dao.manage;

import java.util.List;

import com.syg.manage.model.manage.Cdkey;
import com.syg.manage.model.manage.Point;
import com.syg.manage.pagination.Pagination;

public interface PointMapper {

	public List<Point> queryListPageSearch(Pagination page,Point example);
}
