package br.gov.sp.fatec.springbootapp.controller;

import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonView;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.springbootapp.entity.Profile;
import br.gov.sp.fatec.springbootapp.service.ValidationService;
import br.gov.sp.fatec.springbootapp.repository.ProfileRepository;

@RestController
@RequestMapping(value = "/profile")
@CrossOrigin
public class ProfileController {

    @Autowired
    private ValidationService validationService;

    @Autowired
    private ProfileRepository profRepo;

    @GetMapping
    @JsonView(View.ProfileAllView.class)
    public List<Profile> get() {
        return validationService.findAllProfiles();
    }

    @GetMapping(value = "/{id}")
    @JsonView(View.ProfileAllView.class)
    public Profile getById(@PathVariable("id") Long id) {
        return validationService.findProfileById(id);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteProfile(@PathVariable Long id) {
        Optional<Profile> data = profRepo.findById(id);
        if (data.isPresent()) {
            profRepo.delete(data.get());
            return new ResponseEntity<>(id, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
