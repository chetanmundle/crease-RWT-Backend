package com.crease.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Component
public class Invigilator
{
	@Id
	private String id;
	private String name;
	private String password;
	private Long adharid;
	private Long phone;
	private String email;

	public Invigilator()
	{
		super();
	}

	public Invigilator(String id, String name, String password, Long adharid, Long phone, String email)
	{
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.adharid = adharid;
		this.phone = phone;
		this.email = email;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public Long getAdharid()
	{
		return adharid;
	}

	public void setAdharid(Long adharid)
	{
		this.adharid = adharid;
	}



	public Long getPhone()
	{
		return phone;
	}

	public void setPhone(Long phone)
	{
		this.phone = phone;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

}
