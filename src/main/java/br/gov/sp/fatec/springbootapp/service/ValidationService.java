package br.gov.sp.fatec.springbootapp.service;

import java.util.List;

import br.gov.sp.fatec.springbootapp.entity.Profile;
import br.gov.sp.fatec.springbootapp.entity.Registration;

public interface ValidationService {

    public Registration createRegistration(String email, String password, String name, String cellphone,
            String audioHash, String webGLHash, String canvasHash);

    public List<Profile> findAllProfiles();
    
}
