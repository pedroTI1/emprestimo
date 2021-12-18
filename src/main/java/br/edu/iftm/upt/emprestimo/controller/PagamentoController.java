package br.edu.iftm.upt.emprestimo.controller;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.iftm.upt.emprestimo.model.Cliente;
import br.edu.iftm.upt.emprestimo.model.Emprestimo;
import br.edu.iftm.upt.emprestimo.model.Pagamento;
import br.edu.iftm.upt.emprestimo.model.Situacao;
import br.edu.iftm.upt.emprestimo.repository.ClienteRepository;
import br.edu.iftm.upt.emprestimo.repository.EmprestimoRepository;
import br.edu.iftm.upt.emprestimo.repository.PagamentoRepository;
import br.edu.iftm.upt.emprestimo.service.ClienteService;
import br.edu.iftm.upt.emprestimo.service.EmprestimoService;
import br.edu.iftm.upt.emprestimo.service.PagamentoService;

@Controller
@RequestMapping("/pagamento")
public class PagamentoController {
	
	private static final Logger logger = LoggerFactory.getLogger(PagamentoController.class);
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private EmprestimoRepository emprestimoRepository;

	@Autowired
	private EmprestimoService emprestimoService;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;

	@Autowired
	private PagamentoService pagamentoService;
	
	@PostMapping("/pagarparcelas")
	public ModelAndView pagarParcelas(Long codigo, Long codigo_cliente) {
		Cliente cliente = clienteRepository.findByCodigo(codigo_cliente);
		Emprestimo emprestimo = emprestimoRepository.findByCodigo(codigo);
		ModelAndView mv = new ModelAndView("efetuarpagamento");
		mv.addObject("emprestimo", emprestimo);
		mv.addObject("cliente", cliente);
		logger.trace("Encaminhando para a view efetuar pagamento");		
		return mv;
	}
	
	@PostMapping("/efetuarpagamento")
	public String efetuarPagamento(Long codigo_emprestimo, Long codigo_cliente, Integer parcelas_pagas, RedirectAttributes atributos) {
		Pagamento pagamento = new Pagamento();
		Cliente cliente = clienteRepository.findByCodigo(codigo_cliente);
		Emprestimo e = emprestimoRepository.findByCodigo(codigo_emprestimo);
		e.setParcelas_pagas(e.getParcelas_pagas() + parcelas_pagas);
		if(e.getParcelas_pagas() >= e.getParcelas()) {
			e.setSituacao(Situacao.FECHADO);
		}
		pagamento.setData_pagamento(LocalDate.now());
		pagamento.setQtd_pagas(parcelas_pagas);
		pagamento.setEmprestimo(e);
		pagamentoService.salvar(pagamento);
		emprestimoService.salvar(e);
		atributos.addFlashAttribute("mensagem", "Parcelas pagas com sucesso!");
		logger.trace("Redirecionando para a URL /mostrarmensagem");
		return "redirect:/mostrarmensagem";
		
	}
	
	

	

}
