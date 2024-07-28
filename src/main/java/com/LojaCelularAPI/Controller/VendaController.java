package com.LojaCelularAPI.Controller;


import com.LojaCelularAPI.Model.Venda;
import com.LojaCelularAPI.Service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @GetMapping
    public List<Venda> listarTodasVendas() {
        return vendaService.listarTodasVendas();
    }

    @PostMapping
    public Venda salvarVenda(@RequestBody Venda venda) {
        return vendaService.salvarVenda(venda);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venda> buscarVendaPorId(@PathVariable Long id) {
        Venda venda = vendaService.buscarVendaPorId(id);
        return venda != null ? ResponseEntity.ok(venda) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public void deletarVenda(@PathVariable Long id) {
        vendaService.deletarVenda(id);
    }
}

