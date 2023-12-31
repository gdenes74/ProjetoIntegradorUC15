
package com.senacead.petpug.controller;


import com.senacead.petpug.model.Pet;
import com.senacead.petpug.repository.PetRepository;
import com.senacead.petpug.service.PetService;
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
@RequestMapping("/api/pets")

public class PetAPIController {
    @Autowired
    private PetService petService;

    //cadastrar(C)
    @PostMapping("/cadastrar")
    public ResponseEntity<Pet> addPet(@RequestBody Pet peti) {
        var novoPet = petService.criar(peti);
        return new ResponseEntity<>(novoPet, HttpStatus.CREATED);
  
    }

    //listar(R)
    @GetMapping("/listar")
    public ResponseEntity<List> listar() {
        List<Pet> pets = petService.listarTodos();
        return new ResponseEntity<>(pets, HttpStatus.OK);
    }
    //buscar(R)
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Pet> pesquisar(@PathVariable Long id) {
        Pet petEncontrado = petService.buscarPorId(id);
        return new ResponseEntity<>(petEncontrado, HttpStatus.OK);
    }
   

    //alterar (U)
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Pet> alterarPet(@PathVariable Long id, @RequestBody Pet peti) {
              var editarPet = petService.atualizar(id, peti);
        return new ResponseEntity<>(editarPet, HttpStatus.OK);
    }    
  
      //excluir(D)
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        petService.excluir(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
