package ar.edu.utn.frba.dds.QMP.usuario;

import ar.edu.utn.frba.dds.QMP.GeneradorDeSugerencias;
import ar.edu.utn.frba.dds.QMP.atuendo.Atuendo;
import ar.edu.utn.frba.dds.QMP.excepciones.NoSeDeshacePropuestaNoAceptada;
import ar.edu.utn.frba.dds.QMP.prenda.Prenda;
import ar.edu.utn.frba.dds.serviciosMeteorologicos.Temperatura;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Usuario {
  private List<Guardarropas> guardarropas = new ArrayList<>();
  private List<Propuesta> propuestas = new ArrayList<>();
  //private List<Propuesta> propuestasAceptadas = new ArrayList<>();
  //private List<Propuesta> propuestasPendientes = new ArrayList<>();
  private GeneradorDeSugerencias generadorDeSugerencias;

  public Usuario(List<Guardarropas> guardarropas, GeneradorDeSugerencias generadorDeSugerencias) {
    if(guardarropas!=null)
      guardarropas.addAll(guardarropas);
    this.generadorDeSugerencias = generadorDeSugerencias;
  }
  public Set<Atuendo> getSugerenciaParaTemperatura(Temperatura temperatura) {
    Set<Atuendo> atuendos = new HashSet<>();
    this.guardarropas.forEach(guardarropas ->
        atuendos.addAll(guardarropas.sugerenciaParaTemperatura(
            temperatura,this.generadorDeSugerencias)));
    return atuendos;
  }

  public void aceptarPropuestas() { //si se quisieran aceptar todas las propuestas en la cola
    this.propuestas.forEach(Propuesta::aceptarPropuesta);
  }
  public void deshacerPropuesta(Propuesta propuesta) {
    if (this.obtenerPropuestasAceptadas().contains(propuesta)) {
      propuesta.deshacerPropuesta();
      this.propuestas.remove(propuesta);
    }
    else
      throw new NoSeDeshacePropuestaNoAceptada("No se puede deshacer una propuesta no aceptada.");
  }
  public List<Propuesta> obtenerPropuestasAceptadas() {
    return this.propuestas.stream()
        .filter(propuesta -> propuesta.getEstado().equals(EstadoPropuesta.ACEPTADO)).collect(Collectors.toList());
  }
  public void agregarPropuesta(Propuesta propuesta) {
    this.propuestas.add(propuesta);
  }
  public void rechazarPropuesta(Propuesta propuesta) {
    this.propuestas.remove(propuesta);
  }
  public void agregarPrendaAGuardarropas(Guardarropas guardarropas, Prenda prenda) {
    if(this.guardarropas.contains(guardarropas))
      guardarropas.agregarPrenda(prenda);
  }
  public void agregarGuardarropas(Guardarropas guardarropas) {
    this.guardarropas.add(guardarropas);
  }
  public int cantidadDeGuardarropas() {
    return this.guardarropas.size();
  }
  public int cantidadDePropuestas() {
    return this.propuestas.size();
  }
}
