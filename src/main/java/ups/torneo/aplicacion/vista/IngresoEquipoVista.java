package ups.torneo.aplicacion.vista;
import ups.torneo.aplicacion.modelo.Equipo;

import java.util.Scanner;

public class IngresoEquipoVista {
  private Scanner scanner;

  public IngresoEquipoVista() {
    this.scanner = new Scanner(System.in);
  }

  public Equipo ingresarEquipo(int idEquipo) {
    System.out.println("Ingrese el nombre del equipo " + idEquipo + ": ");
    String nombreEquipo = scanner.nextLine();
    return new Equipo(nombreEquipo, idEquipo);
  }
}

