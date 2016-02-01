<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.first.lastproject.dao.board.BoardDao"%>
<%@ page import="com.first.lastproject.dto.BoardDto" %>
<jsp:include page="../menu/guestHeader.jsp" flush="false"/>
<title>�Խ���</title>
<div class="container">
<h3><p class="text-center">WRITE LIST<small>(�۰��� : ${count})</small></p></h3>
	<div class="pull-right">
	 <a href="writeForm"><button type="button" class="btn btn-warning">Write
	 </button></a><br>
	 </div>

<table class="table table-striped table-bordered table-hover table-condensed text-center">
	<thead>
	<tr class="info">
		<th style="width: 5%"><p class="text-center">�۹�ȣ</p></th>
		<th style="width: 35%"><p class="text-center">������</p></th>
		<th style="width: 10%"><p class="text-center">�ۼ���</p></th>
		<th style="width: 15%"><p class="text-center">�ۼ���</p></th>
		<th style="width: 5%"><p class="text-center">��ȸ��</p></th>
		<th style="width: 10%"><p class="text-center">IP</p></th>

	</tr>
	</thead>
	<tbody>
	<c:if test="${count >0}">
		<c:forEach var="dto" items="${list}">
			<tr class="warning">
				<td align="center">
				 ${number}
				 	<c:set var="number" value="${number-1}"></c:set>
				 </td>
				 <td>
				 <c:if test="${dto.re_level >1 }">
				 	<c:set var="wid" value="${(dto.re_level -1) *10}" />
				 	<img src="${project}images/level.gif" border="0" width="${wid}" height="15">
				 </c:if>
				 	<c:if test="${dto.re_level >0 }">
				 		<img src="${project}images/re.gif" border="0" width="20" height="15">
				 	</c:if>
				 	<a href="contentForm?num=${dto.num}&pageNum=${pageNum}&number=${number+1}">${dto.subject }</a>
				 	<c:if test="${dto.readcount >20}">
				 		<img src="${project}images/hot.gif" border="0" width="20" height="15">
				 	</c:if>
				 </td>
				 <td align="center">
				 	${dto.writer}
				 </td>
				 <td align="center">
				 	<fmt:formatDate type="both" pattern="yyyy-MM-dd HH:mm" value="${dto.reg_date}" />
				 </td>
				 <td align="center">
				 	${dto.readcount}
				 </td>
				 <td align="center">
				 	${dto.ip}
				 </td>
			</tr>
		</c:forEach>
	</c:if>
	<c:if test="${count == 0}}">
		<!-- ���� ���� ��� -->
		<tr>
			<td colspan="6" align="center" style="height:40px">
				�Խ��ǿ� ���� �����ϴ�. �۾��⸦ ������ �ּ���.
			</td>
		</tr>
	</c:if>
</tbody>
</table>
</div>
<br>
<div class="container text-center">
	<c:if test="${count>0 }">
	<!-- ó��[����] ����[����] -->
		<c:if test="${startPage >pageBlock}">
		<ul class="pagination pagination-sm">
		<li><a href="boardList">����</a></li>
		<li><a href="boardList?pageNum=${startPage - pageBlock -1 }"> ��</a></li>
		</ul>
		</c:if>
		<c:forEach var="i" begin="${startPage}" end="${endPage}">
		<ul class="pagination pagination-sm">
		<li class="disable"><c:if test="${i==currentPage}">
			[${i}]
		</c:if></li>
		<li><c:if test="${i !=currentPage }">
			<a href="boardList?pageNum=${i}">${i}</a>
			</c:if></li>
		</ul>
		</c:forEach>
	<!-- ����[��] ��[����] -->
		<c:if test="${pageCount >endPage}">
		<ul class="pagination pagination-sm">
		<li><a href="boardList?pageNum=${startPage + pageBlock}">��</a></li>
		<li><a href="boardList?pageNum=${pageCount}">����</a></li>
			</ul>
			</c:if>
	</c:if>
	<jsp:include page="../menu/guestFooter.jsp" flush="false"/>
</div>
