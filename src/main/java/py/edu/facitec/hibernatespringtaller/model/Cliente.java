package py.edu.facitec.hibernatespringtaller.model;



import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

// Indicamos que nuestra clase será gerenciada para ser persistida en la base de datos y creara una tabla
@Entity
public class Cliente {
	//Indicamos que tendrá la propiedad de clave primaria
	@Id
	// Indicamos la generación automática del código correspondiente a la clave primaria.
	@GeneratedValue
	private Integer id;
	private String nombre;
	private String correo;
	
	@OneToMany(mappedBy="cliente")
	private List<Pedido> pedidos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", correo=" + correo + ", pedidos=" + pedidos + "]";
	}
	
	
}
