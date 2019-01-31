package com.douzone.mysite.action.board;

import java.io.IOException;
import java.util.List;

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

public class WriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		HttpSession session = request.getSession();
		UserVo uservo = (UserVo) session.getAttribute("loginuser");
		
		String flag = (String) request.getParameter("reply");
				
		if (flag == null) {
			String title = request.getParameter("title");
			String contents = request.getParameter("content");

			BoardVo vo = new BoardVo();
			vo.setUser_no(uservo.getNo());
			vo.setTitle(title);
			vo.setContents(contents);

			new BoardDao().insert(vo);
		} else {
						
			String buffer_no = request.getParameter("no");
			int no = Integer.parseInt(buffer_no);
			
			String title = request.getParameter("title");
			String contents = request.getParameter("content");
			
			BoardVo vo = new BoardVo();
			vo.setTitle(title);
			vo.setContents(contents);
			vo.setUser_no(uservo.getNo());
			
			new BoardDao().ReplyInsert(vo,no);
			
			
		}

		WebUtils.redirect(request, response, request.getContextPath() + "/board");

	}

}
