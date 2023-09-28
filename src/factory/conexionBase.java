package factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class conexionBase {
public DataSource datasource;


public conexionBase() {
	ComboPooledDataSource comboPool = new ComboPooledDataSource();
	comboPool.setJdbcUrl("jdbc:mysql://localhost/hotel_alura?useTimeZone=true&serverTimeZone=UTC");
	comboPool.setUser("root");
	comboPool.setPassword("Clave.12345");
	
	this.datasource = comboPool;
}
public Connection recuperarConexion() {
	try {
		return this.datasource.getConnection();
	} catch (SQLException e) {
		throw new RuntimeException(e);
	}
}
}