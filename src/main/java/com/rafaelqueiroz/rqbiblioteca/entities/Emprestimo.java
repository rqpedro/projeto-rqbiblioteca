package com.rafaelqueiroz.rqbiblioteca.entities;

import com.rafaelqueiroz.rqbiblioteca.enums.EmprestimoStatus;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tb_emprestimo", indexes = {
        @Index(name = "idx_emprestimo_membro_id", columnList = "membro_id"),
        @Index(name = "idx_emprestimo_livro_id", columnList = "livro_id")})
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDate dataEmprestimo;
    @Column(nullable = false)
    private LocalDate dataPrevistaDevolucao;
    private LocalDate dataDevolucao;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EmprestimoStatus status;

    @ManyToOne(optional = false)
    @JoinColumn(name = "livro_id", nullable = false, foreignKey = @ForeignKey(name = "fk_emprestimo_livro"))
    private Livro livro;

    @ManyToOne(optional = false)
    @JoinColumn(name = "membro_id", nullable = false, foreignKey = @ForeignKey(name = "fk_emprestimo_membro"))
    private Membro membro;

    public Emprestimo() {
    }

    public Emprestimo(Long id, LocalDate dataEmprestimo, LocalDate dataPrevistaDevolucao, LocalDate dataDevolucao, EmprestimoStatus status, Livro livro, Membro membro) {
        this.id = id;
        this.dataEmprestimo = dataEmprestimo;
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
        this.dataDevolucao = dataDevolucao;
        this.status = status;
        this.livro = livro;
        this.membro = membro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataPrevistaDevolucao() {
        return dataPrevistaDevolucao;
    }

    public void setDataPrevistaDevolucao(LocalDate dataPrevistaDevolucao) {
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public EmprestimoStatus getStatus() {
        return status;
    }

    public void setStatus(EmprestimoStatus status) {
        this.status = status;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Emprestimo that = (Emprestimo) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
