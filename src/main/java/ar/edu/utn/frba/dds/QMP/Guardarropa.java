package ar.edu.utn.frba.dds.QMP;

import java.util.ArrayList;

public class Guardarropa {
  private ArrayList<Prenda> prendas = new ArrayList<>();

  public void agregarPrenda(Prenda prenda) {
    prendas.add(prenda);
  }
  public ArrayList<Prenda> getPrendas() { return prendas; }
}
