package ar.edu.utn.frba.dds.QMP.usuario.acciones;

import ar.edu.utn.frba.dds.QMP.alertas.AlertaMeteorologica;
import ar.edu.utn.frba.dds.QMP.usuario.Usuario;
import ar.edu.utn.frba.dds.notificacion.NotificationService;

public class AccionNotificar implements Accion{
  private NotificationService notificationService;
  public AccionNotificar(NotificationService notificationService) {
    this.notificationService = notificationService;
  }
  @Override
  public void anteNuevaAlertaMeteorologica(Usuario usuario, AlertaMeteorologica alertaMeteorologica) {
    this.notificationService.notificar(usuario.getNumero(),alertaMeteorologica.getMensaje());
  }
}
