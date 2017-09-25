package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.ConnectionFactory;

public class ComputadorDAO {
	
	public void salvar(Computador computador) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "INSERT INTO COMPUTADOR (CODIGO_COMP, NOME, PLACA_MAE, PROCESSADOR, MEMORIA, HD, VIDEO, OUTROS) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, computador.getCodigo_comp());
			ps.setString(2, computador.getNome());
			ps.setString(3, computador.getPlaca_mae());
			ps.setString(4, computador.getProcessador());
			ps.setString(5, computador.getMemoria());
			ps.setString(6, computador.getHd());
			ps.setString(7, computador.getVideo());
			ps.setString(8, computador.getOutros());
			

			ps.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}

	public void alterar(Computador computador){
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "UPDATE COMPUTADOR SET NOME=?, PLACA_MAE=?, PROCESSADOR=?, MEMORIA=?, HD=?, VIDEO=?, OUTROS=? WHERE CODIGO_COMP=?";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, computador.getNome());
			ps.setString(2, computador.getPlaca_mae());
			ps.setString(3, computador.getProcessador());
			ps.setString(4, computador.getMemoria());
			ps.setString(5, computador.getHd());
			ps.setString(6, computador.getVideo());
			ps.setString(7, computador.getOutros());
			ps.setInt(8, computador.getCodigo_comp());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}
	
	public void deletar(int codigo){
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "DELETE FROM COMPUTADOR WHERE CODIGO_COMP=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, codigo);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}	
	
	public List<Computador> getComputadores(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM COMPUTADOR";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			List<Computador> computador = new ArrayList<Computador>();
			
			while(rs.next()) {
				Computador comp = new Computador();
				comp.setCodigo_comp(rs.getInt(1));
				comp.setNome(rs.getString(2));
				comp.setPlaca_mae(rs.getString(3));
				comp.setProcessador(rs.getString(4));
				comp.setMemoria(rs.getString(5));
				comp.setHd(rs.getString(6));
				comp.setVideo(rs.getString(7));
				comp.setOutros(rs.getString(8));
				
				computador.add(comp);

			}
			return computador;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
		
	}
	
	public List<Computador> getComputador(int codigo){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM COMPUTADOR WHERE CODIGO_COMP =" + codigo;;
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			List<Computador> computador = new ArrayList<Computador>();
			
			while(rs.next()) {
				Computador comp = new Computador();
				comp.setCodigo_comp(rs.getInt(1));
				comp.setNome(rs.getString(2));
				comp.setPlaca_mae(rs.getString(3));
				comp.setProcessador(rs.getString(4));
				comp.setMemoria(rs.getString(5));
				comp.setHd(rs.getString(6));
				comp.setVideo(rs.getString(7));
				comp.setOutros(rs.getString(8));
				
				computador.add(comp);

			}
			return computador;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
		
	}
}
