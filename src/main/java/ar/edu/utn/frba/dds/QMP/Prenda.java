package ar.edu.utn.frba.dds.QMP;

import java.util.ArrayList;
import java.util.List;

public class Prenda {
  private final Tipo tipo;
  private final Material material;
  private Trama trama;
  private final Color colorPrincipal;
  private final Color colorSecundario;

  public Prenda(Tipo tipo, Material material, Trama trama, Color colorPrincipal, Color colorSecundario) {
    this.tipo = tipo;
    this.material = material;
    this.trama = trama;
    this.colorPrincipal = colorPrincipal;
    this.colorSecundario = colorSecundario;
  }
  public static Borrador tipo(Tipo tipo) {
    return new Borrador(tipo);
  }

  public Categoria getCategoria() {return this.tipo.getCategoria();}
  public Trama getTrama() { return trama; }
}
