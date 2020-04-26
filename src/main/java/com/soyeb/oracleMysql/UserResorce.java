package com.soyeb.oracleMysql;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class UserResorce {
	
	@Autowired
	private UserService service;
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/create")
	public HashMap<String,String> saveUser(@ModelAttribute("user") User user) {
		service.save(user);
		HashMap<String, String> map = new HashMap<>();
	    map.put("Status", "Success");
	    map.put("Code", "1");
	    return map;
	}
	@GetMapping("/users")
	public List<User> retriveAllUsers(){
		return userRepository.findAll();
	}
	
	@PostMapping("/login")
	public User getLoggedUser(@RequestParam(value = "email") Set<String> email,@RequestParam(value = "password") Set<String> password){
		
		return service.getLoggedUser(email,password);
	}
	
	@PostMapping("/checkedMail")
	public User getChecked(@RequestParam(value = "email") Set<String> email){
		
		return service.getCheckedUserMail(email);
	}
	
	@PostMapping("/update")
	public HashMap<String, String> getUpdateImage(@RequestParam(value="id") Set<Long> id,@RequestParam(value = "image") Set<String> image){
		
		 service.update(id, image);
		 HashMap<String, String> map = new HashMap<String, String>();
		 map.put("Status", "Success");
		 map.put("Code", "1");
		return map;
		 
		 
	}
	
	@PostMapping("/update/name")
	public HashMap<String, String> getUpdatedName(@RequestParam(value="id") Set<Long> id,@RequestParam(value = "name") Set<String> name){
		
		 service.updateName(id, name);
		 HashMap<String, String> map = new HashMap<String, String>();
		 map.put("Status", "Success");
		 map.put("Code", "1");
		return map;
		 
		 
	}
	
	@PostMapping("/update/email")
	public HashMap<String, String> getUpdatedEmail(@RequestParam(value="id") Set<Long> id,@RequestParam(value = "email") Set<String> email){
		
		 service.updateEmail(id, email);
		 HashMap<String, String> map = new HashMap<String, String>();
		 map.put("Status", "Success");
		 map.put("Code", "1");
		 return map;
		 
		 
	}
	
	@PostMapping("/update/phone")
	public HashMap<String, String> getUpdatedPhone(@RequestParam(value="id") Set<Long> id,@RequestParam(value = "phone") Set<String> phone){
		
		 service.updatePhone(id, phone);
		 HashMap<String, String> map = new HashMap<String, String>();
		 map.put("Status", "Success");
		 map.put("Code", "1");
		 return map;
		 	 
	}
	
	@PostMapping("/update/password")
	public HashMap<String, String> getUpdatedPassword(@RequestParam(value="id") Set<Long> id,@RequestParam(value = "password") Set<String> password){
		
		 service.updatePassword(id, password);
		 HashMap<String, String> map = new HashMap<String, String>();
		 map.put("Status", "Success");
		 map.put("Code", "1");
		return map;
		 	 
	}
	
	@PostMapping("/createNew")
	public HashMap<String,String> saveUserNew(@ModelAttribute("user") User user) {
		User user2= service.getRegisteredUser(user);
		if(user2==null) {
			HashMap<String, String> map = new HashMap<>();
		    map.put("Status", "Success");
		    map.put("Code", "1");
		    return map;
		}else {
			HashMap<String, String> map = new HashMap<>();
		    map.put("Status", "Email exists");
		    map.put("Code", "2");
		    return map;
		}
		
	}
	
	@GetMapping("/usersNew")
	public Map<String, List<User>> retriveAllUsersNew(){
		User user = (User) userRepository.findAll();
//		if(user!=null) {
			List<Map<String, List<User>>> list = new ArrayList<Map<String,List<User>>>();
			Map<String, List<User>> map1 = new HashMap<String, List<User>>();
			List<User> newUser= new ArrayList<User>();
			HashMap<String, String> map = new HashMap<>();
		    map.put("Status", "Success");
		    map.put("Code", "1");
		    map1.put("User",(List<User>) user);
		    list.add(map1);
		    return map1;
//		}
//		return ;
	}

}
