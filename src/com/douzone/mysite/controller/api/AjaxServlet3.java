package com.douzone.mysite.controller.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.mysite.vo.UserVo;

import net.sf.json.JSONArray;

@WebServlet("/ajax3")
public class AjaxServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// java Collection(List) -> Json
		List<UserVo> list = new ArrayList<UserVo>();
		
		UserVo vo1 = new UserVo();
		vo1.setNo(10);
		vo1.setName("퍼블리셔");
		vo1.setEmail("wow@naver.com");
		vo1.setGender("male");
		list.add(vo1);
		
		UserVo vo2 = new UserVo();
		vo2.setNo(20);
		vo2.setName("둘리");
		vo2.setEmail("dooly@gmail.com");
		vo2.setGender("male");
		list.add(vo2);
		
		JSONArray jsonArray = JSONArray.fromObject(list);
		String jsonString = jsonArray.toString();
		
		
		response.setContentType("application/json; charset=utf-8"); 
		PrintWriter pw = response.getWriter();
		pw.println(jsonString);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
