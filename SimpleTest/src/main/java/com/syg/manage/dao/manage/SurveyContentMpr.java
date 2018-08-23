package com.syg.manage.dao.manage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.syg.manage.model.manage.SurveyContent;
import com.syg.manage.pagination.Pagination;

public interface SurveyContentMpr {
	
	public List<SurveyContent> queryListPageSearch(Pagination page,@Param("example")SurveyContent example);
	public SurveyContent queryById(Integer id);
	public SurveyContent queryByStId(Integer stId);
	public void saveItem(SurveyContent item);
	public int updateItem(SurveyContent item);
	public int deleteById(Integer id);
}
