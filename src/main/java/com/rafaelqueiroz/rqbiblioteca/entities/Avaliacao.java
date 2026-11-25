package com.rafaelqueiroz.rqbiblioteca.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tb_avaliacao")
public class Avaliacao {

    @EmbeddedId
    private AvaliacaoPK id = new AvaliacaoPK();

    @ManyToOne(optional = false)
    @MapsId("livroId")
    @JoinColumn(name = "livro_id", nullable = false, foreignKey = @ForeignKey(name = "fk_avaliacao_livro"))
    private Livro livro;

    @ManyToOne(optional = false)
    @MapsId("membroId")
    @JoinColumn(name = "membro_id", nullable = false, foreignKey = @ForeignKey(name = "fk_avaliacao_membro"))
    private Membro membro;

    @Column(nullable = false)
    private Integer nota;
    private String comentario;
    @Column(nullable = false)
    private LocalDate data;

    public Avaliacao() {
    }

    public Avaliacao(Livro livro, Membro membro, Integer nota, String comentario, LocalDate data) {
        this.livro = livro;
        this.membro = membro;
        this.nota = nota;
        this.comentario = comentario;
        this.data = data;
    }

    public AvaliacaoPK getId() {
        return id;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Membro getMembro() {
        return membro;
    }

    public void setMembro(Membro membro) {
        this.membro = membro;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Avaliacao avaliacao = (Avaliacao) o;
        return Objects.equals(id, avaliacao.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
