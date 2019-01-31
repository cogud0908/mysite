package com.douzone.mysite.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.douzone.mvc.action.Action;
import com.douzone.mvc.util.WebUtils;
import com.douzone.mysite.repository.BoardDao;
import com.douzone.mysite.repository.UserDao;
import com.douzone.mysite.vo.BoardVo;
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
		String title = request.getParameter("title");
		String contents = request.getParameter("content");
		
		BoardVo vo = new BoardVo();
		vo.setNo(no);
		vo.setTitle(title);
		vo.setContents(contents);
		
		new BoardDao().update(vo);
		
		WebUtils.redirect(request, response, request.getContextPath()+"/board?a=board");
	}

}
