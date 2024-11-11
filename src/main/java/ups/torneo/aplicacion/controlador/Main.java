import ups.torneo.aplicacion.controlador.TorneoControlador;
import ups.torneo.aplicacion.vista.SeleccionEtapaVista;

public class Main {
  public static void main(String[] args) {
    SeleccionEtapaVista seleccionEtapaVista = new SeleccionEtapaVista();
    TorneoControlador torneoControlador = new TorneoControlador();

    String etapaSeleccionada = seleccionEtapaVista.mostrarOpciones();

    if (etapaSeleccionada != null) {
      torneoControlador.seleccionarEtapa(etapaSeleccionada);
      torneoControlador.mostrarEquipos();
    }
  }
}
