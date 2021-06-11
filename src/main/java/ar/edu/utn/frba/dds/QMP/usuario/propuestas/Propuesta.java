package ar.edu.utn.frba.dds.QMP.usuario.propuestas;

public interface Propuesta {
  public void aceptarPropuesta();
  public void deshacerPropuesta();
  public EstadoPropuesta getEstado();
}
