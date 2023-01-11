package com.wln.myrestaurantapi.jpa;

import com.wln.myrestaurantapi.MyrestaurantApiApplication;
import com.wln.myrestaurantapi.domain.model.Cozinha;
import com.wln.myrestaurantapi.domain.repository.CozinhaRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class BuscaCozinhaMain {

    public static void main(String args[]){

        ApplicationContext applicationContext = new SpringApplicationBuilder(MyrestaurantApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);


        CozinhaRepository cadastroCozinha = applicationContext.getBean(CozinhaRepository.class);

        Cozinha cozinha = cadastroCozinha.buscar(1L);
        System.out.println(cozinha.getNome());
    }
}
