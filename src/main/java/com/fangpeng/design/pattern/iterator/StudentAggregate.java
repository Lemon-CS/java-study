package com.fangpeng.design.pattern.iterator;

/*
 * 抽象聚合角色接口
 * @author 方鹏
 * @date 2022/2/8 8:52 下午
 */
public interface StudentAggregate {

    //添加学生功能
    void addStudent(Student stu);

    //删除学生功能
    void removeStudent(Student stu);

    //获取迭代器对象功能
    StudentIterator getStudentIterator();

}
