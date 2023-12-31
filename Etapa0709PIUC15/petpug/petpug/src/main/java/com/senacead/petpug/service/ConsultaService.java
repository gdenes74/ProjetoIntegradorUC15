
package com.senacead.petpug.service;

import com.senacead.petpug.model.Consulta;
import com.senacead.petpug.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    public Consulta getConsultaById(Integer id) {
        Optional<Consulta> optionalConsulta = consultaRepository.findById(id);
        if (optionalConsulta.isPresent()) {
            return optionalConsulta.get();
        } else {
            // Tratar o caso quando não há Consulta com o id fornecido
            // Você pode lançar uma exceção ou retornar null, dependendo da sua escolha
            return null;
        }
    }
}