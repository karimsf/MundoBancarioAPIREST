package es.eoi.mundobancario.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Cuenta {

	private Integer num_cuenta;
	private String alias;
	private Double saldo;
	private Integer id_cliente;
	
}
