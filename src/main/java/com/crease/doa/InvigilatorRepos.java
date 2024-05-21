package com.crease.doa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crease.entity.Invigilator;

public interface InvigilatorRepos extends JpaRepository<Invigilator, String>
{
	Optional<Invigilator> findByAdharid(Long adharid);
	
	Optional<Invigilator> findByIdAndPassword(String id, String password);
}
