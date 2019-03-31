package com.ailot.design.template.jdbc;

import com.ailot.design.template.jdbc.dao.MemberDao;

import java.util.List;

/**
 * @author ailot
 * @version JdbcTmeplateTest.java, 2019年03月30日 下午10:27
 */
public class JdbcTemplateTest {

    public static void main(String[] args) {
        MemberDao memberDao = new MemberDao(null);
        List<?> result = memberDao.selectAll();
        System.out.println(result);
    }
}
