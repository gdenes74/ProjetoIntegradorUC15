
package com.senacead.petpug.controller;

import com.senacead.petpug.model.Consulta;
import com.senacead.petpug.service.ConsultaService;
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
@RequestMapping("/api/consultas")
public class ConsultaAPIController {

    @Autowired
    private ConsultaService consultaService;

    //cadastrar(C)
    @PostMapping("/cadastrar")
    public ResponseEntity<Consulta> addConsulta(@RequestBody Consulta con) {
        var novaConsulta = consultaService.criar(con);
        return new ResponseEntity<>(novaConsulta, HttpStatus.CREATED);
    }

      //listar(R)
    @GetMapping("/listar")
    public ResponseEntity<List> listar() {
        List<Consulta> consultas = consultaService.listarTodos();
        return new ResponseEntity<>(consultas, HttpStatus.OK);
    }
   
    //buscar(R)
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Consulta> pesquisar(@PathVariable Long id) {
        Consulta consultaEncontrado = consultaService.buscarPorId(id);
        return new ResponseEntity<>(consultaEncontrado, HttpStatus.OK);
    }
    
    
    //alterar(U)
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Consulta> editConsulta(@PathVariable Long id, @RequestBody Consulta cli) {
        var editarConsulta = consultaService.atualizar(id, cli);
        return new ResponseEntity<>(editarConsulta, HttpStatus.OK);
    }
    

    //excluir(D)
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        consultaService.excluir(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
  }