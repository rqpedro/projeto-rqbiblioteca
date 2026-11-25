package com.rafaelqueiroz.rqbiblioteca.entities;

import com.rafaelqueiroz.rqbiblioteca.enums.MembroTipo;
import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "tb_membro")
public class Membro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String senha;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MembroTipo tipo;

    @OneToMany(mappedBy = "membro")
    private List<Emprestimo> emprestimos = new ArrayList<>();

    @OneToOne(mappedBy = "membro")
    private Carteirinha carteirinha;

    @ManyToMany
    @JoinTable(name = "tb_membro_role",
            joinColumns = @JoinColumn(name = "membro_id", foreignKey = @ForeignKey(name = "fk_membro_role_membro")),
            inverseJoinColumns = @JoinColumn(name = "role_id", foreignKey = @ForeignKey(name = "fk_membro_role_role")))
    private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "membro")
    private Set<Avaliacao> avaliacoes = new HashSet<>();

    public Membro() {
    }

    public Membro(Long id, String nome, String email, String senha, MembroTipo tipo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public MembroTipo getTipo() {
        return tipo;
    }

    public void setTipo(MembroTipo tipo) {
        this.tipo = tipo;
    }

    public Carteirinha getCarteirinha() {
        return carteirinha;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public Set<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Membro membro = (Membro) o;
        return Objects.equals(id, membro.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
