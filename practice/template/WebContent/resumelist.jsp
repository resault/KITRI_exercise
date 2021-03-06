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
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
		<style type="text/css">
			.far, .fas {
				vertical-align: center;
				font-size: 1.3em;
			}
		</style>
		<script>
			$(function(){
				// 마우스 커서 변경
				$('.resumeBtn').css('cursor', 'pointer');
				$('.editBtn').css('cursor', 'pointer');
				
				// 자소서 내용보기
				$('.resumeBtn').click(function(){
					location.href="/template/viewresume.jsp";
					return false;
				});
				// 첨삭 내용보기
				$('.editBtn').click(function(){
					location.href="/template/viewedit.jsp";
					return false;
				});
			});
		</script>
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
										<label style="font-size: 3em;">자소서 목록</label>
									</header>
									<%-- 자소서&첨삭 분류 --%>
									<div class="row gtr-uniform" style="margin: 0 0 3em 0; padding-right:0;">
										<div class="col-2" style="width:8em; padding-left: 0;">
											 <select name="school-cate2" id="school-cate2">
												<option value="0">첨삭대기</option>
												<option value="1">첨삭완료</option>
											</select>
										</div>
										<div class="col-2" style="width:10em; padding-left: 0; margin-left: 1em;"> 
											<select name="school-cate1" id="school-cate1" >
												<option value="0">- 학교분류 -</option>
												<option value="1">고등학교</option>
												<option value="2">대학교</option>
											</select>
										</div>
									</div>
									<%-- 자소서&첨삭 목록 --%>
									<div>
										<table class="table-wrapper" style="text-align: center;">
											<thead>
												<tr>
													<th></th>
													<th style="text-align: center;">학교명</th>
													<th style="text-align: center;">제목</th>
													<th style="text-align: center;">멘토</th>
													<th style="text-align: center;">작성일</th>
												</tr>
											</thead>
											<tbody>
												<tr class="resumeBtn">
													<td>✔</td>
													<td>ㅇㅇ고등학교</td>
													<td style="text-align: left;">ㅇㅇ고등학교 지원 자소서</td>
													<td>userID</td>
													<td>2019.06.12</td>
												</tr>
												<tr class="editBtn">
													<td>↳</td>
													<td>ㅇㅇ고등학교</td>
													<td style="text-align: left;">Re: ㅇㅇ고등학교 지원 자소서</td>
													<td>mentorID</td>
													<td>2019.06.27 11:23:12</td>
												</tr>
												<tr class="resumeBtn">
													<td>첨삭대기</td>
													<td>ㅇㅇ대학교</td>
													<td style="text-align: left;">ㅇㅇ대학교 지원 자소서</td>
													<td>userID</td>
													<td>2019.06.01</td>
												</tr>
												<tr class="resumeBtn">
													<td>첨삭대기</td>
													<td>ㅇㅇ대학교</td>
													<td style="text-align: left;">ㅇㅇ대학교 지원 자소서</td>
													<td>userID</td>
													<td>2019.05.24</td>
												</tr>
											</tbody>
											<tfoot>
												<tr>
													<td colspan="5" align="center" style="padding-top: 4em;">
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