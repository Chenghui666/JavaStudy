package org.chenghui;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.chenghui.entity.Student;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestMyBatis {
    @Test
    public void testInsert() throws IOException {
        //访问mybatis读取student数据
        //1.定义mybatis主配置文件的名称，从类路径的根开始(target/classes)
        String config="mybatis.xml";
        //读取这个config表示的文件
        InputStream in = Resources.getResourceAsStream(config);
        //3.创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //4.创建SqlSessionFactory对象
        SqlSessionFactory factory = builder.build(in);
        //5.【重要】获取SqlSession对象，中SqlSessionFactory中获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //6.【重要】指定要执行的sql语句的表示。sql映射文件中的namespace+"."+标签的id值
        String sqlId = "org.chenghui.dao.StudentDao" + "." + "insertStudent";
        //7.执行sql语句，通过sqiId找到语句
        Student student = new Student();
        student.setId(1006);
        student.setName("赵云");
        student.setEmail("www.zhaoyun@qq.com");
        student.setAge(18);
        int nums = sqlSession.insert(sqlId, student);
        //mybatis默认不是自动提交事物的，在insert、update、delete之后需要手工添加
        sqlSession.commit();
        //8.输出结果
        System.out.println("执行insert之后：" + nums);
        //9.关闭SqlSession对象
        sqlSession.close();
    }
}
