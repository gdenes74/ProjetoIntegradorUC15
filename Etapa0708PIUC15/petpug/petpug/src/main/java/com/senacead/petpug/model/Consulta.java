package com.senacead.petpug.model;

import com.senacead.petpug.repository.PetRepository;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Consulta")
public class Consulta {

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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pet_id", nullable = false)
    @Autowired
    private Pet pet;

    public Set<Pet> findPets() {
        // Use petRepository to find the associated pet by its ID
        return this.petRepository.findByConsultaId(this.id);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataDaConsulta() {
        return dataDaConsulta;
    }

    public void setDataDaConsulta(Date dataDaConsulta) {
        this.dataDaConsulta = dataDaConsulta;
    }

    public String getDoenca() {
        return doenca;
    }

    public void setDoenca(String doenca) {
        this.doenca = doenca;
    }

    public String getTratamento() {
        return tratamento;
    }

    public void setTratamento(String tratamento) {
        this.tratamento = tratamento;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Pet getPet() {
        // Return the pet itself
        return this.pet;
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "id=" + id +
                ", dataDaConsulta=" + dataDaConsulta +
                ", doenca='" + doenca + '\'' +
                ", tratamento='" + tratamento + '\'' +
                ", valorTotal=" + valorTotal +
                ", cliente=" + cliente +
                ", pet=" + pet +
                '}';
    }
}
