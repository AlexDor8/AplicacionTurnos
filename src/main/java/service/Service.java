package service;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.Dao;
import model.Consulta;

public class Service {
	
	Dao dao;
	
	public Service() {
		dao = new Dao();
	}
	
	
	public ArrayList<Consulta> todasConasultas() throws ClassNotFoundException, SQLException {
		dao.connectar();
		ArrayList<Consulta> consultas = dao.todasConsultas();
		dao.desconectar();
		return consultas;
		
	}
	
	public void actualizarConsulta(int id) throws ClassNotFoundException, SQLException {
		dao.connectar();
		dao.marcarComoConsultado(id);
		System.out.println("Consulta actualizada");
		dao.desconectar();
	}
	
	public void eliminarConsulta(String nombre) throws ClassNotFoundException, SQLException {
		dao.connectar();
		dao.eliminarConsulta(nombre);
		System.out.println("Consulta eliminada");
		dao.desconectar();
	}
	
	public void insertarConsulta(String nombre) throws ClassNotFoundException, SQLException {
		dao.connectar();
		dao.insertarConsulta(nombre);
		System.out.println("Consulta insertada");
		dao.desconectar();
	}
}
