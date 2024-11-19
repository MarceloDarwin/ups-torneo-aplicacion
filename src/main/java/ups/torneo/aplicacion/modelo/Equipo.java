package ups.torneo.aplicacion.modelo;

import java.io.Serializable;

public class Equipo implements Serializable {
  private static final long serialVersionUID = 1L; // Buena practica
  private String nombreEquipo;
  private transient int idEquipo; // Campo transient: Haciendo uso de lo aprendido en la unidad
//Constructor
  public Equipo(String nombreEquipo, int idEquipo) {
    this.nombreEquipo = nombreEquipo;
    this.idEquipo = idEquipo;
  }
//Metodos getter y setter
  public String getNombreEquipo() {
    return nombreEquipo;
  }

  public int getIdEquipo() {
    return idEquipo;
  }

  // Metodo para transformar a String e imprimir en consola, la informacion de el equipo
  @Override
  public String toString() {
    return "Equipo{" +
      "nombreEquipo='" + nombreEquipo + '\'' +
      ", idEquipo=" + idEquipo +
      '}';
  }
}
//Est. Marcelo Darwin Peña Ochoa
