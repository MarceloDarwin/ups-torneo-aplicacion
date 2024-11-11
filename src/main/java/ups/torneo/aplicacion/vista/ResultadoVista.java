package ups.torneo.aplicacion.vista;
import ups.torneo.aplicacion.modelo.Equipo;
import java.util.ArrayList;
import java.util.ArrayList;

public class ResultadoVista {
  public void mostrarEquipos(ArrayList<Equipo> equipos) {
    System.out.println("Equipos participantes en esta etapa: ");
    for (Equipo equipo : equipos) {
      System.out.println(equipo.getNombreEquipo());
    }
  }
}
