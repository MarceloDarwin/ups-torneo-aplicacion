package ups.torneo.aplicacion.servicio;

import ups.torneo.aplicacion.modelo.Equipo;

import java.io.*;
import java.util.ArrayList;

public class ArchivoServicio {
  private static final String ARCHIVO_PREDEFINIDO = "liga_pro_2024.bin";

  public void guardarEquipos(ArrayList<Equipo> equipos, String archivo) {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
      oos.writeObject(equipos);
      System.out.println("Equipos guardados correctamente en el archivo: " + archivo);
    } catch (IOException e) {
      System.err.println("Error al guardar los equipos: " + e.getMessage());
    }
  }

  public ArrayList<Equipo> cargarEquipos(String archivo) {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
      return (ArrayList<Equipo>) ois.readObject();
    } catch (FileNotFoundException e) {
      System.out.println("No se encontró el archivo: " + archivo);
    } catch (IOException | ClassNotFoundException e) {
      System.err.println("Error al cargar los equipos: " + e.getMessage());
    }
    return new ArrayList<>();
  }

  public void crearLigaPro() {
    ArrayList<Equipo> equipos = new ArrayList<>();
    equipos.add(new Equipo("Emelec", 1));
    equipos.add(new Equipo("Barcelona", 2));
    equipos.add(new Equipo("Liga de Quito", 3));
    equipos.add(new Equipo("Macará", 4));
    equipos.add(new Equipo("Delfín", 5));
    equipos.add(new Equipo("Aucas", 6));
    equipos.add(new Equipo("Universidad Católica", 7));
    equipos.add(new Equipo("Mushuc Runa", 8));
    equipos.add(new Equipo("Guayaquil City", 9));
    equipos.add(new Equipo("Independiente del Valle", 10));
    equipos.add(new Equipo("El Nacional", 11));
    equipos.add(new Equipo("Técnico Universitario", 12));
    equipos.add(new Equipo("Cumbayá", 13));
    equipos.add(new Equipo("Libertad", 14));
    equipos.add(new Equipo("Orense", 15));
    equipos.add(new Equipo("Imbabura", 16));

    guardarEquipos(equipos, ARCHIVO_PREDEFINIDO);
  }
}
