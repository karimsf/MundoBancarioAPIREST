package es.eoi.mundobancario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.eoi.mundobancario.domain.Cliente;
import es.eoi.mundobancario.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository repository;
	
	public Cliente findClienteById(Integer id) {
		return repository.findById(id);
	}
	
	public void createCliente (Cliente cliente) {
		repository.create(cliente);
	}
	
	public void updateCliente (Cliente cliente) {
		repository.update(cliente);
	}
		
	
}
