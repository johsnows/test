package com.hp.onlinexam.servlet.teacher;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.Teacher;
import com.hp.onlinexam.service.student.IPaperService;
import com.hp.onlinexam.service.student.PaperService;

@WebServlet("/papersCompareServlet")
public class PapersCompareServlet extends HttpServlet{
    private IPaperService ps=new PaperService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    Teacher tea=(Teacher) req.getSession().getAttribute("user");
	    List pList=ps.getPaperCompare(tea.gettId());
	    req.setAttribute("paperList", pList);
		req.getRequestDispatcher("teacher/classpapers.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
