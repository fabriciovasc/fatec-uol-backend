package br.gov.sp.fatec.springbootapp.controller;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.springbootapp.entity.Profile;
import br.gov.sp.fatec.springbootapp.service.ValidationService;

@RestController
@RequestMapping(value = "/profile")
@CrossOrigin
public class ProfileController {

    @Autowired
    private ValidationService validationService;

    @GetMapping
    @JsonView(View.ProfileAllView.class)
    public List<Profile> get() {
        return validationService.findAllProfiles();
    }
}
