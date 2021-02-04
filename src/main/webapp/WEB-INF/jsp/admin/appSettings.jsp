<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="/WEB-INF/common/includesHead.jsp"></jsp:include>

<script type="text/javascript">

	$(document).ready(function() {
		$("#addUserBtn").click(function() {
			$("#addUserForm").submit();
		});
	});
	
</script>

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
						<li class="active">Add/Edit Settings</li>
					</ul>
				</div>

				<div class="page-content">
					<div class="row">
						<div class="col-xs-12">
							<form:form role="form" autocomplete="off" class="form-horizontal" action="appSettingsMasterSave.html" modelAttribute="settingBean" method="post" id="addUserForm">
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="form-field-1">Register Enable/Disable</label>

									<div class="col-sm-9">
										<select name="registerEnableDisableFlag" class="col-xs-10 col-sm-5" tabindex="1">
											<option <c:if test="${settingBean.regisEnabDis == true }">selected="selected"</c:if> value="true">Enable</option>
											<option <c:if test="${settingBean.regisEnabDis == false }">selected="selected"</c:if> value="false">Disable</option>
										</select>
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="form-field-1">Is Logout</label>
									<div class="col-sm-9">
										<select name="logout" class="col-xs-10 col-sm-5" tabindex="2">
											<option <c:if test="${settingBean.logout == true }">selected="selected"</c:if> value="true">Enable</option>
											<option <c:if test="${settingBean.logout == false }">selected="selected"</c:if> value="false">Disable</option>
										</select>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="form-field-1">Gmail/Facebook Enable/Disable</label>
									<div class="col-sm-9">
										<select name="gmailFbLogin" class="col-xs-10 col-sm-5" tabindex="3">
											<option <c:if test="${settingBean.gmailFbLogin == true }">selected="selected"</c:if> value="true">Enable</option>
											<option <c:if test="${settingBean.gmailFbLogin == false }">selected="selected"</c:if> value="false">Disable</option>
										</select>
									</div>
								</div>	
								
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="form-field-1">App version</label>
									<div class="col-sm-9">
										<input placeholder="Enter App Version" type="text" name="appVersion" value="${settingBean.appVersion }" class="col-xs-10 col-sm-5" tabindex="4"/>
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