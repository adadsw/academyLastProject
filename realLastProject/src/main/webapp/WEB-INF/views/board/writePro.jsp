<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<title>�۾��� ó�� ������ </title>

	<c:if test="${result==0 }">
		<script type="text/javascript">
			<!-- �ۼ� ���� -->
		
			<!--
				erroralert(inserterror);
			
			//-->
		</script>
	</c:if>
	<c:if test="${result !=0 }">
		<!-- �ۼ� ���� -->
		<c:redirect url="boardList" />
	</c:if>

</html>