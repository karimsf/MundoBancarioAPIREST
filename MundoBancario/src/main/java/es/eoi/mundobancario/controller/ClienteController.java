package es.eoi.mundobancario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.eoi.mundobancario.domain.Cliente;
import es.eoi.mundobancario.service.ClienteService;

@RestController
public class ClienteController {

	@Autowired
	ClienteService service;
	
	@GetMapping("clientes/{id}")
	public ResponseEntity<Cliente> findClienteById (@PathVariable Integer id) {
		return ResponseEntity.ok(service.findClienteById(id)) ;
	}
	
	@GetMapping("clientes")
	public ResponseEntity<List<Cliente>> findAll() {
		return ResponseEntity.ok(service.findAll()) ;
	}
	
	@PostMapping("clientes")
	public ResponseEntity<String> createCliente(@RequestBody Cliente cliente) {
		service.createCliente(cliente);
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}
	
	@PutMapping("clientes/{id}")
	public ResponseEntity<String> updateCliente(@PathVariable Integer id, @RequestBody Cliente cliente) {
		
		if(!id.equals(cliente.getId())) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		} else {
			cliente.setId(id);
			service.updateCliente(cliente);
			return new ResponseEntity<String>(HttpStatus.ACCEPTED);
		}
	} 
	
	@DeleteMapping("clientes/{id}")
	public ResponseEntity<String> deleteClienteById (@PathVariable Integer id) {
		service.deleteById(id);
		return new ResponseEntity<String>(HttpStatus.ACCEPTED);
	
	}
	
}
