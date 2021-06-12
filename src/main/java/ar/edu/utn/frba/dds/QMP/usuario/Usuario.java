package ar.edu.utn.frba.dds.QMP.usuario;

import ar.edu.utn.frba.dds.QMP.GeneradorDeSugerencias;
import ar.edu.utn.frba.dds.QMP.alertas.AlertaMeteorologica;
import ar.edu.utn.frba.dds.QMP.atuendo.Atuendo;
import ar.edu.utn.frba.dds.QMP.excepciones.NoSeDeshacePropuestaNoAceptada;
import ar.edu.utn.frba.dds.QMP.prenda.Prenda;
import ar.edu.utn.frba.dds.QMP.usuario.acciones.Accion;
import ar.edu.utn.frba.dds.QMP.usuario.propuestas.EstadoPropuesta;
import ar.edu.utn.frba.dds.QMP.usuario.propuestas.Propuesta;
import ar.edu.utn.frba.dds.serviciosMeteorologicos.Temperatura;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Usuario {
  private String numero;  //TODO: no especifica nada, pero podría tener mails/numeros a los que quiero
                          // la notificación. Y mails en los que no quiero ser notificado.
                          // Lo dejé simple con strings(1 y 1).
  private String mail;
  private GeneradorDeSugerencias generadorDeSugerencias;
  private List<Guardarropas> guardarropas = new ArrayList<>();
  private List<Propuesta> propuestas = new ArrayList<>();
  private Atuendo sugerenciaDiaria;
  private List<Accion> acciones = new ArrayList<>();

  public Usuario(List<Guardarropas> guardarropas,
                 GeneradorDeSugerencias generadorDeSugerencias) {
    if(guardarropas!=null)
      guardarropas.addAll(guardarropas);
    this.generadorDeSugerencias = generadorDeSugerencias;
  }
  public Atuendo getSugerenciaDiaria() {
    return sugerenciaDiaria;
  }
  public void calcularSugerenciaDiaria() {
    this.sugerenciaDiaria = this.guardarropas.get(0).getSugerencia(this.generadorDeSugerencias) ;
  }
  public void realizarAccionesSegun(AlertaMeteorologica alertaMeteorologica) {
    this.acciones.forEach(
        accion ->
            accion.anteNuevaAlertaMeteorologica(this,alertaMeteorologica)
    );
  }
  public void agregarAccion(Accion accion) {
    this.acciones.add(accion);
  }
  public void sacarAccion(Accion accion) {
    this.acciones.remove(accion);
  }
  public Set<Atuendo> getSugerenciaParaTemperatura(Temperatura temperatura) {
    Set<Atuendo> atuendos = new HashSet<>();
    this.guardarropas.forEach(guardarropas ->
        atuendos.addAll(guardarropas.sugerenciaParaTemperatura(
            temperatura,this.generadorDeSugerencias)));
    return atuendos;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public String getNumero() {
    return numero;
  }
  public String getMail() {
    return mail;
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
      throw new NoSeDeshacePropuestaNoAceptada("No se puede deshacer una propuesta no aceptada.");//TODO cambiar nombre de excepción.
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
