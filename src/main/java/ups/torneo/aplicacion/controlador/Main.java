import ups.torneo.aplicacion.controlador.TorneoControlador;

public class Main {
  public static void main(String[] args) {
    TorneoControlador controlador = new TorneoControlador();
    //Luego de crear el objeto controlador, se ejecuta el metodo iniciartorneo().
    controlador.iniciarTorneo();
  }
}

