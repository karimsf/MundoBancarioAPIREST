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

import es.eoi.mundobancario.domain.Cuenta;
import es.eoi.mundobancario.service.CuentaService;

@RestController
public class CuentasController {

	@Autowired
	CuentaService service;
	
	@GetMapping("cuentas/{id}")
	public ResponseEntity<Cuenta> findCuentaById (@PathVariable Integer id) {
		return ResponseEntity.ok(service.findCuentaById(id)) ;
	}
	
	@GetMapping("Cuenta")
	public ResponseEntity<List<Cuenta>> findAll() {
		return ResponseEntity.ok(service.findAll()) ;
	}
	
	@PostMapping("cuentas")
	public ResponseEntity<String> createCuenta(@RequestBody Cuenta cuenta) {
		service.createCuenta(cuenta);
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}
	
	@PutMapping("cuentas/{id}")
	public ResponseEntity<String> updateCuenta(@PathVariable Integer id, @RequestBody Cuenta cuenta) {
		
		if(!id.equals(cuenta.getId_cliente())) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		} else {
			cuenta.setId_cliente(id);
			service.updateCuenta(cuenta);
			return new ResponseEntity<String>(HttpStatus.ACCEPTED);
		}
	} 
	
	@DeleteMapping("cuentas/{id}")
	public ResponseEntity<String> deleteCuentaById (@PathVariable Integer id) {
		service.deleteById(id);
		return new ResponseEntity<String>(HttpStatus.ACCEPTED);
	
	}
	
}
