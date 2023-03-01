package cn.edu.svtcc.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * 工具类
 */
public class MybatisUtils {

    /**
     * 读取配置文件
     * @return
     * @throws IOException
     */
    public static SqlSession getSession() throws IOException {

        String resources="mybatis-config.xml";
        Reader reader=null;
        reader= Resources.getResourceAsReader(resources);
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory=sqlSessionFactoryBuilder.build(reader);
        return sqlSessionFactory.openSession();
    }

}
