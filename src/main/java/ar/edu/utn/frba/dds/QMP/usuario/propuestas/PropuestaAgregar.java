package ar.edu.utn.frba.dds.QMP.usuario.propuestas;

import ar.edu.utn.frba.dds.QMP.prenda.Prenda;
import ar.edu.utn.frba.dds.QMP.usuario.Guardarropas;

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

  @Override
  public boolean estaAceptada() {
    if(this.estado.equals(EstadoPropuesta.ACEPTADO))//TODO: sacar typetest
      return true;
    else
      return false;
  }
}
