package com.rafaelqueiroz.rqbiblioteca.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tb_carteirinha")
public class Carteirinha {

    @Id
    private Long membroId;
    @Column(nullable = false)
    private String numero;
    @Column(nullable = false)
    private LocalDate dataEmissao;

    @OneToOne(optional = false)
    @MapsId
    @JoinColumn(name = "membro_id", nullable = false, foreignKey = @ForeignKey(name = "fk_carteirinha_membro"))
    private Membro membro;

    public Carteirinha() {
    }

    public Carteirinha(String numero, LocalDate dataEmissao, Membro membro) {
        this.numero = numero;
        this.dataEmissao = dataEmissao;
        this.membro = membro;
    }

    public Long getMembroId() {
        return membroId;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Membro getMembro() {
        return membro;
    }

    public void setMembro(Membro membro) {
        this.membro = membro;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Carteirinha that = (Carteirinha) o;
        return Objects.equals(membroId, that.membroId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(membroId);
    }
}