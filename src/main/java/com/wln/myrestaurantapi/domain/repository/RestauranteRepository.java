package com.wln.myrestaurantapi.domain.repository;

import com.wln.myrestaurantapi.domain.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante,Long> {

}
