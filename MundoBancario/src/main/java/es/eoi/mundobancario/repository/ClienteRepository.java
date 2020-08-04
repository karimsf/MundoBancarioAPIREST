package es.eoi.mundobancario.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import es.eoi.mundobancario.domain.Cliente;

@Repository
public class ClienteRepository implements MyRepository<Cliente> {
	
	public Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/mundobancario?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String user = "root";
		String pass = "1234" ;
		return DriverManager.getConnection(url, user, pass);
	}
	
	
	@Override
	public Cliente findById(Integer id) {
		
		Cliente entity=null;
		
		try {
			Connection con=getConnection();
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
		
		try {
			Connection con=getConnection();
			PreparedStatement st=con.prepareStatement(
					"INSERT INTO mundobancario.clientes (USUARIO, PASS, NOMBRE, EMAIL) VALUES (?, ?, ?, ?)");
			st.setString(1, e.getUsuario());
			st.setString(2, e.getPass());
			st.setString(3, e.getNombre());
			st.setString(4, e.getEmail());
			
			st.executeUpdate();

			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}

	@Override
	public void update(Cliente e) {
		try {
			Connection con=getConnection();
			PreparedStatement st=con.prepareStatement(
					"UPDATE mundobancario.clientes SET USUARIO = ?, PASS = ?, NOMBRE = ?, EMAIL = ? WHERE ID = ?");
			st.setString(1, e.getUsuario());
			st.setString(2, e.getPass());
			st.setString(3, e.getNombre());
			st.setString(4, e.getEmail());
			st.setInt(5, e.getId());
			
			st.executeUpdate();

			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}

	@Override
	public void deleteById(Integer id) {
		
		try {
			Connection con=getConnection();
			PreparedStatement st=con.prepareStatement(
					"DELETE FROM mundobancario.clientes WHERE ID=?");
			st.setInt(1, id);
			st.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Cliente> findAll() {
		
		List<Cliente> lista = new ArrayList<Cliente>();
		
		
		try {
			Connection con=getConnection();
			PreparedStatement st=con.prepareStatement(
					"SELECT id,usuario,pass,nombre,email FROM mundobancario.clientes");
	
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				Cliente entity = new Cliente();
				entity=new Cliente();
				entity.setId(rs.getInt("id"));
				entity.setUsuario(rs.getString("usuario"));
				entity.setPass(rs.getString("pass"));
				entity.setNombre(rs.getString("nombre"));
				entity.setEmail(rs.getString("email"));
				lista.add(entity);	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
		
	}
}
