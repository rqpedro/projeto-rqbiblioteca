package com.rafaelqueiroz.rqbiblioteca.entities;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AvaliacaoPK implements Serializable {

    private Long livroId;
    private Long membroId;

    public AvaliacaoPK() {
    }

    public AvaliacaoPK(Long livroId, Long membroId) {
        this.livroId = livroId;
        this.membroId = membroId;
    }

    public Long getLivroId() {
        return livroId;
    }

    public void setLivroId(Long livroId) {
        this.livroId = livroId;
    }

    public Long getMembroId() {
        return membroId;
    }

    public void setMembroId(Long membroId) {
        this.membroId = membroId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AvaliacaoPK that = (AvaliacaoPK) o;
        return Objects.equals(livroId, that.livroId) && Objects.equals(membroId, that.membroId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(livroId, membroId);
    }
}
