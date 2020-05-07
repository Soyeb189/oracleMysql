package com.soyeb.oracleMysql;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class User {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String email;
	private String phone;
	private String password;
	private String image;
	private String uuid;
	private int checeked_value;
	
	public User() {
		
	}
	
	

	public User(int id, String name, String email, String phone, String password, String image, String uuid,
			int checeked_value) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.image = image;
		this.uuid = uuid;
		this.checeked_value = checeked_value;
	}



	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public int getCheceked_value() {
		return checeked_value;
	}

	public void setCheceked_value(int checeked_value) {
		this.checeked_value = checeked_value;
	}
	
	

	
}
