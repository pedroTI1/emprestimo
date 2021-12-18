package br.edu.iftm.upt.emprestimo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.iftm.upt.emprestimo.controller.RelatoriosController;
import br.edu.iftm.upt.emprestimo.service.RelatorioService;


@Controller
@RequestMapping("/relatorios")
public class RelatoriosController {
	
	private static final Logger logger = LoggerFactory.getLogger(RelatoriosController.class);
	
	@Autowired
	private RelatorioService relatorioService;
	
	@GetMapping("/todosclientes")
	public ResponseEntity<byte[]> gerarRelatorioClientes() {
		logger.trace("Entrou em gerarRelatorioClientes");
		logger.debug("Gerando relatório de clientes");
		byte[] relatorio = relatorioService.gerarRelatorioClientes();
		
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PDF_VALUE)
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=RelatorioClientes.pdf")
				.body(relatorio);
	}
	

}
