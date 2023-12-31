package com.senacead.petpug.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Consulta")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_da_consulta")
    private Date dataDaConsulta;

    @Column(name = "doenca")
    private String doenca;

    @Column(name = "tratamento")
    private String tratamento;

    @Column(name = "valor_total")
    private Double valorTotal;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL)
    private Set<Consulta> consultas;

    public Set<Consulta> getConsultas() {

        return consultas;
    }

    public void
            setConsultas(Set<Consulta> consultas) {
        this.consultas = consultas;
    }

    public Pet orElseThrow() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
