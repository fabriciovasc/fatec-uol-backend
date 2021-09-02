package br.gov.sp.fatec.springbootapp.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profile_id")
    private Long id;

    @Column(name = "profile_uuid")
    private String uuid;

    @Column(name = "profile_hash_audio")
    private String hash_audio;

    @Column(name = "profile_hash_webgl")
    private String hash_webgl;

    @Column(name = "profile_hash_canvas")
    private String hash_canvas;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "profile_registration",
        joinColumns = { @JoinColumn(name = "profile_id")},
        inverseJoinColumns = { @JoinColumn(name = "registration_id") }
    )
    private Set<Registration> registrations;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getHash_audio() {
        return this.hash_audio;
    }

    public void setHash_audio(String hash_audio) {
        this.hash_audio = hash_audio;
    }

    public String getHash_webgl() {
        return this.hash_webgl;
    }

    public void setHash_webgl(String hash_webgl) {
        this.hash_webgl = hash_webgl;
    }

    public String getHash_canvas() {
        return this.hash_canvas;
    }

    public void setHash_canvas(String hash_canvas) {
        this.hash_canvas = hash_canvas;
    }

    public Set<Registration> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(Set<Registration> registrations) {
        this.registrations = registrations;
    }
}