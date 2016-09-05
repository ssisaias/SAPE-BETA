package com.quixada.sme.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.quixada.sme.factory.ConnectionFactory;
import com.quixada.sme.model.PClei;

@Component
public class PCleiDAO {

	public void adiciona(PClei professor) throws SQLException {
		Connection conexao = ConnectionFactory.getMySqlConnection();

		String INSERT_QUERY = "INSERT INTO pcLei "
				+ " (idRegional, idUsuario, nome) "
				+ "values (?, ?, ?)";

		PreparedStatement statement = conexao.prepareStatement(INSERT_QUERY);
		statement.setInt(1, professor.getIdRegional());
		statement.setInt(2, professor.getIdUsuario());
		statement.setString(3, professor.getNome());
		statement.execute();
	}

	public PClei busca(int id) throws SQLException {
		Connection conexao = ConnectionFactory.getMySqlConnection();

		String SELECT_QUERY = "SELECT * FROM pcLei WHERE idProfessor=" + id;

		PreparedStatement statement = conexao.prepareStatement(SELECT_QUERY);

		ResultSet rs = statement.executeQuery();

		PClei professor  = null;
		if(rs.next()) {
			professor = new PClei();
			professor.setIdProfessor(rs.getInt(1));
			professor.setIdRegional(rs.getInt(2));
			professor.setIdUsuario(rs.getInt(3));
			professor.setNome(rs.getString(4));
		}
		return professor;
	}	
	/*
	 * Retorna um pc lei que tenha o id de usuario informado
	 */
	public PClei buscaPorIdUsuario(int idUsuario) throws SQLException {
		Connection conexao = ConnectionFactory.getMySqlConnection();

		String SELECT_QUERY = "SELECT * FROM pcLei WHERE idUsuario=" + idUsuario;

		PreparedStatement statement = conexao.prepareStatement(SELECT_QUERY);

		ResultSet rs = statement.executeQuery();

		PClei professor  = null;
		if(rs.next()) {
			professor = new PClei();
			professor.setIdProfessor(rs.getInt(1));
			professor.setIdRegional(rs.getInt(2));
			professor.setIdUsuario(rs.getInt(3));
			professor.setNome(rs.getString(4));
		}
		return professor;
	}	

	public void editar (PClei professor) throws SQLException {
		Connection conexao = ConnectionFactory.getMySqlConnection();
		String UPDATE_QUERY = "UPDATE pcLei"
				+ "SET idRegional=?, idUsuario=?, nome=?" 
				+ "WHERE idProfessor=" + professor.getIdProfessor();

		PreparedStatement statement = conexao.prepareStatement(UPDATE_QUERY);
		statement.setInt(1, professor.getIdRegional());
		statement.setInt(2, professor.getIdUsuario());
		statement.setString(3, professor.getNome());
		statement.execute();
	}

	public void excluir (int id) throws SQLException {
		Connection conexao = ConnectionFactory.getMySqlConnection();

		String DELETE_QUERY = "DELETE FROM pcLei WHERE idProfessor=" + id;
		PreparedStatement statement = conexao.prepareStatement(DELETE_QUERY);
		statement.execute();
	}
}