<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("newline", "\n");
%>
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.servletContext.contextPath }/assets/css/board.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/views/includes/header.jsp"/>
		<div id="content">
			<div id="board" class="board-form">
				<table class="tbl-ex">
					<tr>
						<th colspan="2">글보기</th>
					</tr>
					<tr>
						<td class="label">제목</td>
						<td>${boardview.title }</td>
					</tr>
					<tr>
						<td class="label">내용</td>
						<td>
							<div class="view-content">
								${boardview.contents }
							</div>
						</td>
					</tr>
				</table>
				<div class="bottom">
					<a href="${pageContext.servletContext.contextPath }/board">글목록</a>
					<c:if test="${loginuser.no == boardview.user_no }">
						<a href="${pageContext.servletContext.contextPath }/board?a=modifyform&no=${boardview.no}">글수정</a>
					</c:if>
					<c:if test="${!empty loginuser }">
						<a href="${pageContext.servletContext.contextPath }/board?a=replyform&no=${boardview.no}">답글</a>
					</c:if>
				</div>
				<div>
					<table class = "tbl-ex">
					<c:forEach items = "${m_list }" var = "m_vo">
						<tr>
							<td class="label">${m_vo.name }</td>
							<td>
								<div class="view-content">
								${fn:replace(m_vo.content , newline, "<br>") }
								</div>
							</td>
							<td class="label">
								<c:if test="${loginuser.no == m_vo.user_no }">
									<div align="right">
									<form action = "${pageContext.servletContext.contextPath }/board">
										<input type = "hidden" name = "a" value = "deletemessage">
										<input type = "hidden" name = "message_no" value = "${m_vo.no }">
										<input type = "hidden" name = "board_no" value = "${boardview.no }">
										<input type = "submit" value = "삭제">
									</form>
									</div>
								</c:if>
							</td>
						</tr>
					</c:forEach>
					</table>
				</div>			
				<div>
					<c:if test="${!empty loginuser }">
					<form action = "${pageContext.servletContext.contextPath }/board/message">
					<input type="hidden" name="no" value="${boardview.no }">
					<input type="hidden" name="a" value="message">
					<table class = "tbl-ex">
						<tr>
							<td class="label">댓글</td>
							<td>
							<input type ="text" name="content" style="width:365px"/>
							<input type ="submit" name="submit" value ="작성" style="width:75px"/>
							</td>
						</tr>
					</table>
					</form>
					</c:if>
				</div>
			</div>
			
		</div>
		<c:import url="/WEB-INF/views/includes/navigation.jsp">
			<c:param name="menu" value = "board"/>
		</c:import>
		<c:import url="/WEB-INF/views/includes/footer.jsp"/>
	</div>
</body>
</html>