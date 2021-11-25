package br.gov.sp.fatec.springbootapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.springbootapp.controller.View;

@Entity
@Table(name = "registration")
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registration_id")
    @JsonView({ View.RegistrationAllView.class, View.RegistrationView.class })
    private Long id;

    @Column(name = "registration_email")
    @JsonView({ View.RegistrationAllView.class, View.RegistrationView.class })
    private String email;

    @Column(name = "registration_password")
    @JsonView(View.RegistrationView.class)
    private String password;

    @Column(name = "registration_name")
    @JsonView({ View.RegistrationAllView.class, View.RegistrationView.class })
    private String name;

    @Column(name = "registration_cellphone")
    @JsonView({ View.RegistrationAllView.class, View.RegistrationView.class })
    private String cellphone;

    @Column(name = "registration_user_agent")
    @JsonView({ View.RegistrationAllView.class, View.RegistrationView.class })
    private String userAgent;

    @Column(name = "registration_name_browser")
    @JsonView({ View.RegistrationAllView.class, View.RegistrationView.class })
    private String nameBrowser;

    @Column(name = "registration_version_browser")
    @JsonView({ View.RegistrationAllView.class, View.RegistrationView.class })
    private String versionBrowser;

    @Column(name = "registration_system")
    @JsonView({ View.RegistrationAllView.class, View.RegistrationView.class })
    private String system;

    @Column(name = "registration_gpu_model")
    @JsonView({ View.RegistrationAllView.class, View.RegistrationView.class })
    private String gpuModel;

    @Column(name = "registration_ip")
    @JsonView({ View.RegistrationAllView.class, View.RegistrationView.class })
    private String ip;

    @Column(name = "registration_keyboard_input", columnDefinition = "text")
    @JsonView({ View.RegistrationAllView.class, View.RegistrationView.class })
    private String keyboardInput;

    @Column(name = "registration_time", columnDefinition = "text")
    @JsonView({ View.RegistrationAllView.class, View.RegistrationView.class })
    private String time;

    public Long getId() {
        return this.id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCellphone() {
        return this.cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getNameBrowser() {
        return this.nameBrowser;
    }

    public void setNameBrowser(String nameBrowser) {
        this.nameBrowser = nameBrowser;
    }

    public String getVersionBrowser() {
        return this.versionBrowser;
    }

    public void setVersionBrowser(String versionBrowser) {
        this.versionBrowser = versionBrowser;
    }

    public String getSystem() {
        return this.system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getGpuModel() {
        return this.gpuModel;
    }

    public void setGpuModel(String gpuModel) {
        this.gpuModel = gpuModel;
    }

    public String getIp() {
        return this.ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getKeyboardInput() {
        return this.keyboardInput;
    }

    public void setKeyboardInput(String keyboardInput) {
        this.keyboardInput = keyboardInput;
    }
}