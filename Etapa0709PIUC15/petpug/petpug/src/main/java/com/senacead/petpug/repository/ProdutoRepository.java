
package com.senacead.petpug.repository;
import com.senacead.petpug.model.Produto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository


public interface ProdutoRepository  extends JpaRepository<Produto, Integer>{
   //List<Produto> findByProdutoId(Integer id); 
}



