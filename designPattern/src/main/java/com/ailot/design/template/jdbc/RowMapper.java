package com.ailot.design.template.jdbc;

import java.sql.ResultSet;

/**
 * @author ailot
 * @version RowMapper.java, 2019年03月30日 下午9:39
 */
public interface RowMapper<T> {

    T mapRow(ResultSet rs,int rowNum) throws Exception;
}
