package br.gov.sp.fatec.springbootapp.controller;

import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.gov.sp.fatec.springbootapp.entity.Registration;
import br.gov.sp.fatec.springbootapp.service.ValidationService;
import br.gov.sp.fatec.springbootapp.repository.RegistrationRepository;

@RestController
@RequestMapping(value = "/registration")
@CrossOrigin
public class RegistrationController {

    @Autowired
    private ValidationService validService;

    @Autowired
    private RegistrationRepository regRepo;

    @GetMapping
    @JsonView(View.RegistrationAllView.class)
    public List<Registration> get() {
        return validService.findAllRegistrations();
    }

    @GetMapping(value = "/{id}")
    @JsonView(View.RegistrationAllView.class)
    public Registration getById(@PathVariable("id") Long id) {
        return validService.findRegistrationById(id);
    }

    @PostMapping
    @JsonView(View.RegistrationAllView.class)
    public ResponseEntity<Registration> create(@RequestBody RegistrationDto registration, UriComponentsBuilder uriComponentsBuilder) {
        Registration reg = validService.createRegistration(
            registration.getEmail(),
            registration.getPassword(),
            registration.getName(),
            registration.getCellphone(),
            registration.getAudioHash(),
            registration.getWebGLHash(),
            registration.getCanvasHash()
        );
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(
            uriComponentsBuilder.path("/registration/" + reg.getId()).build().toUri()
        );
        return new ResponseEntity<Registration>(reg, responseHeaders, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    @JsonView(View.RegistrationAllView.class)
    public ResponseEntity<Registration> updateRegistration(@RequestBody RegistrationDto registration, @PathVariable Long id) {
        Optional<Registration> oldReg = regRepo.findById(id);
        if(oldReg.isPresent()){
            Registration reg = oldReg.get();
            reg.setName(registration.getName());
            regRepo.save(reg);
            return new ResponseEntity<Registration>(reg, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Registration> deleteRegistration(@PathVariable Long id) {
        Optional<Registration> data = regRepo.findById(id);
        if(data.isPresent()){
            regRepo.delete(data.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
