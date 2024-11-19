package ups.torneo.aplicacion.servicio;

import ups.torneo.aplicacion.modelo.Equipo;
import ups.torneo.aplicacion.modelo.EtapaTorneo;

import java.util.ArrayList;
import java.util.Collections;

public class PartidosServicio {
  private EtapaTorneo etapaTorneo;

  public PartidosServicio(EtapaTorneo etapaTorneo) {
    this.etapaTorneo = etapaTorneo;
  }

  public ArrayList<Equipo> generarPartidos() {
    ArrayList<Equipo> equipos = etapaTorneo.getEquipos();

    // Validar que haya suficientes equipos y que la cantidad sea par
    if (equipos.size() < 2) {
      throw new IllegalStateException("No hay suficientes equipos para generar partidos.");
    }
    if (equipos.size() % 2 != 0) {
      System.out.println("Advertencia: El número de equipos no es par. Ajuste necesario.");
      equipos.remove(equipos.size() - 1); // Eliminar el último equipo para evitar errores
    }

    ArrayList<Equipo> ganadores = new ArrayList<>();
    Collections.shuffle(equipos); // Mezclar equipos aleatoriamente

    // Imprimir la etapa
    System.out.println("\nEtapa: " + etapaTorneo.getNombreEtapa());

    // Generar partidos
    for (int i = 0; i < equipos.size(); i += 2) {
      Equipo equipo1 = equipos.get(i);
      Equipo equipo2 = equipos.get(i + 1);

      // Generar resultados aleatorios (marcadores)
      int marcador1 = (int) (Math.random() * 5);
      int marcador2 = (int) (Math.random() * 5);

      // Determinar el ganador
      Equipo ganador = marcador1 >= marcador2 ? equipo1 : equipo2;
      ganadores.add(ganador);

      // Imprimir resultados del partido
      System.out.println(equipo1.getNombreEquipo() + " " + marcador1 + " vs " +
        equipo2.getNombreEquipo() + " " + marcador2 + " -> Ganador: " + ganador.getNombreEquipo());
    }

    return ganadores;
  }
}
