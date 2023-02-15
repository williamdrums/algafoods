package com.wln.myrestaurantapi.domain.repository;

import com.wln.myrestaurantapi.domain.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado,Long> {
}
