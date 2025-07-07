package com.example.demo.controller;

import com.example.demo.dto.AutorDTO;
import com.example.demo.model.Autor;
import com.example.demo.service.AutorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping
    public List<AutorDTO> listar() {
        return autorService.findAll();
    }

    @GetMapping("/{id}")
    public AutorDTO buscarPorId(@PathVariable Long id) {
        return autorService.findById(id);
    }

    @PostMapping
    public AutorDTO criar(@RequestBody Autor autor) {
        return autorService.save(autor);
    }

    @PutMapping("/{id}")
    public AutorDTO atualizar(@PathVariable Long id, @RequestBody Autor autor) {
        return autorService.update(id, autor);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        autorService.delete(id);
    }
}