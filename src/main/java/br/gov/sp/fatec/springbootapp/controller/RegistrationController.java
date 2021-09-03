package br.gov.sp.fatec.springbootapp.controller;

import com.fasterxml.jackson.annotation.JsonView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.springbootapp.entity.Registration;
import br.gov.sp.fatec.springbootapp.service.ValidationService;

@RestController
@RequestMapping(value = "/registration")
@CrossOrigin
public class RegistrationController {

    @Autowired
    private ValidationService validService;

    @PostMapping
    @JsonView(View.RegistrationAllView.class)
    public Registration create(@RequestBody RegistrationDto registration) {
        return validService.createRegistration(registration.getEmail(), registration.getPassword(),
                registration.getName(), registration.getCellphone(), registration.getAudioHash(),
                registration.getWebGLHash(), registration.getCanvasHash());
    }
    
}
