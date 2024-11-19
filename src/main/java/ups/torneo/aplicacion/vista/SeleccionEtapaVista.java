package ups.torneo.aplicacion.vista;
import java.util.InputMismatchException;
import java.util.Scanner;
public class SeleccionEtapaVista {

  public String mostrarOpciones() {
    Scanner scanner = new Scanner(System.in);
    int opcion = -1;

    while (true) { // Manejar excepciones de la insercion de datos por parte del usuario
      try {
        System.out.println("Seleccione la etapa del torneo:");
        System.out.println("1. Octavos de Final");
        System.out.println("2. Cuartos de Final");
        System.out.println("3. Semifinal");

        opcion = scanner.nextInt();

        // Validar la opción ingresada
        if (opcion >= 1 && opcion <= 3) {
          break; // Salir del bucle si la entrada es válida
        } else {
          System.out.println("Opción inválida. Por favor, ingrese un número entre 1 y 3.");
        }
      } catch (InputMismatchException e) { // El usuario solo debe insertar una opcion: 1,2,3.
        System.out.println("Error: Debes ingresar un número.");
        scanner.nextLine(); // Limpiar el buffer
      }
    }
    //Este metodo devuleve un String que lo usaremos en la clase Torneo Controlador
    switch (opcion) {
      case 1:
        return "Octavos de Final";
      case 2:
        return "Cuartos de Final";
      case 3:
        return "Semifinal";
      default:
        return null; // Nunca llegará aquí, pero se incluye por seguridad
    }
  }
}

