package com.rafaelqueiroz.rqbiblioteca.entities;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "tb_livro", indexes = {@Index(name = "idx_livro_autor_id", columnList = "autor_id")})
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String titulo;
    private Integer anoPublicacao;

    @ManyToOne(optional = false)
    @JoinColumn(name = "autor_id", nullable = false, foreignKey = @ForeignKey(name = "fk_livro_autor")) // FK
    private Autor autor;

    @ManyToMany
    @JoinTable(name = "tb_livro_categoria",
            joinColumns = @JoinColumn(name = "livro_id", foreignKey = @ForeignKey(name = "fk_livro_categoria_livro")),
            inverseJoinColumns = @JoinColumn(name = "categoria_id", foreignKey = @ForeignKey(name = "fk_livro_categoria_categoria")))
    private Set<Categoria> categorias = new HashSet<>();

    @OneToMany(mappedBy = "livro")
    private List<Emprestimo> emprestimos = new ArrayList<>();

    @OneToMany(mappedBy = "livro")
    private Set<Avaliacao> avaliacoes = new HashSet<>();

    public Livro() {
    }

    public Livro(Long id, String titulo, Integer anoPublicacao, Autor autor) {
        this.id = id;
        this.titulo = titulo;
        this.anoPublicacao = anoPublicacao;
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Set<Categoria> getCategorias() {

        return categorias;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public Set<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return Objects.equals(id, livro.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
