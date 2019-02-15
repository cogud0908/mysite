package com.douzone.mysite.action.guestbook;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.mvc.action.Action;
import com.douzone.mysite.repository.GuestbookDao;
import com.douzone.mysite.vo.GuestbookVo;

import net.sf.json.JSONObject;

public class AjaxDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String buffer = request.getParameter("no");
		int no = Integer.parseInt(buffer);
		String password = request.getParameter("password");

		GuestbookVo vo = new GuestbookVo();

		vo.setNo(no);
		vo.setPassword(password);

		boolean flag = new GuestbookDao().delete(vo);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", flag);
		
		response.setContentType("application/json; charset=UTF-8");
		JSONObject jsonObject = JSONObject.fromObject(map);

		response.getWriter().print(jsonObject.toString());

	}

}
