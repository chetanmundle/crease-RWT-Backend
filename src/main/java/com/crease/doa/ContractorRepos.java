package com.crease.doa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crease.entity.Contractor;

public interface ContractorRepos extends JpaRepository<Contractor, String>
{
	
}
