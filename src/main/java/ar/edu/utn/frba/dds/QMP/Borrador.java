package ar.edu.utn.frba.dds.QMP;

import java.util.List;
import java.util.Objects;

public class Borrador {
  // Parámetros obligatorios
  private final Tipo tipo;
  private Material material;
  private Trama trama = Trama.LISA;
  private Color colorPrincipal;
  // Parámetro opcional
  private Color colorSecundario = null;

  public Borrador(Tipo tipo) {
    if(tipo == null)
      throw new CamposObligatoriosIncompletosException(
              "La prenda debe tener un tipo.");
    this.tipo = tipo;
  }

  public Borrador setMaterial(Material material) {
    if (!this.tipo.admiteMaterial(material))
      throw new MaterialYTipoIncompatiblesException("El tipo [" +
              this.tipo.name() + "] no permite al material [" + material.name() + "]" );
    this.material = Objects.requireNonNull(material, "Se debe ingresar un material.");
    return this;
  }

  public Borrador setColorPrincipal(Color colorPrincipal) {
    this.colorPrincipal = Objects.requireNonNull(colorPrincipal, "Se debe ingresar un color principal.");
    return this;
  }

  public Borrador setTrama(Trama trama) {
    this.trama = Objects.requireNonNull(trama);
    return this;
  }

  public Borrador setColorSecundario(Color colorSecundario) {
    this.colorSecundario = colorSecundario;
    return this;
  }


  public Prenda build() {
    this.validarConstruccion();
    return new Prenda(tipo,material,trama,colorPrincipal,colorSecundario);
  }

  public void validarConstruccion() {
    Objects.requireNonNull(this.tipo, "La prenda debe tener un tipo.");
    Objects.requireNonNull(this.material, "La prenda debe tener un material.");
    Objects.requireNonNull(this.colorPrincipal, "La prenda debe tener un color principal.");
  }

  public Tipo getTipo() { return this.tipo; }
  public Material getMaterial() { return material; }
  public Color getColorPrincipal() { return colorPrincipal; }
  public Color getColorSecundario() { return colorSecundario; }
}