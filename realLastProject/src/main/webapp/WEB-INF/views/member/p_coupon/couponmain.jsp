<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<jsp:include page="../../menu/guestHeader.jsp" flush="false"/>

<style>
#info{
background:#FFE65A;
}

</style>


<head>
<script type="text/javascript">
function setCoupon(coupon_code) {
	opener.document.paymentForm.coupon.value =coupon_code;
	self.close();
	}

</script>


<body>
<h3><p class="text-center">Coupon</p></h3>
<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
    </div>
    <div class="col-sm-8 text-left"> 
 	<table class="table table-striped table-bordered table-hover table-condensed text-center">
	<tr id="info">
	<th><p class="text-center">Coupon</p></th>
	<th><p class="text-center">���� ���Ⱓ</p></th>
	</tr>
	<tr class="warning">
	<td>
	<img src="/lastproject/resources/images/coupon.png" width =400px height=200px>
	</td>
	<td>
	<br><br><br><br>
	<h4><p class="text-center"> 2016.01.01 ~ 2016.08.30</p></h4>
	</td>
	</tr>
	</table>
</div>
<div class="col-sm-2 sidenav"></div>
</div>
</div>
</body>