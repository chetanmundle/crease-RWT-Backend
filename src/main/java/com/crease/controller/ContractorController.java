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

import com.crease.doa.ContractorRepos;
import com.crease.entity.Contractor;

@RestController
@RequestMapping("/contractor")
@CrossOrigin(origins = "*")
public class ContractorController
{
	@Autowired
	private ContractorRepos contractorRepos;
	
//	Save Contractor
	@PostMapping("/post/contractor/save")
	public ResponseEntity<Object> saveContractor(@RequestBody Contractor contractor)
	{
		try
		{
			Optional<Contractor> findById = contractorRepos.findById(contractor.getId());
			if (findById.isEmpty())
			{
				Contractor savecontractor = contractorRepos.save(contractor);
				return ResponseEntity.ok(savecontractor);
			}else {
				return ResponseEntity.status(409).body("UserName Already Exist");
			}
		} catch (Exception e)
		{
			return ResponseEntity.internalServerError().build();
		}
	}
	
//	Get all the Contractor 
	@GetMapping("/get/contractor/all")
	public ResponseEntity<List<Contractor>> getAllContractor()
	{
		try
		{
			List<Contractor> listofContractor = contractorRepos.findAll();
			return ResponseEntity.ok(listofContractor);
		} catch (Exception e)
		{
			return ResponseEntity.internalServerError().build();
		}
	}
}
