<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<jsp:include page="../menu/guestHeader.jsp" flush="false"/>
<h3><p class="text-center">WRITE</p></h3>
<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-4 sidenav">
    </div>
    <div class="col-sm-4 text-left"> 
	<body onload="passwdfocus()">
	<form action="boardModifyView" name="passwdform" method="post" onsubmit="return passwdcheck()">
		<input type="hidden" name="num" value="${num}">
		<input type="hidden" name="pageNum" value="${pageNum}">
	
		<table class="table table-striped table-bordered table-hover table-condensed text-center" >
			<tr class="info">
				<th colspan="2">
					<p class="text-center">��й�ȣ�� �ٽ� Ȯ�����ּ���.</p>
				</th>
			</tr>
			<tr>
				<th><p class="text-center">��й�ȣ</p></th>
				<td><input class="input" type="password" name="passwd" maxlength="12"></td>
			</tr>
			<tr class="info">
				<th colspan="2"><p class="text-center">
				<button type="submit" class="btn btn-warning">�ۼ���
				</button>
				<button type="button" class="btn btn-warning" onclick="window.location='boardList?pageNum=${pageNum}'">�������
				</button></p>
				</th>
			</tr>
		</table>	
	
	</form>
</body>
</div>
<div class="col-sm-4 sidenav">
</div>
</div>
</div>
</html>
<jsp:include page="../menu/guestFooter.jsp" flush="false"/>