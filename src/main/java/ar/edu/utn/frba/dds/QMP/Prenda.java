package ar.edu.utn.frba.dds.QMP;

public class Prenda {
  private final Tipo tipo;
  private final Material material;
  private final Color colorPrincipal;
  private final Color colorSecundario;

  public Prenda(PrendaBuilder builder) {
    this.tipo = builder.getTipo();
    this.material = builder.getMaterial();
    this.colorPrincipal = builder.getColorPrincipal();
    this.colorSecundario = builder.getColorSecundario();
  }
  public static PrendaBuilder tipo(Tipo tipo) {
    if(tipo == null)
      throw new CamposObligatoriosIncompletosException(
          "La prenda debe tener un tipo.");
    return new PrendaBuilder(tipo);
  }

  public Categoria getCategoria() {return this.tipo.getCategoria();}
  public Trama getTrama() {return this.material.getTrama();}
}
