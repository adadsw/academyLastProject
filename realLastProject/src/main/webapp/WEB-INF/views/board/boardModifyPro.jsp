<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> ent="text/html; charset=EUC-KR">
<script src= /lastproject/resources/SJscript.js></script>
<h2>�� ����</h2>

	<c:if test="${result==0 }">
		<script type="text/javascript">
			<!-- �ۼ� ���� -->
		
			<!--
				erroralert(modifyerror);
			
			//-->
		</script>
	</c:if>
	<c:if test="${result !=0 }">
		<!-- �ۼ� ���� -->
		<c:redirect url="boardList?pageNum=${pageNum}" />
	</c:if>
</html>