package com.jnb.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.jnb.modal.GroupBean;
import com.jnb.modal.MenuBean;
import com.jnb.modal.RoleBean;

@Mapper
public interface AdminDao {

	@Select("select * from role_details where del_yn='n' order by role_name")
	public List<RoleBean> roleList();

	@Insert("insert into role_details(role_name, role_desc) values(#{bean.roleName}, #{bean.roleDesc})")
	@Options(useGeneratedKeys = true, keyProperty = "bean.pk", keyColumn = "pk")
	public void addRole(@Param("bean") RoleBean roleBean);

	@Insert("insert into role_menu_mapping(role_pk, menu_pk) values(#{rolePk},#{menuPk})")
	public void addRoleMenuMapping(@Param("rolePk") int rolePk, @Param("menuPk") int menuPk);

	@Select("select user_pk from group_user_mapping where group_pk=#{groupPk}")
	public List<Integer> getGroupUsers(@Param("groupPk") int groupPk);

	@Select("select menu_pk from role_menu_mapping where role_pk=#{rolePk}")
	public List<Integer> getRoleMenus(@Param("rolePk") int role_pk);

	@Select("select * from role_details where pk=#{pk}")
	public RoleBean roleByPk(@Param("pk") int pk);

	@Delete("delete from role_details where pk=#{pk}")
	public void deleteRoleByPk(@Param("pk") int pk);

	@Delete("delete from role_menu_mapping where role_pk=#{rolePk}")
	public void deleteRoleMenuMappingByPk(@Param("rolePk") int rolePk);

	@Update("update role_details set role_name=#{bean.roleName}, role_desc=#{bean.roleDesc} where pk=#{bean.pk}")
	public void updateRole(@Param("bean") RoleBean roleBean);

	@Select("select * from group_details where del_yn='n' order by group_name")
	public List<GroupBean> groupList();

	@Insert("insert into group_details(group_name, group_desc, role_pk) "
			+ " values(#{bean.groupName}, #{bean.groupDesc}, #{bean.rolePk})")
	@Options(useGeneratedKeys = true, keyProperty = "bean.pk", keyColumn = "pk")
	public void addGroup(@Param("bean") GroupBean roleBean);

	@Insert("insert into group_user_mapping(group_pk, user_pk) values(#{groupPk},#{userPk})")
	public void addGroupUserMapping(@Param("groupPk") int groupPk, @Param("userPk") int userPk);

	@Select("select * from group_details where pk=#{pk}")
	public GroupBean groupByPk(@Param("pk") int pk);

	@Delete("delete from group_details where pk=#{pk}")
	public void deleteGroupByPk(@Param("pk") int pk);

	@Delete("delete from group_user_mapping where group_pk=#{pk}")
	public void deleteGroupUserMappingByPk(@Param("pk") int pk);

	@Update("update group_details set group_name=#{bean.groupName}, group_desc=#{bean.groupDesc}, "
			+ "role_pk= #{bean.rolePk} where pk= #{bean.pk}")
	public void updateGroup(@Param("bean") GroupBean groupBean);

	@Select("select * from menu_details order by menu_order")
	public List<MenuBean> menuList();

	@Select("select DISTINCT e.menu_action, e.menu_order, e.menu_name,  e.is_display, e.parent, e.menu_css "
			+ "  from group_user_mapping A inner join group_details B on A.group_pk = B.pk inner join "
			+ "role_details c on B.role_pk=c.pk inner join role_menu_mapping d on c.pk = d.role_pk inner join "
			+ "menu_details e on d.menu_pk = e.pk where A.user_pk=#{userPk} order by e.menu_order")
	public List<Map<String, Object>> userWiseMenuDetails(@Param("userPk") int userPk);

	@Select("select e.menu_name, e.menu_action, e.is_display, e.parent, e.menu_css from "
			+ "menu_details e order by e.menu_order")
	public List<Map<String, Object>> allMenuList();

}
