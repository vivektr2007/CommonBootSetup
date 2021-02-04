
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="/WEB-INF/common/includesHead.jsp"></jsp:include>
</head>

<body class="no-skin">
	<div id="navbar"
		class="navbar navbar-default          ace-save-state navbar-fixed-top">
		<jsp:include page="/WEB-INF/common/navbar.jsp"></jsp:include>
		<!-- /.navbar-container -->
	</div>

	<div class="main-container ace-save-state" id="main-container">

		<jsp:include page="/WEB-INF/common/sidebar.jsp"></jsp:include>


		<div class="main-content">
			<div class="main-content-inner">
				<div class="breadcrumbs ace-save-state" id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a
							href="index.html">Home</a></li>
						<li class="active">Error Page</li>
					</ul>

					<div class="nav-search" id="nav-search">
						<!-- <form class="form-search">
							<span class="input-icon"> <input type="text"
								placeholder="Search ..." class="nav-search-input"
								id="nav-search-input" autocomplete="off" /> <i
								class="ace-icon fa fa-search nav-search-icon"></i>
							</span>
						</form> -->
					</div>
				</div>

				<div class="page-content">
					<div class="row">
						<div class="col-xs-12">
							<div class="error-container">
								<div class="well">
									<h1 class="grey lighter smaller">
										<span class="blue bigger-125"> <i class="icon-random"></i>
											Oops,
										</span> Something Went Wrong
									</h1>

									<hr>
									<h3 class="lighter smaller">
										But we are working <i
											class="icon-wrench icon-animated-wrench bigger-125"></i> on
										it!
									</h3>

									<div class="space"></div>

									<!-- <div>
										<h4 class="lighter smaller">Meanwhile, try one of the
											following:</h4>

										<ul class="unstyled spaced inline bigger-110">
											<li><i class="icon-hand-right blue"></i> Read the faq</li>

											<li><i class="icon-hand-right blue"></i> Give us more
												info on how this specific error occurred!</li>
										</ul>
									</div> -->

									<hr>
									<div class="space"></div>

									<div class="row-fluid">
										<div class="center">
											<a href="#" class="btn btn-grey" onclick="back()"> <i
												class="icon-arrow-left"></i> Go Back
											</a> <a href="index.html" class="btn btn-primary"> <i
												class="icon-dashboard"></i> Dashboard
											</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="footer">
			<jsp:include page="/WEB-INF/common/footer.jsp"></jsp:include>
		</div>

		<a href="#" id="btn-scroll-up"
			class="btn-scroll-up btn btn-sm btn-inverse"> <i
			class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
		</a>
	</div>
	<jsp:include page="/WEB-INF/common/includesFoot.jsp"></jsp:include>
</body>
</html>