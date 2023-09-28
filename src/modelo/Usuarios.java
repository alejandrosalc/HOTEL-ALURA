package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import factory.conexionBase;

public class Usuarios {
	private String nombre;
	private String contrasenia;
	
	public Usuarios(String nombre, String contrasenia) {
		this.nombre = nombre;
		this.contrasenia = contrasenia;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public static boolean validarUsuario(String nombre, String contrasenia) {
	    // Crear una instancia de la clase "conexionBase" para gestionar la conexión a la base de datos.
	    conexionBase conexion = new conexionBase();
	    Connection connection = null; // Declarar una conexión de base de datos.
	    PreparedStatement state = null; // Declarar una sentencia SQL preparada.
	    ResultSet result = null; // Declarar un conjunto de resultados para almacenar el resultado de la consulta.
	    
	    try {
	        // Recuperar una conexión a la base de datos usando la instancia de "conexionBase".
	        connection = conexion.recuperarConexion();
	        
	        // Preparar una consulta SQL parametrizada para buscar un usuario con el nombre y contraseña proporcionados.
	        state = connection.prepareStatement("SELECT * FROM usuarios WHERE nombre = ? AND contraseña = ?");
	        state.setString(1, nombre); // Establecer el primer parámetro de la consulta con el valor de "nombre".
	        state.setString(2, contrasenia); // Establecer el segundo parámetro de la consulta con el valor de "contrasenia".
	        
	        // Ejecutar la consulta y almacenar el resultado en "result".
	        result = state.executeQuery();
	        
	        // Comprobar si la consulta devolvió al menos una fila (usuario válido).
	        return result.next();
	    } catch (SQLException e) {
	        e.printStackTrace(); // Imprimir información sobre cualquier excepción SQL.
	        return false; // Devolver "false" en caso de error.
	    } finally {
	        try {
	            // Cerrar recursos (conjunto de resultados, sentencia y conexión) en el bloque "finally" para asegurar que se cierren correctamente.
	            if (result != null)
	                result.close();
	            if (state != null)
	                state.close();
	            if (connection != null)
	                connection.close();
	        } catch (SQLException e2) {
	            e2.printStackTrace(); // Imprimir información sobre cualquier excepción SQL durante el cierre de recursos.
	        }
	    }
	}


}