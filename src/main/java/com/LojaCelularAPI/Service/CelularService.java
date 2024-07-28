package com.LojaCelularAPI.Service;

import com.LojaCelularAPI.Model.Celular;
import com.LojaCelularAPI.Model.Celular;
import com.LojaCelularAPI.Repository.CelularRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CelularService {

    @Autowired
    private CelularRepository celularRepository;

    // Criar um novo celular
    public Celular salvarCelular(Celular celular) {
        return celularRepository.save(celular);
    }

    // Obter todos os celulares
    public List<Celular> listarCelulares() {
        return celularRepository.findAll();
    }

    // Obter um celular por ID
    public Optional<Celular> obterCelularPorId(Long id) {
        return celularRepository.findById(id);
    }

    // Atualizar um celular
    public Celular atualizarCelular(Long id, Celular celularAtualizado) {
        Optional<Celular> optionalCelular = celularRepository.findById(id);
        if (optionalCelular.isPresent()) {
            Celular celular = optionalCelular.get();
            celular.setMarca(celularAtualizado.getMarca());
            celular.setModelo(celularAtualizado.getModelo());
            celular.setPreco(celularAtualizado.getPreco());
            return celularRepository.save(celular);
        } else {
            throw new RuntimeException("Celular não encontrado com o ID: " + id);
        }
    }

    // Deletar um celular por ID
    public void deletarCelular(Long id) {
        celularRepository.deleteById(id);
    }
}
