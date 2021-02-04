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
						<li class="active">Group List</li>
					</ul>

					<div class="nav-search" id="nav-search">
						<!-- <form class="form-search"> -->
							<span class="input-icon"> <input type="button" class="nav-search-input"
								id="nav-search-input" autocomplete="off" value="Add Group" onclick="addGroup()" />
							</span>
						<!-- </form> -->
					</div>
				</div>

				<div class="page-content">
					<div class="row">
						<div class="col-xs-12">
							<div class="clearfix">
								<div class="pull-right tableTools-container"></div>
							</div>
							<table id="dynamic-table"
								class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th>Sr No.</th>
										<th>Group Name</th>
										<th>Group Desc</th>
										<th>Action</th>
									</tr>
								</thead>

								<tbody>
									<c:forEach items="${groupList}" var="groupBean" varStatus="theCount">
										<tr>
											<td>${theCount.index+1 }</td>
											<td>${groupBean.groupName}</td>
											<td>${groupBean.groupDesc}</td>
											<td>
												<div class="hidden-sm hidden-xs action-buttons">
												<a class="blue" class="tooltip-success" data-rel="tooltip" title="View" href="viewGroup.html?pk=${groupBean.pk}"> <i
													class="ace-icon fa fa-search-plus bigger-130"></i>
												</a> <a class="green" href="addGroup.html?pk=${groupBean.pk}" class="tooltip-success" data-rel="tooltip" title="Edit"> <i
													class="ace-icon fa fa-pencil bigger-130"></i>
												</a> <a class="red" href="javascript:void(0);" onclick="deleteGroup('${groupBean.pk}')" class="tooltip-success" data-rel="tooltip" title="Delete"> <i
													class="ace-icon fa fa-trash-o bigger-130"></i>
												</a>
											</div>

											<div class="hidden-md hidden-lg">
												<div class="inline pos-rel">
													<button class="btn btn-minier btn-yellow dropdown-toggle"
														data-toggle="dropdown" data-position="auto">
														<i class="ace-icon fa fa-caret-down icon-only bigger-120"></i>
													</button>

													<ul
														class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
														<li><a href="viewGroup.html?pk=${groupBean.pk}" class="tooltip-info"
															data-rel="tooltip" title="View"> <span class="blue">
																	<i class="ace-icon fa fa-search-plus bigger-120"></i>
															</span>
														</a></li>

														<li><a href="addGroup.html?pk=${groupBean.pk}" class="tooltip-success"
															data-rel="tooltip" title="Edit"> <span class="green">
																	<i class="ace-icon fa fa-pencil-square-o bigger-120"></i>
															</span>
														</a></li>

														<li><a  href="javascript:void(0);" onclick="deleteGroup('${groupBean.pk}')" class="tooltip-error"
															data-rel="tooltip" title="Delete"> <span class="red">
																	<i class="ace-icon fa fa-trash-o bigger-120"></i>
															</span>
														</a></li>
													</ul>
												</div>
											</div>
												<%-- <a href="addGroup.html?pk=${groupBean.pk}">view</a>
												<a href="addGroup.html?pk=${groupBean.pk}">edit</a>
												<a href="javascript:void(0);" onclick="deleteGroup('${groupBean.pk}')">delete</a> --%>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>

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
<script type="text/javascript" src="js/common/common.js?version=${sessionScope.version}"></script>
<script type="text/javascript">
	initDatatableWithPagination('dynamic-table');
</script>