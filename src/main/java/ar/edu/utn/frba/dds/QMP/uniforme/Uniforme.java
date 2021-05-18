package ar.edu.utn.frba.dds.QMP.uniforme;

import ar.edu.utn.frba.dds.QMP.Prenda;

import java.util.Objects;

public class Uniforme {
  private Prenda prendaSuperior;
  private Prenda prendaInferior;
  private Prenda calzado;

  public Uniforme(Prenda prendaSuperior, Prenda prendaInferior, Prenda calzado) {
    this.prendaSuperior = Objects.requireNonNull(prendaSuperior, "Un uniforme debe tener prenda superior");
    this.prendaInferior = Objects.requireNonNull(prendaInferior, "Un uniforme debe tener prenda inferior");
    this.calzado = Objects.requireNonNull(calzado, "Un uniforme debe tener un calzado");
  }
  public Prenda getPrendaSuperior() {
    return prendaSuperior;
  }
  public Prenda getPrendaInferior() {
    return prendaInferior;
  }
  public Prenda getCalzado() {
    return calzado;
  }
}
