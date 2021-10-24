package br.gov.sp.fatec.springbootapp.security;

public class Login { // clase para realizar login no sistema

  // passa usuario e senha
  private String username;

  private String password;

  // retorna objeto com auth (admin, user) e token de acesso
  private String auth;

  private String token;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public String getAuth() {
    return auth;
  }

  public void setAuth(String auth) {
    this.auth = auth;
  }

}