package com.wln.myrestaurantapi.jpa;

import com.wln.myrestaurantapi.MyrestaurantApiApplication;
import com.wln.myrestaurantapi.domain.model.Cozinha;
import com.wln.myrestaurantapi.domain.model.Restaurante;
import com.wln.myrestaurantapi.domain.repository.CozinhaRepository;
import com.wln.myrestaurantapi.domain.repository.RestauranteRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ConsultaRestauranteMain {

    public static void main(String args[]) {

        ApplicationContext applicationContext = new SpringApplicationBuilder(MyrestaurantApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        RestauranteRepository cadastroRestaurante = applicationContext.getBean(RestauranteRepository.class);

        List<Restaurante> restaurantes = cadastroRestaurante.listar();

        for (Restaurante restaurante : restaurantes){

            System.out.printf("%s - %f - %s\n",
                    restaurante.getNome(),
                    restaurante.getTaxa_Frete(),
                    restaurante.getCozinha().getNome());
        }
    }
}
