package ar.edu.utn.frba.dds.QMP.prenda;

import ar.edu.utn.frba.dds.serviciosMeteorologicos.Temperatura;

public class Prenda {
  private final Tipo tipo;
  private final Material material;
  private Trama trama;
  private final Color colorPrincipal;
  private final Color colorSecundario;
  private Temperatura temperaturaMaxima;

  public Prenda(Tipo tipo, Material material, Trama trama, Color colorPrincipal,
                Color colorSecundario, Temperatura temperaturaMaxima) {
    this.tipo = tipo;
    this.material = material;
    this.trama = trama;
    this.colorPrincipal = colorPrincipal;
    this.colorSecundario = colorSecundario;
    this.temperaturaMaxima = temperaturaMaxima;
  }
  public static Borrador tipo(Tipo tipo) {
    return new Borrador(tipo);
  }

  public Categoria getCategoria() {return this.tipo.getCategoria();}
  public Trama getTrama() { return trama; }
  public Color getColorPrincipal() { return colorPrincipal; }
  public Material getMaterial() { return material; }
  public Temperatura getTemperaturaMaxima() { return temperaturaMaxima; }
}
