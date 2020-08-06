package es.eoi.mundobancario.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import es.eoi.mundobancario.domain.Cuenta;

@Repository
public class CuentaRepository implements MyRepository<Cuenta>  {

	public Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/mundobancario?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String user = "root";
		String pass = "1234" ;
		return DriverManager.getConnection(url, user, pass);
	}

	@Override
	public Cuenta findById(Integer id) {
		
		Cuenta entity=null;
		
		try {
			Connection con=getConnection();
			PreparedStatement st=con.prepareStatement(
					"SELECT ID, USUARIO, PASS, NOMBRE, EMAIL, NUM_CUENTA, ALIAS, SALDO, ID_CLIENTE  FROM mundobancario.clientes INNER JOIN mundobancario.cuentas ON clientes.id = cuentas.id_cliente WHERE ID_CLIENTE = ?");
			st.setInt(1, id);
			
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				entity=new Cuenta();
				entity.setNum_cuenta(rs.getInt("num_cuenta"));
				entity.setAlias(rs.getString("alias"));
				entity.setSaldo(rs.getDouble("saldo"));
				entity.setId_cliente(rs.getInt("id_cliente"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return entity;

	}
	

	@Override
	public void create(Cuenta e) {
		
		try {
			Connection con=getConnection();
			PreparedStatement st=con.prepareStatement(
					"INSERT INTO mundobancario.cuentas (NUM_CUENTA, ALIAS, SALDO, ID_CLIENTE) VALUES (?, ?, ?, ?)");
			st.setInt(1, e.getNum_cuenta());
			st.setString(2, e.getAlias());
			st.setDouble(3, e.getSaldo());
			st.setInt(4, e.getId_cliente());
			
			st.executeUpdate();

			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}

	@Override
	public void update(Cuenta e) {
		try {
			Connection con=getConnection();
			PreparedStatement st=con.prepareStatement(
					"UPDATE mundobancario.cuentas SET NUM_CUENTA = ?, ALIAS = ?, SALDO = ? WHERE ID_CLIENTE = ?");
			st.setInt(1, e.getNum_cuenta());
			st.setString(2, e.getAlias());
			st.setDouble(3, e.getSaldo());
			st.setInt(4, e.getId_cliente());
			
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
					"DELETE FROM mundobancario.cuentas WHERE ID_CLIENTE=?");
			st.setInt(1, id);
			st.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public List<Cuenta> findAll() {	
		
		List<Cuenta> lista = new ArrayList<Cuenta>();
				
				try {
					Connection con=getConnection();
					PreparedStatement st=con.prepareStatement(
							"SELECT num_cuenta,alias,saldo,id_cliente FROM mundobancario.cuentas");
			
					ResultSet rs=st.executeQuery();
					while(rs.next()) {
						Cuenta entity = new Cuenta();
						entity=new Cuenta();
						entity.setNum_cuenta(rs.getInt("num_cuenta"));
						entity.setAlias(rs.getString("alias"));
						entity.setSaldo(rs.getDouble("saldo"));
						entity.setId_cliente(rs.getInt("id_cliente"));;
						lista.add(entity);	
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return lista;
				
			}
	
}