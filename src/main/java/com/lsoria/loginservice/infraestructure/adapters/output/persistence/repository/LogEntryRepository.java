package com.lsoria.loginservice.infraestructure.adapters.output.persistence.repository;

import com.lsoria.loginservice.infraestructure.adapters.output.persistence.entity.LogEntryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogEntryRepository extends JpaRepository<LogEntryEntity, Long> {
}
