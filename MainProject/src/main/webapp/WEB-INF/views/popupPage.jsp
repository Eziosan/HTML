<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>메인 페이지</title>
<link rel="stylesheet" type="text/css"
	href="./resources/css/default.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script type="text/javascript">

</script>
</head>
<body>
<div class="popup">
		<h2>간편 상담 신청</h2>
		<div class="con">
			<table class="type1">
				<caption>
					<details class="hide">
						<summary>간편상담신청 폼</summary>
						<div>신청자이름, 연락처, 메모, 적용가능</div>
					</details>
				</caption>

				<colgroup>
					<col style="width: 111px">
					<col>
				</colgroup>
				<tbody>
					<tr>
						<th><label for="txt1">신청자이름</label></th>
						<td><input type="text" id="txt1" placeholder="이름을 입력해 주세요"></td>
					</tr>
					<tr>
						<th><label for="txt2">연락처</label></th>
						<td><input type="tel" id="txt2" placeholder="숫자만 입력해 주세요"></td>
					</tr>
					<tr>
						<th><label for="txt3">메모</label>(0/300 byte)</th>
						<td><textarea id="txt3"
								placeholder="궁금하신 점이나 렌탈 계약 진행 시 SK매직
			이 고민해야 할 부분이 있다면 메모로 남겨 주세요.">
			</textarea></td>

					</tr>
					<tr>
						<th>적용 가능한<br>혜택이 있나요?
						</th>
						<td>
							<ul>
								<li><input type="checkbox" id="chk1_1"><label
									for="chk1_1">T멤버십 회원이에요</label></li>
								<li><input type="checkbox" id="chk1_2"><label
									for="chk1_2">지금 브로드밴드 인터넷을 쓰고 있어요</label></li>
								<li><input type="checkbox" id="chk1_3"><label
									for="chk1_3">브로드밴드 인터넷을 신규 가입하여 결합하고 싶어요</label></li>
							</ul>
						</td>
					</tr>
				</tbody>
			</table>

			<div class="agree">
				<input type="checkbox" id="chk1_4"><label for="chk1_4">[필수]개인정보
					수집 및 이용 동의</label> 
					<a href="#a" >전문보기</a>
			</div>

		</div>
	
		<div class="txt_center">
			<a href="#a" class="btn_type1">상담신청</a> 
		</div>
		<a href="#a" class="close">닫기</a>
	</div>

	<div class="dim"></div>
</body>
</html>
