package com.jnb.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.jnb.modal.SettingBean;
import com.jnb.modal.UserBean;

@Mapper
public interface LoginDao {

	@Select("select pk, id , name , password, is_active, database_name, email_id, is_admin from user_details where id = #{userId} and password = #{password} and is_active='Y'")
	public UserBean checkLogin(@Param("userId") String userId, @Param("password") String password);

	@Select("select pk, id, name  , password, is_active, database_name, email_id, is_admin from user_details "
			+ " where is_active='Y' order by name")
	public List<UserBean> userList();

	@Insert("insert into user_details(id, name, password, database_name, email_id, is_admin) values(#{userBean.id}, #{userBean.name}, #{userBean.password}"
			+ ", #{userBean.databaseName}, #{userBean.emailId}, #{userBean.isAdmin})")
	public void addUser(@Param("userBean") UserBean userBean);

	@Update("update user_details set name=#{userBean.name},password=#{userBean.password}, email_id=#{userBean.emailId}, is_admin=#{userBean.isAdmin} "
			+ " where pk = #{userBean.pk}")
	public void editUser(@Param("userBean") UserBean userBean);

	@Select("select pk, id, name  , password, is_active, database_name, email_id, is_admin from user_details "
			+ " where pk=#{pk} order by name")
	public UserBean getUserByPk(@Param("pk") int pk);

	@Delete("delete from user_details where pk = #{pk}")
	public void deleteUserByPk(@Param("pk") int pk);

	@Select("select * from user_details where id= #{userName} and is_active='Y'")
	public UserBean getUserByName(@Param("userName") String userName);

	@Update("update user_details set password=#{password} where pk = #{pk}")
	public void resetPassword(@Param("password") String password, @Param("pk") int pk);

	@Select("select * from app_settings")
	public List<Map<String, Object>> getSettings();

	@Update("update app_settings set regis_enab_dis = #{bean.regisEnabDis}, gmail_fb_login=#{bean.gmailFbLogin}, "
			+ "app_version=#{bean.appVersion}, is_logout=#{bean.isLogout} where pk = 1")
	public void saveAppSetting(@Param("bean") SettingBean bean);

	@Update("update user_details set password=#{newPassword}  where id=#{userId}")
	public void changePassword(@Param("newPassword") String newPassword, @Param("userId") String userId);

	@Update("update user_details set password=#{newPassword}  where pk=#{userPk}")
	public void changePasswordByUserPk(@Param("newPassword") String newPassword, @Param("userPk") int userPk);

}
