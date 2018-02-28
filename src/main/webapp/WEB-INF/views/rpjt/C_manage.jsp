<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../include/cheader.jsp"%>

<!-- Main content -->
<!-- 기업 채용공고 목록 -->
<div class="col-md-9">
	<h1>채용 공고 목록</h1>
	<table class="table table-bordered">
		<tr>
			<th>순번</th>
			<th>공고 제목</th>
			<th style="text-align: center">기간</th>
			<th>조회수</th>
			<th style="text-align: center">지원자수</th>
			<th>진행/완료</th>
		</tr>
		<tr>
			<td>4</td>
			<td><a href="/rpjt/detail">IT 금융 및 연구소 경력사원 채용공고</a></td>
			<td>~3/02(금)</td>
			<td>72</td>
			<td style="text-align: center">13</td>
			<td>모집중</td>
		</tr>
		<tr>
			<td>3</td>
			<td><a href="C_detail.html">(주)케이티넥스알 인턴사원 모집</td>
			<td>~3/02(금)</a>
			</td>
			<td>72</td>
			<td style="text-align: center">6</td>
			<td>모집중</td>
		</tr>
		<tr>
			<td>2</td>
			<td><a href="C_detail.html">PHP개발자 / 웹,앱 개발 / 유지보수 / 퍼블리셔
					경력자 채용</a></td>
			<td>~3/02(금)</td>
			<td>72</td>
			<td style="text-align: center">4</td>
			<td>모집중</td>
		</tr>
		<tr>
			<td>1</td>
			<td><a href="C_detail.html">웹 프로그래머 / 시스템 엔지니어 / VOC 경력 및
					신입사원 모집</a></td>
			<td>~2/9(금)</td>
			<td>72</td>
			<td style="text-align: center">54</td>
			<td>모집완료</td>
		</tr>
	</table>
</div>
<!-- //기업 채용공고 목록 끝 -->

<%@include file="../include/cfooter.jsp"%>
