package clase5.serializable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

public class Persona implements Serializable {

	// Al agregarle esta propiedad, le asigno yo un serial. Entonces si modifico
	// esta clase, ya no voy a recibir errores
	// al leer el objeto con readObject().

	private static final long serialVersionUID = 1L;
	// Si yo cambio un Tipo de dato de un atributo, esto va a arrojar error
	// igualmente. Por mas que le asigne el serial.
	// No resuelve TODAS las cosas, si algunas.

	private String nombre;
	private String apellido;
	private LocalDate fechaNacimiento;

	/*
	 * Si asigno un atributo de tipo transient, no se va a serializar, el
	 * serializable sabe que es un atributo que yo no quiero que me guarde.
	 */
	private transient int edad;

	private EstadoCivil estadoCivil;

	private Direccion direccion;

	public Persona(String nombre, String apellido, LocalDate fechaNacimiento) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.edad = calcularEdad();
	}

	private int calcularEdad() {
		return edad = Period.between(fechaNacimiento, LocalDate.now()).getYears();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", fechaNacimiento=" + fechaNacimiento
				+ ", edad=" + edad + "," + direccion + "]";
	}

	public void presentacion() {
		System.out.println(toString());
	}

	// Con este metodo, hago que el transient por ej, ahora lo empiece a leer. Se lo
	// especifico a la clase.
	private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
		s.defaultReadObject();
		calcularEdad();
	}
}
