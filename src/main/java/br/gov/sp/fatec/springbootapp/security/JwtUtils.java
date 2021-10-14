package br.gov.sp.fatec.springbootapp.security;

import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtils {

  private static final String KEY = "spring.jwt.sec"; //chave de criptografia, usado para gerar token (possui assinatura chave+token)

  public static String generateToken(Authentication usuario) throws JsonProcessingException { //recebe objeto de auth (user, senha e autenticação)
    ObjectMapper mapper = new ObjectMapper(); //mapper para gerar json
    Login usuarioSemSenha = new Login(); //objeto classe login
    usuarioSemSenha.setUsername(usuario.getName()); //seta username
    if (!usuario.getAuthorities().isEmpty()) { //verificaçao para checar se tem autorizaçao
      usuarioSemSenha.setAutorizacao(usuario.getAuthorities().iterator().next().getAuthority()); //pega e seta a primeira autorizaçao do usuario
    }
    String usuarioJson = mapper.writeValueAsString(usuarioSemSenha); //gera um json e coloca dentro do token
    Date agora = new Date();
    Long hora = 1000L * 60L * 60L; // Uma hora | token com duraçao de 1 hora
    //lib que cria o token, userDetails coloca o json do user | setIssuer quem seta o token | setSubject de quem é o token | setExpiration data de validade | signWith assina colocando a chave e algoritimo de criptografia | compact junta tudo em uma string base64
    return Jwts.builder().claim("userDetails", usuarioJson).setIssuer("br.gov.sp.fatec").setSubject(usuario.getName()) 
        .setExpiration(new Date(agora.getTime() + hora)).signWith(SignatureAlgorithm.HS512, KEY).compact();
  }

  public static Authentication parseToken(String token) throws JsonParseException, JsonMappingException, IOException { //pega a string da request e valida
    ObjectMapper mapper = new ObjectMapper();
    String credentialsJson = Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody().get("userDetails",
        String.class); //da um parse passando a chave e o token, verificando validade ou adulteraçao, lançando exceçoes, .get("userDetails", String.class) pega o user details
    Login usuario = mapper.readValue(credentialsJson, Login.class); //transforma na classe login
    UserDetails userDetails = User.builder().username(usuario.getUsername()).password("secret")
        .authorities(usuario.getAutorizacao()).build(); //gera objeto do tipo userDetails
    return new UsernamePasswordAuthenticationToken(usuario.getUsername(), usuario.getPassword(),
        userDetails.getAuthorities()); //gera outro objeto UsernamePasswordAuthenticationToken contendo user, senha e autorizaçoes, OBJETO USADO PARA O LOGIN NO FILTER
  }

}