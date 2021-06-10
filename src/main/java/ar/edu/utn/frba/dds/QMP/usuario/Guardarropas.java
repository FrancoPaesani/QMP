package ar.edu.utn.frba.dds.QMP.usuario;

import ar.edu.utn.frba.dds.QMP.GeneradorDeSugerencias;
import ar.edu.utn.frba.dds.QMP.atuendo.Atuendo;
import ar.edu.utn.frba.dds.QMP.prenda.Categoria;
import ar.edu.utn.frba.dds.QMP.prenda.Prenda;
import ar.edu.utn.frba.dds.serviciosMeteorologicos.Temperatura;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


public class Guardarropas {

  private Set<Prenda> prendas = new HashSet<>();


  public Guardarropas(Set<Prenda> prendas) {
    if (prendas != null)
      this.prendas.addAll(prendas);
  }

  public Set<Prenda> prendasParaTemperatura(Set<Prenda> prendas, Temperatura temperatura) {
    return prendas.stream().filter(prenda ->
        prenda.getTemperaturaMaxima().esMayor(temperatura))
        .collect(Collectors.toSet());
  }

  public Set<Atuendo> sugerenciaParaTemperatura(Temperatura temperatura, GeneradorDeSugerencias generadorDeSugerencias) {
    Set<Prenda> prendasSuperiores = filtrarPrendasPor(Categoria.PRENDA_SUPERIOR);
    Set<Prenda> prendasInferiores = filtrarPrendasPor(Categoria.PRENDA_INFERIOR);
    Set<Prenda> calzados = filtrarPrendasPor(Categoria.CALZADO);
    Set<Prenda> accesorios = filtrarPrendasPor(Categoria.ACCESORIO);
    return generadorDeSugerencias.sugerenciaUnaPorCategoria(
        prendasParaTemperatura(prendasSuperiores, temperatura), prendasParaTemperatura(prendasInferiores, temperatura),
        prendasParaTemperatura(calzados, temperatura), prendasParaTemperatura(accesorios, temperatura));
  }

  private Set<Prenda> filtrarPrendasPor(Categoria categoria) {
    return this.prendas.stream().filter(
        prenda -> prenda.getCategoria().equals(categoria))
        .collect(Collectors.toSet());
  }

  public int cantidadDePrendas() {
    return this.prendas.size();
  }

  public void agregarPrenda(Prenda prenda) {
    this.prendas.add(prenda);
  }
  public void sacarPrenda(Prenda prenda) { this.prendas.remove(prenda); }
}
