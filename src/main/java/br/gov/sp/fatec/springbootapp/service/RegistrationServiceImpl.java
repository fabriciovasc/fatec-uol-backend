package br.gov.sp.fatec.springbootapp.service;

import java.util.HashSet;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.springbootapp.entity.Registration;
import br.gov.sp.fatec.springbootapp.entity.Profile;
import br.gov.sp.fatec.springbootapp.repository.RegistrationRepository;
import br.gov.sp.fatec.springbootapp.repository.ProfileRepository;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private RegistrationRepository regRepo;

    @Autowired
    private ProfileRepository profRepo;

    @Transactional
    public Registration cadastrarRegistration(String email, String password, String name, String cellphone, String uuid, String hash_audio, String hash_webgl, String hash_canvas) {
        Profile prof = profRepo.findByHash_canvasAndHash_webglAndfindByHash_canvas(hash_audio, hash_webgl, hash_canvas);
        Registration reg = regRepo.findByEmail(email);

        if(email == "" || email == null || password == "" || password == null || name == "" || name == null || cellphone == "" || cellphone == null) {
            throw new RuntimeException("Invalid Parameters");
        }
        
        Registration registrations = new Registration();
        System.out.println("profile" + prof);
        if (prof == null) {
            prof = new Profile();
            prof.setUuid(uuid);
            prof.setHash_audio(hash_audio);
            prof.setHash_webgl(hash_webgl);
            prof.setHash_canvas(hash_canvas);
            profRepo.save(prof);
        }
        
        System.out.println("passou pelo profile");
        if(reg == null) {
            registrations.setEmail(email);
            registrations.setPassword(password);
            registrations.setName(name);
            registrations.setCellphone(cellphone);
            regRepo.save(registrations);     
        }

        System.out.println("passou pelo registration");

        prof.setRegistrations(new HashSet<Registration>());
        prof.getRegistrations().add(registrations);

        return registrations;
    }
}