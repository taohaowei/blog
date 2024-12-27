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
    <meta name="description" content="陶浩伟的个人博客，http://www.mynight.top"/>
    <meta name="keywords"
          content="博客，私人空间、原创，个人展示"/>
    <meta name="author" content="TaoHaoWei"/>


    <!-- Facebook and Twitter integration -->
    <meta property="og:title" content="陶浩伟的个人博客，http://www.mynight.top"/>
    <meta property="og:image" content=""/>
    <meta property="og:url" content="http://www.mynight.top"/>
    <meta property="og:site_name" content="private space"/>
    <meta property="og:description" content="陶浩伟的个人博客，http://www.mynight.top"/>
    <meta name="twitter:title" content="陶浩伟的个人博客，http://www.mynight.top"/>
    <meta name="twitter:image" content=""/>
    <meta name="twitter:url" content="http://www.mynight.top"/>
    <meta name="twitter:card" content=""/>

    <link href="https://fonts.googleapis.com/css?family=Work+Sans:300,400,500,700,800" rel="stylesheet">

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


    <style type="text/css">
        .ulc {
            list-style: none;
            float: right;
            width: 500px;
        }

        .lic {
            float: left;
            width: 30px;
            margin-left: 20px;
            line-height: 30px;
        }

        .lic a {
            display: block;
            text-align: center;
            height: 30px;
            color: black;
        }
        .lic a:hover {
            transition: 0.5s;
            color: #FC5185;
        }
    </style>

</head>
<body>



    <div id="introduce" class="alert alert-success" style="text-align: right;">
        欢迎来到我的博客 ^^，右侧显示博客内容，点击左侧home图标可查看更多信息~
    </div>

<div id="page">
    <div id="fh5co-aside" style="background-image: url(<%=basePath%>images/image_1.jpg)">
        <div class="overlay"></div>
        <nav role="navigation">
            <ul>
                <li><a href="<%=basePath%>myshow.html"><i class="icon-home"></i></a></li>
            </ul>
        </nav>
        <div class="featured">
            <span>Blog</span>
            <h2><a href="<%=basePath%>myshow.html">I'm 陶浩伟 </a></h2>
        </div>
    </div>
    <div id="fh5co-main-content">
        <div class="fh5co-post">
            <c:forEach items="${blogList}" var="blog" begin="0" end="${blogList.size()}">
                <div class="fh5co-entry padding">
                    <img src="<%=basePath%>images/${blog.summaryImg}"
                         alt="Free HTML5 Bootstrap Template by FreeHTML5.co">
                    <div>
							<span class="fh5co-post-date">
									<c:choose>
                                        <c:when test="${blog.type==1}"><span title="原创">原</span></c:when>
                                        <c:when test="${blog.type==2}"><span title="转载">转</span></c:when>
                                        <c:when test="${blog.type==3}"><span title="翻译">翻</span></c:when>
                                        <c:when test="${blog.type==4}"><span title="收藏">收</span> </c:when>
                                    </c:choose>
                                    ${sdf.format(blog.createTime)}  点击：${blog.viewCount}</span>
                        <h2><a href="/blog/toNextBlog.html?blogId=${blog.id}">

                                ${blog.title}</a></h2>
                        <p>${blog.summary}</p>
                    </div>
                </div>
            </c:forEach>

            <ul class="ulc">
                <li class="lic"><a href="<%=basePath%>/blog/loadIndex.html?nowPage=${pageVO.nowPage-1}">«</a></li>
                <c:forEach varStatus="i" begin="${pageVO.beginPage}" end="${pageVO.endPage}">
                        <li class="lic"><a ${pageVO.nowPage==i.index?"style='color: #FC5185;'":""} href="<%=basePath%>/blog/loadIndex.html?nowPage=${i.index}">${i.index}</a></li>
                </c:forEach>
                <li class="lic" style="margin-right: 50px;"><a href="<%=basePath%>/blog/loadIndex.html?nowPage=${pageVO.nowPage+1}">»</a></li>
            </ul>
            <footer>
                <jsp:include page="foot.jsp"/>
            </footer>
        </div>
    </div>
</div>

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
<script>
    <%--if(${visiter==1})--%>
    <%--{--%>
//        $('#myidmyid').click();
//    }
</script>
</body>
</html>

