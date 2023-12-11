
package com.senacead.petpug.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Pet")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "espécie", nullable = false)
    private String especie;

    @Column(name = "raça", nullable = false)
    private String raca;

    @Column(name = "sexo")
    private String sexo;
    
    @OneToMany(mappedBy = "petId")
    private List<Consulta> consultas;

}
