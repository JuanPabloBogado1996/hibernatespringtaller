package py.edu.facitec.hibernatespringtaller.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Pedido {
	
	@Id
	@GeneratedValue
	private Integer id;
	private Date fechaToma;
	private Date fechaEntrega;
	private Double total;
	//indica que es de uno a muchos y facilita la creacion de la clave foranea
	@ManyToOne
	private Cliente cliente;
	@ManyToOne
	private Usuario usuario;
	@OneToMany(mappedBy="pedido")
	private List<ItemPedido> itemPedidos;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getFechaToma() {
		return fechaToma;
	}
	public void setFechaToma(Date fechaToma) {
		this.fechaToma = fechaToma;
	}
	public Date getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<ItemPedido> getItemPedidos() {
		return itemPedidos;
	}
	public void setItemPedidos(List<ItemPedido> itemPedidos) {
		this.itemPedidos = itemPedidos;
	}
	@Override
	public String toString() {
		return "Pedido [id=" + id + ", fechaToma=" + fechaToma + ", fechaEntrega=" + fechaEntrega + ", total=" + total
				+ ", cliente=" + cliente + ", usuario=" + usuario + ", itemPedidos=" + itemPedidos + "]";
	}
	
	

}
