<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<title>��� ��� ������</title>


</head>

	<h2>����� ������</h2>
	<body onload="">
		<form>
		<table border="1">
			<tr>
					<th>��� ǰ��</th>
					<th>��� ����</th>
	
			</tr>		
			<c:forEach var="ingredient" items="${ingredientList}">
				<tr>
				<td>
				<a href="modifyForm?ingredient_code=${ingredient.ingredient_code}&ingre_num=${ingredient.ingre_num}">${ingredient.ingredient}</a></td>
	            <td>${ingredient.ingre_num}</td>
	         </tr>
			</c:forEach>
			<tr>
				<th colspan="2">
				<input class="inputbutton" type="button" value="ǰ�� �߰�" onclick="window.location='inputForm'">
				</th>
			</tr>
		</table>
		
		<table border="1">
			<tr>
					<th>��� ǰ��</th>
					<th>��� ����</th>
	
			</tr>		
			<c:forEach var="food" items="${goodslist}">
				<tr>
				<td>
				<a href="foodmodifyForm?food_code=${food.food_code}">${food.food_name}</a></td>
	            <td>${food.food_num}</td>
	
	         </tr>
			</c:forEach>
			<tr>
				<th colspan="2">
				<input class="inputbutton" type="button" value="ǰ�� �߰�" onclick="window.location='inputForm'">
				</th>
			</tr>
		</table>
		</form>
	</body>
</html>