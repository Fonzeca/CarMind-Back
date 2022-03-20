package com.mindia.carmind.revision.persistence;

import com.mindia.carmind.entities.Revision;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RevisionRepository extends JpaRepository<Revision, Integer> {

}
