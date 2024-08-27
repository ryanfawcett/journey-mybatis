package org.example.bank.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.List;

/**
 * SqlSession 工具类
 *
 * @author ryanfawcett
 * @since 2024/04/13
 */
public class SqlSessionUtil {

    public static final String CONFIG_RESOURCE = "mybatis-config.xml";

    private static final SqlSessionFactory sqlSessionFactory;

    private SqlSessionUtil() {
    }

    static {
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(CONFIG_RESOURCE));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }

    public static SqlSession getAutoCommitSqlSession() {
        return sqlSessionFactory.openSession(true);
    }

    public static void main(String[] args) {
        List<Object> objects = getAutoCommitSqlSession().selectList("getAccounts");
        objects.forEach(System.out::println);
    }

}
