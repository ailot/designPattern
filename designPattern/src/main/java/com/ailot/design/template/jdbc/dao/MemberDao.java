package com.ailot.design.template.jdbc.dao;

import com.ailot.design.template.jdbc.JdbcTemplate;
import com.ailot.design.template.jdbc.Member;
import com.ailot.design.template.jdbc.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;

/**
 * @author ailot
 * @version MemberDao.java, 2019年03月30日 下午10:17
 */
public class MemberDao extends JdbcTemplate {


    public MemberDao(DataSource dataSource) {
        super(dataSource);
    }

    public List<?> selectAll(){
        String sql = "select * from member ";
        return executeQuery(sql, new RowMapper<Member>() {
            @Override
            public Member mapRow(ResultSet rs, int rowNum) throws Exception {
                Member member = new Member();
                member.setAge(rs.getInt("age"));
                member.setAddr(rs.getString("addr"));
                member.setNickname(rs.getString("nickname"));
                member.setPassword(rs.getString("password"));
                member.setUsername(rs.getString("username"));
                return member;
            }
        },null);
    }
}
