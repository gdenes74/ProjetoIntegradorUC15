
package com.senacead.petpug.service;

import com.senacead.petpug.model.Pet;
import com.senacead.petpug.model.Produto;
import com.senacead.petpug.repository.PetRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PetService {
  @Autowired
    private PetRepository petRepository;
  
   public Pet criar(Pet peti){
        peti.setId(null);
        petRepository.save(peti);
        return peti;
    }
     public List<Pet> listarTodos() {
        return petRepository.findAll();
    }
     public Pet buscarPorId(Long id) {
        return petRepository.findById(id).orElseThrow();
    }  
      public Pet atualizar(Long id, Pet petEnviado) {

  Pet petEncontrado = buscarPorId(id);
  if (petEncontrado == null) {
    throw new EntityNotFoundException("Pet não encontrado com ID: " + id);
  }

  // Atualiza os dados do produto
  petEncontrado.setDataDaConsulta(petEnviado.getDataDaConsulta());
  petEncontrado.setDoenca(petEnviado.getDoenca());
  petEncontrado.setTratamento(petEnviado.getTratamento());
  petEncontrado.setValorTotal(petEnviado.getValorTotal());
  petEncontrado.setPet(petEnviado.getPet());
  petEncontrado.setCliente(petEnviado.getCliente());

  // Atualiza a referência à linha consulta
  petEncontrado.getConsultas().clear();
  petEncontrado.getConsultas().addAll(petEnviado.getConsultas());

  petRepository.save(petEncontrado);
  return petEncontrado;
}
           public void excluir(Long id) {
        Pet petEncontrado = buscarPorId(id);
        petRepository.deleteById(petEncontrado.getId());
    }
}