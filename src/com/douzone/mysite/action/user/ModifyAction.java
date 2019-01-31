package com.douzone.mysite.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.douzone.mvc.action.Action;
import com.douzone.mvc.util.WebUtils;
import com.douzone.mysite.repository.UserDao;
import com.douzone.mysite.vo.UserVo;

public class ModifyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		UserVo loginUser = null;
		HttpSession session = request.getSession();
		
		if(session != null)
		{
			loginUser = (UserVo)session.getAttribute("loginuser");
		}
		if(loginUser == null)
		{
			WebUtils.redirect(request, response, request.getContextPath());
			return;
		}
		
		String no_buffer = request.getParameter("no");
		int no = Integer.parseInt(no_buffer);
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		
		UserVo vo = new UserVo();
		vo.setNo(no);
		vo.setName(name);
		vo.setPassword(password);
		vo.setGender(gender);
		
		new UserDao().update(vo);
		
		WebUtils.redirect(request, response, request.getContextPath()+"/user?a=modifysuccess");
	}

}
