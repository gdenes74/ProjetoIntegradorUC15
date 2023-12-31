
package com.senacead.petpug.service;

import com.senacead.petpug.model.Consulta;
import com.senacead.petpug.model.Pet;
import com.senacead.petpug.model.Produto;
import com.senacead.petpug.repository.ConsultaRepository;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;
    
     private Long id;

  public ConsultaService() {
    this.id = null;
  }
    
    public Set<Pet> getPets() {
  // Use o repositório injetado para recuperar os Pets relacionados à Consulta
  return consultaRepository.findPetsByConsultaId(this.id);
}

    public Consulta criar(Consulta con) {
        con.setId(null);
        consultaRepository.save(con);
        return con;
    }
    
      public List<Consulta> listarTodos() {
        return consultaRepository.findAll();
    } 

    public Consulta buscarPorId(Long id) {
        return consultaRepository.findById(id).orElseThrow();
    }
          
         
     public Consulta atualizar(Long id, Consulta consultaEnviado) {
        Consulta consultaEncontrado = buscarPorId(id);
        
        consultaEncontrado.setDataDaConsulta(consultaEnviado.getDataDaConsulta());
        consultaEncontrado.setTratamento(consultaEnviado.getTratamento());
        consultaEncontrado.setDoenca(consultaEnviado.getDoenca());
        consultaEncontrado.setValorTotal(consultaEnviado.getValorTotal());
     
        
      
           consultaRepository.save(consultaEncontrado);

    return consultaEncontrado;
        }
       
    
      public void excluir(Long id) {
        Consulta consultaEncontrado = buscarPorId(id);
        consultaRepository.deleteById(consultaEncontrado.getId());
    }
      public ConsultaService(ConsultaRepository consultaRepository) {
    this.consultaRepository = consultaRepository;
}
}