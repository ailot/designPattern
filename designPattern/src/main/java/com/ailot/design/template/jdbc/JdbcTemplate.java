package com.ailot.design.template.jdbc;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ailot
 * @version JdbcTemplate.java, 2019年03月30日 下午9:41
 */
public abstract class JdbcTemplate {

    private DataSource dataSource;

    public JdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<?> executeQuery(String sql, RowMapper<?> rowMapper, Object[] values) {

        try {
            //1.获取连接
            Connection conn = this.getConnection();

            //2.创建语句集
            PreparedStatement prsm = this.createPreparedStatement(conn, sql);

            //3.执行语句集
            ResultSet rs = this.executeQuery(prsm, values);

            //4.处理结果集
            List<?> result = this.paresResultSet(rs, rowMapper);

            //5.关闭结果集
            this.closeResultSet(rs);

            //6.关闭语句集
            this.closeStatement(prsm);

            //7.关闭连接
            this.closeConnection(conn);

            return result;
        } catch (Exception e) {

        }
        return null;
    }

    protected void closeConnection(Connection conn) throws SQLException {
        conn.close();
    }

    protected void closeStatement(PreparedStatement prsm) throws SQLException {
        prsm.close();
    }

    protected void closeResultSet(ResultSet rs) throws SQLException {
        rs.close();
    }

    protected List<?> paresResultSet(ResultSet rs, RowMapper<?> rowMapper) throws Exception {
        List<Object> result = new ArrayList<>();
        int rowNum = 1;
        while (rs.next()){
            result.add(rowMapper.mapRow(rs,rowNum++));
        }
        return result;
    }

    protected ResultSet executeQuery(PreparedStatement prsm, Object[] values) throws SQLException {
        for (int i = 0; i < values.length; i++) {
            prsm.setObject(i,values[i]);
        }
        return prsm.executeQuery();
    }

    protected PreparedStatement createPreparedStatement(Connection conn, String sql) throws SQLException {
        return conn.prepareStatement(sql);
    }

    protected Connection getConnection() throws SQLException {
        return this.dataSource.getConnection();
    }

}
