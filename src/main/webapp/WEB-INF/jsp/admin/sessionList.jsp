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
		class="navbar navbar-default ace-save-state navbar-fixed-top">
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
						<li class="active">Manage Sessions</li>
					</ul>
				</div>

				<div class="page-content">
					<div class="row">
						<div class="col-xs-12 col-sm-3">
							<div class="widget-box">
								<div class="widget-header">
									<h4 class="widget-title">Add/Edit Session</h4>

									<div class="widget-toolbar">
										<a href="#" data-action="collapse"> <i
											class="ace-icon fa fa-chevron-up"></i>
										</a>
									</div>
								</div>

								<div class="widget-body">
									<div class="widget-main">
										<form role="form" method="post" action="addSessionSubmit.html">

											<div class="box-body">

												<div class="form-group">
													<label for="form-field-1">Session</label> <input
														type="hidden" name="pk" value="${sessionBean.pk }" /> <input
														placeholder="Enter session name" type="text"
														class="form-control" tabindex="1" name="sessionValue"
														value="${sessionBean.sessionValue}" required>
												</div>

												<div class="form-group">
													<label for="form-field-1">Session Start Year/Month</label>
													<input placeholder="Enter session start year/month"
														type="text" class="form-control date-picker" tabindex="2"
														readonly="readonly" name="sessionStartYearMonth"
														value="${sessionBean.sessionStartYearMonth}" required>
												</div>

												<div class="form-group">
													<label for="form-field-1">Session End Year/Month</label> <input
														placeholder="Enter session end year/month" type="text"
														class="form-control date-picker" tabindex="3"
														readonly="readonly" name="sessionEndYearMonth"
														value="${sessionBean.sessionEndYearMonth}" required>
												</div>

												<div class="form-group">
													<label for="form-field-1">Session Description</label>
													<textarea placeholder="Enter Session Description"
														class="form-control" tabindex="4" name="sessionDesc"
														required>${sessionBean.sessionDesc}</textarea>

												</div>

											</div>

											<div class="box-footer">
												<button type="submit" class="btn btn-sm btn-success"
													tabindex="10">
													Submit <i
														class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
												</button>

												&nbsp; &nbsp; &nbsp;
												<button class="btn btn-sm btn-danger" type="reset">
													<i class="ace-icon fa fa-undo"></i> Reset
												</button>
											</div>
										</form>
									</div>
								</div>
							</div>
						</div>

						<div class="col-xs-12 col-sm-9">
							<div class="widget-box">
								<div class="widget-header">
									<h4 class="widget-title">Sections List</h4>

									<div class="widget-toolbar">
										<a href="#" data-action="collapse"> <i
											class="ace-icon fa fa-chevron-up"></i>
										</a>


									</div>
								</div>
								<div class="widget-body">
									<div class="widget-main">
										<div class="clearfix">
											<div class="pull-right tableTools-container"></div>
										</div>
										<table id="dynamic-table"
											class="table table-striped table-bordered table-hover">
											<thead>
												<tr>
													<th>Sr No.</th>
													<th>Session Value</th>
													<th>Start Year-Month</th>
													<th>End Year-Month</th>
													<th>Session Description</th>
													<th>Status</th>
													<th>Action</th>
												</tr>
											</thead>

											<tbody>
												<c:forEach items="${sessionList}" var="sessionBean"
													varStatus="theCount">
													<tr>
														<td>${theCount.index+1 }</td>
														<td>${sessionBean.sessionValue}</td>
														<td>${sessionBean.sessionStartYearMonth}</td>
														<td>${sessionBean.sessionEndYearMonth}</td>
														<td>${sessionBean.sessionDesc}</td>
														<td><c:if test="${sessionBean.isActive =='y' }">Active</c:if>
															<c:if test="${sessionBean.isActive !='y' }">In Active <a
																	href="#" onclick="activateSession(${sessionBean.pk})">
																	Activate</a>
															</c:if></td>
														<td>
															<div class="hidden-sm hidden-xs action-buttons">
																<a class="green"
																	href="sessionList.html?pk=${sessionBean.pk}"
																	class="tooltip-success" data-rel="tooltip" title="Edit">
																	<i class="ace-icon fa fa-pencil bigger-130"></i>
																</a> <a class="red" href="javascript:void(0);"
																	onclick="deleteSession('${sessionBean.pk}')"
																	class="tooltip-success" data-rel="tooltip"
																	title="Delete"> <i
																	class="ace-icon fa fa-trash-o bigger-130"></i>
																</a>
															</div>

															<div class="hidden-md hidden-lg">
																<div class="inline pos-rel">
																	<button
																		class="btn btn-minier btn-yellow dropdown-toggle"
																		data-toggle="dropdown" data-position="auto">
																		<i
																			class="ace-icon fa fa-caret-down icon-only bigger-120"></i>
																	</button>

																	<ul
																		class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">


																		<li><a
																			href="sessionList.html?pk=${sessionBean.pk}"
																			class="tooltip-success" data-rel="tooltip"
																			title="Edit"> <span class="green"> <i
																					class="ace-icon fa fa-pencil-square-o bigger-120"></i>
																			</span>
																		</a></li>

																		<li><a href="javascript:void(0);"
																			onclick="deleteSession('${sessionBean.pk}')"
																			class="tooltip-error" data-rel="tooltip"
																			title="Delete"> <span class="red"> <i
																					class="ace-icon fa fa-trash-o bigger-120"></i>
																			</span>
																		</a></li>
																	</ul>
																</div>
															</div>
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
<script type="text/javascript"
	src="js/common/common.js?version=${sessionScope.version}"></script>
<script type="text/javascript">
	initDatatableWithPagination('dynamic-table');
	function addSession(){
		location.href="addSession.html";
	}
	function deleteSession(pk){
		if(confirm("Are you sure")){
			location.href="deleteSession.html?pk="+pk;	
		}
	}
	
	function activateSession(sessionPk){
		
		$.ajax({url: "activateSession.json", 
			data:{"sessionPk":sessionPk},
			method : "post",
			success: function(result){
				location.reload();
	    	}
		});		
	}
	
	$(document).ready(function(){
		
		$('.date-picker').datepicker( {
            changeMonth: true,
            changeYear: true,
            showButtonPanel: true,
            dateFormat: 'MM yy',
            onClose: function(dateText, inst) { 
                var month = $("#ui-datepicker-div .ui-datepicker-month :selected").val();
                var year = $("#ui-datepicker-div .ui-datepicker-year :selected").val();
                $(this).datepicker('setDate', new Date(year, month, 1));
            },
            beforeShow : function(input, inst) {
                
            }
        });
		
	});
	
</script>