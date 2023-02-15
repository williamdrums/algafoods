package com.wln.myrestaurantapi;

import com.wln.myrestaurantapi.domain.model.Cozinha;
import com.wln.myrestaurantapi.domain.repository.CozinhaRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ConsultaCozinhaMain {

    public static void main(String args[]) {

        ApplicationContext applicationContext = new SpringApplicationBuilder(MyrestaurantApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CozinhaRepository cadastroCozinha = applicationContext.getBean(CozinhaRepository.class);

        List<Cozinha> cozinhas = cadastroCozinha.findAll();

        for (Cozinha cozinha : cozinhas){
            System.out.println(cozinha.getNome());
        }
    }
}
