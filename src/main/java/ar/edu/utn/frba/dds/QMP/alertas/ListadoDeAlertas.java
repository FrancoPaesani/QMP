package ar.edu.utn.frba.dds.QMP.alertas;

import ar.edu.utn.frba.dds.QMP.usuario.ListadoDeUsuarios;
import ar.edu.utn.frba.dds.QMP.usuario.Usuario;
import ar.edu.utn.frba.dds.serviciosMeteorologicos.ServicioMeteorologico;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListadoDeAlertas {
  private List<AlertaMeteorologica> alertaMeteorologicas = new ArrayList<>();
  private ListadoDeUsuarios usuarios;
  private ServicioMeteorologico servicioMeteorologico;
  private String ciudad; //TODO: puede ser una clase Lugar, para separar las diferentes alertas de
                         // cada lugar (un usuario de BuenosAires no tendrá la misma alerta q uno de Bariloche).
                         // no hay rq especifico sobre esto.

  public ListadoDeAlertas(List<AlertaMeteorologica> alertasMeteorologicas,
                          ServicioMeteorologico servicioMeteorologico,
                          ListadoDeUsuarios usuarios, String ciudad) {
    this.ciudad = ciudad;
    this.servicioMeteorologico = servicioMeteorologico;
    this.alertaMeteorologicas.addAll(Objects.requireNonNull(alertasMeteorologicas));
    this.usuarios = Objects.requireNonNull(usuarios);
  }

  public void actualizarAlertas() {
    this.alertaMeteorologicas = this.servicioMeteorologico.getAlertas(this.ciudad);
    this.dispararAccionesParaTodasLasAlertas();
  }

  private void dispararAccionesParaTodasLasAlertas() {
    this.alertaMeteorologicas.forEach(
        alertaMeteorologica ->
            this.usuarios.realizarAccionesParaTodosSegun(alertaMeteorologica)
        );
  }

  public List<AlertaMeteorologica> getAlertaMeteorologicas() {
    return alertaMeteorologicas;
  }
}
