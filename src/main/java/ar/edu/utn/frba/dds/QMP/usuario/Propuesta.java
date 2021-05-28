package ar.edu.utn.frba.dds.QMP.usuario;

public interface Propuesta {
  public void aceptarPropuesta();
  public void deshacerPropuesta();
  public EstadoPropuesta getEstado();
}
