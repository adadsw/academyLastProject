<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../../menu/hostHeader.jsp" flush="false" />

<h2><p class="text-center">Dessert Modify</p></h2>
<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-4 sidenav">
    </div>
    <div class="col-sm-4 text-left"> 
	<form action="foodModifyPro" method="post">
		<table  class="table table-striped table-bordered table-hover table-condensed text-center" >
			<tr class="info">
				<th colspan="2"><h4><p class="text-center">���� ������ �Է��ϼ���.</p></h4></th>
			</tr>
			<tr>
				<th><h4><p class="text-center">������</p></h4></th>
				<td>
				<h4><input type="hidden" name="food_code" value="${param.food_code}"></h4>
				<h4><input class="input" type="number" name="food_num" min="0" max="999" value="${param.food_num}"></h4>
				</td>
			</tr>
			<tr class="info">
				<th colspan="2">
				<h4><p class="text-center">
				<button type="submit" class="btn btn-warning">����Ȯ��
				</button>
				<button type="button" class="btn btn-warning" onclick="window.location='ingredient'">�������
				</button></p></h4>
				</th>
			</tr>
		</table>
	</form>
</div>
</div>
</div>
<jsp:include page="../../menu/hostFooter.jsp" flush="false" />