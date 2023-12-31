package com.senacead.petpug.repository;

import com.senacead.petpug.model.Pet;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface PetRepository  extends JpaRepository<Pet, Long>{

    public Optional<Pet> findById(Long id);

    public void deleteById(Long id);
    @Query("SELECT p FROM Pet p JOIN p.consulta c WHERE c.id = :consultaId ORDER BY p.nome")
    List<Pet> findByConsultaId(Long consultaId);
 
}