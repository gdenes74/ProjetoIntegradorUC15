
package com.senacead.petpug.controller;

import com.senacead.petpug.model.Cliente;
import com.senacead.petpug.model.Consulta;
import com.senacead.petpug.model.Pet;
import com.senacead.petpug.model.Produto;
import com.senacead.petpug.repository.ClienteRepository;
import com.senacead.petpug.repository.ConsultaRepository;
import com.senacead.petpug.repository.PetRepository;
import com.senacead.petpug.repository.ProdutoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class ExibirController {
    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private PetRepository petRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("/listar")
    public String listar(Model model) {
        List<Consulta> consultas = consultaRepository.findAll();
        List<Pet> listaPets = petRepository.findAll();
        List<Cliente> listaClientes = clienteRepository.findAll();
        List<Produto> listaProdutos = produtoRepository.findAll();
        model.addAttribute("consultas", consultas);
        model.addAttribute("pets", listaPets);
        model.addAttribute("clientes", listaClientes);
        model.addAttribute("produtos", listaProdutos);
        return "listar_dados";
    }
    @GetMapping("/inicio")
    public String exibirTelaInicial() {
        return "tela_inicial";
    }
    @GetMapping("/selecao")
    public String exibirTelaSeleção() {
        return "tela_seleção";
    }
    @GetMapping("/pet")
    public String exibirTelaPet(Model model) {
        model.addAttribute("pet", new Pet());
        return "tela_cadastro_de_pet";
    }
    @GetMapping("/cliente")
    public String exibirTelaCliente(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "tela_cadastro_de_cliente";
    }
    @GetMapping("/consulta")
    public String exibirTelaConsulta(Model model) {
        List<Pet> listaPets = petRepository.findAll();
        List<Cliente> listaClientes = clienteRepository.findAll();
        model.addAttribute("pet_existente", listaPets);
        model.addAttribute("cliente_existente", listaClientes);
        model.addAttribute("consulta", new Consulta());
        return "tela_cadastro_de_consulta";
    }
    @GetMapping("/produto")
    public String exibirTelaProduto(Model model) {
        model.addAttribute("produto", new Produto());
        return "tela_cadastro_de_produto";
    }
    @GetMapping("/controle")
    public String exibirTelaControle(Model model) {
        List<Produto> listaProdutos = produtoRepository.findAll();
        model.addAttribute("produtos", listaProdutos);
        return "tela_controle_de_caixa";
    }
    @PostMapping("/produto/cadastrar")
    public String cadastrarProduto(Produto produto) {
        produtoRepository.save(produto);
        return "redirect:/selecao";
    }
    @PostMapping("/pet/cadastrar")
    public String cadastrarPet(Pet pet) {
        petRepository.save(pet);
        return "redirect:/selecao";
    }
    @PostMapping("/cliente/cadastrar")
    public String cadastrarCliente(Cliente cliente) {
        clienteRepository.save(cliente);
        return "redirect:/selecao";
    }
    @PostMapping("/consulta/cadastrar")
    public String cadastrarConsulta(Consulta consulta) {
        consultaRepository.save(consulta);
        return "redirect:/selecao";
    }
}