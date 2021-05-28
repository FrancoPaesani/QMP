package ar.edu.utn.frba.dds.QMP.usuario;

import ar.edu.utn.frba.dds.QMP.excepciones.NoSeDeshacePropuestaNoAceptada;
import ar.edu.utn.frba.dds.QMP.prenda.Prenda;

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
    if (this.estado == EstadoPropuesta.ACEPTADO){
      guardarropasAProponer.agregarPrenda(prendaAProponer);
      this.estado = EstadoPropuesta.PENDIENTE;
    }
    else
      throw new NoSeDeshacePropuestaNoAceptada("No podés deshacer una propuesta no aceptada.");
  }

  public EstadoPropuesta getEstado() {
    return estado;
  }
}
