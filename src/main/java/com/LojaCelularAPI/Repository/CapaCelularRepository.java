package com.LojaCelularAPI.Repository;

import com.LojaCelularAPI.Model.CapaCelular;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CapaCelularRepository extends JpaRepository<CapaCelular, Long> {
}
