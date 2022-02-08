package com.fangpeng.design.pattern.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 方鹏
 * @date 2022年02月08日 8:52 下午
 */
public class StudentAggregateImpl implements StudentAggregate {

    private List<Student> list = new ArrayList<Student>();

    @Override
    public void addStudent(Student stu) {
        list.add(stu);
    }

    @Override
    public void removeStudent(Student stu) {
        list.remove(stu);
    }

    @Override
    public StudentIterator getStudentIterator() {
        return new StudentIteratorImpl(list);
    }
}
