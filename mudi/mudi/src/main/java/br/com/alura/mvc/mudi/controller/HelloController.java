package br.com.alura.mvc.mudi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController {

    //Criei um metodo que e um action, quando e chamado ele direciona para o hello, que e uma view
    // criada no template, essa view e um html que ira mostrar seu conteudo.
    @GetMapping("/hello")
    //para acessar um valor por request na view, necessario colocar a notacao abaixo do httpservletrequest
    public String hello(HttpServletRequest request){
        //aqui esta fazendo uma request e mudando o atributo nome, passando o valor mundo para ele
        request.setAttribute("nome", "mundo");
        return "hello";
    }

}
