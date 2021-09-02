package br.gov.sp.fatec.springbootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springbootapp.entity.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    
    public Registration findByEmail(String email);

}