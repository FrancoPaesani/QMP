package ar.edu.utn.frba.dds.QMP.usuario.acciones;

import ar.edu.utn.frba.dds.QMP.alertas.AlertaMeteorologica;
import ar.edu.utn.frba.dds.QMP.usuario.Usuario;

public interface Accion {
  public void anteNuevaAlertaMeteorologica(Usuario usuario, AlertaMeteorologica alertaMeteorologica);
}
