package ar.edu.utn.frba.dds.QMP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Uniforme {//TODO fabricas de uniformes. 3 prendas solas cada unif.
  private ArrayList<Prenda> prendas = new ArrayList<>();
  private static final ArrayList<Categoria> categoriasPrendas = new ArrayList<>(
      Arrays.asList(Categoria.PRENDA_SUPERIOR,
          Categoria.PRENDA_INFERIOR,Categoria.CALZADO));

  public Uniforme(ArrayList<Prenda> prendas) {
    this.prendas = (ArrayList<Prenda>) prendas.clone();
  }

  public static UniformeBuilder crearUniforme() {
    return new UniformeBuilder();
  }

  public List<Prenda> getPrendasDeCategoria(Categoria categoria) {
    return prendas.stream().filter(prenda -> prenda.getCategoria() == categoria).collect(Collectors.toList());
  }

  public ArrayList<Prenda> getPrendas() { return prendas; }

    public static class UniformeBuilder {
      private final ArrayList<Prenda> prendas = new ArrayList<>();

      public UniformeBuilder agregarPrenda(Prenda prenda) {prendas.add(prenda);return this;}

      public boolean tienePrendaPorCategoria() { return this.mapCategoriasPrendas().containsAll(categoriasPrendas); }

      public ArrayList<Categoria> mapCategoriasPrendas() {
       return (ArrayList<Categoria>) prendas.stream().map(Prenda::getCategoria).collect(Collectors.toList());
     }

     public Uniforme build() {
       if(tienePrendaPorCategoria() && prendas.size()==3)
         return new Uniforme(prendas);
       else
          throw new UniformeInvalidoException("El uniforme no cumple con las categorias o tiene tamaño mayor.");
      }
    }

}
