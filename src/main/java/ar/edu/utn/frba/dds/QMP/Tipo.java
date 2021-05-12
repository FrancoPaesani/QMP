package ar.edu.utn.frba.dds.QMP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Tipo {
  REMERA(Categoria.PRENDA_SUPERIOR, Arrays.asList(Material.ALGODON)),
  PANTALON(Categoria.PRENDA_INFERIOR, Arrays.asList(Material.CUERO,Material.ALGODON, Material.JEAN)),
  ZAPATOS(Categoria.CALZADO, Arrays.asList(Material.LANA,Material.CUERO)),
  GORRA(Categoria.ACCESORIO, Arrays.asList(Material.CUERO,Material.ALGODON,Material.LANA));
  private final List<Material> materialesPosibles = new ArrayList<>();
  private final Categoria categoria;

  Tipo(Categoria categoria, List<Material> materialesPosibles)
  {
    this.categoria = categoria;
    this.materialesPosibles.addAll(materialesPosibles);
  }
  public Categoria getCategoria() {
    return this.categoria;
  }
  public boolean admiteMaterial(Material material) { return this.materialesPosibles.contains(material); }
}
