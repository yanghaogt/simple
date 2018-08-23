package com.syg.manage.dao.manage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.syg.manage.model.manage.SurveyType;
import com.syg.manage.pagination.Pagination;

public interface SurveyTypeMpr {
	
	public List<SurveyType> queryListPageSearch(Pagination page,@Param("example")SurveyType example);
	public List<SurveyType> queryAll();
	public SurveyType queryByTitle(String stTitle);
	public SurveyType queryById(Integer id);
	public void saveItem(SurveyType item);
	public int updateItem(SurveyType item);
	public int deleteById(Integer id);
	
}
