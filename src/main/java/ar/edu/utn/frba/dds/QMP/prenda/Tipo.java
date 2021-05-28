package ar.edu.utn.frba.dds.QMP.prenda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Tipo {
  REMERA(Categoria.PRENDA_SUPERIOR, Arrays.asList(Material.ALGODON)),
  CHOMBA(Categoria.PRENDA_SUPERIOR, Arrays.asList(Material.ALGODON,Material.PIQUE)),
  CAMISA(Categoria.PRENDA_SUPERIOR, Arrays.asList(Material.ALGODON)),
  PANTALON(Categoria.PRENDA_INFERIOR, Arrays.asList(Material.CUERO,Material.ALGODON, Material.JEAN, Material.ACETATO)),
  ZAPATOS(Categoria.CALZADO, Arrays.asList(Material.LANA,Material.CUERO)),
  ZAPATILLAS(Categoria.CALZADO, Arrays.asList(Material.LANA,Material.CUERO,Material.ALGODON)),
  GORRA(Categoria.ACCESORIO, Arrays.asList(Material.CUERO,Material.ALGODON,Material.LANA,Material.JEAN)),
  MUNIEQUERA(Categoria.ACCESORIO, Arrays.asList(Material.CUERO));
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
