package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Consulta;

public class Dao {
	public static final String SCHEMA_NAME = "dam2tm06uf4p1";
	public static final String USER_CONNECTION = "root";
	public static final String PASS_CONNECTION = "";
	public static final String CONNECTION = "jdbc:mysql://localhost:3306/" + SCHEMA_NAME
			+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

	public static final String SELECT_ALL_EN_COLA = "SELECT * FROM CONSULTAS WHERE marcado = 0 ORDER BY id ASC";
	public static final String UPDATE_CONSULTA = "UPDATE CONSULTAS SET marcado = true WHERE id = ?";
	public static final String ELIMINAR_CONSULTA = "DELETE FROM consultas WHERE nombre = ?";
	public static final String INSERTAR_CONSULTA = "INSERT INTO consultas(nombre, marcado) VALUES (?, false)";

	private Connection conexion;

	public void connectar() throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection(CONNECTION, USER_CONNECTION, PASS_CONNECTION);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void desconectar() throws SQLException {
		if (conexion != null) {
			conexion.close();
		}
	}

	public ArrayList<Consulta> todasConsultas() throws SQLException {
		ArrayList<Consulta> todasConsultas = new ArrayList<>();

		try (Statement st = conexion.createStatement()) {
			try (ResultSet rs = st.executeQuery(SELECT_ALL_EN_COLA)) {
				while (rs.next()) {
					Consulta consulta = new Consulta(rs.getInt(1), rs.getString(2), rs.getBoolean(3));
					todasConsultas.add(consulta);
				}
			}
		}
		return todasConsultas;
	}
	
	public void marcarComoConsultado(int id) throws SQLException {
		try (PreparedStatement ps = conexion.prepareStatement(UPDATE_CONSULTA)) {
			ps.setInt(1, id);
			ps.execute();
		}
	}
	
	public void eliminarConsulta(String nombre) throws SQLException {
		try(PreparedStatement ps = conexion.prepareStatement(ELIMINAR_CONSULTA)) {
			ps.setString(1, nombre);
			ps.execute();
		}
	}
	
	public void insertarConsulta(String nombre) throws SQLException {
		try(PreparedStatement ps = conexion.prepareStatement(INSERTAR_CONSULTA)) {
			ps.setString(1, nombre);
			ps.execute();
		}
	}
}
