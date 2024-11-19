package ups.torneo.aplicacion.controlador;

import ups.torneo.aplicacion.modelo.Equipo;
import ups.torneo.aplicacion.modelo.EtapaTorneo;
import ups.torneo.aplicacion.servicio.ArchivoServicio;
import ups.torneo.aplicacion.servicio.AvanceServicio;
import ups.torneo.aplicacion.vista.SeleccionEtapaVista;

import java.util.ArrayList;
import java.util.Scanner;

public class TorneoControlador {
  private EtapaTorneo etapaActual;
  private SeleccionEtapaVista seleccionEtapaVista;
  private AvanceServicio avanceServicio;
  private ArchivoServicio archivoServicio;
  private static final String ARCHIVO_PREDEFINIDO = "liga_pro.bin";

  public TorneoControlador() {
    this.seleccionEtapaVista = new SeleccionEtapaVista();
    this.avanceServicio = new AvanceServicio();
    this.archivoServicio = new ArchivoServicio();
  }

  public void iniciarTorneo() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("¿Qué desea hacer?");
    System.out.println("1. Usar torneo pre-cargado (Liga Pro)");
    System.out.println("2. Crear un nuevo torneo personalizado");

    int opcion = scanner.nextInt();
    scanner.nextLine(); // Limpiar buffer

    switch (opcion) {
      case 1:
        cargarLigaPro();
        break;
      case 2:
        crearNuevoTorneo();
        break;
      default:
        System.out.println("Opción inválida. Terminando programa.");
    }
  }

  private void cargarLigaPro() {
    ArrayList<Equipo> equipos = archivoServicio.cargarEquipos(ARCHIVO_PREDEFINIDO);
    if (equipos.isEmpty()) {
      System.out.println("No se encontró un torneo predefinido. Creándolo...");
      archivoServicio.crearLigaPro();
      equipos = archivoServicio.cargarEquipos(ARCHIVO_PREDEFINIDO);
    }

    if (equipos.size() < 16) {
      System.out.println("Error: La Liga Pro no tiene suficientes equipos.");
      return;
    }

    etapaActual = new EtapaTorneo("Octavos de Final");
    for (Equipo equipo : equipos) {
      etapaActual.agregarEquipo(equipo);
    }

    avanzarEtapas();
  }

  private void crearNuevoTorneo() {
    String etapaSeleccionada = seleccionEtapaVista.mostrarOpciones();
    if (etapaSeleccionada != null) {
      etapaActual = new EtapaTorneo(etapaSeleccionada);
      Scanner scanner = new Scanner(System.in);
      ArrayList<Equipo> equipos = new ArrayList<>();
      for (int i = 1; i <= etapaActual.getCantidadEquipos(); i++) {
        System.out.print("Ingrese el nombre del equipo " + i + ": ");
        String nombreEquipo = scanner.nextLine();
        equipos.add(new Equipo(nombreEquipo, i));
        etapaActual.agregarEquipo(new Equipo(nombreEquipo, i));
      }
      archivoServicio.guardarEquipos(equipos, "equipos_personalizados.bin");
      avanzarEtapas();
    } else {
      System.out.println("Selección de etapa inválida.");
    }
  }

  private void avanzarEtapas() {
    avanceServicio.avanzarEtapas(etapaActual);
  }
}

