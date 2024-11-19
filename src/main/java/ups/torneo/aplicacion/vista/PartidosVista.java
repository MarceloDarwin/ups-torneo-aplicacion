package ups.torneo.aplicacion.vista;

import ups.torneo.aplicacion.modelo.Equipo;

import java.util.ArrayList;

public class PartidosVista {

  // Método para mostrar los resultados de los partidos
  public void mostrarPartidos(String etapa, ArrayList<Equipo> equipos, ArrayList<Equipo> ganadores) {
    //Logica: Si el ArrayList equipos o ganadores esta vacio imprimir:
    if (equipos.isEmpty() || ganadores.isEmpty()) {
      System.out.println("No hay información de partidos para mostrar.");
      return;
    }
//Logica: Sino esta vacio imprimir la etapa actual y los partidos con su respectivo ganador
    System.out.println("\nResultados de la etapa: " + etapa);
    for (int i = 0; i < equipos.size(); i += 2) {
      Equipo equipo1 = equipos.get(i);
      Equipo equipo2 = equipos.get(i + 1);
      System.out.println(equipo1.getNombreEquipo() + " vs " + equipo2.getNombreEquipo() +
        " -> Ganador: " + ganadores.get(i / 2).getNombreEquipo());
    }
  }

  // Método para mostrar al campeón
  // Una vez obtenido el campeon, se ejecutara este metodo
  public void mostrarCampeon(Equipo campeon) {
    if (campeon == null) {
      System.out.println("\nNo hay campeón para mostrar.");
      return;
    }
    System.out.println("\nEl campeón del torneo es: " + campeon.getNombreEquipo());
  }
}

