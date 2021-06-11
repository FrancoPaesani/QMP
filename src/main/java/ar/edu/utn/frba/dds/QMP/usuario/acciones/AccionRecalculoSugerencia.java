package ar.edu.utn.frba.dds.QMP.usuario.acciones;

import ar.edu.utn.frba.dds.QMP.alertas.AlertaMeteorologica;
import ar.edu.utn.frba.dds.QMP.usuario.Usuario;

public class AccionRecalculoSugerencia implements Accion{
  @Override
  public void realizarAccion(Usuario usuario, AlertaMeteorologica alertaMeteorologica) {
    usuario.calcularSugerenciaDiaria();
  }
}
