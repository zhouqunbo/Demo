package servlet;

import entity.StudentInfo;
import service.StudentInfoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by zhou on 2019/3/20.
 */
@WebServlet(name = "StudentInfoServlet",value ="/StudentInfoServlet")
public class StudentInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String info = request.getParameter("info");
        if(info!=null){
            if(info.equals("all")){//查询所有学生信息
                all(request,response);
            }else if(info.equals("idAll")){
                StudentInfoById(request,response);
            }else if(info.equals("update")) {
                update(request,response);
            }
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int stuid = Integer.parseInt(id);
        String name = request.getParameter("user");
        String age = request.getParameter("age");
        int stuage = Integer.parseInt(age);
        String sex = request.getParameter("sex");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        StudentInfo studentInfo =new StudentInfo();
        studentInfo.setSname(name);
        studentInfo.setSid(stuid);
        studentInfo.setSaddress(address);
        studentInfo.setSage(stuage);
        studentInfo.setSemail(email);
        studentInfo.setSgender(sex);
        StudentInfoService service = new StudentInfoService();
        int i = service.updateStudent(studentInfo);
        if(i==1){
            request.setAttribute("tishi","更新成功");
            request.getRequestDispatcher("stuInfo.jsp").forward(request,response);
        }else {
            request.setAttribute("tishi","更新失败");
            request.getRequestDispatcher("stuByIdInfo.jsp").forward(request,response);
        }
    }

    private void StudentInfoById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentInfoService service = new StudentInfoService();
        String id = request.getParameter("id");
        int i = Integer.parseInt(id);
        List<StudentInfo> studentById = service.findStudentById(i);
        request.setAttribute("stuInfoById",studentById);
        request.getRequestDispatcher("stuByIdInfo.jsp").forward(request,response);
    }

    private void all(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentInfoService service = new StudentInfoService();
        List<StudentInfo> studentInfo = service.findStudentInfo();
        request.setAttribute("stuInfo",studentInfo);
        request.getRequestDispatcher("stuInfo.jsp").forward(request,response);
    }
}
