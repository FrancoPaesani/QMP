package ar.edu.utn.frba.dds.QMP.usuario.acciones;

import ar.edu.utn.frba.dds.QMP.alertas.AlertaMeteorologica;
import ar.edu.utn.frba.dds.QMP.usuario.Usuario;
import ar.edu.utn.frba.dds.notificacion.MailSender;

public class AccionEnvioMail implements Accion{
  private MailSender mailSender;
  public AccionEnvioMail(MailSender mailSender) {
    this.mailSender = mailSender;
  }
  @Override
  public void realizarAccion(Usuario usuario, AlertaMeteorologica alertaMeteorologica) {
   this.mailSender.notificar(usuario.getMail(), alertaMeteorologica.getMensaje());
  }
}
