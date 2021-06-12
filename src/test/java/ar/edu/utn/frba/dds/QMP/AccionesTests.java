package ar.edu.utn.frba.dds.QMP;

import ar.edu.utn.frba.dds.QMP.alertas.AlertaMeteorologica;
import ar.edu.utn.frba.dds.QMP.usuario.Usuario;
import ar.edu.utn.frba.dds.QMP.usuario.acciones.AccionEnvioMail;
import ar.edu.utn.frba.dds.QMP.usuario.acciones.AccionNotificar;
import ar.edu.utn.frba.dds.QMP.usuario.acciones.AccionRecalculoSugerencia;
import ar.edu.utn.frba.dds.notificacion.MailSenderAdapter;
import ar.edu.utn.frba.dds.notificacion.NotificationAdapter;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.*;

public class AccionesTests {

  @Test
  public void AccionNotificarUsaNotificarDelService() {
    NotificationAdapter notificationService = mock(NotificationAdapter.class);
    Usuario usuario = mock(Usuario.class);
    AccionNotificar accionNotificar = new AccionNotificar(notificationService);
    accionNotificar.anteNuevaAlertaMeteorologica(usuario, AlertaMeteorologica.GRANIZO);
    verify(notificationService,atLeastOnce()).notificar(any(),any());
  }

  @Test
  public void AccionMailUsaNotificarDelMailer() {
    MailSenderAdapter mailSender = mock(MailSenderAdapter.class);
    Usuario usuario = mock(Usuario.class);
    AccionEnvioMail accionNotificar = new AccionEnvioMail(mailSender);
    accionNotificar.anteNuevaAlertaMeteorologica(usuario, AlertaMeteorologica.GRANIZO);
    verify(mailSender,atLeastOnce()).notificar(any(),any());
  }

  @Test
  public void AccionRecalcularUtilizaMetodoDelUsuario() {
    Usuario usuario = mock(Usuario.class);
    AccionRecalculoSugerencia recalculoSugerencia = new AccionRecalculoSugerencia();
    recalculoSugerencia.anteNuevaAlertaMeteorologica(usuario, AlertaMeteorologica.GRANIZO);
    verify(usuario,atLeastOnce()).calcularSugerenciaDiaria();
  }
}
