
package com.senacead.petpug.repository;
import com.senacead.petpug.model.Consulta;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Integer>{
    @Query("SELECT c FROM Consulta c WHERE c.id = ?1")
    List<Consulta> findByConsultaId(Integer id);
    
}




