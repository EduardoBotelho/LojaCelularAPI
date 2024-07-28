package com.LojaCelularAPI.Controller;

import com.LojaCelularAPI.Model.Celular;
import com.LojaCelularAPI.Service.CelularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/celulares")
public class CelularController {

        @Autowired
        private CelularService celularService;

        // Criar um novo celular
        @PostMapping
        public Celular criarCelular(@RequestBody Celular celular) {
            return celularService.salvarCelular(celular);
        }

        // Obter todos os celulares
        @GetMapping
        public List<Celular> listarCelulares() {
            return celularService.listarCelulares();
        }

        // Obter um celular por ID
        @GetMapping("/{id}")
        public ResponseEntity<Celular> obterCelularPorId(@PathVariable Long id) {
            Optional<Celular> celular = celularService.obterCelularPorId(id);
            return celular.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        }

        // Atualizar um celular
        @PutMapping("/{id}")
        public ResponseEntity<Celular> atualizarCelular(@PathVariable Long id, @RequestBody Celular celularAtualizado) {
            try {
                Celular celular = celularService.atualizarCelular(id, celularAtualizado);
                return ResponseEntity.ok(celular);
            } catch (RuntimeException e) {
                return ResponseEntity.notFound().build();
            }
        }

        // Deletar um celular por ID
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deletarCelular(@PathVariable Long id) {
            celularService.deletarCelular(id);
            return ResponseEntity.noContent().build();
        }
    }


