<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 


<body>
	<c:if test="${resultPasswd==0 }">
		<script type="text/javascript">
			<!-- �ۼ� ���� -->
		
			<!--
				erroralert(passwderror);
			
			//-->
		</script>
	</c:if>
		<c:if test="${resultPasswd !=0 }">
			<c:if test="${result==-1 }"> 
			<!--����� �ִ°��  -->
				<script type="text/javascript">
					<!--
						erroralert(replyerror);
					//-->
				</script>
				<meta http-equiv="refresh" content="0; url='list?pageNum=${pageNum}'">
				</c:if>
			<c:if test="${result==0}">
				<script type="text/javascript">
					<!--
						erroralert(deleteerror);
						//-->
				</script>
			</c:if>
		<c:if test="${result ==1 }">
					<!-- �ۼ� ���� -->
					<c:redirect url="list?pageNum=${pageNum}" />
				</c:if>
		</c:if>
</body>
</html>