package ups.torneo.aplicacion.vista;
import ups.torneo.aplicacion.modelo.Equipo;
import java.util.ArrayList;
import java.util.ArrayList;

public class ResultadoVista {
  //Se imprime los equipos pre-cargador en el archivo binario o los insertados por el usuario
  public void mostrarEquipos(ArrayList<Equipo> equipos) {
    System.out.println("Equipos participantes en esta etapa: ");
    for (Equipo equipo : equipos) {
      System.out.println(equipo.getNombreEquipo());
    }
  }
}
