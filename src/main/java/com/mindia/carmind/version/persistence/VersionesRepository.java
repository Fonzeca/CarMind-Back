package com.mindia.carmind.version.persistence;
import com.mindia.carmind.entities.Version;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VersionesRepository extends JpaRepository<Version, Integer> {

    Version getByVersion(String version);
    void deleteByVersion(String version);
    
}