<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<jsp:include page="../menu/guestHeader.jsp" flush="false"/>
<h2> �� ����</h2>

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
				
				<table>
					<tr>
						<th colspan="2">
						������ ������ �Է��ϼ���.
						</th>
					</tr>
					<tr>
						<th> �ۼ���</th>
						<td>${dto.writer}</td>
					</tr>		
					<tr>
						<th> �̸���</th>
						<td>
							<c:if test="${dto.email == null}">
								<input class="inputbutton" type="text" name="email" maxlength="30">
							</c:if>
							<c:if test="${dto.email !=null}">
								<input class="inputbutton" type="text" name="email" maxlength="30" value="${dto.email}">							
							</c:if>
						</td>
					</tr>
					<tr>
						<th>������</th>
						<td>
						<input class="inputbutton" type="text" name="subject" maxlength="50" value="${dto.subject}">
						</td>
					</tr>	
					<tr>
						<th>�۳���</th>
						<td>
						<textarea class="input" name="content" rows="10" cols="32" >${dto.content}</textarea>
						</td>
					</tr>			
					<tr>
						<th>��й�ȣ</th>
						<td>
						<input class="inputbutton" type="password" name="passwd" maxlength="12" value="${dto.passwd}">
						</td>
					</tr>	
					<tr>
						<th colspan="2">
							<input class="inputbutton" type="submit" value="�ۼ���">
							<input class="inputbutton" type="reset" value="�����">
							<input class="inputbutton" type="button" value="��Ϻ���" onclick="window.location='list?pageNum=${pageNum}'">
					</tr>
				</table>
			</form>
		</body>	
	</c:if>
	<jsp:include page="../menu/guestFooter.jsp" flush="false"/>