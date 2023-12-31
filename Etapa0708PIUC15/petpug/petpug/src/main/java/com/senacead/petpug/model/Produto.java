package com.senacead.petpug.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Column(name = "descrição")
    private String descricao;

    @Column(name = "nome_da_empresa", nullable = false)
    private String nomeDaEmpresa;

    @Column(name = "preço", nullable = false)
    private Double preco;

    @Column(name = "código", nullable = false, unique = true, columnDefinition = "VARCHAR(255) DEFAULT 'teste12345'")
    private String codigo;

    @ManyToMany(mappedBy = "consultas")
    private Set<Consulta> consultas;

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Consulta> getConsultas() {
        return consultas;
    }

    public void addConsulta(Consulta consulta) {
        consultas.add(consulta);

    }

    public Long getId() {
        return id;
    }
}
