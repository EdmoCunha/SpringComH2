package com.example.demo.dto;
import java.util.List;

public class AutorDTO {
    private Long id;
    private String nome;
    private List<LivroDTO> livros;

    public AutorDTO() {}

    public AutorDTO(Long id, String nome, List<LivroDTO> livros) {
        this.id = id;
        this.nome = nome;
        this.livros = livros;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public List<LivroDTO> getLivros() { return livros; }
    public void setLivros(List<LivroDTO> livros) { this.livros = livros; }
}