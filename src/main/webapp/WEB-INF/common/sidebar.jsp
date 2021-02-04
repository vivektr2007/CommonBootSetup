<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<script type="text/javascript">
	try {
		ace.settings.loadState('main-container')
	} catch (e) {
	}
</script>

<div id="sidebar" class="sidebar responsive ace-save-state">
	<script type="text/javascript">
		try {
			ace.settings.loadState('sidebar')
		} catch (e) {
		}
	</script>
	<ul class="nav nav-list">
		<c:forEach items="${sessionScope.userBean.userMenus }" var="menuMap">
			<c:set var="parentValue" value='${fn:split(menuMap.key,"#")[0] }'/>
			<c:set var="cssClass" value='${fn:split(menuMap.key,"#")[1] }'/>
			<li class='<c:if test="${selectedUriParent == parentValue }">open</c:if>'><a href="#" class="dropdown-toggle"> <i class="menu-icon fa ${cssClass }"></i> <span class="menu-text">
					 ${parentValue }</span> <b class="arrow fa fa-angle-down"></b></a> <b class="arrow"></b>
			<ul class="submenu">
				<c:forEach items="${menuMap.value }" var="menuBean">
					<c:if test="${menuBean.menuAction == selectedUri }">
						<li class="active"><a href="${menuBean.menuAction }"><span>${menuBean.menuName }</span><i class="menu-icon fa fa-caret-right"></i></a></li>
					</c:if>
					<c:if test="${menuBean.menuAction != selectedUri }">
						<li><a href="${menuBean.menuAction }"><span>${menuBean.menuName }</span><i class="menu-icon fa fa-caret-right"></i></a></li>
					</c:if>	
				</c:forEach>
			</ul></li>
		</c:forEach>
	</ul>
	
	<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
		<i id="sidebar-toggle-icon"
			class="ace-icon fa fa-angle-double-left ace-save-state"
			data-icon1="ace-icon fa fa-angle-double-left"
			data-icon2="ace-icon fa fa-angle-double-right"></i>
	</div>
</div>


