package com.douzone.mysite.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.mvc.action.Action;
import com.douzone.mvc.util.WebUtils;
import com.douzone.mysite.repository.BoardDao;
import com.douzone.mysite.repository.MessageDao;

public class DeleteMessageAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	
		String buffer_board_no = request.getParameter("board_no");
		int board_no = Integer.parseInt(buffer_board_no);
		
		String buffer_message_no = request.getParameter("message_no");
		int message_no = Integer.parseInt(buffer_message_no);
		
		MessageDao dao = new MessageDao();
		
		dao.delete(message_no);
		
		WebUtils.redirect(request, response, request.getContextPath()+"/board?a=view&no="+board_no);
	}

}
