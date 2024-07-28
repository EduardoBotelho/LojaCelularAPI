package com.LojaCelularAPI.Repository;

import com.LojaCelularAPI.Model.Celular;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CelularRepository extends JpaRepository<Celular, Long> {
}
