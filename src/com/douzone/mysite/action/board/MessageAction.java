package com.douzone.mysite.action.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.douzone.mvc.action.Action;
import com.douzone.mvc.util.WebUtils;
import com.douzone.mysite.repository.BoardDao;
import com.douzone.mysite.repository.MessageDao;
import com.douzone.mysite.vo.BoardVo;
import com.douzone.mysite.vo.MessageVo;
import com.douzone.mysite.vo.UserVo;

public class MessageAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		HttpSession session = request.getSession();
		UserVo uservo = (UserVo) session.getAttribute("loginuser");

		String content = request.getParameter("content");
		String buffer_board_no = request.getParameter("no");
		int board_no = Integer.parseInt(buffer_board_no);

		if (content.equals("")) {
			PrintWriter out = response.getWriter();

			out.println("<script type=text/javascript>");
			out.println("alert('제목에 내용이 없습니다!');");
			out.println("</script>");

		} else {
			MessageVo vo = new MessageVo();
			vo.setBoard_no(board_no);
			vo.setContent(content);
			vo.setUser_no(uservo.getNo());

			new MessageDao().Insert(vo);
		}
		WebUtils.redirect(request, response, request.getContextPath() + "/board?a=view&no=" + board_no);
	}

}
