package controladores;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import DAO.ReservaDAO;
import factory.conexionBase;
import modelo.Reserva;

public class ReservaControlador {
	private ReservaDAO reservas;
	
	public ReservaControlador() {
		Connection con = new conexionBase().recuperarConexion();
		this.reservas = new ReservaDAO(con);	
	}
	
	public void guardar (Reserva res) {
		this.reservas.guardar(res);
	}
	
	public List<Reserva> buscar(){
		return this.reservas.buscar();
	}
	public List<Reserva> buscarId(String id){
		return this.reservas.buscarId(id);
	}
		
	public void actualizar(Date fechaE, Date fechaS, String valor, String formaPago, Integer id) {
		this.reservas.Actualizar(fechaE, fechaS, valor,formaPago, id);
	}
	
	public void Eliminar(Integer id) {
		this.reservas.Eliminar(id);
	}
}