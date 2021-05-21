package ar.edu.utn.frba.dds.QMP.atuendo;

import ar.edu.utn.frba.dds.QMP.prenda.Prenda;
import java.util.ArrayList;
import java.util.List;

public class Atuendo {
    private Prenda prendaSuperior;
    private Prenda prendaInferior;
    private Prenda calzado;
    private List<Prenda> accesorios = new ArrayList<>();

    public Atuendo(Prenda prendaSuperior, Prenda prendaInferior, Prenda calzado) {
        this.prendaSuperior = prendaSuperior;
        this.prendaInferior = prendaInferior;
        this.calzado = calzado;
    }

    public void agregarAccesorios(List<Prenda> accesorios) { this.accesorios.addAll(accesorios); }

    public Prenda getPrendaSuperior() { return prendaSuperior; }
    public Prenda getPrendaInferior() { return prendaInferior; }
    public Prenda getCalzado() { return calzado; }
}
