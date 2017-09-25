package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.ConnectionFactory;

public class ResponsavelDAO {
	
	public List<Responsavel> getResponsavel(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM RESPONSAVEL ORDER BY NOME ASC";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			List<Responsavel> responsavel = new ArrayList<Responsavel>();
			
			while(rs.next()) {
				Responsavel resp = new Responsavel();
				resp.setNome(rs.getString(1));
				responsavel.add(resp);

			}
			return responsavel;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
		
	}

	public void salvar(Responsavel responsavel) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "INSERT INTO RESPONSAVEL (NOME) VALUES (?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, responsavel.getNome());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}
	
}
