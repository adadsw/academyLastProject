<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<script src="script.js"></script>
<link type="text/css" rel="stylesheet" href="">



<body>
	<form method="post" name="findForm">

		<table>
			<tr>
				<th>ID/PASSWD 찾기</th>
			</tr>

			<tr>
				<th>이름</th>
				<td><input class="input" type="text" name="name" maxlength="12">
				</td>
			</tr>
			<tr>
				<th>아이디</th>
				<td><input class="input" type="text" name="id" maxlength="12">
				</td>
			</tr>
			<tr>
				<th>주민번호</th>
				<td><input class="input" type="text" name="jumin1"
					maxlength="6" style="width: 50px" onkeyup="nextjumin1()"> -
					<input class="input" type="text" name="jumin2" maxlength="7"
					style="width: 60px" onkeyup="nextjumin2()"></td>
			</tr>
			<tr>
				<th colspan="2"><br> 
				<input class="inputbutton" type="button" value="비밀번호 찾기"
					onclick="window.location='findPasswdView.jsp'">
			</tr>
		</table>
	</form>
</body>




</html>