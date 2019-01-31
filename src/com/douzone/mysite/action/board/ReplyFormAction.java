package com.douzone.mysite.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.mvc.action.Action;
import com.douzone.mvc.util.WebUtils;
import com.douzone.mysite.repository.BoardDao;
import com.douzone.mysite.vo.BoardVo;

public class ReplyFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String buffer_no = request.getParameter("no");
		int no = Integer.parseInt(buffer_no);
		
		BoardDao dao = new BoardDao();
		BoardVo vo = dao.getReply(no);

		// 데이터를 request 범위에 저장
		request.setAttribute("reply", vo);
		
		WebUtils.forward(request, response, "/WEB-INF/views/board/write.jsp");
	}

}
