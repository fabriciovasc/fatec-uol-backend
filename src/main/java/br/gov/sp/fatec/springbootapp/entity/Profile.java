package br.gov.sp.fatec.springbootapp.entity;

import java.util.Set;
import java.util.UUID;

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
    private UUID uuid;

    @Column(name = "profile_audio_hash")
    private String audioHash;

    @Column(name = "profile_webgl_hash")
    private String webGLHash;

    @Column(name = "profile_canvas_hash")
    private String canvasHash;
    
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

    public UUID getUuid() {
        return this.uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getAudioHash() {
        return audioHash;
    }

    public void setAudioHash(String audioHash) {
        this.audioHash = audioHash;
    }

    public String getWebGLHash() {
        return webGLHash;
    }

    public void setWebGLHash(String webGLHash) {
        this.webGLHash = webGLHash;
    }

    public String getCanvasHash() {
        return canvasHash;
    }

    public void setCanvasHash(String canvasHash) {
        this.canvasHash = canvasHash;
    }

    public Set<Registration> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(Set<Registration> registrations) {
        this.registrations = registrations;
    }
}