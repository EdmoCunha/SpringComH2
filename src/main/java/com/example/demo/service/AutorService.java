package com.example.demo.service;

import com.example.demo.model.Autor;
import com.example.demo.model.Livro;
import com.example.demo.dto.AutorDTO;
import com.example.demo.dto.LivroDTO;
import com.example.demo.repository.AutorRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AutorService {

    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public List<AutorDTO> findAll() {
        return autorRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public AutorDTO findById(Long id) {
        Autor autor = autorRepository.findById(id).orElseThrow();
        return toDTO(autor);
    }

    public AutorDTO save(Autor autor) {
        return toDTO(autorRepository.save(autor));
    }

    public AutorDTO update(Long id, Autor novoAutor) {
        Autor autor = autorRepository.findById(id).orElseThrow();
        autor.setNome(novoAutor.getNome());
        return toDTO(autorRepository.save(autor));
    }

    public void delete(Long id) {
        autorRepository.deleteById(id);
    }

    private AutorDTO toDTO(Autor autor) {
        List<LivroDTO> livros = autor.getLivros().stream()
                .map(livro -> new LivroDTO(livro.getId(), livro.getTitulo()))
                .collect(Collectors.toList());
        return new AutorDTO(autor.getId(), autor.getNome(), livros);
    }
}