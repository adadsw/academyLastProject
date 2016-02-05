<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<script src= /lastproject/resources/SJscript.js></script>

<style>
 #info {
  background:#FFBCB9;
 }
 #info1 {
  background:#F0FFF0;
 }
</style>

<c:if test="${sessionScope.id == 'host'}">
<jsp:include page="../menu/hostHeader.jsp" flush="false" />
</c:if>
<c:if test="${sessionScope.id != 'host'}">
<jsp:include page="../menu/guestHeader.jsp" flush="false" />
</c:if>
<h3><p class="text-center">WRITE</p></h3>
<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
    </div>
    <div class="col-sm-8 text-left"> 
<c:if test="${result==0 }">
		<script type="text/javascript">
			<!-- �ۼ� ���� -->
		
			<!--
				erroralert(passwderror);
			
			//-->
		</script>
	</c:if>
	<c:if test="${result !=0 }">
		<body onload="modifyfocus()">
			<form action="boardModifyPro" name="modifyform" method="post" onsubmit="return modifycheck()">
				<input type="hidden" name="num" value="${num}">
				<input type="hidden" name="pageNum" value="${pageNum}">
				
				<table class="table table-striped table-bordered table-hover table-condensed text-center">
					<tr id="info">
						<th colspan="2"><p class="text-center">
						<h4><p class="text-center">������ ������ �Է��ϼ���.</p></h4>
						</th>
					</tr>
					<tr>
						<th id="info1"><p class="text-center">�ۼ���</p></th>
						<td class="warning"><p class="text-center">${dto.id}</p></td>
					</tr>		
					<tr>
						<th id="info1"><p class="text-center">�̸���</p></th>
						<td class="warning">
							<c:if test="${dto.email == null}">
								<input placeholder="Enter email" type="text" name="email" class="form-control">
							</c:if>
							<c:if test="${dto.email !=null}">
								<input class="form-control" type="text" name="email" placeholder="Enter email" value="${dto.email}">							
							</c:if>
						</td>
					</tr>
					<tr>
						<th id="info1"><p class="text-center">������</p></th>
						<td class="warning">
						<input class="form-control" type="text" name="subject"  placeholder="Enter subject" value="${dto.subject}">
						</td>
					</tr>	
					<tr>
						<th id="info1"><p class="text-center">�۳���</p></th>
						<td class="warning">
						<textarea placeholder="Enter content" name="content" rows="10" cols="70" >${dto.content}</textarea>
						</td>
					</tr>			
					<tr>
						<th id="info1"><p class="text-center">��й�ȣ</p></th>
						<td class="warning">
						<input class="form-control" type="password" name="passwd" placeholder="Enter subject" value="${dto.passwd}">
						</td>
					</tr>	
					<tr id="info">
						<th colspan="2"><p class="text-center"> 
						<button type="submit" class="btn btn-warning">�ۼ���</button>
						<button type="reset" class="btn btn-warning">�����</button>
						<button type="button" class="btn btn-warning" onclick="window.location='boardList?pageNum=${pageNum}'">��Ϻ���</button>
						</p></th>
					</tr>
				</table>
			</form>
		</body>	
	</c:if>
</div>
<div class="col-sm-2 sidenav">
</div>
</div>
</div>
	<jsp:include page="../menu/guestFooter.jsp" flush="false"/>