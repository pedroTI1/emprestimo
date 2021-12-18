package br.edu.iftm.upt.emprestimo.controller;

import java.time.LocalDate;
import java.time.LocalTime;
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
import br.edu.iftm.upt.emprestimo.model.Emprestimo;
import br.edu.iftm.upt.emprestimo.model.Situacao;
import br.edu.iftm.upt.emprestimo.repository.ClienteRepository;
import br.edu.iftm.upt.emprestimo.repository.EmprestimoRepository;
import br.edu.iftm.upt.emprestimo.service.ClienteService;
import br.edu.iftm.upt.emprestimo.service.EmprestimoService;

@Controller
@RequestMapping("/emprestimo")
public class EmprestimoController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmprestimoController.class);
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private EmprestimoRepository emprestimoRepository;

	@Autowired
	private EmprestimoService emprestimoService;
	
	
	@GetMapping(value = {"/cadastraremprestimo"} )
	public ModelAndView novoEmprestimo(Emprestimo emprestimo) {
		logger.trace("Entrou em novaviagem");
		ModelAndView mv = new ModelAndView("novoemprestimo");
		logger.trace("Encaminhando para a view novoemprestimo");
		List<Cliente> clientes = clienteRepository.findAll();
		mv.addObject("clientes", clientes);
		mv.addObject("emprestimo", emprestimo);
		return mv;
	}
	
	@PostMapping("/inserirnovoemprestimo")
	public String cadastrarEmprestimo(Emprestimo emprestimo, Long codigocliente, RedirectAttributes atributos) {
		logger.trace("Entrou em inserirNovaViagem");
		Cliente cliente = clienteRepository.findByCodigo(codigocliente);
		Emprestimo e = emprestimoRepository.findByCodigo(codigocliente);
		logger.debug("Recebeu o emprestimo {}", e);
		emprestimo.setCliente(cliente);
		emprestimo.setData_emprestimo(LocalDate.now());
		emprestimo.setSituacao(Situacao.ABERTO);
		emprestimo.setParcelas_pagas(0);
		emprestimoService.salvar(emprestimo);
		atributos.addFlashAttribute("mensagem", "Emprestimo feito com sucesso!");
		logger.trace("Redirecionando para a URL /mostrarmensagem");
		return "redirect:/mostrarmensagem";
		
	}
	
	@GetMapping("/emprestimosaberto")
	public ModelAndView mostrarEmprestimosAbertos() {
		logger.trace("Entrou em emprestimos abertos");
		ModelAndView mv = new ModelAndView("emprestimosabertos");
		List<Emprestimo> emprestimo = emprestimoRepository.buscarComClienteSituacao(Situacao.ABERTO);
		logger.debug("Cidadaos encontrados: {}", emprestimo);
		mv.addObject("emprestimos", emprestimo);
		return mv;
	}
	
	
	
	
	
	

}
