package es.eoi.mundobancario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.eoi.mundobancario.domain.Cuenta;
import es.eoi.mundobancario.repository.CuentaRepository;

@Service
public class CuentaService {
	
	@Autowired
	CuentaRepository repository;
	
	public Cuenta findCuentaById (Integer id) {
		return repository.findById(id);
	}
	
	public void createCuenta (Cuenta cuenta) {
		repository.create(cuenta);
	}
	
	public void updateCuenta (Cuenta cuenta) {
		repository.update(cuenta);
	}
		
	public void deleteById (Integer id) {
		repository.deleteById(id);
	}
	
	public List<Cuenta> findAll() {
		return repository.findAll();
	}

}