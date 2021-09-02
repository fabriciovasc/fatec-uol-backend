package br.gov.sp.fatec.springbootapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.springbootapp.entity.Registration;
import br.gov.sp.fatec.springbootapp.entity.Profile;
import br.gov.sp.fatec.springbootapp.repository.RegistrationRepository;
import br.gov.sp.fatec.springbootapp.repository.ProfileRepository;
import br.gov.sp.fatec.springbootapp.service.RegistrationService;

@SpringBootTest
@Transactional
@Rollback
class SpringBootAppApplicationTests {

    @Autowired
    private ProfileRepository profRepo;

    @Autowired
    private RegistrationRepository regRepo;

    @Autowired
    private RegistrationService registrationService;

    @Test
    void RegistrationServiceCadastrarRegistrationTest() {
        registrationService.cadastrarRegistration("test@test.com", "teste_password", "teste_nome", "(12)999999999", "uuid", "hash_audio", "hash_webgl", "hash_canvas");

        assertNotNull(regRepo.findByEmail("test@test.com").getId());
    }
}
