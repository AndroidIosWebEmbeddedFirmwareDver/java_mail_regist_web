package com.hacker.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hacker.domain.User;
import com.hacker.service.impl.UserServiceImpl;
import com.hacker.utils.UUIDUtils;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistServlet() {
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
			// 接收数据
			request.setCharacterEncoding("UTF-8");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String nickname = request.getParameter("nickname");
			String email = request.getParameter("email");

			// 封装数据
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setNickname(nickname);
			user.setEmail(email);
			;
			user.setState(0);// 0 未激活 1 已激活
			String code = UUIDUtils.getUUID() + UUIDUtils.getUUID();
			user.setCode(code);
			// 调用业务层处理数据
			UserServiceImpl userServiceImpl = new UserServiceImpl();
			userServiceImpl.regist(user);

			// 跳转页面
			request.setAttribute("msg", "你已经注册成功，请到邮箱激活！");
			request.getRequestDispatcher("Static/msg.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
		// 页面跳转
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
