package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.ConnectionFactory;

public class SetorDAO {
	
	public List<Setor> getSetor(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM SETOR ORDER BY NOME ASC";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			List<Setor> setor = new ArrayList<Setor>();
			
			while(rs.next()) {
				Setor set = new Setor();
				set.setNome(rs.getString(1));
				setor.add(set);

			}
			return setor;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
		
	}

	public void salvar(Setor setor) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "INSERT INTO SETOR (NOME) VALUES (?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, setor.getNome());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}
}
