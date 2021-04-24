package ar.edu.utn.frba.dds.QMP;

public class Prenda {
  private final Tipo tipo;
  private final Material material;
  private final Color colorPrincipal;
  private final Color colorSecundario;

  private Prenda(PrendaBuilder builder) {
    this.tipo = builder.tipo;
    this.material = builder.material;
    this.colorPrincipal = builder.colorPrincipal;
    this.colorSecundario = builder.colorSecundario;
  }
  public static PrendaBuilder tipo(Tipo tipo) {
    if(tipo == null)
      throw new CamposObligatoriosIncompletosException(
          "La prenda debe tener un tipo.");
    return new PrendaBuilder(tipo);
  }

  public static class PrendaBuilder {
    // Parámetros obligatorios
    private final Tipo tipo;
    private Material material;
    private Color colorPrincipal;
    // Parámetro opcional
    private Color colorSecundario = null;

    private PrendaBuilder(Tipo tipo) {
      this.tipo = tipo;
    }
    public PrendaBuilder setMaterial(Material material) {
      this.material = material;
      return this;
    }
    public PrendaBuilder setColorPrincipal(Color colorPrincipal) {
      this.colorPrincipal = colorPrincipal;
      return this;
    }
    public void setColorSecundario(Color colorSecundario) {
      this.colorSecundario = colorSecundario;
    }
    public Prenda build() {
      if(this.material == null || this.colorPrincipal == null)
        throw new CamposObligatoriosIncompletosException(
            "La prenda debe tener por lo menos un tipo, material y color principal.");
      return new Prenda(this);
    }

  }

  public Categoria getCategoria() {return this.tipo.getCategoria();}
}
