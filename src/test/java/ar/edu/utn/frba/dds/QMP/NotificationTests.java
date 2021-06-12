package ar.edu.utn.frba.dds.QMP;

import ar.edu.utn.frba.dds.notificacion.MailSenderAdapter;
import ar.edu.utn.frba.dds.notificacion.NotificationAdapter;
import org.junit.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class NotificationTests {
  @Test
  public void NotificarUsaMetodoNotificar() {
    NotificationAdapter notificationService = mock(NotificationAdapter.class);
    notificationService.notificar(any(),any());
    verify(notificationService,only()).notificar(any(),any());
  }
  @Test
  public void MailSenderUsaMetodoNotificar() {
    MailSenderAdapter mailSender = mock(MailSenderAdapter.class);
    mailSender.notificar(any(),any());
    verify(mailSender,only()).notificar(any(),any());
  }
}
