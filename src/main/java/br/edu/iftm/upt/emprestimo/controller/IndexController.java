package br.edu.iftm.upt.emprestimo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

	@GetMapping(value = {"/", "/index.html"} )
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("index");
		logger.trace("Encaminhando para a view index");
		return mv;
	}
	
	@GetMapping("/mostrarmensagem")
	public String mostrarMensagem() {
		return "mostrarmensagem";
	}
	
	
	@GetMapping(value = {"/gerenciaremprestimo"} )
	public ModelAndView emprestimo() {
		ModelAndView mv = new ModelAndView("gerenciaremprestimos");
		logger.trace("Encaminhando para a view gerenciaremprestimo");
		return mv;
	}
	

	@GetMapping(value = {"/gerenciarcliente"} )
	public ModelAndView gerenciarViagem() {
		ModelAndView mv = new ModelAndView("gerenciarclientes");
		logger.trace("Encaminhando para a view gerenciarcliente");
		return mv;
	}
	
	
}
