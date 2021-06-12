package ar.edu.utn.frba.dds.notificacion;

public class MailSenderAdapter implements Notificador{
  @Override
  public void notificar(String to, String text) {
    //send...
  }
}
