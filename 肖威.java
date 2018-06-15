package com.hpe.online.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hpe.online.pojo.Admin;
import com.hpe.online.service.IAdminService;
import com.hpe.online.service.impl.AdminService;
import com.hpe.online.util.BaseServlet;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet(name="admin/adminServlet", urlPatterns ={"/admin/adminServlet"} )
public class AdminServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	private IAdminService iAdminService =new AdminService();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 进行登录操作
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		 
		//调用service层
		Admin admin =iAdminService.login(username, password);
		if(admin==null)
		{
			request.setAttribute("error", "用户名或密码错误");
			
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else 
		{
			//保存用户登录信息 保存到session
			
			HttpSession session= request.getSession();
			session.setAttribute("admin", admin);
			//重定向
			
			
			response.sendRedirect("specialty.jsp");
		}
		
	}

	public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//退出如何操作
		//清空登录信息
		HttpSession session=request.getSession();
		session.removeAttribute("admin");
		//跳转登录页面
		response.sendRedirect("login.jsp");
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("该方法不存在");
	}

}
