package com.crease.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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

}
