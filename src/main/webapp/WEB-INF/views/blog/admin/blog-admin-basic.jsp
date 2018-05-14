<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<link rel="stylesheet" href="/assets/css/jblog.css">
<script type="text/javascript" src="/assets/js/jquery/jquery-1.12.4.js"></script>
</head>
<body>

	<div id="container">
		<!-- 블로그 해더 -->
		<div id="header">
			<h1><a href="/jblog/${blogVO.id}">${blogVO.blogTitle}</a></h1>
			<ul>
				<c:choose>
					<c:when test="${authUser.id eq blogVO.id}">
						<!-- 로그인 후 메뉴 -->
						<li><a href="/jblog/user/logout">로그아웃</a></li>
						<li><a href="/jblog/blog/${blogVO.id}/manage">내블로그 관리</a></li>
					</c:when>
					<c:otherwise>
						<!-- 로그인 전 메뉴 -->
						<li><a href="/jblog/user/loginform">로그인</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
		<div id="wrapper">
			<div id="content" class="full-screen">
				<ul class="admin-menu">
					<li class="selected"><a href="/jblog/${blogVO.id}">기본설정</a></li>
					<li><a href="/jblog/blog/${blogVO.id}/manage_cate?id=${sessionScope.authUser.id}">카테고리</a></li>
					<li><a href="/jblog/${blogVO.id}/admin/write?auth=${sessionScope.authUser.id}">글작성</a></li>
				</ul>
				
				<form action="/jblog/blog/${blogVO.id}/modify" method="post" enctype="multipart/form-data">
	 		      	<table class="admin-config">
			      		<tr>
			      			<td class="t">블로그 제목</td>
			      			<td><input type="text" size="40" name="blogTitle" value=""></td>
			      		</tr>
			      		<tr>
			      			<td class="t">로고이미지</td>
			      			<td><img src="/upload/${blogVO.logoFile}"></td>
			      		</tr>      		
			      		<tr>
			      			<td class="t">&nbsp;</td>
			      			<td><input type="file" name="file"></td>      			
			      		</tr>
			      		<tr>
			      			<td class="t">&nbsp;</td>
			      			<td class="s"><input type="submit" value="기본설정 변경"></td>      			
			      		</tr>           		
			      	</table>
				</form>
			</div>
		</div>
		<!-- 푸터-->
		<div id="footer">
			<p>
				<strong>Spring 이야기</strong> is powered by JBlog (c)2018
			</p>
		</div>
	
	</div>
</body>

</html>