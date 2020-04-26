package com.soyeb.oracleMysql;


import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User, Long>{
	
	String rawQuery = "select * from user where email IN ?1 and password = ?2";
	@Query(nativeQuery = true,value = rawQuery)
	User  loggedUserByQuery(Set<String> email,Set<String> password);
	
	String checkMail = "select * from user where email = ?1";
	@Query(nativeQuery = true,value = checkMail)
	User  checkedMailByQuery(Set<String> email);
	
	String checkMail2 = "select * from user where email = ?1";
	@Query(nativeQuery = true,value = checkMail)
	User  checkedMailByQuery2(String mail);
	
	
//	String updateQuery = "UPDATE user where ";
//	@Query("")
//    void updatePhoto(@Param("id") long id, @Param("image") String image);
	//String updatePhoto = "UPDATE user SET image IN ?1 where id =?2";
	String updatePhoto = "UPDATE user c SET c.image = :image WHERE c.id = :id";
	@Modifying(clearAutomatically = true)
	@Query(nativeQuery = true,value = updatePhoto)
	void updateUserPhoto(Set<Long> id,Set<String> image);
	
	String updateName = "UPDATE user c SET c.name = :name WHERE c.id = :id";
	@Modifying(clearAutomatically = true)
	@Query(nativeQuery = true,value = updateName)
	void updateUserName(Set<Long> id,Set<String> name);
	
	String updateEmail = "UPDATE user c SET c.email = :email WHERE c.id = :id";
	@Modifying(clearAutomatically = true)
	@Query(nativeQuery = true,value = updateEmail)
	void updateUserEmail(Set<Long> id,Set<String> email);
	
	String updatePhone = "UPDATE user c SET c.phone = :phone WHERE c.id = :id";
	@Modifying(clearAutomatically = true)
	@Query(nativeQuery = true,value = updatePhone)
	void updateUserPhone(Set<Long> id,Set<String> phone);
	
	String updatePassword = "UPDATE user c SET c.password = :password WHERE c.id = :id";
	@Modifying(clearAutomatically = true)
	@Query(nativeQuery = true,value = updatePassword)
	void updateUserpPassword(Set<Long> id,Set<String> password);
	
	String selectAll = "SELECT * FROM user";
	@Modifying(clearAutomatically = true)
	@Query(nativeQuery = true,value =selectAll)
	User allUser();
}
