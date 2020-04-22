package com.soyeb.oracleMysql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> listAll(){
		return repo.findAll();
	}
	
	public void save(User user) {
		repo.save(user);
	}
	
//	public void update(long id,String image) {
//		repo.updatePhoto(id, image);
//	}
	
	public User get(long id) {
		return repo.findById(id).get();
	}

	public User getLoggedUser(Set<String> email, Set<String> password) {
		User user = repo.loggedUserByQuery(email, password);
		
		if(user==null) {
			Map<String, String> map = new HashMap<>();
		    map.put("Status", "Success");
		    map.put("Code", "1");
		    return user;
		}else {
			return user;
		}
		
	}

	public void update(Set<Long> id, Set<String> image) {
		// TODO Auto-generated method stub
		repo.updateUserPhoto(id, image);
		
	}

	public void updateName(Set<Long> id, Set<String> name) {
		// TODO Auto-generated method stub
		repo.updateUserName(id,name);
		
	}

	public void updateEmail(Set<Long> id, Set<String> email) {
		// TODO Auto-generated method stub
		repo.updateUserEmail(id, email);
		
	}

	public void updatePhone(Set<Long> id, Set<String> phone) {
		// TODO Auto-generated method stub
		repo.updateUserPhone(id, phone);
		
	}

	public void updatePassword(Set<Long> id, Set<String> password) {
		// TODO Auto-generated method stub
		repo.updateUserpPassword(id, password);
		
	}

	public User getCheckedUserMail(Set<String> email) {
		// TODO Auto-generated method stub
		User user = repo.checkedMailByQuery(email);
		return user;
	}

}
