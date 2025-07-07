package com.example.demo.service;

import com.example.demo.model.Autor;
import com.example.demo.model.Livro;
import com.example.demo.dto.LivroDTO;
import com.example.demo.repository.AutorRepository;
import com.example.demo.repository.LivroRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivroService {

    private final LivroRepository livroRepository;
    private final AutorRepository autorRepository;

    public LivroService(LivroRepository livroRepository, AutorRepository autorRepository) {
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
    }

    public List<LivroDTO> findAll() {
        return livroRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public LivroDTO findById(Long id) {
        Livro livro = livroRepository.findById(id).orElseThrow();
        return toDTO(livro);
    }

    public LivroDTO save(LivroDTO livroDTO, Long autorId) {
        Autor autor = autorRepository.findById(autorId).orElseThrow();
        Livro livro = new Livro();
        livro.setTitulo(livroDTO.getTitulo());
        livro.setAutor(autor);
        Livro saved = livroRepository.save(livro);
        return toDTO(saved);
    }

    public LivroDTO update(Long id, LivroDTO livroDTO, Long autorId) {
        Livro livro = livroRepository.findById(id).orElseThrow();
        Autor autor = autorRepository.findById(autorId).orElseThrow();
        livro.setTitulo(livroDTO.getTitulo());
        livro.setAutor(autor);
        return toDTO(livroRepository.save(livro));
    }

    public void delete(Long id) {
        livroRepository.deleteById(id);
    }

    private LivroDTO toDTO(Livro livro) {
        return new LivroDTO(livro.getId(), livro.getTitulo());
    }
}