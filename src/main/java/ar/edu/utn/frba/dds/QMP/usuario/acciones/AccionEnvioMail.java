package ar.edu.utn.frba.dds.QMP.usuario.acciones;

import ar.edu.utn.frba.dds.QMP.alertas.AlertaMeteorologica;
import ar.edu.utn.frba.dds.QMP.usuario.Usuario;
import ar.edu.utn.frba.dds.notificacion.MailSenderAdapter;

public class AccionEnvioMail implements Accion{
  private MailSenderAdapter mailSender;
  public AccionEnvioMail(MailSenderAdapter mailSender) {
    this.mailSender = mailSender;
  }
  @Override
  public void anteNuevaAlertaMeteorologica(Usuario usuario, AlertaMeteorologica alertaMeteorologica) {
   this.mailSender.notificar(usuario.getMail(), alertaMeteorologica.getMensaje());
  }
}
