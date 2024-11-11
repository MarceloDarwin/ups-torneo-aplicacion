package ups.torneo.aplicacion.controlador;
import ups.torneo.aplicacion.modelo.Equipo;
import ups.torneo.aplicacion.modelo.EtapaTorneo;
import ups.torneo.aplicacion.vista.IngresoEquipoVista;
import ups.torneo.aplicacion.vista.ResultadoVista;
import ups.torneo.aplicacion.vista.SeleccionEtapaVista;
import java.util.ArrayList;

public class TorneoControlador {
  private EtapaTorneo etapaActual;
  private IngresoEquipoVista ingresoEquipoVista;
  private ResultadoVista resultadoVista;

  public TorneoControlador() {
    this.ingresoEquipoVista = new IngresoEquipoVista();
    this.resultadoVista = new ResultadoVista();
  }

  public void seleccionarEtapa(String nombreEtapa) {
    this.etapaActual = new EtapaTorneo(nombreEtapa);
    ingresarEquipos();
  }

  private void ingresarEquipos() {
    for (int i = 1; i <= etapaActual.getCantidadEquipos(); i++) {
      Equipo equipo = ingresoEquipoVista.ingresarEquipo(i);
      etapaActual.agregarEquipo(equipo);
    }
  }

  public void mostrarEquipos() {
    resultadoVista.mostrarEquipos(etapaActual.getEquipos());
  }

}

