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
	<div class="center-content">
		<c:import url="/WEB-INF/views/includes/header.jsp"/>
		<form class="join-form" id="join-form" method="post" action="/jblog/user/join">
			<label class="block-label" for="name">이름</label>
			<input type="text" id= "name_space"name="userName"  value="" />
			<label class="block-label" for="id">아이디</label>
			<input type="text" name="id"  value="" />
			<input id="btn-checkid" type="button" value="id 중복체크">
			<p id="checkid-msg" class="form-error">
			&nbsp;
			</p>
			<label class="block-label" for="password">패스워드</label>
			<input type="password" name="password"  value="" />
			<fieldset>
				<legend>약관동의</legend>
				<input id="agree-prov" type="checkbox" name="agreeProv" value="y">
				<label class="l-float">서비스 약관에 동의합니다.</label>
			</fieldset>
			<input type="submit" value="가입하기">
		</form>
	</div>
</body>
<script type="text/javascript">
	$("#btn-checkid").on("click",function(checkId){
	    var id = $("[name=id]").val();
	    console.log(id);
	    $.ajax({
			url:"/jblog/user/idCheck",
			type:"post",
			data:{id:id},
			dataType:"json",
			success: function(result){
			    console.log(result);
			    if(result==true){
			        $("#checkid-msg").html("사용 할 수 있는 아이디입니다.").css("color", "red");
				}else{
			        $("#checkid-msg").html("다른 아이디로 가입해 주세요.").css("color","red");
				}
			}
            , error: function (XHR, status, error) {
                console.error(status + " : " + error);
            }
		})
	})

	$("#name_space").on("ready" ,{


	})
</script>



</html>