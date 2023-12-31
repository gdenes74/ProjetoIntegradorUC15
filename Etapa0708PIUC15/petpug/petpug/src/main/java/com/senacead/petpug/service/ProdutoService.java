
package com.senacead.petpug.service;

import com.senacead.petpug.model.Produto;
import com.senacead.petpug.repository.ProdutoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ProdutoService {
  @Autowired
    private ProdutoRepository produtoRepository;

    public Produto  criar(Produto prod){
        prod.setId(null);
        produtoRepository.save(prod);
        return prod;
    }
       public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }
        public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id).orElseThrow();
    }
           public Produto atualizar(Long id, Produto produtoEnviado) {
        Produto produtoEncontrado = buscarPorId(id);
        
        produtoEncontrado.setNome(produtoEnviado.getNome());
        produtoEncontrado.setTipo(produtoEnviado.getTipo());
        produtoEncontrado.setDescricao(produtoEnviado.getDescricao());
        produtoEncontrado.setNomeDaEmpresa(produtoEnviado.getNomeDaEmpresa());
        produtoEncontrado.setPreco(produtoEnviado.getPreco());
        produtoEncontrado.setCodigo(produtoEnviado.getCodigo());
        
        // Atualiza a referência à linha consulta
        produtoEncontrado.getConsultas().clear();
        produtoEncontrado.getConsultas().addAll(produtoEnviado.getConsultas());

        produtoRepository.save(produtoEncontrado);
        return produtoEncontrado;
    }
                 public void excluir(Long id) {
        Produto produtoEncontrado = buscarPorId(id);
       produtoRepository.deleteById(produtoEncontrado.getId());
    }
}
