package es.eoi.mundobancario.repository;

import java.util.List;

import es.eoi.mundobancario.domain.Cliente;

public interface MyRepository<E>{
	
	public E findById(Integer id);
	
	public void create(E e);
	
	public void update(E e);

	public void deleteById(Integer id);
	
	public List<E> findAll();
}
