@@ -1,18 +0,0 @@
package br.gov.sp.fatec.springbootapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.gov.sp.fatec.springbootapp.entity.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {

    public Registration findByEmail(String email);
}