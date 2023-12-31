
package com.senacead.petpug.repository;
import com.senacead.petpug.model.Consulta;
import com.senacead.petpug.model.Pet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long>{
     Set<Pet> findPetsByConsultaId(Long consultaId);
    Set<Consulta> findConsultasByProdutoId(Long produtoId);
    @Query("SELECT c FROM Consulta c WHERE c.id = ?1")
    List<Consulta> findByConsultaId(Integer id);

    public Optional<Consulta> findById(Long id);

    public void deleteById(Long id);
    
    
0
}




