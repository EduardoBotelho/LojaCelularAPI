package com.LojaCelularAPI.Service;


import com.LojaCelularAPI.Model.Venda;
import com.LojaCelularAPI.Repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    public List<Venda> listarTodasVendas() {
        return vendaRepository.findAll();
    }

    public Venda salvarVenda(Venda venda) {
        return vendaRepository.save(venda);
    }

    public Venda buscarVendaPorId(Long id) {
        return vendaRepository.findById(id).orElse(null);
    }

    public void deletarVenda(Long id) {
        vendaRepository.deleteById(id);
    }
}

