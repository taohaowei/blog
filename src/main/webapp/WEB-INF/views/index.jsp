<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Blog &mdash; My Private space</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="陶浩伟的个人博客，http://www.mynight.top"/>
    <meta name="keywords" content="博客，私人空间、原创，个人展示"/>
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

    <link rel="shortcut icon" th:href="@{/images/title.ico}" type="image/x-icon"/>
    <!-- Animate.css -->
    <link rel="stylesheet" th:href="@{/css/animate.css}">
    <!-- Icomoon Icon Fonts-->
    <link rel="stylesheet" th:href="@{/css/icomoon.css}">
    <!-- Bootstrap  -->
    <link rel="stylesheet" th:href="@{/css/bootstrap.css}">

    <!-- Theme style  -->
    <link rel="stylesheet" th:href="@{/css/style.css}">

    <!-- Modernizr JS -->
    <script th:src="@{/js/modernizr-2.6.2.min.js}"></script>
    <!-- FOR IE9 below -->
    <!--[if lt IE 9]>
    <script th:src="@{/js/respond.min.js}"></script>
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
        <div id="fh5co-aside" th:style="'background-image: url(' + @{/images/image_1.jpg} + ')'">
            <div class="overlay"></div>
            <nav role="navigation">
                <ul>
                    <li><a th:href="@{/myshow.html}"><i class="icon-home"></i></a></li>
                </ul>
            </nav>
            <div class="featured">
                <span>Blog</span>
                <h2><a th:href="@{/myshow.html}">I'm 陶浩伟</a></h2>
            </div>
        </div>
        <div id="fh5co-main-content">
            <div class="fh5co-post">
                <div th:each="blogDO : ${blogDOList}">
                    <div class="fh5co-entry padding">
                        <img th:src="@{'/images/' + ${blogDO.summaryImg}}"
                             alt="Free HTML5 Bootstrap Template by FreeHTML5.co">
                        <div>
                            <span class="fh5co-post-date">
                                <span th:if="${blogDO.type == 1}" title="原创">原</span>
                                <span th:if="${blogDO.type == 2}" title="转载">转</span>
                                <span th:if="${blogDO.type == 3}" title="翻译">翻</span>
                                <span th:if="${blogDO.type == 4}" title="收藏">收</span>
                                [[${#dates.format(blogDO.createTime, 'yyyy-MM-dd HH:mm:ss')}]]  点击：[[${blogDO.viewCount}]])
                            </span>
                            <h2>
                                <a th:href="@{/blogDO/toNextBlog.html(blogId=${blogDO.id})}">
                                    [[${blogDO.title}]]
                                </a>
                            </h2>
                            <p>[[${blogDO.summary}]]</p>
                        </div>
                    </div>
                </div>

                <ul class="ulc">
                    <li class="lic">
                        <a th:href="@{/blogDO/loadIndex.html(nowPage=${pageVO.nowPage - 1})}">«</a>
                    </li>
                    <th:block th:each="i : ${#numbers.sequence(pageVO.beginPage, pageVO.endPage)}">
                        <li class="lic">
                            <a th:href="@{/blogDO/loadIndex.html(nowPage=${i})}"
                               th:style="${pageVO.nowPage == i} ? 'color: #FC5185;' : ''">
                                [[${i}]]
                            </a>
                        </li>
                    </th:block>
                    <li class="lic" style="margin-right: 50px;">
                        <a th:href="@{/blogDO/loadIndex.html(nowPage=${pageVO.nowPage + 1})}">»</a>
                    </li>
                </ul>
                <footer th:insert="foot :: footer"></footer>
            </div>
        </div>
    </div>

    <div class="gototop js-top">
        <a href="#" class="js-gotop"><i class="icon-arrow-up"></i></a>
    </div>

    <!-- jQuery -->
    <script th:src="@{/js/jquery.min.js}"></script>
    <!-- jQuery Easing -->
    <script th:src="@{/js/jquery.easing.1.3.js}"></script>
    <!-- Bootstrap -->
    <script th:src="@{/js/bootstrap.min.js}"></script>
    <!-- Waypoints -->
    <script th:src="@{/js/jquery.waypoints.min.js}"></script>
    <!-- Stellar Parallax -->
    <script th:src="@{/js/jquery.stellar.min.js}"></script>
    <!-- Main -->
    <script th:src="@{/js/main.js}"></script>
    <!-- Additional script if needed -->
    <!-- <script th:inline="javascript">
        // Your JavaScript code here
    </script> -->
</body>
</html>
