
package com.senacead.petpug.service;

import com.senacead.petpug.model.Produto;
import com.senacead.petpug.repository.ProdutoRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ProdutoService {
  @Autowired
    private ProdutoRepository produtoRepository;

    public Produto getProdutoById(Integer id) {
        Optional<Produto> optionalProduto = produtoRepository.findById(id);
        if(optionalProduto.isPresent()){
            return optionalProduto.get();
        }else{
            // lidar com o caso em que o produto não é encontrado
            return null;
        }
    }  
}
