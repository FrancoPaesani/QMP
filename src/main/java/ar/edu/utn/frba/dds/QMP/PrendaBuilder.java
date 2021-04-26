package ar.edu.utn.frba.dds.QMP;

public class PrendaBuilder {
  // Parámetros obligatorios
  private final Tipo tipo;
  private Material material;
  private Color colorPrincipal;
  // Parámetro opcional
  private Color colorSecundario = null;

  public PrendaBuilder(Tipo tipo) {
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

  public PrendaBuilder setColorSecundario(Color colorSecundario) {
    this.colorSecundario = colorSecundario;
    return this;
  }

  public PrendaBuilder setTrama(Trama trama) {
    this.material.setTrama(trama);
    return this;
  }

  public Prenda build() {
    if (this.material == null || this.colorPrincipal == null)
      throw new CamposObligatoriosIncompletosException(
          "La prenda debe tener por lo menos un tipo, material y color principal.");
    return new Prenda(this);
  }

  public Tipo getTipo() { return this.tipo; }
  public Material getMaterial() { return material; }
  public Color getColorPrincipal() { return colorPrincipal; }
  public Color getColorSecundario() { return colorSecundario; }
}