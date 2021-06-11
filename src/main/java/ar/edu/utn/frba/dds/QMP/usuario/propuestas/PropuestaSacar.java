package ar.edu.utn.frba.dds.QMP.usuario.propuestas;

import ar.edu.utn.frba.dds.QMP.prenda.Prenda;
import ar.edu.utn.frba.dds.QMP.usuario.Guardarropas;

public class PropuestaSacar implements Propuesta{
  private Prenda prendaAProponer;
  private Guardarropas guardarropasAProponer;
  private EstadoPropuesta estado = EstadoPropuesta.PENDIENTE;

  public PropuestaSacar(Prenda prendaAProponer, Guardarropas guardarropasAProponer) {
    this.prendaAProponer = prendaAProponer;
    this.guardarropasAProponer = guardarropasAProponer;
  }
  @Override
  public void aceptarPropuesta() {
    guardarropasAProponer.sacarPrenda(prendaAProponer);
    this.estado = EstadoPropuesta.ACEPTADO;
  }

  @Override
  public void deshacerPropuesta() {
      guardarropasAProponer.agregarPrenda(prendaAProponer);
  }

  public EstadoPropuesta getEstado() {
    return estado;
  }
}
