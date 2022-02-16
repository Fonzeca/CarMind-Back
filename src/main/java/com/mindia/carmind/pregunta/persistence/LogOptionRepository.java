package com.mindia.carmind.pregunta.persistence;

import com.mindia.carmind.entities.LogOption;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogOptionRepository extends JpaRepository<LogOption, Integer> {

}
