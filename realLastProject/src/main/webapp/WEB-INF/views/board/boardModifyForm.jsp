<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<title>�ۼ��� ������</title>
</head>
<body onload="passwdfocus()">
	<form action="boardModifyView" name="passwdform" method="post" onsubmit="return passwdcheck()">
		<input type="hidden" name="num" value="${num}">
		<input type="hidden" name="pageNum" value="${pageNum}">
	
		<table>
			<tr>
				<th colspan="2">
					��й�ȣ�� �ٽ� Ȯ�����ּ���.
				</th>
			</tr>
			<tr>
				<th>��й�ȣ</th>
				<td><input class="input" type="password" name="passwd" maxlength="12"></td>
			</tr>
			<tr>
				<th colspan="2">
					<input class="inputbutton" type="submit" value="�ۼ���">
					<input class="inputbutton" type="button" value="�������" 
								onclick="window.location='list?pageNum=${pageNum}'">
				</th>
			</tr>
		</table>	
	
	</form>
</body>
</html>