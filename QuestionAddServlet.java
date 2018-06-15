package com.hp.onlinexam.servlet.teacher;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.Course;
import com.hp.onlinexam.po.Questions;
import com.hp.onlinexam.service.admin.CourseService;
import com.hp.onlinexam.service.admin.ICourseService;
import com.hp.onlinexam.service.teacher.IQuestionService;
import com.hp.onlinexam.service.teacher.QuestionService;

@WebServlet("/questionAddServlet")
public class QuestionAddServlet extends HttpServlet{
    
	private ICourseService cs=new CourseService();
	private IQuestionService qs=new QuestionService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Course> courList=cs.findAllCourses("");
		req.setAttribute("courseList", courList);
		req.getRequestDispatcher("teacher/quesadd.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String courseId=req.getParameter("courseId");
		String queType=req.getParameter("queType");
		String queTitle=req.getParameter("queTitle");
		String choiceA=req.getParameter("choiceA");
		String choiceB=req.getParameter("choiceB");
		String choiceC=req.getParameter("choiceC");
		String choiceD=req.getParameter("choiceD");
		String ans=req.getParameter("ans");
		Questions que=new Questions();
		que.setCourseId(Integer.valueOf(courseId));
		que.setQueType(Integer.valueOf(queType));
		que.setQueTitle(queTitle);
		que.setChoiceA(choiceA);
		que.setChoiceB(choiceB);
		que.setChoiceC(choiceC);
		que.setChoiceD(choiceD);
		que.setAns(ans);
		qs.addQuestion(que);
		resp.sendRedirect(req.getContextPath()+"/questionQueryServlet");
	}

}
