package com.vale.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vale.entities.Persona;

public interface  PersonaRepository extends JpaRepository<Persona, Long>{

}
