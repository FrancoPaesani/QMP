package ar.edu.utn.frba.dds.QMP.usuario;

import ar.edu.utn.frba.dds.QMP.alertas.AlertaMeteorologica;

import java.util.ArrayList;
import java.util.List;

public class ListadoDeUsuarios {
  private List<Usuario> usuarios = new ArrayList<>();

  public ListadoDeUsuarios(List<Usuario> usuarios) {
    if(usuarios != null)
      this.usuarios.addAll(usuarios);
  }

  public void realizarAccionesParaTodosSegun(AlertaMeteorologica alertaMeteorologica) {
    this.usuarios.forEach(
        usuario ->
            usuario.realizarAccionesSegun(alertaMeteorologica)
    );
  }

  public void calcularSugerenciaDiaria() {
    this.usuarios.forEach(
        Usuario::calcularSugerenciaDiaria
    );
  }
}
