<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../include/cheader.jsp"%>

<!-- Main content -->
<!-- 공고 작성 바디 -->
<div class="col-md-9">

	<!-- 회사 기본 정보  -->
	<!-- DB에서 값을 불러와서 td에 채워 넣어야 함  -->
	<h3>공고제목</h3>
	<input type="text" class="form-control"> <br>
	<h3>기본정보</h3>
	<table class="table table-bordered">
		<tr>
			<th>기업명</th>
			<td>${cinfoVO.cname}</td>
			<th>대표자명</th>
			<td>${cinfoVO.ceo}</td>
		</tr>
		<tr>
			<th>소속그룹</th>
			<td colspan="3">???</td>
		</tr>
		<tr>
			<th>업종</th>
			<td colspan="3">${cinfoVO.ctype}</td>
		</tr>
		<tr>
			<th>사업내용</th>
			<td colspan="3">???</td>
		</tr>
		<tr>
			<th>기업형태</th>
			<td colspan="3">${cinfoVO.form}</td>
		</tr>
		<tr>
			<th>설립일</th>
			<td>${cinfoVO.establish}</td>
			<th>채용현황</th>
			<td>???</td>
		</tr>
		<tr>
			<th>매출액</th>
			<td colspan="3">${cinfoVO.sales}</td>
		</tr>
		<tr>
			<th>자본금</th>
			<td colspan="3">???</td>
		</tr>
		<tr>
			<th>대표전화</th>
			<td>${cinfoVO.tel}</td>
			<th>FAX</th>
			<td>${cinfoVO.fax}</td>
		</tr>
		<tr>
			<th>홈페이지</th>
			<td><a href="${cinfoVO.homepage}" class="link_site"
				target="_blank" rel="nofollow">${cinfoVO.homepage}</a></td>
			<th>SNS / 블로그</th>
			<td><a href="{cinfoVO.sns}" class="link_site"
				target="_blank" rel="nofollow">${cinfoVO.sns}</a></td>
		</tr>
		<tr>
			<th>기업주소</th>
			<td colspan="3">${cinfoVO.location}</td>
		</tr>
	</table>
	<br> <br> <br>
	<!-- // 회사 기본 정보 끝 -->

	<!-- 공고 입력 부분 -->
	<h3>모집부문</h3>
	<form action="C_manage.html" method="POST">
		<table class="table table-bordered" id="my-tbody">
			<tr>
				<th>모집직종</th>
				<td><select name="" id="">
						<option value="null">분류1</option>
						<option value="1">웹프로그래머</option>
						<option value="2">응용프로그래머</option>
				</select> -> <select name="" id="">
						<option value="">분류2</option>
						<option value="">Java</option>
						<option value="">JSP</option>
				</select>
					<button type="button">삭제</button>
					<button type="button">추가</button> <br> <select name="" id="">
						<option value="null">분류1</option>5
						<option value="1">웹프로그래머</option>
						<option value="2">응용프로그래머</option>
				</select> -> <select name="" id="">
						<option value="">분류2</option>
						<option value="">Java</option>
						<option value="">JSP</option>
				</select>
					<button type="button">삭제</button></td>
			</tr>
			<tr>
				<th>근무지역</th>
				<td><select name="" id="">
						<option value="null">도</option>
						<option value="1">강원도</option>
						<option value="2">경기도</option>
				</select> -> <select name="" id="">
						<option value="">시</option>
						<option value="">강릉시</option>
						<option value="">고성군</option>
				</select>
					<button type="button">삭제</button>
					<button type="button">추가</button></td>
			</tr>
			<tr>
				<th>담당업무</th>
				<td><textarea name="" id="" cols="30" rows="5"></textarea></td>
			</tr>
			<tr>
				<th>모집인원</th>
				<td><input type="number" name="quantity" min="1" max="5">
					명</td>
			</tr>
			<tr>
				<th>근무형태</th>
				<td><select name="" id="">
						<option value="">근무형태</option>
						<option value="1">정규직</option>
						<option value="2">계약직</option>
						<option value="3">병역특례</option>
						<option value="4">프리랜서</option>
						<option value="5">헤드헌팅</option>
						<option value="6">파견대행</option>
						<option value="7">인턴직</option>
				</select></td>
			</tr>
			<tr>
				<th>급여사항</th>
				<td><select name="" id="">
						<option value="">급여사항</option>
						<option value="34">2000이하</option>
						<option value="35">~2500</option>
						<option value="36">~3000</option>
						<option value="37">~3500</option>
						<option value="38">~4000</option>
						<option value="39">~4500</option>
						<option value="40">~5000</option>
				</select></td>
			</tr>
			<tr>
				<th>학력</th>
				<td><select name="" id="">
						<option value="">학력</option>
						<option value="9">대학교졸업(4년)</option>
						<option value="10">대학졸업(2,3년)</option>
						<option value="11">대학원 석사졸업</option>
						<option value="12">대학원 박사졸업</option>
						<option value="13">고등학교졸업</option>
						<option value="14">학력무관</option>
				</select></td>
			</tr>
			<tr>
				<th>경력</th>
				<td><select name="" id="">
						<option value="">경력</option>
						<option value="1">신입</option>
						<option value="2">1~3년</option>
						<option value="3">4~6년</option>
						<option value="4">7~9년</option>
						<option value="5">10~15년</option>
						<option value="6">16~20년</option>
						<option value="7">21년 이상</option>
				</select></td>
			</tr>
			<tr>
				<th>상세내용 및 우대사항</th>
				<td><textarea name="" id="" cols="30" rows="10"></textarea></td>
			</tr>
			<tr>
				<th>접수기간</th>
				<td><input type="date"> -> <input type="date">
				</td>
			</tr>
			<tr>
				<th>접수방법</th>
				<td><input type="radio" name="sbm">홈페이지접수 &nbsp; <input
					type="radio" name="sbm">즉시지원</td>
			</tr>
		</table>
		<br> <br> <input class="btn btn-success" type="submit"
			value="등록">
	</form>
	<br>
	<!-- // 공고 입력 부분 끝 -->
</div>
<!-- // 공고 작성 바디 끝 -->

<%@include file="../include/cfooter.jsp"%>
