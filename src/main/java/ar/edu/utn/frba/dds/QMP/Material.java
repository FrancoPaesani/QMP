package ar.edu.utn.frba.dds.QMP;

public class Material {//TODO: ver si queda bien el material como clase
  private Trama trama = Trama.LISA;

  public Material(Trama trama) {
    if(trama != null)
      this.trama = trama;
  }

  public Trama getTrama() { return trama; }
  public void setTrama(Trama trama) { this.trama = trama; }
}
