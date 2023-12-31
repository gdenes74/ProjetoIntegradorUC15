package com.senacead.petpug.controller;

import com.senacead.petpug.model.Cliente;
import com.senacead.petpug.service.ClienteService;
import java.util.List;
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
@RequestMapping("/api/clientes")
public class ClienteAPIController {

    @Autowired
    private ClienteService clienteService;

   //cadastrar(C)
    @PostMapping("/cadastrar")
    public ResponseEntity<Cliente> addCliente(@RequestBody Cliente cli) {
        var novoCliente = clienteService.criar(cli);
        return new ResponseEntity<>(novoCliente, HttpStatus.CREATED);
    }
    
 
    //listar(R)
    @GetMapping("/listar")
    public ResponseEntity<List> listar() {
        List<Cliente> clientes = clienteService.listarTodos();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }
   
    //buscar(R)
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Cliente> pesquisar(@PathVariable Long id) {
        Cliente clienteEncontrado = clienteService.buscarPorId(id);
        return new ResponseEntity<>(clienteEncontrado, HttpStatus.OK);
    }
    
    
    //alterar(U)
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Cliente> editCliente(@PathVariable Long id, @RequestBody Cliente cli) {
        var editarCliente = clienteService.atualizar(id, cli);
        return new ResponseEntity<>(editarCliente, HttpStatus.OK);
    }
    

    //excluir(D)
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        clienteService.excluir(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
  }

