package com.mindia.carmind.evaluacion.persistence;

import java.util.List;

import com.mindia.carmind.entities.Evaluacion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluacionRepository extends JpaRepository<Evaluacion, Integer> {
    Evaluacion findByIdAndEmpresaIdAndActiveTrue(Integer id, Integer empresaId);

    List<Evaluacion> findByEmpresaIdAndActiveTrue(Integer empresaId);
}
