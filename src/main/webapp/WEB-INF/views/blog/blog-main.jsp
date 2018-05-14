<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JBlog</title>
    <link rel="stylesheet" href="/assets/css/jblog.css">
    <script type="text/javascript" src="/assets/js/jquery/jquery-1.12.4.js"></script>
</head>
<body>
<input type="hidden" id="blogId" value="${blogVO.id}"/>
<div id="container">
    <!-- 블로그 해더 -->
    <div align="center" id="header">
        <%--<c:choose>--%>
            <%--<c:if test=""--%>
        <%--</c:choose>--%>
        <h1><a href="/jblog/${blogVO.id}?cateNo=${cateVO.cateNo}">${blogVO.blogTitle}</a></h1>
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
        <div id="content">
            <div class="blog-content">
123123
                <c:choose>
                    <c:when test="${empty postList}">
123213213
                        <h4>${postList[0].postTitle}</h4>
                        <pre>${postList[0].postContent}
                        </pre>
                    </c:when>
                    <c:otherwise>
                        456456
                        <h4>${postVO.postTitle}</h4>
                        <pre>${postVO.postContent}
                        </pre>
                    </c:otherwise>
                </c:choose>
                <!-- 등록된 글이 없는경우 -->
                <!--
                <h4>등록된 글이 없습니다.</h4>
                <p>
                <p>
                 -->
            </div>
            <ul class="blog-list">
                <li id="postList">
                    <%--<c:if test="${defaultCateNo eq '-1'}">--%>

                        <%--<a href="">${postList[0].postTitle}ㅋㅋㅋㅋㅋ</a>--%>
                        <%--<span>${postList[0].regDate}</span>--%>

                    <%--</c:if>--%>
                    <c:choose>
                        <c:when test="${empty postList}">
                            <a href ="">글이 없습니다.</a>
                            <span>${postList[0].regDate}</span>
                        </c:when>
                    <c:otherwise>
                    <c:forEach items="${postList}" var="list">
                        <a href="/jblog/post/view?id=${blogVO.id}&postNo=${list.postNo}">${list.postTitle}</a>
                        <span>${list.regDate}</span><br>
                    </c:forEach>
                    </c:otherwise>
                    </c:choose>
                </li>
            </ul>
        </div>
    </div>

    <div id="extra">
        <div class="blog-logo">
            <img src="/upload/${blogVO.logoFile}">
        </div>
    </div>
    <div id="navigation">
        <h2>카테고리</h2>
        <ul id="cateList">
            <%--카테 리스트 오는 곳--%>
        </ul>
    </div>
    <!-- 푸터-->
    <div id="footer">
        <p>
            <strong>Spring 이야기</strong> is powered by JBlog (c)2018
        </p>
    </div>
</div>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        var id = $("#blogId").val();
        fetchList(id);
        //
        // var defaultCateNo = $("#0").val();
        // console.log(defaultCateNo);
        // postList(id,defaultCateNo);
    })

    <%--$("#postList").ready(function(){--%>
        <%--var id = $("#blogID").val();--%>

        <%--var cateNo = $(this).attr("class");--%>

        <%--console.log("who are you"+cateNo);--%>
        <%--<c:choose>--%>
        <%--<c:when test="${empty cateNo }">--%>
        <%--console.log("나낭ㄹ아ㅓ디폴트ㅌ트트트"+cateNo);--%>
        <%--getDefaultCate(id)--%>
        <%--</c:when>--%>
        <%--<c:otherwise>--%>
        <%--var cateNo = cateNo;--%>
        <%--console.log("나낭ㄹ아ㅓ"+cateNo);--%>
        <%--postList(id,cateNo);--%>
        <%--</c:otherwise>--%>
        <%--</c:choose>--%>

    <%--})--%>

    <%--function postList(id,cateNo){--%>

        <%--$.ajax({--%>
            <%--url: "/jblog/blog/"+cateNo+"/getPost",--%>
            <%--type:"post",--%>
            <%--data:{cateNo:cateNo ,id:id},--%>
            <%--dataType: "json",--%>
            <%--success:--%>
            <%--function(list){--%>
                <%--for(var i=0; i<list.length;i++){--%>
                    <%--renderPost(list[i]);}--%>
                <%--}, error: function (XHR, status, error) {--%>
                    <%--console.error(status + ":" + error);--%>
            <%--}--%>
        <%--})--%>
<%--}--%>
    function fetchList(id) {
        $.ajax({
                url: "/jblog/category/getList",
                type: "post",
                data: {id: id},
                dataType: "json",
                success:
                    function (list) {
                    for(var i = 0; i < list.length;i++){
                        render(list[i],i,id);}
                    }, error: function (XHR, status, error) {
                    console.error(status + ":" + error);
                }
            }
        )
    }

    // function renderPost(postVO){
    //     var postTitle = postVO.postTitle;
    //     var postDate = postVO.regDate;
    //
    //     var str ="";
    //     str += "<a href=''>"+postTitle+"</a>";
    //     str += "<span>"+postDate+"</span>";
    //
    //     $("#postList").prepend(str);
    // }

    function render(categoryVO,i) {
        var cateName = categoryVO.cateName;
        var cateNo = categoryVO.cateNo;
        var str = "";
        str += "<li id='"+i+"' name='postCateNo' value='"+cateNo+"'><a href = '/jblog/blog/"+cateNo+"/getPost?id='>" + cateName + "</a></li>";
        str += "";
        $("#cateList").append(str);
    }
    //
    // function getDefaultCate(id){
    //     $.ajax({
    //         url:"/jblog/category/getDefaultCate",
    //         type: "post",
    //         data:{id:id},
    //         dataType: "json",
    //         success:
    //             function(defaultCateNo){
    //                 console.log("디폴트트트트"+defaultCateNo)
    //                 postList(id,defaultCateNo)
    //             }
    //     })
    // }
</script>
</html>