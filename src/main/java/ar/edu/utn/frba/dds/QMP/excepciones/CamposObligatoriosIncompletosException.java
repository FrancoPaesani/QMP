package ar.edu.utn.frba.dds.QMP.excepciones;

public class CamposObligatoriosIncompletosException extends RuntimeException{
  public CamposObligatoriosIncompletosException(String msg) {
    super(msg);
  }
}
