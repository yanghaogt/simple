package com.syg.manage.dao.manage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.syg.manage.model.manage.Cdkey;
import com.syg.manage.pagination.Pagination;

public interface CdkeyMapper {
    
    public List<Cdkey> queryAll();
    
    public List<Cdkey> queryListPageSearch(Pagination page,@Param("example")Cdkey example);
    
    public void saveItem(@Param("example")Cdkey example,@Param("codeList") List<String> codeList);
}