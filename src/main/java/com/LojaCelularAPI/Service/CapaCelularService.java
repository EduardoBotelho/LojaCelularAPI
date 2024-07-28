package com.LojaCelularAPI.Service;

import com.LojaCelularAPI.Model.CapaCelular;
import com.LojaCelularAPI.Repository.CapaCelularRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
    public class CapaCelularService {

        @Autowired
        private CapaCelularRepository capaCelularRepository;

        // Criar uma nova capa de celular
        public CapaCelular salvarCapaCelular(CapaCelular capaCelular) {
            return capaCelularRepository.save(capaCelular);
        }

        // Obter todas as capas de celular
        public List<CapaCelular> listarCapasCelular() {
            return capaCelularRepository.findAll();
        }

        // Obter uma capa de celular por ID
        public Optional<CapaCelular> obterCapaCelularPorId(Long id) {
            return capaCelularRepository.findById(id);
        }

        // Atualizar uma capa de celular
        public CapaCelular atualizarCapaCelular(Long id, CapaCelular capaCelularAtualizada) {
            Optional<CapaCelular> optionalCapaCelular = capaCelularRepository.findById(id);
            if (optionalCapaCelular.isPresent()) {
                CapaCelular capaCelular = optionalCapaCelular.get();
                capaCelular.setMarca(capaCelularAtualizada.getMarca());
                capaCelular.setModelo(capaCelularAtualizada.getModelo());
                capaCelular.setPreco(capaCelularAtualizada.getPreco());
                return capaCelularRepository.save(capaCelular);
            } else {
                throw new RuntimeException("Capa de celular não encontrada com o ID: " + id);
            }
        }

        // Deletar uma capa de celular por ID
        public void deletarCapaCelular(Long id) {
            capaCelularRepository.deleteById(id);
        }
    }


