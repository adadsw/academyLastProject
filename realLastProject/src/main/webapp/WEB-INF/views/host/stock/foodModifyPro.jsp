<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src= /lastproject/resources/SJscript.js></script>
<title>Insert title here</title>
</head>
<body>
	<c:if test="${foodModifyResult == 0}">
		<script type="text/javascript">
		<!--
			erroralert(modifyerror);
		//-->
		</script>
	</c:if>
	<c:if test="${foodModifyResult != 0}">
		<c:redirect url="ingredient"/>
	</c:if>
</body>
</html>