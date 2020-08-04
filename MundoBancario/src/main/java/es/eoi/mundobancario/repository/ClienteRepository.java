package es.eoi.mundobancario.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import es.eoi.mundobancario.domain.Cliente;

@Repository
public class ClienteRepository implements MyRepository<Cliente> {
	
	@Override
	public Cliente findById(Integer id) {
		
		Cliente entity=null;
		
		try {
			
			String url = "jdbc:mysql://localhost:3306/mundobancario?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String user = "root";
			String pass = "1234" ;
			Connection con = DriverManager.getConnection(url, user, pass);
			
			PreparedStatement st=con.prepareStatement(
					"SELECT id,usuario,pass,nombre,email FROM mundobancario.clientes WHERE id=?");
			st.setInt(1, id);
			
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				entity=new Cliente();
				entity.setId(rs.getInt("id"));
				entity.setUsuario(rs.getString("usuario"));
				entity.setPass(rs.getString("pass"));
				entity.setNombre(rs.getString("nombre"));
				entity.setEmail(rs.getString("email"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return entity;

	}

	@Override
	public void create(Cliente e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Cliente e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
