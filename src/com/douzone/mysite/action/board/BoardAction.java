package com.douzone.mysite.action.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.mvc.action.Action;
import com.douzone.mvc.util.WebUtils;
import com.douzone.mysite.repository.BoardDao;
import com.douzone.mysite.vo.BoardVo;

public class BoardAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String search = request.getParameter("search");
		String buffer_page = request.getParameter("page");
		
		if(search == null)
			search = "";
		
		int page;
		
		if(buffer_page == null)
			page = 1;
		else
			page = Integer.parseInt(buffer_page);
			
		BoardDao dao = new BoardDao();
		int totalcount = dao.getCount(search);
		int totalpage;
		int pagecount;
		
		if(totalcount % 10 == 0)
		{
			totalpage = (totalcount / 10);
			pagecount = 10;
		}
		else
		{
			totalpage = (totalcount / 10) + 1;
			pagecount = totalcount % 10;
		}
		
		int start_page = (page / 6)*5 + 1;
		int end_page = start_page + 4;
		
		if(totalpage < end_page)
			end_page = totalpage;
		
		int[] pageList = {page, start_page, end_page, totalpage, pagecount};
		
		List<BoardVo> list = dao.getList(search,page);

		// 데이터를 request 범위에 저장
		request.setAttribute("list", list);
		request.setAttribute("pagelist",pageList);
		request.setAttribute("search", search);
		
		WebUtils.forward(request, response, "/WEB-INF/views/board/list.jsp");
	}

}
