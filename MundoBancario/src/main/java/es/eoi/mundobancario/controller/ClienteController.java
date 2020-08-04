package es.eoi.mundobancario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.eoi.mundobancario.domain.Cliente;
import es.eoi.mundobancario.service.ClienteService;

@RestController
public class ClienteController {

	@Autowired
	ClienteService service;
	
	@GetMapping("clientes/{id}")
	public Cliente findCliuentById (@PathVariable Integer id) {
		return service.findClienteById(id);
	}
	
	@PostMapping("clientes")
	public void createCliente(@RequestBody Cliente cliente) {
		service.createCliente(cliente);
	
	}
	
}
