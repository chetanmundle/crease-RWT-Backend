package com.crease.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
//	Delete Contractor
	@DeleteMapping("/delete/id/{contractorid}")
	public ResponseEntity<String> delteContractor(@PathVariable("contractorid") String contractorid)
	{
		try
		{
			Optional<Contractor> findById = contractorRepos.findById(contractorid);
			if(findById.isPresent())
			{
				contractorRepos.deleteById(contractorid);
				return ResponseEntity.status(204).body("Contractore Delete Successfully");
			}else {
				return ResponseEntity.status(404).body("No Data of Id found");
			}
		} catch (Exception e)
		{
			return ResponseEntity.status(500).build();
		}
	}
	
	
//	Update the Contractor
	@PutMapping("/put/update")
	public ResponseEntity<Object> updateContractor(@RequestBody Contractor contractor)
	{
		try
		{
			Optional<Contractor> findById = contractorRepos.findById(contractor.getId());
			if(findById.isPresent())
			{
				Contractor savecontractor = contractorRepos.save(contractor);
				
				return ResponseEntity.ok(savecontractor);
			}else {
				return ResponseEntity.status(404).body("Contractor not found");
			}
		} catch (Exception e)
		{
			return ResponseEntity.internalServerError().build();
		}
	}
}
