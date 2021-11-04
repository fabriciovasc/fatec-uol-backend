package br.gov.sp.fatec.springbootapp.controller;

public class RegistrationDto {

    public String email;

    public String password;
    
    public String name;

    public String cellphone;

    public String uniqueHash;

    public String nameBrowser;

    public String versionBrowser;

    public String system;

    public String gpuModel;

    public String userAgent;

    public String ip;

    public Integer registerDuration;

    public Integer acceptedTermsDuration;

    public String startRegisterDate;

    public String endRegisterDate;

    public String scroll_x;

    public String scroll_y;

    public String scroll_millis;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCellphone() {
        return cellphone;
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

    public Integer getDurationTime() {
        return this.registerDuration;
    }

    public void setDurationTime(Integer registerDuration) {
        this.registerDuration = registerDuration;
    }

    public Integer getAcceptTermsTime() {
        return this.acceptedTermsDuration;
    }

    public void setAcceptTermsTime(Integer acceptedTermsDuration) {
        this.acceptedTermsDuration = acceptedTermsDuration;
    }

    public String getStartDateRegister() {
        return this.startRegisterDate;
    }

    public void setStartDateRegister(String startRegisterDate) {
        this.startRegisterDate = startRegisterDate;
    }

    public String getEndDateRegister() {
        return this.endRegisterDate;
    }

    public void setEndDateRegister(String endRegisterDate) {
        this.endRegisterDate = endRegisterDate;
    }

    public String getScrollX() {
        return this.scroll_x;
    }

    public void setScrollX(String scroll_x) {
        this.scroll_x = scroll_x;
    }

    public String getScrollY() {
        return this.scroll_y;
    }

    public void setScrollY(String scroll_y) {
        this.scroll_y = scroll_y;
    }

    public String getScrollMillis() {
        return this.scroll_millis;
    }

    public void setScrollMillis(String scroll_millis) {
        this.scroll_millis = scroll_millis;
    }

    public String getUniqueHash() {
        return uniqueHash;
    }

    public void setUniqueHash(String uniqueHash) {
        this.uniqueHash = uniqueHash;
    }   
    
}
