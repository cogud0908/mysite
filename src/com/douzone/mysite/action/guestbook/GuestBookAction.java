package com.douzone.mysite.action.guestbook;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.mysite.repository.GuestbookDao;
import com.douzone.mvc.action.Action;
import com.douzone.mvc.util.WebUtils;
import com.douzone.mysite.vo.GuestbookVo;

public class GuestBookAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		GuestbookDao dao = new GuestbookDao();
		List<GuestbookVo> list = dao.getList();
		
		// 데이터를 request 범위에 저장
		request.setAttribute("list", list);
		
		WebUtils.forward(request, response, "/WEB-INF/views/guestbook/list.jsp");
	}

}
