package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import database.ConnectionFactory;

public class PatrimonioDAO {
	
	public void salvar(Patrimonio patrimonio) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String data = sdf.format(new Date());
		
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "INSERT INTO PATRIMONIO (CODIGO, SITUACAO, RESPONSAVEL, SETOR, LOCAL, MATERIAL, MARCA, MODELO, DATA) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, patrimonio.getCodigo());
			ps.setString(2, patrimonio.getSituacao());
			ps.setString(3, patrimonio.getResponsavel());
			ps.setString(4, patrimonio.getSetor());
			ps.setString(5, patrimonio.getLocal());
			ps.setString(6, patrimonio.getMaterial());
			ps.setString(7, patrimonio.getMarca());
			ps.setString(8, patrimonio.getModelo());
			ps.setString(9, data);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}
	
	public void alterar(Patrimonio patrimonio){
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "UPDATE PATRIMONIO SET SITUACAO=?, RESPONSAVEL=?, SETOR=?, LOCAL=?, MATERIAL=?, MARCA=?, MODELO=? WHERE CODIGO=?";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, patrimonio.getSituacao());
			ps.setString(2, patrimonio.getResponsavel());
			ps.setString(3, patrimonio.getSetor());
			ps.setString(4, patrimonio.getLocal());
			ps.setString(5, patrimonio.getMaterial());
			ps.setString(6, patrimonio.getMarca());
			ps.setString(7, patrimonio.getModelo());
			ps.setInt(8, patrimonio.getCodigo());
			
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
			String sql = "DELETE FROM PATRIMONIO WHERE CODIGO=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, codigo);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}	
	
	public List<Patrimonio> getPatrimonios(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM PATRIMONIO";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			List<Patrimonio> patrimonios = new ArrayList<Patrimonio>();
			
			while(rs.next()) {
				Patrimonio patrimonio = new Patrimonio();
				patrimonio.setCodigo(rs.getInt(1));
				patrimonio.setSituacao(rs.getString(2));
				patrimonio.setResponsavel(rs.getString(3));
				patrimonio.setSetor(rs.getString(4));
				patrimonio.setLocal(rs.getString(5));
				patrimonio.setMaterial(rs.getString(6));
				patrimonio.setMarca(rs.getString(7));
				patrimonio.setModelo(rs.getString(8));
				patrimonio.setData(rs.getString(9));
				
				patrimonios.add(patrimonio);

			}
			return patrimonios;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
		
	}
	
	public List<Patrimonio> getPatrimoniosAtivos(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM PATRIMONIO WHERE SITUACAO = 'Ativo' ORDER BY CODIGO ASC";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			List<Patrimonio> patrimonios = new ArrayList<Patrimonio>();
			
			while(rs.next()) {
				Patrimonio patrimonio = new Patrimonio();
				patrimonio.setCodigo(rs.getInt(1));
				patrimonio.setSituacao(rs.getString(2));
				patrimonio.setResponsavel(rs.getString(3));
				patrimonio.setSetor(rs.getString(4));
				patrimonio.setLocal(rs.getString(5));
				patrimonio.setMaterial(rs.getString(6));
				patrimonio.setMarca(rs.getString(7));
				patrimonio.setModelo(rs.getString(8));
				patrimonio.setData(rs.getString(9));
				
				patrimonios.add(patrimonio);

			}
			return patrimonios;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
		
	}
	
	public List<Patrimonio> getRelatorio(int codigo){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Patrimonio> patrimonios = new ArrayList<Patrimonio>();
		
		if(codigo == 1){	
			try {
					conn = ConnectionFactory.getConnection();
					String sql = "SELECT * FROM PATRIMONIO WHERE MATERIAL = 'Mesa' OR MATERIAL = 'mesa' ORDER BY CODIGO ASC";
					ps = conn.prepareStatement(sql);
					rs = ps.executeQuery();
					
					while(rs.next()) {
						Patrimonio patrimonio = new Patrimonio();
						patrimonio.setCodigo(rs.getInt(1));
						patrimonio.setSituacao(rs.getString(2));
						patrimonio.setResponsavel(rs.getString(3));
						patrimonio.setSetor(rs.getString(4));
						patrimonio.setLocal(rs.getString(5));
						patrimonio.setMaterial(rs.getString(6));
						patrimonio.setMarca(rs.getString(7));
						patrimonio.setModelo(rs.getString(8));
						patrimonio.setData(rs.getString(9));
						
						patrimonios.add(patrimonio);
		
					}
				} catch (SQLException e) {
					throw new RuntimeException(e);
				} finally {
					ConnectionFactory.closeConnection(conn, ps, rs);
				}
		}
		
		if(codigo == 2){
			try {
				conn = ConnectionFactory.getConnection();
				String sql = "SELECT * FROM PATRIMONIO WHERE MATERIAL = 'Cadeira' OR MATERIAL = 'cadeira' ORDER BY CODIGO ASC";
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				
				while(rs.next()) {
					Patrimonio patrimonio = new Patrimonio();
					patrimonio.setCodigo(rs.getInt(1));
					patrimonio.setSituacao(rs.getString(2));
					patrimonio.setResponsavel(rs.getString(3));
					patrimonio.setSetor(rs.getString(4));
					patrimonio.setLocal(rs.getString(5));
					patrimonio.setMaterial(rs.getString(6));
					patrimonio.setMarca(rs.getString(7));
					patrimonio.setModelo(rs.getString(8));
					patrimonio.setData(rs.getString(9));
					
					patrimonios.add(patrimonio);
	
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			} finally {
				ConnectionFactory.closeConnection(conn, ps, rs);
			}
		}
		
		if(codigo == 3){
			try {
				conn = ConnectionFactory.getConnection();
				String sql = "SELECT * FROM PATRIMONIO WHERE MATERIAL = 'Computador' OR MATERIAL = 'computador' ORDER BY CODIGO ASC";
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				
				while(rs.next()) {
					Patrimonio patrimonio = new Patrimonio();
					patrimonio.setCodigo(rs.getInt(1));
					patrimonio.setSituacao(rs.getString(2));
					patrimonio.setResponsavel(rs.getString(3));
					patrimonio.setSetor(rs.getString(4));
					patrimonio.setLocal(rs.getString(5));
					patrimonio.setMaterial(rs.getString(6));
					patrimonio.setMarca(rs.getString(7));
					patrimonio.setModelo(rs.getString(8));
					patrimonio.setData(rs.getString(9));
					
					patrimonios.add(patrimonio);
	
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			} finally {
				ConnectionFactory.closeConnection(conn, ps, rs);
			}
		}
		
		if(codigo == 4){
			try {
				conn = ConnectionFactory.getConnection();
				String sql = "SELECT * FROM PATRIMONIO WHERE MATERIAL = 'Monitor' OR MATERIAL = 'monitor' ORDER BY CODIGO ASC";
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				
				while(rs.next()) {
					Patrimonio patrimonio = new Patrimonio();
					patrimonio.setCodigo(rs.getInt(1));
					patrimonio.setSituacao(rs.getString(2));
					patrimonio.setResponsavel(rs.getString(3));
					patrimonio.setSetor(rs.getString(4));
					patrimonio.setLocal(rs.getString(5));
					patrimonio.setMaterial(rs.getString(6));
					patrimonio.setMarca(rs.getString(7));
					patrimonio.setModelo(rs.getString(8));
					patrimonio.setData(rs.getString(9));
					
					patrimonios.add(patrimonio);
	
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			} finally {
				ConnectionFactory.closeConnection(conn, ps, rs);
			}
		}
		
		if(codigo == 5){
			try {
				conn = ConnectionFactory.getConnection();
				String sql = "SELECT * FROM PATRIMONIO WHERE SITUACAO = 'Ativo' ORDER BY CODIGO ASC";
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				
				while(rs.next()) {
					Patrimonio patrimonio = new Patrimonio();
					patrimonio.setCodigo(rs.getInt(1));
					patrimonio.setSituacao(rs.getString(2));
					patrimonio.setResponsavel(rs.getString(3));
					patrimonio.setSetor(rs.getString(4));
					patrimonio.setLocal(rs.getString(5));
					patrimonio.setMaterial(rs.getString(6));
					patrimonio.setMarca(rs.getString(7));
					patrimonio.setModelo(rs.getString(8));
					patrimonio.setData(rs.getString(9));
					
					patrimonios.add(patrimonio);
	
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			} finally {
				ConnectionFactory.closeConnection(conn, ps, rs);
			}
		}
		
		if(codigo == 6){
			try {
				conn = ConnectionFactory.getConnection();
				String sql = "SELECT * FROM PATRIMONIO WHERE SITUACAO = 'Manutenção' ORDER BY CODIGO ASC";
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				
				while(rs.next()) {
					Patrimonio patrimonio = new Patrimonio();
					patrimonio.setCodigo(rs.getInt(1));
					patrimonio.setSituacao(rs.getString(2));
					patrimonio.setResponsavel(rs.getString(3));
					patrimonio.setSetor(rs.getString(4));
					patrimonio.setLocal(rs.getString(5));
					patrimonio.setMaterial(rs.getString(6));
					patrimonio.setMarca(rs.getString(7));
					patrimonio.setModelo(rs.getString(8));
					patrimonio.setData(rs.getString(9));
					
					patrimonios.add(patrimonio);
	
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			} finally {
				ConnectionFactory.closeConnection(conn, ps, rs);
			}
		}
		
		if(codigo == 7){
			try {
				conn = ConnectionFactory.getConnection();
				String sql = "SELECT * FROM PATRIMONIO WHERE SITUACAO = 'Inativo' ORDER BY CODIGO ASC";
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				
				while(rs.next()) {
					Patrimonio patrimonio = new Patrimonio();
					patrimonio.setCodigo(rs.getInt(1));
					patrimonio.setSituacao(rs.getString(2));
					patrimonio.setResponsavel(rs.getString(3));
					patrimonio.setSetor(rs.getString(4));
					patrimonio.setLocal(rs.getString(5));
					patrimonio.setMaterial(rs.getString(6));
					patrimonio.setMarca(rs.getString(7));
					patrimonio.setModelo(rs.getString(8));
					patrimonio.setData(rs.getString(9));
					
					patrimonios.add(patrimonio);
	
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			} finally {
				ConnectionFactory.closeConnection(conn, ps, rs);
			}
		}
		
		if(codigo == 8){
			try {
				conn = ConnectionFactory.getConnection();
				String sql = "SELECT * FROM PATRIMONIO ORDER BY CODIGO ASC";
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				
				while(rs.next()) {
					Patrimonio patrimonio = new Patrimonio();
					patrimonio.setCodigo(rs.getInt(1));
					patrimonio.setSituacao(rs.getString(2));
					patrimonio.setResponsavel(rs.getString(3));
					patrimonio.setSetor(rs.getString(4));
					patrimonio.setLocal(rs.getString(5));
					patrimonio.setMaterial(rs.getString(6));
					patrimonio.setMarca(rs.getString(7));
					patrimonio.setModelo(rs.getString(8));
					patrimonio.setData(rs.getString(9));
					
					patrimonios.add(patrimonio);
	
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			} finally {
				ConnectionFactory.closeConnection(conn, ps, rs);
			}
		}
		
		return patrimonios;
	}

	public List<Patrimonio> getComputadores(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM PATRIMONIO WHERE MATERIAL = 'Computador' OR MATERIAL = 'computador' ORDER BY CODIGO ASC";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			List<Patrimonio> patrimonios = new ArrayList<Patrimonio>();
			
			while(rs.next()) {
				Patrimonio patrimonio = new Patrimonio();
				patrimonio.setCodigo(rs.getInt(1));
				patrimonio.setSituacao(rs.getString(2));
				patrimonio.setResponsavel(rs.getString(3));
				patrimonio.setSetor(rs.getString(4));
				patrimonio.setLocal(rs.getString(5));
				patrimonio.setMaterial(rs.getString(6));
				patrimonio.setMarca(rs.getString(7));
				patrimonio.setModelo(rs.getString(8));
				
				patrimonios.add(patrimonio);

			}
			return patrimonios;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
		
	}

	public List<Patrimonio>	getPatrimonio(int codigo){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM PATRIMONIO WHERE CODIGO =" + codigo;
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			List<Patrimonio> patrimonios = new ArrayList<Patrimonio>();
			
			while(rs.next()) {
				Patrimonio patrimonio = new Patrimonio();
				patrimonio.setCodigo(rs.getInt(1));
				patrimonio.setSituacao(rs.getString(2));
				patrimonio.setResponsavel(rs.getString(3));
				patrimonio.setSetor(rs.getString(4));
				patrimonio.setLocal(rs.getString(5));
				patrimonio.setMaterial(rs.getString(6));
				patrimonio.setMarca(rs.getString(7));
				patrimonio.setModelo(rs.getString(8));
				patrimonio.setData(rs.getString(9));
				
				patrimonios.add(patrimonio);

			}
			return patrimonios;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}
	
	public List<Patrimonio>	getBusca(int codigo, String situacao){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM PATRIMONIO WHERE CODIGO=? AND SITUACAO=?" ;
			ps = conn.prepareStatement(sql);
			ps.setInt(1, codigo);
			ps.setString(2, situacao);
			rs = ps.executeQuery();
			List<Patrimonio> patrimonios = new ArrayList<Patrimonio>();
			
			while(rs.next()) {
				Patrimonio patrimonio = new Patrimonio();
				patrimonio.setCodigo(rs.getInt(1));
				patrimonio.setSituacao(rs.getString(2));
				patrimonio.setResponsavel(rs.getString(3));
				patrimonio.setSetor(rs.getString(4));
				patrimonio.setLocal(rs.getString(5));
				patrimonio.setMaterial(rs.getString(6));
				patrimonio.setMarca(rs.getString(7));
				patrimonio.setModelo(rs.getString(8));
				patrimonio.setData(rs.getString(9));
				
				patrimonios.add(patrimonio);

			}
			return patrimonios;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}
}
