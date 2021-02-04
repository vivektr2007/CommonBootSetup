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
						<li class="active">View Group</li>
					</ul>

					<div class="nav-search" id="nav-search">
						<span class="input-icon"> <input type="button" class="nav-search-input"
								id="nav-search-input" autocomplete="off" value="Add Group" onclick="addGroup()" />
							</span>
					</div>
				</div>

				<div class="page-content">
					<div class="row">
						<div class="col-xs-12">
							<form class="form-horizontal" role="form" method="post" action="addGroupSubmit.html">
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="form-field-1">Group Name</label>

									<div class="col-sm-9">
										<input type="hidden" name="pk" value="${groupBean.pk }"/>
										<input placeholder="Group Name:" readonly="readonly" type="text" class="col-xs-10 col-sm-5" tabindex="1" name="groupName" size="200" value="${groupBean.groupName }" required>
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="form-field-1">Group Desc</label>

									<div class="col-sm-9">
										<textarea placeholder="Group description:" readonly="readonly" class="col-xs-10 col-sm-5" tabindex="2" name="groupDesc" required>${groupBean.groupDesc }</textarea>
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="form-field-1">Role</label>

									<div class="col-sm-9">
										<select name="rolePk" required tabindex="3" class="col-xs-10 col-sm-5" disabled="disabled">
											<option value="">Select Role</option>
											<c:forEach items="${roleList }" var="roleBean">
												<c:if test="${roleBean.pk == groupBean.rolePk }">
													<option selected="selected" value="${roleBean.pk}">${roleBean.roleName }</option>
												</c:if>
												<c:if test="${roleBean.pk != groupBean.rolePk }">
													<option value="${roleBean.pk}">${roleBean.roleName }</option>
												</c:if>
												
											</c:forEach>
										</select>
									</div>
								</div>

								<div class="space-4"></div>

								<div class="form-group">
									<div class="control-group">
											<label class="control-label bolder blue">User List</label>
											<c:forEach items="${userList }" var="userBean">
												<div class="checkbox">
													<label>
														<c:if test="${fn:contains(groupBean.userPks, userBean.pk)}">
															<input type="checkbox" class="ace" name="userPks" value="${userBean.pk }" disabled="disabled" checked="checked"/>
														</c:if>
														<c:if test="${!fn:contains(groupBean.userPks, userBean.pk)}">
															<input type="checkbox" class="ace" name="userPks" value="${userBean.pk }" disabled="disabled"/>
														</c:if>
														<span class="lbl"> ${userBean.name }</span>
													</label>
												</div>
											</c:forEach>
										</div>
								</div>
								<div class="space-4"></div>

								<div class="row">
									<div class="col-md-offset-3 col-md-9">
										<button class="btn btn-sm btn-warning" onclick="back()" type="button">
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
<script type="text/javascript" src="js/admin/group.js?version=${sessionScope.version}"></script>
