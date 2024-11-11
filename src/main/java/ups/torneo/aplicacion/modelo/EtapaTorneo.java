package ups.torneo.aplicacion.modelo;

import java.util.ArrayList;

public class EtapaTorneo {
  private String nombreEtapa;
  private int cantidadEquipos;
  private ArrayList<Equipo> equipos;

  public EtapaTorneo(String nombreEtapa) {
    this.nombreEtapa = nombreEtapa;
    this.equipos = new ArrayList<>();

    switch (nombreEtapa) {
      case "Octavos de Final":
        this.cantidadEquipos = 16;
        break;
      case "Cuartos de Final":
        this.cantidadEquipos = 8;
        break;
      case "Semifinal":
        this.cantidadEquipos = 4;
        break;
      default:
        this.cantidadEquipos = 0;
    }
  }

  public String getNombreEtapa() {
    return nombreEtapa;
  }

  public int getCantidadEquipos() {
    return cantidadEquipos;
  }

  public void agregarEquipo(Equipo equipo) {
    if (equipos.size() < cantidadEquipos) {
      equipos.add(equipo);
    }
  }

  public ArrayList<Equipo> getEquipos() {
    return equipos;
  }
}