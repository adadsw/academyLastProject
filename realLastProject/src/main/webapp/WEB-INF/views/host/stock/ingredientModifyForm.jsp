<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>���� ��� ���� ���� ������</title>
</head>

<h2>���� ��� ���� ���� ������</h2>
<body>
	<form action="modifyPro" method="post">
		<table>
			<tr>
				<th colspan="2">���������� �Է��ϼ���.</th>
			</tr>
			<tr>
				<th>������</th>
				<td>
					<input type="hidden" name="ingredient_code" value="${param.ingredient_code}"> 
					<input class="input" type="number" name="ingre_num" min="0" max="999" value="${param.ingre_num}">
				</td>
			</tr>
			<tr>
				<th colspan="2">
					<input class="inputbutton" type="submit" value="����Ȯ��">
					<input class="inputbutton" type="button" value="�������" 
						onclick="window.location='ingredient'">
				</th>
			</tr>
		</table>
	</form>
</body>

</html>