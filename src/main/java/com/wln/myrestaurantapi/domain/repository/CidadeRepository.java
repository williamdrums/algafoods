package com.wln.myrestaurantapi.domain.repository;

import com.wln.myrestaurantapi.domain.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

}
