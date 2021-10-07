package br.gov.sp.fatec.springbootapp.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.springbootapp.controller.RegistrationDto;
import br.gov.sp.fatec.springbootapp.entity.Profile;
import br.gov.sp.fatec.springbootapp.entity.Registration;
import br.gov.sp.fatec.springbootapp.repository.ProfileRepository;
import br.gov.sp.fatec.springbootapp.repository.RegistrationRepository;

@Service("ValidationService")
public class ValidationServiceImpl implements ValidationService {

    @Autowired
    private RegistrationRepository regRepo;

    @Autowired
    private ProfileRepository profRepo;

    @Transactional
    public Registration createRegistration(RegistrationDto registrationDto) {

        if (registrationDto.getEmail().isEmpty() || registrationDto.getPassword().isEmpty()
                || registrationDto.getName().isEmpty() || registrationDto.getCellphone().isEmpty()
                || registrationDto.getUniqueHash().isEmpty() || registrationDto.getUserAgent().isEmpty()
                || registrationDto.getNameBrowser().isEmpty()|| registrationDto.getVersionBrowser().isEmpty() 
                || registrationDto.getSystem().isEmpty() || registrationDto.getGpuModel().isEmpty()
                || registrationDto.getIp().isEmpty()) {

            throw new RuntimeException("Invalid params");
        }

        Registration registration = regRepo.findByEmail(registrationDto.getEmail());
        if (registration != null) {
            throw new RuntimeException("The email address must be unique");
        }

        registration = new Registration();
        registration.setEmail(registrationDto.getEmail());
        registration.setPassword(registrationDto.getPassword());
        registration.setName(registrationDto.getName());
        registration.setCellphone(registrationDto.getCellphone());
        registration.setUserAgent(registrationDto.getUserAgent());
        registration.setNameBrowser(registrationDto.getNameBrowser());
        registration.setVersionBrowser(registrationDto.getVersionBrowser());
        registration.setSystem(registrationDto.getSystem());
        registration.setGpuModel(registrationDto.getGpuModel());
        registration.setIp(registrationDto.getIp());
        regRepo.save(registration);

        Profile profile = profRepo.findByUniqueHash(registrationDto.getUniqueHash());
        if (profile == null) {
            profile = new Profile();
            profile.setUuid(UUID.randomUUID().toString());
            profile.setUniqueHash(registrationDto.getUniqueHash());
            profile.setRegistrations(new HashSet<Registration>());
        }

        profile.getRegistrations().add(registration);
        profRepo.save(profile);

        return registration;
    }

    public List<Profile> findAllProfiles() {
        return profRepo.findAll();
    }

    public Profile findProfileById(Long id) {
        Optional<Profile> profileOptional = profRepo.findById(id);
        if (profileOptional.isPresent()) {
            return profileOptional.get();
        }
        throw new RuntimeException("Profile not found for id: " + id);
    }

    public Profile findProfileByHash(String hash) {
        Profile profile = profRepo.findByUniqueHash(hash);
        if (profile != null) {
            return profile;
        }
        throw new RuntimeException("Profile not found for hash: " + hash);
    }

    public List<Registration> findAllRegistrations() {
        return regRepo.findAll();
    }

    public Registration findRegistrationById(Long id) {
        Optional<Registration> registrationOptional = regRepo.findById(id);
        if (registrationOptional.isPresent()) {
            return registrationOptional.get();
        }
        throw new RuntimeException("Registration not found for id: " + id);
    }

    public Long deleteProfile(Long id) {
        Optional<Profile> pOptional = profRepo.findById(id);
        if (pOptional.isPresent()) {
            profRepo.delete(pOptional.get());
            return id;
        }
        return null;
    }

    public Long deleteRegistration(Long id) {
        Optional<Registration> rOptional = regRepo.findById(id);
        if (rOptional.isPresent()) {
            regRepo.delete(rOptional.get());
            return id;
        }
        return null;
    }

    public Registration updateRegistration(RegistrationDto registration, Long id) {
        Optional<Registration> oldReg = regRepo.findById(id);
        if (oldReg.isPresent()) {
            Registration reg = oldReg.get();
            reg.setName(registration.getName());
            regRepo.save(reg);
            return reg;
        }
        return null;
    }
}