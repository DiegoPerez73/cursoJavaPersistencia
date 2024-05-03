package clase5.serializable;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class MainApp {

	public static void crearPersona() throws IOException {
		Direccion direccion = new Direccion("Av la Plata", 123, "Santos Lugares");
		Persona persona1 = new Persona("Juana", "Perez", LocalDate.of(1989, 10, 3));
		persona1.setDireccion(direccion);
		String filepath = "src/main/resources/persona1.serial";
		FileOutputStream archivo = new FileOutputStream(filepath);
		ObjectOutputStream output = new ObjectOutputStream(archivo);
		output.writeObject(persona1);
		output.close();
		archivo.close();
	}

	public static void recuperarPersona() throws ClassNotFoundException, IOException {
		String filepath = "src/main/resources/persona1.serial";
		FileInputStream archivo = new FileInputStream(filepath);
		ObjectInputStream input = new ObjectInputStream(archivo);

		// Leo el objeto con el input.readObject().
		Persona p = (Persona) input.readObject();

		// Compruebo que efectivamente es la instancia de Persona que cree con
		// crearPersona.
		// Esto debería hacerlo en el test, no aca.
		assertEquals("Perez", p.getApellido());
		assertEquals("Juana", p.getNombre());
		assertEquals(LocalDate.of(1989, 10, 3), p.getFechaNacimiento());

		p.presentacion();
		input.close();
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		// Si cambio la clase Persona, esto va a arrojar error class incompatible
		// (invalidClassException).
		// Porque se creo con un serialVersionUID de X numero, y al modificarlo, se
		// cambia ese serial.

		try {
			// crearPersona();
			recuperarPersona();
		} catch (IOException e) {
			System.out.println(e);
		}
	}

}
