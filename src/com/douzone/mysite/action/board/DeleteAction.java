package com.douzone.mysite.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.douzone.mvc.action.Action;
import com.douzone.mvc.util.WebUtils;
import com.douzone.mysite.repository.BoardDao;
import com.douzone.mysite.repository.GuestbookDao;
import com.douzone.mysite.vo.BoardVo;
import com.douzone.mysite.vo.GuestbookVo;
import com.douzone.mysite.vo.UserVo;

public class DeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		HttpSession session = request.getSession();
		UserVo uservo = (UserVo)session.getAttribute("loginuser");
		
		String buffer_no = request.getParameter("no");
		int no = Integer.parseInt(buffer_no);
		
		BoardDao dao = new BoardDao();
		
		if(dao.search(no,uservo.getNo()))
		{
			dao.delete(no);
		}		
		
		WebUtils.redirect(request, response, request.getContextPath()+"/board");
	}

}
