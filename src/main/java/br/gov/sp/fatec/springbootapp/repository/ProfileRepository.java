package br.gov.sp.fatec.springbootapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.gov.sp.fatec.springbootapp.entity.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

    public Profile findByHash_canvasAndHash_webglAndfindByHash_canvas(String hash_audio, String hash_webgl, String hash_canvas);

}
