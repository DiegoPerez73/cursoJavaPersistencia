package clase5.serializable;

import java.io.Serializable;

public class Direccion implements Serializable {

	private static final long serialVersionUID = 1L;

	private String calle;
	private int numero;
	private String ciudad;

	public Direccion(String calle, int i, String ciudad) {
		super();
		this.calle = calle;
		this.numero = i;
		this.ciudad = ciudad;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	@Override
	public String toString() {
		return "Direccion [calle=" + calle + ", numero=" + numero + ", ciudad=" + ciudad + "]";
	}

}
