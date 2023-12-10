package com.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.empresa.entidades.Pasatiempo;

@Repository
public interface PasatiempoRepository extends JpaRepository<Pasatiempo, Integer> {

}
