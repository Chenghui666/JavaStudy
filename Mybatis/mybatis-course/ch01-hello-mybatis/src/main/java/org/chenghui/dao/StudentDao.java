package org.chenghui.dao;

import org.chenghui.entity.Student;

import java.util.List;

/*接口操作student表*/
public interface StudentDao {
    //查询student表中所有数据
    List<Student> selectStudents(); //对应一个SQL语句的执行，写在sql映射文件之中
    //向student表中插入数据
    /**
     * @return 影响数据库中的行数
     * @param student 要插入到数据库中的数据
     * */
    int insertStudent(Student student);
}
