<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../include/pheader.jsp"%>
	
<!-- picker : https://lalwr.blogspot.kr/2016/04/bootstrap-datepicker.html -->
<link rel="stylesheet" type="text/css" href="/resources/rpjt/datepicker/datepicker3.css" />
<script type="text/javascript" src="/resources/rpjt/datepicker/bootstrap-datepicker.js"></script>
<script type="text/javascript" src="/resources/rpjt/datepicker/bootstrap-datepicker.kr.js"></script>

<!-- Main content -->
<!-- 개인 수정 페이지 -->
<div class="col-md-9">
		
	<br> <br>
	<div class="row">
		<div class="form-group col-lg-6">
			<label>프로필이미지</label> <br> <input type="file"
				id="exampleInputFile">
		</div>
	</div>
	<div class="row">
		<div class="form-group col-lg-6">
			<label>아이디</label> <input type="" name="" class="form-control" id=""
				placeholder="${PUserVO.id}">
		</div>
	</div>
	<div class="row">
		<div class="form-group col-lg-6">
			<label>비밀번호</label> <input type="" name="" class="form-control" id=""
				placeholder="${PUserVO.pw}">
		</div>
	</div>

	<div class="row">
		<div class="form-group col-lg-6">
			<label>이름</label> <input type="" name="" class="form-control" id=""
				placeholder="${PUserVO.pname}">
		</div>
	</div>
	<div class="row">
		<div class="form-group col-lg-6">
			<label>email</label>
			<input type="" name = "" class="form-control" id=""
				placeholder ="${PUserVO.email}">
		</div>
	</div>

	<div class="row">
		<!-- ☆google search : datepicker -->
		<div class="form-group col-lg-6">
			<label>생일</label>
			<div class="input-group date" data-provide="datepicker">
				<input type="text" class="form-control"
				placeholder ="${PUserVO.birth}">
				<span
					class="input-group-addon"> <i
					class="glyphicon glyphicon-calendar"></i>
				</span>
			</div>
		</div>
	</div>
	<br> <br>
	<!-- 수정 버튼 -->
	<form>
		<input class="btn btn-success" type='button' value='완료'
			onClick="javascript:self.location='C_index_r04.html';">
	</form>
	<!-- //수정 버튼 -->
	<br> <br>
</div>
<!-- //기업 페이지 -->

<script type='text/javascript'>
	$(function() {
		$('.input-group.date').datepicker({
			calendarWeeks : false,
			todayHighlight : true,
			autoclose : true,
			format : "yyyy-mm-dd",
			language : "kr"
		});
	});
</script>

<%@include file="../include/cfooter.jsp"%>
