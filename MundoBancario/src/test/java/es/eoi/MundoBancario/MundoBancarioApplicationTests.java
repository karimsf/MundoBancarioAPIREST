package es.eoi.MundoBancario;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import es.eoi.mundobancario.domain.Cliente;
import es.eoi.mundobancario.repository.ClienteRepository;

class MundoBancarioApplicationTests {

	@Test
	void testFindClientebyId() {
		
		ClienteRepository repo=new ClienteRepository();
		Cliente cliente=repo.findById(1);
		assertThat(cliente.getNombre().contentEquals("JJ"));
	}

}
