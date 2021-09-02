package br.gov.sp.fatec.springbootapp.service;

import br.gov.sp.fatec.springbootapp.entity.Registration;

public interface RegistrationService {

    public Registration cadastrarRegistration(String email, String password, String name, String cellphone, String uuid, String hash_audio, String hash_webgl, String hash_canvas);
    
}

