package ar.edu.utn.frba.dds.QMP;

import ar.edu.utn.frba.dds.notificacion.MailSender;
import ar.edu.utn.frba.dds.notificacion.NotificationService;
import org.junit.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class NotificationTests {
  @Test
  public void NotificarUsaMetodoNotificar() {
    NotificationService notificationService = mock(NotificationService.class);
    notificationService.notificar(any(),any());
    verify(notificationService,only()).notificar(any(),any());
  }
  @Test
  public void MailSenderUsaMetodoNotificar() {
    MailSender mailSender = mock(MailSender.class);
    mailSender.notificar(any(),any());
    verify(mailSender,only()).notificar(any(),any());
  }
}
