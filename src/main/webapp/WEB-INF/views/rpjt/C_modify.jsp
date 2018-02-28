<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../include/cheader.jsp"%>

<!-- picker : https://lalwr.blogspot.kr/2016/04/bootstrap-datepicker.html -->
<link rel="stylesheet" type="text/css" href="/resources/rpjt/datepicker/datepicker3.css" />
<script type="text/javascript" src="/resources/rpjt/datepicker/bootstrap-datepicker.js"></script>
<script type="text/javascript" src="/resources/rpjt/datepicker/bootstrap-datepicker.kr.js"></script>

<!-- Main content -->
<!-- 기업 페이지 -->
<div class="col-md-9">
	<br> <br>
	<div class="row">
		<div class="form-group col-lg-6">
			<label>기업명</label> <input type="" name="" class="form-control" id=""
				value="${cinfoVO.cname}">
		</div>

		<div class="form-group col-lg-6">
			<label>대표자명</label> <input type="" name="" class="form-control" id=""
				value="${cinfoVO.ceo}">
		</div>
	</div>

	<div class="row">
		<div class="form-group col-lg-6">
			<label>업종</label> <input type="" name="" class="form-control" id=""
				value="${cinfoVO.ctype}">
		</div>

		<div class="form-group col-lg-6">
			<label>로고이미지</label> <br> <input type="file"
				id="exampleInputFile">
		</div>
	</div>
	<div class="row">
		<div class="form-group col-lg-12">
			<label>기업소개</label>
			<textarea class="form-control" rows="2">${cinfoVO.intro}</textarea>
		</div>
	</div>

	<div class="row">
		<div class="form-group col-lg-6">
			<label>기업형태</label> <input type="" name="" class="form-control" id=""
				value="${cinfoVO.form}">
		</div>

		<!-- ☆google search : datepicker -->
		<div class="form-group col-lg-6">
			<label>설립일</label>
			<div class="input-group date" data-provide="datepicker">
				<input type="text" class="form-control"> <span
					class="input-group-addon"> <i
					class="glyphicon glyphicon-calendar"></i>
				</span>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="form-group col-lg-6">
			<label>사원수</label> <input type="" name="" class="form-control" id=""
				value="${cinfoVO.numemp}">
		</div>

		<div class="form-group col-lg-6">
			<label>매출액</label> <input type="" name="" class="form-control" id=""
				value="${cinfoVO.sales}">
		</div>
	</div>


	<div class="row">
		<div class="form-group col-lg-6">
			<label>대표전화</label> <input type="" name="" class="form-control" id=""
				value="${cinfoVO.tel}">
		</div>

		<div class="form-group col-lg-6">
			<label>FAX</label> <input type="" name="" class="form-control" id=""
				value="${cinfoVO.fax}">
		</div>
	</div>


	<div class="row">

		<div class="form-group col-lg-6">
			<label>홈페이지</label> <input type="" name="" class="form-control" id=""
				value="${cinfoVO.homepage}">
		</div>

		<div class="form-group col-lg-6">
			<label>SNS</label> <input type="" name="" class="form-control" id=""
				value="${cinfoVO.sns}">
		</div>
	</div>


	<div class="row">
		<div class="form-group col-lg-12">
			<label>기업주소</label> <input type="" name="" class="form-control" id=""
				value="${cinfoVO.location}">
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
			format : "yyyy/mm/dd",
			language : "kr"
		});
	});
</script>

<%@include file="../include/cfooter.jsp"%>
