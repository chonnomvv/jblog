<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!-- 메인해더 -->
<a href="/jblog">
    <img class="logo" src="/assets/images/logo.jpg">
</a>
<ul class="menu">
    <!-- 로그인 전 메뉴 -->
    <c:choose>
        <c:when test="${empty authUser}">

            <li><a href="/jblog/user/loginform">로그인</a></li>
            <li><a href="/jblog/user/joinform">회원가입</a></li>

        </c:when>
        <c:otherwise>
            <li><a href="/jblog/user/logout">로그아웃</a></li>
            <li><a href="/jblog/${authUser.id}">내블로그</a></li>

        </c:otherwise>
    </c:choose>

    <!-- 로그인 후 메뉴 -->
</ul>