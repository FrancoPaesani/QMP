package ar.edu.utn.frba.dds.QMP.usuario;

import ar.edu.utn.frba.dds.QMP.GeneradorDeSugerencias;
import ar.edu.utn.frba.dds.QMP.atuendo.Atuendo;
import ar.edu.utn.frba.dds.QMP.prenda.Prenda;
import ar.edu.utn.frba.dds.serviciosMeteorologicos.Temperatura;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Usuario {
  private List<Guardarropas> guardarropas = new ArrayList<>();
  private List<Propuesta> propuestas = new ArrayList<>();
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

  public void compartirGuardarropasCon(Usuario usuario, Guardarropas guardarropas) {
    usuario.agregarGuardarropas(guardarropas);
  }
  public void aceptarPropuestas() {
    this.propuestas.forEach(Propuesta::aceptarPropuesta);
  }
  public void deshacerPropuestasAceptadas() {
    this.propuestas.forEach(propuesta ->{
      if(propuesta.getEstado().equals(EstadoPropuesta.ACEPTADO))
        propuesta.deshacerPropuesta();
    });
  }
  public void rechazarPropuestas() {
    this.propuestas.clear();
  }
  public void agregarPropuestaDeAgregarA(Usuario usuario, Prenda prenda, Guardarropas guardarropas) {
    usuario.addPropuesta(new PropuestaAgregar(prenda,guardarropas));
  }
  public void agregarPropuestaDeSacarA(Usuario usuario, Prenda prenda, Guardarropas guardarropas) {
    usuario.addPropuesta(new PropuestaSacar(prenda,guardarropas));
  }
  public void addPropuesta(Propuesta propuesta){
    this.propuestas.add(propuesta);
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
