package com.LojaCelularAPI.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dataVenda;

    @ManyToMany
    @JoinTable(
            name = "venda_celular",
            joinColumns = @JoinColumn(name = "venda_id"),
            inverseJoinColumns = @JoinColumn(name = "celular_id")
    )
    private List<Celular> celulares;

    @ManyToMany
    @JoinTable(
            name = "venda_capa_celular",
            joinColumns = @JoinColumn(name = "venda_id"),
            inverseJoinColumns = @JoinColumn(name = "capa_celular_id")
    )
    private List<CapaCelular> capasCelular;

    private Double valorTotal;
}
