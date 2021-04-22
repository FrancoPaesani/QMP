package ar.edu.utn.frba.dds.QMP;

public enum Tipo {
  REMERA(Categoria.PRENDA_SUPERIOR), PANTALON(Categoria.PRENDA_INFERIOR), ZAPATOS(Categoria.CALZADO),
  GORRA(Categoria.ACCESORIO);
  private final Categoria categoria;

  Tipo(Categoria categoria) {
    this.categoria = categoria;
  }
  public Categoria getCategoria() {
    return this.categoria;
  }
}
