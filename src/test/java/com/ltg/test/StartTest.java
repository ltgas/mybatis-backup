package com.ltg.test;

import com.ltg.mapper.BasicdataMapper;
import com.ltg.pojo.Basicdata;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class StartTest {
    SqlSession sqlSession;

    @Before
    public void openSqlSession() throws IOException {
        String resource = "SqlMapConfig.xml";
        // 1.使用文件流读取核心配置文件 SqlMapConfig.xml
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 2.创建 SqlSessionFactory 工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 3.取出 sqlSession ,带（true）参数表示提交事务，默认为空 (false)
        sqlSession = sqlSessionFactory.openSession(true);
    }

    @After
    public void closeSqlSession() {
        sqlSession.close();
    }

    @Test
    public void testQueryAll() {
        // 取出动态代理的对象，完成接口中方法的调用，实则是调用 xml 文件中相应的标签的功能
        // 方法1：适用返回结果是超过一个实体 方法接口返回使用类型：实体集类型 -> List<Basicdata>
        List<Basicdata> list = sqlSession.selectList("com.ltg.mapper.BasicdataMapper.queryAll");
        list.forEach(System.out::println);
        System.out.println("Next...");
    }

    @Test
    public void testQueryById() {
        // 取出动态代理的对象，完成接口中方法的调用，实则是调用 xml 文件中相应的标签的功能
        // 方法2：适用返回结果是一个实体 方法接口返回使用类型：实体类型 -> Basicdata
        BasicdataMapper bMapper = sqlSession.getMapper(BasicdataMapper.class);
        Basicdata basicdata = bMapper.queryById(100);
        System.out.println(basicdata);
        System.out.println("Countine...");
    }

    @Test
    public void testQueryByName() {
        // 取出动态代理的对象，完成接口中方法的调用，实则是调用 xml 文件中相应的标签的功能
        BasicdataMapper bMapper = sqlSession.getMapper(BasicdataMapper.class);
        List<Basicdata> list = bMapper.queryByName("ser");
        list.forEach(System.out::println);
        System.out.println("Go ...");
    }

    @Test
    public void testQueryByNearName() {
        // 取出动态代理的对象，完成接口中方法的调用，实则是调用 xml 文件中相应的标签的功能
        BasicdataMapper bMapper = sqlSession.getMapper(BasicdataMapper.class);
        System.out.println(bMapper.getClass());   // Pause->test,Can be deleted
        List<Basicdata> list = bMapper.queryByNearName("first_name","sar");
        list.forEach(System.out::println);
        System.out.println("Again ...");
    }
}
