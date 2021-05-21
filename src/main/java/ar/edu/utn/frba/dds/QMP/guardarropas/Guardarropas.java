package ar.edu.utn.frba.dds.QMP.guardarropas;

import ar.edu.utn.frba.dds.QMP.GeneradorDeSugerencias;
import ar.edu.utn.frba.dds.QMP.atuendo.Atuendo;
import ar.edu.utn.frba.dds.QMP.prenda.Prenda;
import ar.edu.utn.frba.dds.QMP.prenda.Temperatura;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


public class Guardarropas {

    private Set<Prenda> prendasSuperiores = new HashSet<>();
    private Set<Prenda> prendasInferiores = new HashSet<>();
    private Set<Prenda> calzados = new HashSet<>();
    private Set<Prenda> accesorios = new HashSet<>();

    public Guardarropas(Set<Prenda> prendasSuperiores, Set<Prenda> prendasInferiores, Set<Prenda> calzados, Set<Prenda> accesorios) {
        this.prendasSuperiores = prendasSuperiores;
        this.prendasInferiores = prendasInferiores;
        this.calzados = calzados;
        this.accesorios = accesorios;
    }

    public Set<Prenda> prendasParaTemperatura(Set<Prenda> prendas, Temperatura temperatura) {
        return prendas.stream().filter(prenda ->
                prenda.getTemperaturaMaxima().esMayor(temperatura))
                .collect(Collectors.toSet());
    }

    public Set<Atuendo> sugerenciaParaTemperatura(Temperatura temperatura, GeneradorDeSugerencias generadorDeSugerencias) {
        return generadorDeSugerencias.sugerenciaUnaPorCategoria(
                prendasParaTemperatura(prendasSuperiores,temperatura),prendasParaTemperatura(prendasInferiores,temperatura),
                prendasParaTemperatura(calzados,temperatura),prendasParaTemperatura(accesorios,temperatura));
    }

  /*  public void agregarSuperiores(Set<Prenda> prendasSuperiores) { this.prendasSuperiores.addAll(prendasSuperiores); }
    public void agregarInferiores(Set<Prenda> prendasInferiores) { this.prendasInferiores.addAll(prendasInferiores); }
    public void agregarCalzados(Set<Prenda> calzados) { this.calzados.addAll(calzados); }
    public void agregarAccesorios(Set<Prenda> accesorios) { this.accesorios.addAll(accesorios); }*/
}
