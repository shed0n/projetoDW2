package model;

import java.sql.*;

import database.ConnectionFactory;

public class UsuarioDAO {
	
	public boolean verificaUsuario(Usuario usuario) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM USUARIO WHERE NOME=? AND SENHA=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getSenha());
			rs = ps.executeQuery();

			if(rs.next()) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.
				closeConnection(conn, ps, rs);
		}
		
	}
	
	public void salvar(Usuario usuario) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "INSERT INTO USUARIO" + "(NOME, SENHA) " + "VALUES (?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getSenha());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}
	
	public void alterar(Usuario usuario) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "UPDATE USUARIO SET SENHA=? WHERE NOME=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, usuario.getSenha());
			ps.setString(2, usuario.getNome());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}
	
}
