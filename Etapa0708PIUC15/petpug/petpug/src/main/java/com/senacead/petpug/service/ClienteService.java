
package com.senacead.petpug.service;

import com.senacead.petpug.model.Cliente;
import com.senacead.petpug.repository.ClienteRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente getClienteById(Integer id) {
        Optional<Cliente> optionalCliente = clienteRepository.findById(id);
        if(optionalCliente.isPresent()){
            return optionalCliente.get();
        }else{
            // lidar com o caso em que o cliente não é encontrado
            return null;
        }
    }
}
