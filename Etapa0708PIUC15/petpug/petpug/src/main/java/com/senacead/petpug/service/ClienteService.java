
package com.senacead.petpug.service;

import com.senacead.petpug.model.Cliente;
import com.senacead.petpug.repository.ClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

     public Cliente criar(Cliente cli){
        cli.setId(null);
        clienteRepository.save(cli);
        return cli;
    }
    
    
   
      public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    } 

    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id).orElseThrow();
    }
          
         
     public Cliente atualizar(Long id, Cliente clienteEnviado) {
        Cliente clienteEncontrado = buscarPorId(id);
        
        clienteEncontrado.setNome(clienteEnviado.getNome());
        clienteEncontrado.setIdade(clienteEnviado.getIdade());
        clienteEncontrado.setCpf(clienteEnviado.getCpf());
        clienteEncontrado.setEndereco(clienteEnviado.getEndereco());
        clienteEncontrado.setTelefone(clienteEnviado.getTelefone());
        clienteRepository.save(clienteEncontrado);
        return clienteEncontrado;
    }
      public void excluir(Long id) {
        Cliente clienteEncontrado = buscarPorId(id);
        clienteRepository.deleteById(clienteEncontrado.getId());
    }
}
