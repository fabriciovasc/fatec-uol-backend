package br.gov.sp.fatec.springbootapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.springbootapp.entity.Profile;
import br.gov.sp.fatec.springbootapp.entity.Registration;
import br.gov.sp.fatec.springbootapp.repository.ProfileRepository;
import br.gov.sp.fatec.springbootapp.repository.RegistrationRepository;
import br.gov.sp.fatec.springbootapp.service.ValidationService;

@SpringBootTest
@Transactional
@Rollback
class SpringBootAppApplicationTests {

    @Autowired
    private ProfileRepository profRepo;

    @Autowired
    private RegistrationRepository regRepo;

    @Autowired
    private ValidationService validService;

    private Registration reg1;
    private Profile prof1;

    @BeforeEach()
    void init() {
        reg1 = new Registration();
        reg1.setEmail("before@profile.com");
        reg1.setName("before");
        reg1.setPassword("password");
        reg1.setCellphone("999999999");
        regRepo.save(reg1);

        prof1 = new Profile();
        prof1.setAudioHash("qqwwee");
        prof1.setCanvasHash("qqwwee");
        prof1.setWebGLHash("qqwwee");
        prof1.setUuid(UUID.randomUUID().toString());
        prof1.setRegistrations(new HashSet<Registration>());
        prof1.getRegistrations().add(reg1);
        profRepo.save(prof1);
        assertNotNull(prof1.getId());
    }

    @Test
    void registrationRepoSaveTest() {
        Registration reg = new Registration();
        reg.setEmail("profile@profile.com");
        reg.setName("profile");
        reg.setPassword("password");
        reg.setCellphone("999999999");
        regRepo.save(reg);
        assertNotNull(reg.getId());
    }

    @Test
    void profileRepoSaveTest() {
        Profile prof = new Profile();
        prof.setAudioHash("xxyyzz");
        prof.setCanvasHash("xxyyzz");
        prof.setWebGLHash("xxyyzz");
        prof.setUuid(UUID.randomUUID().toString());
        prof.setRegistrations(new HashSet<Registration>());
        Registration reg = new Registration();
        reg.setEmail("profile@profile.com");
        reg.setName("profile");
        reg.setPassword("password");
        reg.setCellphone("999999999");
        regRepo.save(reg);
        prof.getRegistrations().add(reg);
        profRepo.save(prof);
        assertNotNull(prof.getRegistrations().iterator().next().getId());
    }

    @Test
    void profileRepoFindByHashes() {
        assertNotNull(profRepo.findByCanvasHashOrWebGLHashOrAudioHash("qqwwee", "qqwwee", "qqwwee").getId());
    }

    @Test
    void registrationRepoFindByEmail() {
        Registration reg = new Registration();
        reg.setEmail("profile@profile.com");
        reg.setName("profile");
        reg.setPassword("password");
        reg.setCellphone("999999999");
        regRepo.save(reg);

        assertNotNull(regRepo.findByEmail("profile@profile.com").getId());
    }

    @Test
    void validationServiceParamsException() {
        RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> validService
                .createRegistration("", "xxxxxx", "foo", "999999999", "xxxyyyzzz", "xxxyyyzzz", "xxxyyyzzz"));
        assertTrue(runtimeException.getMessage().equals("Invalid params"));
    }

    @Test
    void validationServiceDuplicateRegistration() {
        Registration reg = new Registration();
        reg.setEmail("profile@profile.com");
        reg.setName("profile");
        reg.setPassword("password");
        reg.setCellphone("999999999");
        regRepo.save(reg);

        RuntimeException runtimeException = assertThrows(RuntimeException.class,
                () -> validService.createRegistration(reg.getEmail(), reg.getPassword(), reg.getName(),
                        reg.getCellphone(), "xxxyyyzzz", "xxxyyyzzz", "xxxyyyzzz"));
        assertTrue(runtimeException.getMessage().equals("The email address must be unique"));
    }

    @Test
    void validationServiceCreateRegistration() {
        assertNotNull(validService.createRegistration("profile@profile", "password", "profile", "999999999",
                "xxxyyyzzz", "xxxyyyzzz", "xxxyyyzzz").getId());
    }

    @Test
    void validationServiceExistHashes() {
        String hash = "xxxyyyzzz";
        validService.createRegistration("profile@profile", "password", "profile", "999999999", hash, hash, hash);
        validService.createRegistration("profile2@profile2", "password2", "profile2", "999999990", hash, hash, hash);
        assertEquals(regRepo.findByOneOfHashes(hash).size(), 2);
    }

    @Test
    void validationServiceFindProfileException() {
        Long id = 12345678910L;
        RuntimeException runtimeException = assertThrows(RuntimeException.class,
                () -> validService.findProfileById(id));
        assertTrue(runtimeException.getMessage().equals("Profile not found for id: " + id));
    }

    @Test
    void validationServiceFindProfileById() {
        assertNotNull(validService.findProfileById(prof1.getId()));
    }

    @Test
    void validationServiceFindProfileByHash() {
        assertNotNull(validService.findProfileByHash(prof1.getAudioHash()));
    }

    @Test 
    void validationServiceFindRegistrationException() {
        Long id = 12345678910L;
        RuntimeException runtimeException = assertThrows(RuntimeException.class,
                () -> validService.findRegistrationById(id));
        assertTrue(runtimeException.getMessage().equals("Registration not found for id: " + id));
    }

    @Test
    void validationServiceFindRegistrationById() {
        assertNotNull(validService.findRegistrationById(reg1.getId()));
    }

    @AfterEach
    void exit() {
        regRepo.deleteAll();
        profRepo.deleteAll();
    }
}
