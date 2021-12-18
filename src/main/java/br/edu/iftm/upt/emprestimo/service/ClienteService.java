package br.edu.iftm.upt.emprestimo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import br.edu.iftm.upt.emprestimo.model.Cliente;
import br.edu.iftm.upt.emprestimo.repository.ClienteRepository;


@Service
public class ClienteService {
	private static final Logger logger = LoggerFactory.getLogger(ClienteService.class);
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Transactional
	public void salvar(Cliente cliente) {
		logger.debug("Salvando o cliente {}", cliente);
		clienteRepository.save(cliente);
		logger.debug("Cliente salvo com sucesso");
	}
	
	@Transactional
	public void remover(Cliente cliente) {
		clienteRepository.delete(cliente);
		logger.debug("Cliente removido com sucesso {}", cliente);
	}

}
