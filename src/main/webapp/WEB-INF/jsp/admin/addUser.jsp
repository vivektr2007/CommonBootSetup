<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

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
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="index.html">Home</a>
						</li>
						<li class="active">Add/Edit User</li>
					</ul>
				</div>

				<div class="page-content">
					<div class="row">
						<div class="col-xs-12">
							<form class="form-horizontal" role="form" method="post" action="addUserSubmit.html">
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="form-field-1">User Name</label>

									<div class="col-sm-9">
										<input type="hidden" name="pk" value="${userBean.pk }"/>
										<input placeholder="Enter user name" type="text" class="col-xs-10 col-sm-5" tabindex="1" name="name" size="200" value="${userBean.name }" required/>
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="form-field-1">User Id</label>

									<div class="col-sm-9">
										<input placeholder="Enter user id" type="text"
										<c:if test="${userBean.pk != 0 }"> disabled='disabled' </c:if>
										 class="col-xs-10 col-sm-5" tabindex="2" name="id" size="200" value="${userBean.id }" required/>
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="form-field-1">Email Id</label>
									<div class="col-sm-9">
										<input placeholder="Enter email id" type="text" class="col-xs-10 col-sm-5" tabindex="3" name="emailId" size="200" value="${userBean.emailId }" required/>
									</div>
								</div>	
								
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="form-field-1">Password</label>
									<div class="col-sm-9">
										<input placeholder="Enter password" type="password" class="col-xs-10 col-sm-5" tabindex="4" name="password" size="200" value="${userBean.password }" required/>
									</div>
								</div>	
								
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="form-field-1">Is Admin</label>
									<div class="col-sm-9">
										<select name="isAdmin" id="isAdmin" class="col-xs-10 col-sm-5">
											<option value="N" <c:if test="${userBean.isAdmin == 'N' }"> selected="selected"</c:if>>User</option>
											<option value="Y" <c:if test="${userBean.isAdmin == 'Y' }"> selected="selected"</c:if>>Admin</option>
										</select>
									</div>
								</div>	
								
								<div class="space-4"></div>

								<div class="row">
									<div class="col-md-offset-3 col-md-9">
										<button type="submit" class="btn btn-sm btn-success">
											Submit
											<i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
										</button>

										&nbsp; &nbsp; &nbsp;
										<button class="btn btn-sm btn-danger"  type="reset">
											<i class="ace-icon fa fa-undo"></i> Reset
										</button>
										&nbsp; &nbsp; &nbsp;
										<button class="btn btn-sm btn-warning"  onclick="back()" type="button">
											<i class="ace-icon fa fa-arrow-left icon-on-right bigger-110"></i> back
										</button>
									</div>
								</div>
							</form>
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
<script type="text/javascript" src="js/admin/user.js?version=${sessionScope.version}"></script>