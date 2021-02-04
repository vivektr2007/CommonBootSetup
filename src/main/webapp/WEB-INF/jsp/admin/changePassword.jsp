<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
						<li class="active">Change Password</li>
					</ul>
				</div>

				<div class="page-content">
					<div class="row">
						<div class="col-xs-12">
							<c:if test="${changePasswordMsg != null && changePasswordMsg != '' }">
								<div class="alert alert-success">
									${changePasswordMsg }
									<button class="close" data-dismiss="alert">
										<i class="ace-icon fa fa-times"></i>
									</button>
								</div>
							</c:if>
							<form:form class="form-horizontal" autocomplete="off" action="changedPasswordSubmit.html" method="post" id="addCompanyForm" modelAttribute="changePasswordBean">
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="form-field-1">Old Password</label>

									<div class="col-sm-9">
										<input type="password" class="col-xs-10 col-sm-5" id="oldPassword" name="oldPassword" required="required" placeholder="Enter Old Password" />
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="form-field-1">New Password</label>

									<div class="col-sm-9">
										<input type="password" class="col-xs-10 col-sm-5" id="newPassword" name="newPassword" required="required" placeholder="Enter New Password" />
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="form-field-1">Confirm New Password</label>

									<div class="col-sm-9">
										<input type="password" class="col-xs-10 col-sm-5" id="confirmNewPassword" name="confirmNewPassword" required="required" placeholder="Enter Confirm New Password" />
									</div>
								</div>	
								
								<div class="row">
									<div class="col-md-offset-3 col-md-9">
										<button type="submit" class="btn btn-sm btn-success">
											Submit <i
												class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
										</button>

										&nbsp; &nbsp; &nbsp;
										<button class="btn btn-sm btn-danger" type="reset">
											<i class="ace-icon fa fa-undo"></i> Reset
										</button>
										&nbsp; &nbsp; &nbsp;
										<button class="btn btn-sm btn-warning" onclick="back()"
											type="button">
											<i class="ace-icon fa fa-arrow-left icon-on-right bigger-110"></i>
											back
										</button>
									</div>
								</div>
							</form:form>
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