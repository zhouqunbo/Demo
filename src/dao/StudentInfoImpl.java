package dao;

import entity.StudentInfo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhou on 2019/3/20.
 */
public class StudentInfoImpl extends BaseDao {
    public List<StudentInfo> findStudent() throws SQLException {
        List<StudentInfo> list = new ArrayList<>();
        String sql ="SELECT * FROM  `studentinfo`";
        Object[] params = {};
        ResultSet rs = executeQuery(sql, params);
        while(rs.next()){
            StudentInfo studentInfo = new StudentInfo();
            studentInfo.setSaddress(rs.getString("saddress"));
            studentInfo.setSage(rs.getInt("sage"));
            studentInfo.setSemail(rs.getString("semail"));
            studentInfo.setSgender(rs.getString("sgender"));
            studentInfo.setSid(rs.getInt("sid"));
            studentInfo.setSname(rs.getString("sname"));
            list.add(studentInfo);
        }
        closeAll(null,rs);
        return list;
    }

    public List<StudentInfo> findStudentById(int id) throws SQLException {
        List<StudentInfo> list = new ArrayList<>();
        String sql ="SELECT * FROM  `studentinfo` WHERE `sid`=?";
        Object[] params ={id};
        ResultSet rs = executeQuery(sql, params);
        while(rs.next()){
            StudentInfo studentInfo = new StudentInfo();
            studentInfo.setSaddress(rs.getString("saddress"));
            studentInfo.setSage(rs.getInt("sage"));
            studentInfo.setSemail(rs.getString("semail"));
            studentInfo.setSgender(rs.getString("sgender"));
            studentInfo.setSid(rs.getInt("sid"));
            studentInfo.setSname(rs.getString("sname"));
            list.add(studentInfo);
        }
        closeAll(null,rs);
        return list;
    }

    public int updateStudent(StudentInfo stu){
        int i =-1;
        String sql ="UPDATE `studentinfo` SET `sname`=?,`sgender`=?,`sage`=?,`saddress`=?,`semail`=? WHERE `sid`=?";
        Object[] params ={stu.getSname(),stu.getSgender(),stu.getSage(),stu.getSaddress(),stu.getSemail(),stu.getSid()};
        i = executeUpdate(sql, params);
        return i;
    }
}
