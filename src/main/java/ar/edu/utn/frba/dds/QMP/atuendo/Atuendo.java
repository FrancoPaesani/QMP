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
    public Atuendo(Prenda prendaSuperior, Prenda prendaInferior, Prenda calzado, List<Prenda> accesorios) {
        this.prendaSuperior = prendaSuperior;
        this.prendaInferior = prendaInferior;
        this.calzado = calzado;
        this.accesorios.addAll(accesorios);
    }

    public void agregarAccesorios(List<Prenda> accesorios) { this.accesorios.addAll(accesorios);}
    public void agregarAccesorio(Prenda accesorio) { this.accesorios.add(accesorio);}

    public Prenda getPrendaSuperior() { return prendaSuperior; }
    public Prenda getPrendaInferior() { return prendaInferior; }
    public Prenda getCalzado() { return calzado; }
    public List<Prenda> getAccesorios() { return accesorios; }
}
