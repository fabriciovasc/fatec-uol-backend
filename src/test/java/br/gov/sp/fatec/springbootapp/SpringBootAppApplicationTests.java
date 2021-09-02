package br.gov.sp.fatec.springbootapp;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.springbootapp.entity.Registration;
import br.gov.sp.fatec.springbootapp.repository.ProfileRepository;
import br.gov.sp.fatec.springbootapp.repository.RegistrationRepository;

@SpringBootTest
@Transactional
@Rollback
class SpringBootAppApplicationTests {

    @Autowired
    private ProfileRepository profRepo;

    @Autowired
    private RegistrationRepository regRepo;

    // @Autowired
    // private RegistrationService registrationService;

    @Test
    void registrationSaveTest() {
        Registration reg = new Registration();
        reg.setEmail("profile@profile.com");
        reg.setName("profile");
        reg.setPassword("password");
        reg.setCellphone("999999999");
        regRepo.save(reg);
        assertNotNull(reg.getId());
    }
}
