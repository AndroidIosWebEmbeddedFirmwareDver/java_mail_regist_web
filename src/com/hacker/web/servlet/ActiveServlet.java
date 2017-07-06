package com.hacker.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hacker.domain.User;
import com.hacker.service.impl.UserServiceImpl;

/**
 * Servlet implementation class ActiveServlet
 */
@WebServlet("/ActiveServlet")
public class ActiveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ActiveServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String code = request.getParameter("code");
			// 调用业务层查询用户
			UserServiceImpl userServiceImpl = new UserServiceImpl();
			User user = userServiceImpl.findUserByCode(code);
			if (null != user) {
				// 已经查询到user，修改用户状态
				user.setState(1);
				user.setCode(null);
				userServiceImpl.update(user);
				// 跳转页面
				request.setAttribute("msg", "激活成功，欢迎开始使用！");
			} else {
				// 没有查询到user，跳转提示
				// 跳转页面
				request.setAttribute("msg", "激活码不正确，请重新激活！");
			}
			request.getRequestDispatcher("Static/msg.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
