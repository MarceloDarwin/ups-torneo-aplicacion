package ups.torneo.aplicacion.vista;

import ups.torneo.aplicacion.modelo.Equipo;

//Importe el Scanner
import java.util.Scanner;

public class IngresoEquipoVista {
  private Scanner scanner;

  public IngresoEquipoVista() {
    //Aplique el constructor al scanner como buena practica
    this.scanner = new Scanner(System.in);
  }
  //Metodo ingresar equipo, usando manejo de excepciones.
  public Equipo ingresarEquipo(int idEquipo) {
    try {
      System.out.println("Ingrese el nombre del equipo " + idEquipo + ": ");
      String nombreEquipo = scanner.nextLine();

      if (nombreEquipo.trim().isEmpty()) {
        //No se inserto equipo
        throw new IllegalArgumentException("El nombre del equipo no puede estar vacío.");
      }
//Si se inserta correctamente, crear un objeto equipo con los atributos brindados por el usuario
      return new Equipo(nombreEquipo, idEquipo);
    } catch (IllegalArgumentException e) {
      System.out.println("Error: " + e.getMessage());
      //Uso de el concepto aprendido en la presente unidad, recursividad para que el usuario a ejecutar este metodo
      return ingresarEquipo(idEquipo); // Reintentar
    }
  }
}
