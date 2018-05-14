<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JBlog</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
    <script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/jquery/jquery-1.12.4.js"></script>
</head>
<body>
<input type="hidden" id="blogId" value="${blogVO.id}"/>
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
                <li><a href="/jblog/${blogVO.id}">기본설정</a></li>
                <li class="selected"><a href="${blogVO.id}/manage_cate?id=${sessionScope.authUser.id}">카테고리</a></li>
                <li><a href="/jblog/${blogVO.id}/admin/write?id=${sessionScope.authUser.id}">글작성</a></li>
            </ul>

            <table class="admin-cat">
                <thead>
                <tr>
                    <th>번호</th>
                    <th>카테고리명</th>
                    <th>포스트 수</th>
                    <th>설명</th>
                    <th>삭제</th>
                </tr>
                </thead>

                <tbody id="cateList" >
                <%--카테 리스트 오는 곳 --%>
                </tbody>

            </table>

            <h4 class="n-c">새로운 카테고리 추가</h4>
            <table id="admin-cat-add">
                <tr>
                    <td class="t">카테고리명</td>
                    <td><input type="text" name="name" value=""></td>
                </tr>
                <tr>
                    <td class="t">설명</td>
                    <td><input type="text" name="desc"></td>
                </tr>
                <tr>
                    <td class="s">&nbsp;</td>
                    <td><input id="btnAddCate" type="submit" value="카테고리 추가"></td>
                </tr>
            </table>

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
<script type="text/javascript">
    $(document).ready(function () {
        var id = $("#blogId").val();

        fetchList(id);
    });
    $("#btnAddCate").on("click", function () {
        var name = $("[name=name]").val();
        var desc = $("[name=desc]").val();
        var id = $("#blogId").val();
        console.log(id);
        console.log(name);
        console.log(desc);
        $.ajax({
            url: "/jblog/category/addCate",
            type: "post",
            // contentType:"application/json",
            data: {id:id, name:name, description:desc},
            dataType: "json",
            success: function (categoryVOList) {
                render(categoryVOList);
                $("[name=name]").val("");
                $("[name=desc]").val("");
            }
            , error: function (XHR, status, error) {
                console.error(status + ":" + error);
            }
        })
    });
    function fetchList(id) {
        $.ajax({
            url: "/jblog/category/getList",
            type: "post",
            data: {id: id},
            dataType: "json",

            success:
                function (list) {
                    for (var i = 0; i < list.length; i++) {
                        console.log(list.size);
                        render(list[i]);
                    }
                }, error: function (XHR, status, error) {
                console.error(status + ":" + error);
            }
        })
    }
    function render(categoryVO) {
        var cateNo = categoryVO.cateNo;
        var cateName = categoryVO.cateName;
        console.log(cateNo);
        console.log(cateName);
        var str = "";
        str += "<tr name = '"+cateNo+"'>";
        str += "<td id= '"+cateNo+"'>" + categoryVO.cateNo + "</td>";
        str += "<td>" + categoryVO.cateName + "</td>";
        str += "<td>"+categoryVO.cateCount+"</td>";
        str += "<td>" + categoryVO.description + "</td>";
        str += "<td><img src = '" + "${pageContext.request.contextPath}/assets/images/delete.jpg" + "' id='"+cateNo+"'></td>";
        str += "";
        $("#cateList").prepend(str);
    }
    $("#cateList").on("click","img",function(){
        var cateNo = $(this).attr("id");
        console.log(cateNo);
        deleteCate(cateNo);
    })
    function deleteCate(cateNo){
        $.ajax({
            url: "/jblog/category/deleteCate",
            type: "post",
            data: {cateNo: cateNo},
            dataType: "json",
    success:
    function(result){
                if(result ==true){
                    $("[name="+cateNo+"]").remove();
                }
    }
        })
    }
</script>


</html>