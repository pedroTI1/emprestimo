package br.edu.iftm.upt.emprestimo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import br.edu.iftm.upt.emprestimo.model.Cliente;
import br.edu.iftm.upt.emprestimo.repository.ClienteRepository;
import br.edu.iftm.upt.emprestimo.service.ClienteService;


@Controller
@RequestMapping("/clientes")
public class ClienteController {
	
	private static final Logger logger = LoggerFactory.getLogger(ClienteController.class);
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ClienteService clienteService;
	
	
	@GetMapping(value = {"/novocliente"} )
	public String novoCliente(Cliente cliente) {
		logger.trace("Encaminhando para a view novocliente");
		return "novocliente";
	}
	
	@PostMapping("/cadastrarcliente")
	public String cadastrarCarro(Cliente cliente, RedirectAttributes atributos) {
		logger.debug("Carro: {}", cliente);
		clienteService.salvar(cliente);
		atributos.addFlashAttribute("mensagem", "Cliente adicionado com sucesso!");
		return "redirect:/mostrarmensagem";
		
	}
	
	@GetMapping("/todosclientes")
	public ModelAndView mostrarTodosClientes() {
		ModelAndView mv = new ModelAndView("todosclientes");
		List<Cliente> cliente = clienteRepository.findAll();
		mv.addObject("clientes", cliente);
		logger.trace("Encaminhando para a view todosclientes");
		return mv;
	}
	
	@PostMapping("/alterarcliente")
	public String alterarCliente(Cliente cliente) {
		logger.debug("Carro recebido para confirmar a remocao ta aqui: {}", cliente);
		logger.trace("Encaminhando para a view alteracarro");		
		return "alteracliente";
	}
	
	@PostMapping("/alterar")
	public String alterarCliente(Cliente cliente, RedirectAttributes atributos) {
		logger.debug("Cliente recebido para alterar: {}", cliente);		
		clienteService.salvar(cliente);
		atributos.addFlashAttribute("mensagem", "Cliente alterado com sucesso!");
		logger.trace("Redirecionando para a URL /mostrarmensagem");
		return "redirect:/mostrarmensagem";
	}
	
	@PostMapping("/remover")
	public ModelAndView removerCliente(Cliente cliente, RedirectAttributes atributos) {
		logger.debug("Contato recebido para remover: {}", cliente);
		ModelAndView mv;
		clienteService.remover(cliente);
		mv = new ModelAndView("redirect:/mostrarmensagem");
		atributos.addFlashAttribute("mensagem", "Cliente removido com sucesso!");
		return mv;
	}
	
	@PostMapping("/confirmaremocao")
	public String confirmarRemocao(Cliente cliente) {
		logger.debug("Cliente recebido para confirmar a remocao: {}", cliente);		
		logger.trace("Encaminhando para a view confirmaremocao");		
		return "confirmaremocao";
	}
	

}
