package com.LojaCelularAPI.Controller;

import com.LojaCelularAPI.Model.CapaCelular;
import com.LojaCelularAPI.Service.CapaCelularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
 @RequestMapping("/api/capas")
 public class CapaCelularController {

        @Autowired
        private CapaCelularService capaCelularService;

        // Criar uma nova capa de celular
        @PostMapping
        public CapaCelular criarCapaCelular(@RequestBody CapaCelular capaCelular) {
            return capaCelularService.salvarCapaCelular(capaCelular);
        }

        // Obter todas as capas de celular
        @GetMapping
        public List<CapaCelular> listarCapasCelular() {
            return capaCelularService.listarCapasCelular();
        }

        // Obter uma capa de celular por ID
        @GetMapping("/{id}")
        public ResponseEntity<CapaCelular> obterCapaCelularPorId(@PathVariable Long id) {
            Optional<CapaCelular> capaCelular = capaCelularService.obterCapaCelularPorId(id);
            return capaCelular.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        }

        // Atualizar uma capa de celular
        @PutMapping("/{id}")
        public ResponseEntity<CapaCelular> atualizarCapaCelular(@PathVariable Long id, @RequestBody CapaCelular capaCelularAtualizada) {
            try {
                CapaCelular capaCelular = capaCelularService.atualizarCapaCelular(id, capaCelularAtualizada);
                return ResponseEntity.ok(capaCelular);
            } catch (RuntimeException e) {
                return ResponseEntity.notFound().build();
            }
        }

        // Deletar uma capa de celular por ID
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deletarCapaCelular(@PathVariable Long id) {
            capaCelularService.deletarCapaCelular(id);
            return ResponseEntity.noContent().build();
        }
    }


