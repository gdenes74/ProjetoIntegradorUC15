
package com.senacead.petpug.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
public class Consulta {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
   @ManyToOne
   @JoinColumn(name = "pet_id", nullable = false)
   private Pet petId;
   @ManyToOne
   @JoinColumn(name = "cliente_id", nullable = false)
   private Cliente clienteId;
   @Column(name = "data_da_consulta")
    private Date dataDaConsulta;

    @Column(name = "doença")
    private String doenca;

    @Column(name = "tratamento", nullable = false)
    private String tratamento;

    @Column(name = "valor_total", nullable = false)
    private Double valorTotal;
    @ManyToMany
    @JoinTable(
            name = "Consulta_Produto",
            joinColumns = @JoinColumn(name = "consulta_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    private Set<Produto> produtos;
}
