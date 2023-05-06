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
		return consultas;
		
	}
	
	public void actualizarConsulta(int id) throws ClassNotFoundException, SQLException {
		dao.connectar();
		dao.marcarComoConsultado(id);
		System.out.println("Consulta actualizada");
	}
}
