package ups.torneo.aplicacion.modelo;

public class Equipo {
  private String nombreEquipo;
  private int idEquipo;

  public Equipo(String nombreEquipo, int idEquipo) {
    this.nombreEquipo = nombreEquipo;
    this.idEquipo = idEquipo;
  }

  public String getNombreEquipo() {
    return nombreEquipo;
  }

  public int getIdEquipo() {
    return idEquipo;
  }

  @Override
  public String toString() {
    return "Equipo{" +
      "nombreEquipo='" + nombreEquipo + '\'' +
      ", idEquipo=" + idEquipo +
      '}';
  }
}
