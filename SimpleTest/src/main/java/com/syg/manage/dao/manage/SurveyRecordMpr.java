package com.syg.manage.dao.manage;

import java.util.List;

import com.syg.manage.model.manage.SurveyRecord;

public interface SurveyRecordMpr {
	public List<SurveyRecord> queryByscId(Integer scId);
}
