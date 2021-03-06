<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<%--
Created by IntelliJ IDEA.
User: Taohaowei
Date: 2017/7/26
Time: 14:51
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Blog &mdash; My Private space</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="${blog.title},${blog.summary}" />
	<meta name="keywords" content="${blog.blogType}" />
	<meta name="author" content="TaoHaoWei" />

	

  	<!-- Facebook and Twitter integration -->
	<meta property="og:title" content="${blog.title}"/>
	<meta property="og:image" content=""/>
	<meta property="og:url" content="http://www.mynight.top"/>
	<meta property="og:site_name" content=""/>
	<meta property="og:description" content=""/>
	<meta name="twitter:title" content="${blog.title}" />
	<meta name="twitter:image" content="" />
	<meta name="twitter:url" content="http://www.mynight.top" />
	<meta name="twitter:card" content="" />
	<link rel="stylesheet" href="<%=basePath%>themes/base.css" />
	<script type="text/javascript" src="<%=basePath%>themes/MathJax.js"></script>
	<%--<link href="https://fonts.googleapis.com/css?family=Work+Sans:300,400,500,700,800" rel="stylesheet">--%>

	<link rel="shortcut icon" href="<%=basePath%>images/title.ico" type="image/x-icon"/>
	<!-- Animate.css -->
	<link rel="stylesheet" href="<%=basePath%>css/animate.css">
	<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" href="<%=basePath%>css/icomoon.css">
	<!-- Bootstrap  -->
	<link rel="stylesheet" href="<%=basePath%>css/bootstrap.css">

	<!-- Theme style  -->
	<link rel="stylesheet" href="<%=basePath%>css/style.css">



	<!-- Modernizr JS -->
	<script src="<%=basePath%>js/modernizr-2.6.2.min.js"></script>
	<!-- FOR IE9 below -->
	<!--[if lt IE 9]>
	<script src="<%=basePath%>js/respond.min.js"></script>
	<![endif]-->

	</head>
	<body class="single">
		
	<div class="fh5co-loader"></div>
	
	<div id="page">
		<div id="fh5co-aside" style="background-image: url(<%=basePath%>images/image_2.jpg)" data-stellar-background-ratio="0.5">
			<div class="overlay"></div>
			<nav role="navigation">
				<ul>
					<li><a href="<%=basePath%>/blog/loadIndex.html"><i class="icon-home"></i></a></li>
				</ul>
			</nav>
			<div class="page-title">
				<img src="<%=basePath%>images/person_2.jpg" alt="Free HTML5 by FreeHTMl5.co">
				<span>${sdf.format(blog.createTime)}</span>
				<h2>${blog.title}</h2>
			</div>
		</div>
		<div id="fh5co-main-content">
			<div class="fh5co-post"> 
				<div class="fh5co-entry padding">
					<div>
						<p>-------------------------------------我是一条正文分割线-------------------------------------</p>
						<c:if test="${sdf.format(blog.createTime)<'2017-07-03'}">
						<p>------------------这篇博客是从我的csdn转移过来的，可能会存在轻微的格式问题，抱歉^_^------------------</p>
						</c:if>
						${blog.context}
						
					</div>
				</div>
				
				

			</div>
		</div>
	</div>

	<div class="fh5co-navigation">
		<c:if test="${preBlog==null}">
			<div class="fh5co-cover prev fh5co-cover-sm" style="background-image: url(<%=basePath%>images/)">
				<div class="overlay"></div>

				<a class="copy" href="#">
					<div class="display-t">
						<div class="display-tc">
							<div>
								<span>No Have Previous Blog</span>
								<%--<h2>${preBlog.title}</h2>--%>
							</div>
						</div>
					</div>
				</a>
			</div>
		</c:if>
		<c:if test="${preBlog!=null}">
		<div class="fh5co-cover prev fh5co-cover-sm" style="background-image: url(<%=basePath%>images/${preBlog.summaryImg})">
			<div class="overlay"></div>

			<a class="copy" href="<%=basePath%>/blog/toNextBlog.html?blogId=${preBlog.id}">
				<div class="display-t">
					<div class="display-tc">
						<div>
							<span>Previous Blog</span>
							<h2>${preBlog.title}</h2>
						</div>
					</div>
				</div>
			</a>
		</div>
		</c:if>
		<c:if test="${nextBlog==null}">
			<div class="fh5co-cover next fh5co-cover-sm" style="background-image: url(<%=basePath%>images/)">
				<div class="overlay"></div>
				<a class="copy" href="#">
					<div class="display-t">
						<div class="display-tc">
							<div>
								<span>No Have Next Blog</span>
								<%--<h2>${nextBlog.title}</h2>--%>
							</div>
						</div>
					</div>
				</a>

			</div>
		</c:if>
		<c:if test="${nextBlog!=null}">
		<div class="fh5co-cover next fh5co-cover-sm" style="background-image: url(<%=basePath%>images/${nextBlog.summaryImg})">
			<div class="overlay"></div>
			<a class="copy" href="<%=basePath%>/blog/toNextBlog.html?blogId=${nextBlog.id}">
				<div class="display-t">
					<div class="display-tc">
						<div>
							<span>Next Blog</span>
							<h2>${nextBlog.title}</h2>
						</div>
					</div>
				</div>
			</a>
		</div>
		</c:if>
	</div>

	<footer>
		<jsp:include page="foot.jsp"/>
	</footer>

	<div class="gototop js-top">
		<a href="#" class="js-gotop"><i class="icon-arrow-up"></i></a>
	</div>
	
	<!-- jQuery -->
	<script src="<%=basePath%>js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="<%=basePath%>js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="<%=basePath%>js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="<%=basePath%>js/jquery.waypoints.min.js"></script>
	<!-- Stellar Parallax -->
	<script src="<%=basePath%>js/jquery.stellar.min.js"></script>
	<!-- Main -->
	<script src="<%=basePath%>js/main.js"></script>

	</body>
</html>

