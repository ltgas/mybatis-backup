package com.ltg.test;

import com.ltg.mapper.BasicdataMapper;
import com.ltg.pojo.Basicdata;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;

public class StartTest {
    SqlSession sqlSession;
    static Logger logger = Logger.getLogger(StartTest.class);

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
        System.out.println("Testing QueryAll() is end!");
    }

    @Test
    public void testQueryById() {
        logger.debug("测试 testQueryById(),进入方法成功!");
        // 取出动态代理的对象，完成接口中方法的调用，实则是调用 xml 文件中相应的标签的功能
        // 方法2：适用返回结果是一个实体 方法接口返回使用类型：实体类型 -> Basicdata
        BasicdataMapper bMapper = sqlSession.getMapper(BasicdataMapper.class);
        Basicdata basicdata = bMapper.queryById(100);
        System.out.println(basicdata);
        System.out.println("Testing QueryBYId() is end!");
    }

    @Test
    public void testQueryByName() {
        // 取出动态代理的对象，完成接口中方法的调用，实则是调用 xml 文件中相应的标签的功能
        BasicdataMapper bMapper = sqlSession.getMapper(BasicdataMapper.class);
        List<Basicdata> list = bMapper.queryByName("ser");
        list.forEach(System.out::println);
        System.out.println("Testing QueryByName() is end!");
    }

    @Test
    public void testQueryByNearName() {
        // 取出动态代理的对象，完成接口中方法的调用，实则是调用 xml 文件中相应的标签的功能
        BasicdataMapper bMapper = sqlSession.getMapper(BasicdataMapper.class);
        System.out.println(bMapper.getClass());   // Pause->test,Can be deleted
        List<Basicdata> list = bMapper.queryByNearName("first_name","sar");
        list.forEach(System.out::println);
        System.out.println("Testing QueryByNearName() is end!");
    }

    @Test
    public void testLog4j() {
        logger.info("info: 进入了 testLog4j!");
        logger.debug("debug: 进入了 testLog4j!");
        logger.error("error: 进入了 testLog4j!");
    }

    @Test
    public void testQueryByLimit() {
        BasicdataMapper bMapper = sqlSession.getMapper(BasicdataMapper.class);
        HashMap<String, Integer> map = new HashMap<>();
        map.put("startIndex", 10);
        map.put("pageSize", 20);
        List<Basicdata> list = bMapper.queryByLimit(map);
        list.forEach(System.out::println);
        System.out.println("Testing QueryByLimit is over!");
    }

    @Test
    public void testQueryByRowBounds() {
        // RowBounds 实现
        RowBounds rowBounds = new RowBounds(1,10);
        List<Basicdata> list = sqlSession.selectList("com.ltg.mapper.BasicdataMapper.queryByRowBounds",null,rowBounds);
        list.forEach(System.out::println);
        System.out.println("Testing QueryByRowBounds is over!");
    }

    @Test
    public void testgetBasicdataById() {
        BasicdataMapper bMapper = sqlSession.getMapper(BasicdataMapper.class);
        Basicdata basicdata = bMapper.getBasicdataById(10);
        System.out.println(basicdata);
        System.out.println("Testing getBasicdataById is over!");
    }

    /*@Test
    public void testInsertBasicdata() {
        BasicdataMapper bMapper = sqlSession.getMapper(BasicdataMapper.class);
        Basicdata basicdata = bMapper.addBasicdata(new Basicdata(21001002,"aaa","bbb","sas@abc.com",true,18,'T',88.5F,99.00F,68.5F,75.00F,0.00F,"1.1.1.1","aabbccddee","13362552211",05-01-2022));
        System.out.println(basicdata);
        System.out.println("Testing getBasicdataById is over!");
    }*/

    @Test
    public void testaddBasicdataInfo() {
        int num = sqlSession.insert("addBasicdataInfo",new Basicdata(21002022,"aaa11","bbb11","ssss@abc.com", (char) 1,28,Boolean.FALSE,
                80.5F,89.00F,18.5F,25.00F,0.00F,"11.11.11.11","aabbcc","13311112222", Date.valueOf("2021-2-5")));
        System.out.println(num);
    }
}
