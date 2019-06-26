<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<!--
	Editorial by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
	<head>
		<title>Elements - Editorial by HTML5 UP</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
		<%-- font-awesome --%>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
		<style type="text/css">
			.far, .fas {font-size: 1.5em;}
			i {vertical-align: center;}
		</style>
	</head>
	<body class="is-preload">

		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Main -->
					<div id="main">
						<div class="inner">

							<!-- Header -->
								<header id="header">
									<a href="index.html" class="logo">Mentoring</a>
									<ul class="icons">
										<li><a href="#" class="icon brands fa-twitter"><span class="label">Twitter</span></a></li>
										<li><a href="#" class="icon brands fa-facebook-f"><span class="label">Facebook</span></a></li>
										<li><a href="#" class="icon brands fa-snapchat-ghost"><span class="label">Snapchat</span></a></li>
										<li><a href="#" class="icon brands fa-instagram"><span class="label">Instagram</span></a></li>
										<li><a href="#" class="icon brands fa-medium-m"><span class="label">Medium</span></a></li>
									</ul>
								</header>

							<%-- Content --%>
								<section>
									<header class="main">
										<h1>Find Mentor</h1>
									</header>
									<%-- 멘토 검색 --%>
									<div class="row gtr-uniform" style="margin-top: 2em;">
										<div class="col-3 col-12-small">
										</div>
										<div class="col-9 col-12-small">
											<div class="col-2 col-4-small" style="padding-left	: 0; float: right;">
												<ul class="actions">
													<li><a href="#" class="button primary icon"><i class="fas fa-search"></i></a></li>
													<li><a href="#" class="button"><i class="fas fa-redo"></i></a></li>
												</ul>
											<div class="col-0 col-8-small" style="padding-left	: 0; float: right;">
											</div>
											</div>
											
											<div class="col-4 col-6-small" style="padding-left: 0.5em; padding-right: 1em; float: right;">
												<input type="email" name="demo-email" id="demo-email" value="" placeholder="검색어를 입력하세요" />
											</div>
											<div class="col-6 col-6-small" style="padding-left	: 0; float: right;">
												 <select name="school-cate2" id="school-cate2">
													<option value="0">ID</option>
													<option value="1">모교</option>
												</select>
											</div>
											<div style="clear: both;">
											</div>
										</div>
									</div>
									<%-- 학교 분류 --%>
									<div class="row gtr-uniform" style="margin: 0 0 2em 0;">
										<div class="col-2" style="padding-left: 0; width: 10em;">
											 <select name="school-cate1" id="school-cate1" >
												<option value="0">- 대분류 -</option>
												<option value="1">고등학교</option>
												<option value="2">대학교</option>
											</select>
										</div>
										<div class="col-2" style="width: 10em; padding-left: 0; margin-left: 1em;"> 
											 <select name="school-cate2" id="school-cate2">
												<option value="0">- 소분류 -</option>
												<option value="1">- 소분류 -</option>
												<option value="2">- 소분류 -</option>
											</select>
										</div>
										<div class="col-6 col-5-large" style="padding-right: 0;">
										</div>
										<div class="col-2" style="padding-right: 0;">
											<ul class="actions" style="float: right;">
												<li><a href="#" class="button"><i class="far fa-comment-dots"></i></a></li>
											</ul>
										</div>
									</div>
									<%-- 멘토 목록 --%>
									<div>
										<table class="alt" style="text-align: center;">
											<thead>
												<tr>
													<th></th>
													<th style="text-align: center;">ID</th>
													<th style="text-align: center;">고등학교</th>
													<th style="text-align: center;">대학교</th>
													<th style="text-align: center;">email</th>
													<th style="text-align: center;">첨삭글수</th>
													<th style="text-align: center;">쪽지보내기</th>
													<th style="text-align: center;">첨삭의뢰</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td>1</td>
													<td>userID</td>
													<td>ㅇㅇ고등학교</td>
													<td>ㅇㅇ대학교</td>
													<td>userID@gmail.com</td>
													<td>5건</td>
													<td><i class="far fa-envelope"></i></td>
													<td><i class="fas fa-edit"></i></td>
												</tr>
												<tr>
													<td>2</td>
													<td>userID</td>
													<td>ㅇㅇ고등학교</td>
													<td>ㅇㅇ대학교</td>
													<td>userID@gmail.com</td>
													<td>5건</td>
													<td><i class="far fa-envelope"></i></td>
													<td><i class="fas fa-edit"></i></td>
												</tr>
												<tr>
													<td>3</td>
													<td>userID</td>
													<td>ㅇㅇ고등학교</td>
													<td>ㅇㅇ대학교</td>
													<td>userID@gmail.com</td>
													<td>5건</td>
													<td><i class="far fa-envelope"></i></td>
													<td><i class="fas fa-edit"></i></td>
												</tr>
												<tr>
													<td>4</td>
													<td>userID</td>
													<td>ㅇㅇ고등학교</td>
													<td>ㅇㅇ대학교</td>
													<td>userID@gmail.com</td>
													<td>5건</td>
													<td><i class="far fa-envelope"></i></td>
													<td><i class="fas fa-edit"></i></td>
												</tr>
											</tbody>
											<tfoot>
												<tr>
													<td colspan="7" align="center" style="padding-top: 4em;">
														<ul class="pagination">
															<li><span class="button disabled">Prev</span></li>
															<li><a href="#" class="page active">1</a></li>
															<li><a href="#" class="page">2</a></li>
															<li><a href="#" class="page">3</a></li>
															<li><span>&hellip;</span></li>
															<li><a href="#" class="page">8</a></li>
															<li><a href="#" class="page">9</a></li>
															<li><a href="#" class="page">10</a></li>
															<li><a href="#" class="button">Next</a></li>
														</ul>
													</td>
												</tr>
											</tfoot>
										</table>
									</div>


								</section>

						</div>
					</div>

				<!-- Sidebar -->
					<div id="sidebar">
						<div class="inner">

							<!-- Search -->
								<section id="search" class="alt">
									<form method="post" action="#">
										<input type="text" name="query" id="query" placeholder="Search" />
									</form>
								</section>

							<!-- Menu -->
								<nav id="menu">
									<header class="major">
										<h2>Menu</h2>
									</header>
									<ul>
										<li><a href="index.html">Homepage</a></li>
										<li><a href="generic.html">Generic</a></li>
										<li><a href="elements.html">Elements</a></li>
										<li>
											<span class="opener">Submenu</span>
											<ul>
												<li><a href="#">Lorem Dolor</a></li>
												<li><a href="#">Ipsum Adipiscing</a></li>
												<li><a href="#">Tempus Magna</a></li>
												<li><a href="#">Feugiat Veroeros</a></li>
											</ul>
										</li>
										<li><a href="#">Etiam Dolore</a></li>
										<li><a href="#">Adipiscing</a></li>
										<li>
											<span class="opener">Another Submenu</span>
											<ul>
												<li><a href="#">Lorem Dolor</a></li>
												<li><a href="#">Ipsum Adipiscing</a></li>
												<li><a href="#">Tempus Magna</a></li>
												<li><a href="#">Feugiat Veroeros</a></li>
											</ul>
										</li>
										<li><a href="#">Maximus Erat</a></li>
										<li><a href="#">Sapien Mauris</a></li>
										<li><a href="#">Amet Lacinia</a></li>
									</ul>
								</nav>

							<!-- Section -->
								<section>
									<header class="major">
										<h2>Ante interdum</h2>
									</header>
									<div class="mini-posts">
										<article>
											<a href="#" class="image"><img src="images/pic07.jpg" alt="" /></a>
											<p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore aliquam.</p>
										</article>
										<article>
											<a href="#" class="image"><img src="images/pic08.jpg" alt="" /></a>
											<p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore aliquam.</p>
										</article>
										<article>
											<a href="#" class="image"><img src="images/pic09.jpg" alt="" /></a>
											<p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore aliquam.</p>
										</article>
									</div>
									<ul class="actions">
										<li><a href="#" class="button">More</a></li>
									</ul>
								</section>

							<!-- Section -->
								<section>
									<header class="major">
										<h2>Get in touch</h2>
									</header>
									<p>Sed varius enim lorem ullamcorper dolore aliquam aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin sed aliquam facilisis ante interdum. Sed nulla amet lorem feugiat tempus aliquam.</p>
									<ul class="contact">
										<li class="icon solid fa-envelope"><a href="#">information@untitled.tld</a></li>
										<li class="icon solid fa-phone">(000) 000-0000</li>
										<li class="icon solid fa-home">1234 Somewhere Road #8254<br />
										Nashville, TN 00000-0000</li>
									</ul>
								</section>

							<!-- Footer -->
								<footer id="footer">
									<p class="copyright">&copy; Untitled. All rights reserved. Demo Images: <a href="https://unsplash.com">Unsplash</a>. Design: <a href="https://html5up.net">HTML5 UP</a>.</p>
								</footer>

						</div>
					</div>

			</div>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/browser.min.js"></script>
			<script src="assets/js/breakpoints.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>

	</body>
</html>