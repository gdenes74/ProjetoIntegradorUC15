
package com.senacead.petpug.controller;

import com.senacead.petpug.model.Produto;
import com.senacead.petpug.repository.ProdutoRepository;
import com.senacead.petpug.service.ProdutoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoAPIController {

    @Autowired
    private ProdutoService produtoService;
   
   //cadastrar(C)
    @PostMapping("/cadastrar")
    public ResponseEntity<Produto> addProduto(@RequestBody Produto prod) {
        var novoProduto = produtoService.criar(prod);
        return new ResponseEntity<>(novoProduto, HttpStatus.CREATED);
    }
 
    //listar(R)
    @GetMapping("/listar")
    public ResponseEntity<List> listar(){
        List<Produto> produtos = produtoService.listarTodos();
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }
 
    
      //buscar(R)Long id
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Produto> pesquisar(@PathVariable Long id) {
        Produto produtoEncontrado = produtoService.buscarPorId(id);
        return new ResponseEntity<>(produtoEncontrado, HttpStatus.OK);
    }
    //alterar (U)
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Produto> editProduto(@PathVariable Long id, @RequestBody Produto prod) {
        var editarProduto = produtoService.atualizar(id, prod);
        return new ResponseEntity<>(editarProduto, HttpStatus.OK);
        }
    

         //excluir(D)
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        produtoService.excluir(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    
}