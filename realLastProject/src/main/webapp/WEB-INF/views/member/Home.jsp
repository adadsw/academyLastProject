<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">
<head>
  <title>회원 로그인</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
  <div class="row">
    <div class="col-sm-6" style="background-color:lavender;"></div>
    <div class="col-sm-4" style="background-color:lavenderblush;"><mark>${id}</mark>님 안녕하세요.</div>
   	<div class="col-sm-2" style="background-color:lavenderblush;">
    <a href="memberLogout"><span class="glyphicon glyphicon-log-out"></span>Logout</a>
    </div>
  </div>
  <blockquote>
   <h1>Sasaeg cafe</h1>
  <p> 커피 한잔, 책 한권 북카페</p>
  </blockquote>
</div>

<nav class="navbar navbar-default"">
  <div class="container">
    <div class="navbar-header">
      <a class="navbar-brand"><span style="color:black">SASAEG<img src="/lastproject/resources/images/glyphicons_free/glyphicons_free/glyphicons/png/glyphicons-20-heart-empty.png"></span></a>
    </div>
    <ul class="nav navbar-nav">
    <li class="active"><a href="Home">이용안내</a></li>
      <li><a href="seatList">좌석</a></li>
    	<li><a href="goodsList">메뉴</a></li>
      <li><a href="boardList">게시판</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a>마일리지:${mileage} point</a></li>
      <li>
      	  <c:if test="${coupon == 0}"><a>Coupon 없어</a></c:if>
      	  <c:if test="${coupon != 0}"><a href="couponmain">Coupon 있어</a></c:if>
      </li>
      <li><a href="memberModifyForm">회원정보수정</a></li>
    </ul>
  </div>
</nav>

<html> 
<head> 
<title>게시판 > Block _ 강남점 1 페이지</title> 
<meta http-equiv="content-type" content="text/html; charset=euc-kr"> 
<meta http-equiv="cache-control" content="no-cache"> 
<meta http-equiv="pragma" content="no-cache"> 
<meta http-equiv="imagetoolbar" content="no"> 

<link rel='stylesheet' href='/webzigi/css/style.css' type='text/css'> 
<link rel="shortcut icon" href="http://mayisland.cafe24.com/1/maypb.ico">
<!--[if lte IE 7]>
<link rel="stylesheet" type="text/css" href="css/ie7.css" />
<![endif]-->
<!--[if lte IE 9]>
<link rel="stylesheet" type="text/css" href="css/ie9.css" />
<![endif]-->
<link rel='stylesheet' type='text/css' href='css/chrome.css' />
<script language='JavaScript' src='http://www.mayisland.com/webzigi/js/javascript.js'></script> 
<script language='JavaScript' src='js/flash.js'></script> 
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js/tinyfader.js"></script>
<script type="text/javascript" src="js/slides.jquery.js"></script>
<script type="text/javascript" src="js/menu_banner.js"></script>
<script type="text/javascript" src="js/quick.js"></script>
<script type="text/javascript" src="js/kr.js"></script>
<script type="text/javascript" src="js/datepicker.js"></script>
<link href="css/datepicker.css" rel="stylesheet" type="text/css" />

<!-- 리포트2.0 로그분석코드 시작 -->
<script type="text/javascript">
var JsHost = (("https:" == document.location.protocol) ? "https://" : "http://");
var uname = escape('MAYISLAND');
document.write(unescape("%3Cscript id='log_script' src='" + JsHost + "mayisland.weblog.cafe24.com/weblog.js?uid=mayisland&uname="+uname+"' type='text/javascript'%3E%3C/script%3E"));
</script>
<!-- 리포트2.0  로그분석코드 완료 -->

</head> 

<body leftmargin='0' topmargin='0'>
<div class="container"> 
 <h4>SASAEG CAFE <mark><b>이용안내</b></mark></h4>
  <div class="row content">
    <div class="col-sm-2 sidenav">
    </div>
    <div class="col-sm-8 text-left"> 
<div class="wrap">

  
<!--서브02 -->
</td>
        <td width="745" valign="top" style="padding-bottom:100px;padding-top:20px;"><DIV><BR>
        <IMG border=0 src="http://mayisland.cafe24.com/webzigi/data/board/3690597053_znClaOpw_20150824_homepage_block_gn_guide_2428.png">
        <IMG border=0 src="http://mayisland.cafe24.com/webzigi/data/board/3690597053_TezkWSr4_20150824_homepage_block_gn_guide_0710.png"><BR>
        <IMG border=0 src="http://mayisland.cafe24.com/webzigi/data/board/3690597053_J6ln18yN_20150824_homepage_block_gn_guide_2024.png"><BR>
        <BR></DIV></td>
		</tr>
		</table>
		</td>
	</tr>
	</table>

</div> 
</div>
</div>
   <div class="col-sm-2 sidenav">
    </div>
<script language='JavaScript' src='http://www.mayisland.com/webzigi/js/wscript.js'></script> 
</body> 
</html> 

	<jsp:include page="../menu/guestFooter.jsp" flush="false"/>