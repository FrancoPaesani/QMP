package ar.edu.utn.frba.dds.QMP.alertas;

public enum AlertaMeteorologica {
  TORMENTA("Lleva paraguas."), GRANIZO("Van a caer piedras!! Trata de guardar el coche.");

  private String mensaje;
  private AlertaMeteorologica(String mensaje) {
    this.mensaje = mensaje;
  }
  public String getMensaje() {
    return this.mensaje;
  }
}
