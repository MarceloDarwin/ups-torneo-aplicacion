package ups.torneo.aplicacion.servicio;

import ups.torneo.aplicacion.modelo.Equipo;
import ups.torneo.aplicacion.modelo.EtapaTorneo;

import java.util.ArrayList;

public class AvanceServicio {

  public void avanzarEtapas(EtapaTorneo etapaTorneo) {
    PartidosServicio partidosServicio = new PartidosServicio(etapaTorneo);
    ArrayList<Equipo> ganadores = partidosServicio.generarPartidos();

    // Verificar si hay ganadores
    if (ganadores == null || ganadores.isEmpty()) {
      System.out.println("No hay ganadores para avanzar a la siguiente etapa.");
      return;
    }

    // Caso especial: Procesar la "Final" si quedan exactamente dos equipos
    if (etapaTorneo.getNombreEtapa().equals("Semifinal") && ganadores.size() == 2) {
      procesarFinal(ganadores);
      return;
    }

    // Condición base: si solo queda un equipo, es el campeón
    if (ganadores.size() == 1) {
      System.out.println("\nEl campeón del torneo es: " + ganadores.get(0).getNombreEquipo());
      return;
    }

    // Determinar la siguiente etapa
    String siguienteEtapa = obtenerSiguienteEtapa(etapaTorneo.getNombreEtapa());
    if (siguienteEtapa != null) {
      EtapaTorneo nuevaEtapa = new EtapaTorneo(siguienteEtapa);
      for (Equipo ganador : ganadores) {
        nuevaEtapa.agregarEquipo(ganador);
      }
      avanzarEtapas(nuevaEtapa); // Llamada recursiva
    }
  }

  private void procesarFinal(ArrayList<Equipo> equiposFinalistas) {
    System.out.println("\nEtapa: Final");
    Equipo equipo1 = equiposFinalistas.get(0);
    Equipo equipo2 = equiposFinalistas.get(1);

    // Generar resultado del partido final
    int marcador1 = (int) (Math.random() * 5);
    int marcador2 = (int) (Math.random() * 5);

    System.out.println(equipo1.getNombreEquipo() + " " + marcador1 + " vs " +
      equipo2.getNombreEquipo() + " " + marcador2);

    // Determinar el campeón
    Equipo campeon;
    if (marcador1 > marcador2) {
      campeon = equipo1;
    } else if (marcador2 > marcador1) {
      campeon = equipo2;
    } else {
      // Desempate en caso de empate
      campeon = (Math.random() < 0.5) ? equipo1 : equipo2;
    }

    System.out.println("\nEl campeón del torneo es: " + campeon.getNombreEquipo());
  }

  private String obtenerSiguienteEtapa(String etapaActual) {
    switch (etapaActual) {
      case "Octavos de Final":
        return "Cuartos de Final";
      case "Cuartos de Final":
        return "Semifinal";
      case "Semifinal":
        return "Final";
      case "Final":
        return null; // La final es la última etapa
      default:
        return null;
    }
  }
}

