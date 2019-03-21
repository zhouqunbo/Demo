package service;

import dao.StudentInfoImpl;
import entity.StudentInfo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhou on 2019/3/20.
 */
public class StudentInfoService {
    StudentInfoImpl stuImpl = new StudentInfoImpl();
    public List<StudentInfo> findStudentInfo(){
        List<StudentInfo> list = new ArrayList<>();
        try {
            list=stuImpl.findStudent();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<StudentInfo> findStudentById(int id){
        List<StudentInfo> list = new ArrayList<>();
        try {
            list= stuImpl.findStudentById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public int updateStudent(StudentInfo stu){
        int i =-1;
        i=stuImpl.updateStudent(stu);
        return i;
    }
}
