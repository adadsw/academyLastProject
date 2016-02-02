<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<jsp:include page="../../menu/hostHeader.jsp" flush="false" />
    <h3>정산 페이지(${time})</h3>
	<form method="get" action="accountMonth">
	<table>
		<tr>
			<td><input type="button" value="일간"
				onclick="window.location='accountDay'"></td>
			<td><input type="submit" value="월간"> 
			<input name="monlist" type="text" list="monthList"> <datalist
					id="monthList">
					<option value="01" label="january"></option>
					<option value="02" label="febuary"></option>
					<option value="03" label="march"></option>
					<option value="04" label="april"></option>
					<option value="05" label="may"></option>
					<option value="06" label="june"></option>
					<option value="07" label="july"></option>
					<option value="08" label="august"></option>
					<option value="09" label="setember"></option>
					<option value="10" label="october"></option>
					<option value="11" label="november"></option>
					<option value="12" label="december"></option>
				</datalist></td>
		</tr>
	</table>
</form>
<form method="get" action="accountDateSelect">
	<table>
		<tr>
			<td><input type="submit" value="기간선택"> <input
				type="date" value="dateselect" name="startday"> ~ <input
				type="date" value="dateselect" name="endday"></td>
		</tr>
	</table>
</form>
<form>	
		<table border ="1">
			
			<tr>
				<th>일자</th>
				<th>일간 수익</th>
				<th>일간 사용 시간</th>
			</tr>
			<c:forEach var="mList" items="${mList}">
			<tr>
				<td>${mList.date}</td>	
				<%-- <c:forEach var="mPrice" items="${mPrice}">
				<td>${mPrice.price}</td>
				</c:forEach> --%>
				<td>0</td>		
			</tr>
		</c:forEach>
		</table>
		
		<table border="1">
			<tr>
				<th>총 가격</th>
			</tr>
			<c:set var="mTotal" value="${mTotal}" />
			<tr>
				<td>${mTotal.total_price}</td>
			</tr>	
		</table>
	</form>
	<jsp:include page="../../menu/hostFooter.jsp" flush="false" />