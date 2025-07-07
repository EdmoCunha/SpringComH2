package com.example.demo.controller;

import com.example.demo.dto.LivroDTO;
import com.example.demo.service.LivroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping
    public List<LivroDTO> listar() {
        return livroService.findAll();
    }

    @GetMapping("/{id}")
    public LivroDTO buscarPorId(@PathVariable Long id) {
        return livroService.findById(id);
    }

    // Para criar um livro, precisa informar o id do autor na URL!
    @PostMapping("/autor/{autorId}")
    public LivroDTO criar(@PathVariable Long autorId, @RequestBody LivroDTO livroDTO) {
        return livroService.save(livroDTO, autorId);
    }

    @PutMapping("/{id}/autor/{autorId}")
    public LivroDTO atualizar(@PathVariable Long id, @PathVariable Long autorId, @RequestBody LivroDTO livroDTO) {
        return livroService.update(id, livroDTO, autorId);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        livroService.delete(id);
    }
}