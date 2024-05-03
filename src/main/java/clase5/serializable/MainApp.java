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
		Persona persona1 = new Persona("Juana", "Perez", LocalDate.of(1989, 10, 3));

		String filepath = "src/main/resources/persona1.serial";
		FileOutputStream archivo = new FileOutputStream(filepath);
		ObjectOutputStream output = new ObjectOutputStream(archivo);
		output.writeObject(persona1);
		output.close();
	}

	public static void recuperarPersona() throws ClassNotFoundException, IOException {
		String filepath = "src/main/resources/persona1.serial";
		FileInputStream archivo = new FileInputStream(filepath);
		ObjectInputStream input = new ObjectInputStream(archivo);

		// Leo el objeto con el input.readObject().
		Persona p = (Persona) input.readObject();
		// Compruebo que efectivamente es la instancia de Persona que cree con
		// crearPersona.
		assertEquals("Perez", p.getApellido());
		assertEquals("Juana", p.getNombre());
		assertEquals(LocalDate.of(1989, 10, 3), p.getFechaNacimiento());
		System.out.println(p.toString());
		input.close();
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		// Si cambio la clase Persona, esto va a arrojar error class incompatible
		// (invalidClassException).
		// Porque se creo con un serialVersionUID de X numero, y al modificarlo, se
		// cambia ese serial.

		try {
			crearPersona();
			recuperarPersona();
		} catch (IOException e) {
			System.out.println(e);
		}
	}

}
