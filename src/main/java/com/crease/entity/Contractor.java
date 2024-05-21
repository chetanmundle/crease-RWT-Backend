package com.crease.entity;

import java.util.Date;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Component
public class Contractor
{
	@Id
	private String id;

	private String name;
	private Long adharid;

	@Temporal(TemporalType.DATE)
	private Date issuedate;

	@Temporal(TemporalType.DATE)
	private Date expirydate;

	private Long phone;
	private String email;

	public Contractor()
	{
		super();
		// TODO Auto-generated constructor stub
	}


	public Contractor(String id, String name, Long adharid, Date issuedate, Date expirydate, Long phone, String email)
	{
		super();
		this.id = id;
		this.name = name;
		this.adharid = adharid;
		this.issuedate = issuedate;
		this.expirydate = expirydate;
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

	public Long getAdharid()
	{
		return adharid;
	}

	public void setAdharid(Long adharid)
	{
		this.adharid = adharid;
	}

	

	public Date getIssuedate()
	{
		return issuedate;
	}


	public void setIssuedate(Date issuedate)
	{
		this.issuedate = issuedate;
	}


	public Date getExpirydate()
	{
		return expirydate;
	}

	public void setExpirydate(Date expirydate)
	{
		this.expirydate = expirydate;
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
