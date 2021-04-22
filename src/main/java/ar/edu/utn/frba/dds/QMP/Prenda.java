package ar.edu.utn.frba.dds.QMP;

import jdk.internal.util.xml.impl.Pair;

public class Prenda {
  private final Categoria categoria;
  private final Tipo tipo;
  private final Material material;
  private final ColorEnum colorPrincipal;
  private final ColorEnum colorSecundario;

  private Prenda(PrendaBuilder builder) {
    this.categoria = builder.categoria;
    this.tipo = builder.tipo;
    this.material = builder.material;
    this.colorPrincipal = builder.colorPrincipal;
    this.colorSecundario = builder.colorSecundario;
  }
  public static PrendaBuilder tipo(Tipo tipo) {
    if(tipo == null)
      throw new CamposObligatoriosIncompletos(
          "La prenda debe tener por lo menos un tipo, material y color principal.");
    return new PrendaBuilder(tipo);
  }

  public static class PrendaBuilder {
    // Parámetros obligatorios
    private final Tipo tipo;
    private Categoria categoria;
    private Material material;
    private ColorEnum colorPrincipal;
    // Parámetro opcional
    private ColorEnum colorSecundario = null;

    private PrendaBuilder(Tipo tipo) {
      this.tipo = tipo;
      this.categoria = tipo.getCategoria();
    }
    public PrendaBuilder setMaterial(Material material) {
      this.material = material;
      return this;
    }
    public PrendaBuilder setColorPrincipal(ColorEnum colorPrincipal) {
      this.colorPrincipal = colorPrincipal;
      return this;
    }
    public void setColorSecundario(ColorEnum colorSecundario) {
      this.colorSecundario = colorSecundario;
    }
    public Prenda build() {
      if(this.material == null || this.colorPrincipal == null)
        throw new CamposObligatoriosIncompletos(
            "La prenda debe tener por lo menos un tipo, material y color principal.");
      return new Prenda(this);
    }

  }
  public Tipo getTipo() {return this.tipo;}
  public Categoria getCategoria() {return this.categoria;}
  public Material getMaterial() {return this.material;}
  public ColorEnum getColorPrincipal() {return this.colorPrincipal;}
  public ColorEnum getColorSecundario() {return this.colorSecundario;}
}
