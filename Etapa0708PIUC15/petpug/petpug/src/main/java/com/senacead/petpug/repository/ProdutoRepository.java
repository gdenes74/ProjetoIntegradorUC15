
package com.senacead.petpug.repository;
import com.senacead.petpug.model.Produto;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository


public interface ProdutoRepository  extends JpaRepository<Produto, Long>{

    public Optional<Produto> findById(Long id);
   //List<Produto> findByProdutoId(Integer id); 

    public void deleteById(Long id);
}



