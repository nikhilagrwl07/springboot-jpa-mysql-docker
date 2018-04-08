package com.fitness.repository;

import com.fitness.table.Credential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CredentialRepository extends JpaRepository<Credential, Long> {

}
