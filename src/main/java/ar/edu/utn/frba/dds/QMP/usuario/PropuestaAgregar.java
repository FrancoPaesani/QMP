package ar.edu.utn.frba.dds.QMP.usuario;

import ar.edu.utn.frba.dds.QMP.excepciones.NoSeDeshacePropuestaNoAceptada;
import ar.edu.utn.frba.dds.QMP.prenda.Prenda;

public class PropuestaAgregar implements Propuesta{
  private Prenda prendaAProponer;
  private Guardarropas guardarropasAProponer;
  private EstadoPropuesta estado = EstadoPropuesta.PENDIENTE;

  public PropuestaAgregar(Prenda prendaAProponer, Guardarropas guardarropasAProponer) {
    this.prendaAProponer = prendaAProponer;
    this.guardarropasAProponer = guardarropasAProponer;
  }
  @Override
  public void aceptarPropuesta() {
    guardarropasAProponer.agregarPrenda(prendaAProponer);
    this.estado = EstadoPropuesta.ACEPTADO;
  }

  @Override
  public void deshacerPropuesta() {
    guardarropasAProponer.sacarPrenda(prendaAProponer);
  }

  public EstadoPropuesta getEstado() {
    return estado;
  }
}
