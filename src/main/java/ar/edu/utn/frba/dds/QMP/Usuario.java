package ar.edu.utn.frba.dds.QMP;

public class Usuario {
  private Guardarropa guardarropa;

  public Usuario() {this.guardarropa = new Guardarropa();}
  public void setGuardarropa(Guardarropa guardarropa) { this.guardarropa = guardarropa; }
  public Guardarropa getGuardarropa() { return guardarropa; }
  public void agregarPrenda(Prenda prenda) {this.guardarropa.agregarPrenda(prenda);}
}
