package ar.edu.utn.frba.dds.QMP;

import java.util.ArrayList;

public class Uniforme {
  private Prenda prendaSuperior;
  private Prenda prendaInferior;
  private Prenda calzado;

  public Uniforme(Prenda superior, Prenda inferior, Prenda calzado) {
    this.prendaSuperior = superior;
    this.prendaInferior = inferior;
    this.calzado = calzado;
  }

  public UniformeBuilder crearUniforme() {
    return new UniformeBuilder();
  }

  public static class UniformeBuilder {
    private Prenda prendaSuperior;
    private Prenda prendaInferior;
    private Prenda calzado;

    public UniformeBuilder setPrendaSuperior(Prenda prenda) {
      if(prenda.getCategoria() == Categoria.PRENDA_SUPERIOR)
        this.prendaSuperior = prenda;
      else
        throw new UniformeTipoInvalidoException
            ("La prenda ingresada debe ser de tipo superior.");
      return this;
    }
    public UniformeBuilder setPrendaInferior(Prenda prenda) {
      if(prenda.getCategoria() == Categoria.PRENDA_INFERIOR)
        this.prendaSuperior = prenda;
      else
        throw new UniformeTipoInvalidoException
            ("La prenda ingresada debe ser de tipo inferior.");
      return this;
    }
    public UniformeBuilder setCalzado(Prenda prenda) {
      if(prenda.getCategoria() == Categoria.CALZADO)
        this.prendaSuperior = prenda;
      else
        throw new UniformeTipoInvalidoException
            ("La prenda ingresada debe ser de tipo calzado.");
      return this;
    }

    public Uniforme build() {
      return new Uniforme(prendaSuperior,prendaInferior,calzado);
    }

  }
}
