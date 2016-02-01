<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<h3>정산 페이지(${time})</h3>
	<form method="get" action="accountDateSelect">
		<table>
			<tr>
			<td><input type="button" value="일간" 
					onclick="window.location='accountDay'"></td>
			<td><input type="button" value="월간" 
			onclick="window.location='accountMonth?list=${list}'" >
			<input name="list" type="text" list="monthList">
			<datalist id = "monthList">
				<option value = "1월"></option>	
				<option value = "2월"></option>	
				<option value = "3월"></option>	
				<option value = "4월"></option>	
				<option value = "5월"></option>	
				<option value = "6월"></option>	
				<option value = "7월"></option>	
				<option value = "8월"></option>	
				<option value = "9월"></option>	
				<option value = "10월"></option>	
				<option value = "11월"></option>	
				<option value = "12월"></option>	
			</datalist></td>
			<td><input type="submit" value="기간선택" id="select">
			<input type = "date" value = "dateselect" id="select">
			~ <input type = "date" value = "dateselect" id="select">
			</td>
			</tr>	
		</table>
	
		<table border ="1">
		
			<tr>
				<th>주문번호</th>
				<th>좌석번호</th>
				<th>주문시간</th>
				<th>사용시간</th>
				<th>가격</th>
			</tr>
			<c:forEach var="dayList" items="${list}">
			<tr>
				<td>${dayList.order_id}</td>
				<td>${dayList.seat_num}</td>
				<td>${dayList.order_time}</td>
				<td>${dayList.used_time}</td>
				<td>${dayList.price}</td>	
			</tr>
		</c:forEach>
		</table>
		<c:set var="dto" value="${dto}" />
		<table border="1">
			<tr>
				<th>총 가격</th>
			</tr>
			<tr>
				<td>${dto.total_price}</td>
			</tr>	
		</table>
	</form>