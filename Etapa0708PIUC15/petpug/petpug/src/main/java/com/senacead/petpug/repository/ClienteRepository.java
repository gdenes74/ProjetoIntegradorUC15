
package com.senacead.petpug.repository;

import com.senacead.petpug.model.Cliente;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

    

      Optional<Cliente> findById(Long id);
    
}