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
	<title>Story &mdash; Free Website Template, Free HTML5 Template by freehtml5.co</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Free HTML5 Website Template by freehtml5.co" />
	<meta name="keywords" content="free website templates, free html5, free template, free bootstrap, free website template, html5, css3, mobile first, responsive" />
	<meta name="author" content="freehtml5.co" />

	

  	<!-- Facebook and Twitter integration -->
	<meta property="og:title" content=""/>
	<meta property="og:image" content=""/>
	<meta property="og:url" content=""/>
	<meta property="og:site_name" content=""/>
	<meta property="og:description" content=""/>
	<meta name="twitter:title" content="" />
	<meta name="twitter:image" content="" />
	<meta name="twitter:url" content="" />
	<meta name="twitter:card" content="" />
	<link href="https://fonts.googleapis.com/css?family=Work+Sans:300,400,500,700,800" rel="stylesheet">
		<style>
			/* =======================================================
			*
			* 	新增按钮
			*
			* ======================================================= */
		.tm-submit-btn {
			background-color: #0066CC;
			border: none;
			color: white;
			padding: 10px 50px;
			margin-top: 10px;
			font-weight: 400;
			font-size: 2.5rem;
		}</style>
		<script>
			function clickType(obj) {
			    document.getElementById("blogtype").innerHTML=obj.innerHTML;
                document.getElementById("type").innerHTML=obj.innerHTML;
            }
		</script>
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
					<li><a href="index.index.jsp"><i class="icon-home"></i></a></li>
				</ul>
			</nav>
			<div class="page-title">
				<img src="<%=basePath%>images/person_1.jpg" alt="Free HTML5 by FreeHTMl5.co">
				<span>September 10, 2016</span>
				<h2>新增博客</h2>
			</div>
		</div>
		<div id="fh5co-main-content">
			<div class="fh5co-post"> 
				<div class="fh5co-entry padding">
					<div>
						<p><a style="color: #3361cd;" href="https://stackedit.io/editor">文章编辑</a>  ${fileUrl}</p>
						<p>上传博客内容图片，以及文章编辑生成的 blog.html文件</p>
						<form action="/blog/uploadFile.html" method="post" enctype="multipart/form-data">
							<div class="form-group" >
								<input type="file" id="file" name="file" style="display: inline;width: 80%" class="form-control">
								<input type="submit" style="width: 18%" class="btn" value="上传图片"/>
							</div>
							<%--<div class="form-group">--%>
								<%--<input type="file" id="context" name="contextFile" style="display: inline;width: 80%" class="form-control" placeholder="博客内容" required="">--%>
								<%--<button type="submit" style="width: 18%" class="btn">上传文章</button>--%>
							<%--</div>--%>
						</form>

						<form action="/blog/insert.html" method="post" class="tm-contact-form">
							<div class="form-group">
								<div class="btn-group">
									<button id="blogtype" class="btn dropdown-toggle" data-toggle="dropdown">
										博客类型
										<input type="hidden" name="typeName" id="type">
									</button>
									<ul class="dropdown-menu">
										<li onclick="clickType(this)">  原创  </li>
										<li onclick="clickType(this)">  转载  </li>
										<li onclick="clickType(this)">  翻译  </li>
										<li onclick="clickType(this)">  收藏  </li>
									</ul>
								</div>
								<input type="text" style="display: inline;width: 80%" id="title" name="title" class="form-control" placeholder="标题" required="">
							</div>

							<div class="form-group">
								<input type="email" name="blogType" class="form-control" placeholder="文章分类，多个用逗号分隔" required="">
							</div>


							<div class="form-group">
								<textarea id="summary" name="summary" class="form-control" rows="5" placeholder="摘要" required=""></textarea>
							</div>

							<button type="submit" class="tm-submit-btn">Send</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="fh5co-navigation">
		<div class="fh5co-cover prev fh5co-cover-sm" style="background-image: url(<%=basePath%>images/project-4.jpg)">
			<div class="overlay"></div>

			<a class="copy" href="#">
				<div class="display-t">
					<div class="display-tc">
						<div>
							<span>Previous Post</span>
							<h2>How to be an affective web developer</h2>
						</div>
					</div>
				</div>
			</a>

		</div>
		<div class="fh5co-cover next fh5co-cover-sm" style="background-image: url(<%=basePath%>images/project-5.jpg)">
			<div class="overlay"></div>
			<a class="copy" href="#">
				<div class="display-t">
					<div class="display-tc">
						<div>
							<span>Next Post</span>
							<h2>How to be an affective web developer</h2>
						</div>
					</div>
				</div>
			</a>

		</div>
	</div>

	<footer>
		<div>
					&copy; 2016 Free HTML5. All Rights Reserved. Designed by <a href="" target="_blank">FreeHTML5</a> 
					</div>
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

