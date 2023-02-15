package com.wln.myrestaurantapi.domain.repository;

import com.wln.myrestaurantapi.domain.model.Cozinha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {

}
