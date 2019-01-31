package com.douzone.mysite.action.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.mvc.action.Action;
import com.douzone.mvc.util.WebUtils;
import com.douzone.mysite.repository.BoardDao;
import com.douzone.mysite.repository.MessageDao;
import com.douzone.mysite.vo.BoardVo;
import com.douzone.mysite.vo.MessageVo;

public class BoardViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String buffer_no = request.getParameter("no");
		int no = Integer.parseInt(buffer_no);
		
		BoardDao dao = new BoardDao();
		BoardVo vo = dao.getBoard(no);
		
		MessageDao m_dao = new MessageDao();
		List<MessageVo> m_list = m_dao.getList(no);
		
		request.setAttribute("m_list", m_list);		
		request.setAttribute("boardview", vo);
		
		WebUtils.forward(request, response, "/WEB-INF/views/board/view.jsp");
	}

}
