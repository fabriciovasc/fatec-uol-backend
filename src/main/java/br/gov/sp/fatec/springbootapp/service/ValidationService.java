package br.gov.sp.fatec.springbootapp.service;

import java.util.List;

import br.gov.sp.fatec.springbootapp.controller.RegistrationDto;
import br.gov.sp.fatec.springbootapp.entity.Registration;

public interface ValidationService {

    public Registration createRegistration(RegistrationDto registration);

    public List<Registration> findAllRegistrations();

    public Registration findRegistrationById(Long id);

    public Long deleteRegistration(Long id);

    public Registration updateRegistration(RegistrationDto registration, Long id);

}
