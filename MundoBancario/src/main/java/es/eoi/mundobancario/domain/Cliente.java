package es.eoi.mundobancario.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Cliente {
	
	private Integer id;
	private String usuario;
	private String pass;
	private String nombre;
	private String email;

}
