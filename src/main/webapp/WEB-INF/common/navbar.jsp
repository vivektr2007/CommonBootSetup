<div class="navbar-container ace-save-state" id="navbar-container">
	<button type="button" class="navbar-toggle menu-toggler pull-left"
		id="menu-toggler" data-target="#sidebar">
		<span class="sr-only">Toggle sidebar</span> <span class="icon-bar"></span>
		<span class="icon-bar"></span> <span class="icon-bar"></span>
	</button>
	<div class="navbar-header pull-left">
		<a href="index.html" class="navbar-brand"> <small> <!-- <i
				class="fa fa-leaf"></i> --> <!-- 
				 <img class="nav-user-photo"
					src="images/MansarIcon.png" alt="Jason's Photo" width="40px" height="40ox" /> --> 
				Header Name
		</small>
		</a>
	</div>
	<div class="navbar-buttons navbar-header pull-right" role="navigation">
		<ul class="nav ace-nav">
			<li class="light-blue dropdown-modal"><a data-toggle="dropdown"
				href="#" class="dropdown-toggle"> <img class="nav-user-photo"
					src="images/avatar/avatar.png" alt="Jason's Photo" /> <span
					class="user-info"> <small>Welcome,${sessionScope.userBean.name }</small>

				</span> <i class="ace-icon fa fa-caret-down"></i>
			</a>
				<ul
					class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
					<!-- <li><a href="#"> <i class="ace-icon fa fa-cog"></i>
							Settings
					</a></li> -->

					<!-- <li><a href="#"> <i class="ace-icon fa fa-user"></i>
							Profile
					</a></li> -->
					<li><a href="changePassword.html"> <i class="ace-icon fa fa-user"></i>
							Change Password
					</a></li>
					<li class="divider"></li>

					<li><a href="logout.html"> <i class="ace-icon fa fa-power-off"></i>
							Logout
					</a></li>
				</ul></li>
		</ul>
	</div>
</div>