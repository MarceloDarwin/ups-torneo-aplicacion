package ups.torneo.aplicacion.vista;

import java.util.Scanner;
import java.util.Scanner;

public class SeleccionEtapaVista {
  public String mostrarOpciones() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Seleccione la etapa del torneo:");
    System.out.println("1. Octavos de Final");
    System.out.println("2. Cuartos de Final");
    System.out.println("3. Semifinal");

    int opcion = scanner.nextInt();

    switch (opcion) {
      case 1:
        return "Octavos de Final";
      case 2:
        return "Cuartos de Final";
      case 3:
        return "Semifinal";
      default:
        System.out.println("Opción inválida.");
        return null;
    }
  }
}
