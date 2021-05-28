package ar.edu.utn.frba.dds.QMP.excepciones;

public class NoSeDeshacePropuestaNoAceptada extends RuntimeException {
  public NoSeDeshacePropuestaNoAceptada(String msg) {
    super(msg);
  }
}
