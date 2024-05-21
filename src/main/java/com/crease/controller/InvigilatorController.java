package com.crease.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crease.doa.InvigilatorRepos;
import com.crease.entity.Invigilator;

@RestController
@RequestMapping("/invigilator")
@CrossOrigin(origins = "*")
public class InvigilatorController
{

	@Autowired
	private InvigilatorRepos invigilatorRepos;

//	Api for save Invigilator
	@PostMapping("/post/save/invigilator")
	public ResponseEntity<Object> saveInvigilator(@RequestBody Invigilator invigilator)
	{
		try
		{
			Optional<Invigilator> findByAdharid = invigilatorRepos.findByAdharid(invigilator.getAdharid());
			
			if(findByAdharid.isPresent())
			{
				return ResponseEntity.status(409).body("Adhar Id Alread Exist");
			}
			
			Optional<Invigilator> findById = invigilatorRepos.findById(invigilator.getId());
			if (findById.isEmpty())
			{
				Invigilator invigilatorresponse = invigilatorRepos.save(invigilator);
				return ResponseEntity.ok(invigilatorresponse);
			} else
			{
				return ResponseEntity.status(409).body("Username already exists");
			}

		} catch (Exception e)
		{
			return ResponseEntity.internalServerError().build();
		}
	}

//	GET all invigilator
	@GetMapping("/get/all/invigilator")
	public ResponseEntity<Object> getAllInvigilator()
	{
		try
		{
			List<Invigilator> allinvigilator = invigilatorRepos.findAll();
			return ResponseEntity.ok(allinvigilator);

		} catch (Exception e)
		{
			return ResponseEntity.internalServerError().build();
		}
	}
	
//	Get one Invigilator
	@GetMapping("/get/single/invigilator/id/{invigilatorid}")
	public ResponseEntity<Invigilator> getOneInvigilator(@PathVariable("invigilatorid") String invigilatorid)
	{
		try
		{
			Optional<Invigilator> findById = invigilatorRepos.findById(invigilatorid);
			if(findById.isPresent())
			{
				Invigilator invigilator = findById.get();
				return ResponseEntity.ok(invigilator);
				
			}else {
				return ResponseEntity.notFound().build();
			}
		} catch (Exception e)
		{
			return ResponseEntity.internalServerError().build();
		}
	}
	
//	Invigilator Login
	@PostMapping("/post/invigilator/login")
	public ResponseEntity<Map<String, Object>> invigilatorLogin(@RequestBody Map<String, Object> requestMap)
	{
		try
		{
			String id = (String) requestMap.get("id");
			String pass = (String) requestMap.get("password");
			
			Optional<Invigilator> findByIdAndPassword = invigilatorRepos.findByIdAndPassword(id, pass);
			
			if(findByIdAndPassword.isPresent())
			{
				Invigilator invigilator = findByIdAndPassword.get();
				
				Map<String, Object> responseMap = new HashMap<>();
				
				responseMap.put("id", invigilator.getId());
				responseMap.put("name", invigilator.getName());
				responseMap.put("adharid", invigilator.getAdharid());
			 	responseMap.put("phone", invigilator.getPhone());
				responseMap.put("email", invigilator.getEmail());
				
				return ResponseEntity.ok(responseMap);
				
				
			}else {
				return ResponseEntity.notFound().build();
			}
		
		} catch (Exception e)
		{
			return ResponseEntity.internalServerError().build();
		}
		
		
	}

}
