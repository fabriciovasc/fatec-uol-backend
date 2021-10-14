package br.gov.sp.fatec.springbootapp.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

public class JwtAuthenticationFilter extends GenericFilterBean {

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) //recebe request, volta resposta, trabalha em cadeia (até chegar no controller)
      throws IOException, ServletException {

    try {
      HttpServletRequest servletRequest = (HttpServletRequest) request; //pega requisiçao
      String authorization = servletRequest.getHeader(HttpHeaders.AUTHORIZATION); //utiliza o header da request (onde fica o auth {token})
      if (authorization != null) { //verifica se nao ta nulo
        Authentication credentials = JwtUtils.parseToken(authorization.replaceAll("Bearer ", "")); //abre o token e tira o bearer ficando só com o token
        //parseToken valida o token, se errado cai no catch
        SecurityContextHolder.getContext().setAuthentication(credentials); //faz login com o token, usando o UsernamePasswordAuthenticationToken
      }
      chain.doFilter(request, response); //proximo filtro
    } catch (Throwable t) { //exceção
      HttpServletResponse servletResponse = (HttpServletResponse) response; //resposta de erro
      servletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, t.getMessage());
    }
  }

}
