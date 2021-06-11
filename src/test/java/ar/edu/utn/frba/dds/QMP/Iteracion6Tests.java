package ar.edu.utn.frba.dds.QMP;

import ar.edu.utn.frba.dds.QMP.alertas.AlertaMeteorologica;
import ar.edu.utn.frba.dds.QMP.alertas.ListadoDeAlertas;
import ar.edu.utn.frba.dds.QMP.usuario.ListadoDeUsuarios;
import ar.edu.utn.frba.dds.QMP.usuario.Usuario;
import ar.edu.utn.frba.dds.serviciosMeteorologicos.ServicioMeteorologicoAccuWeather;
import org.junit.Test;

import java.util.Arrays;

import static org.mockito.Mockito.*;

public class Iteracion6Tests {

  @Test
  public void CalculoLasSugerenciasParaTodosConUnRepoDeUsuariosCalculaSugerenciaDiariaDeCadaUno() {
    Usuario usuario = mock(Usuario.class);
    ListadoDeUsuarios listadoDeUsuarios = new ListadoDeUsuarios(Arrays.asList(usuario));
    listadoDeUsuarios.calcularSugerenciaDiaria();
    verify(usuario,atLeastOnce()).calcularSugerenciaDiaria();
  }

  @Test
  public void ActualizarLasAlertasDisparaLasAccionesAsociadasACadaUsuario() {
    Usuario usuario1 = mock(Usuario.class);
    ServicioMeteorologicoAccuWeather api = mock(ServicioMeteorologicoAccuWeather.class);
    ListadoDeUsuarios listadoDeUsuarios = new ListadoDeUsuarios(Arrays.asList(usuario1));
    ListadoDeAlertas listadoDeAlertas = new ListadoDeAlertas(Arrays.asList(AlertaMeteorologica.TORMENTA),
        api,listadoDeUsuarios,"Buenos Aires");
    when(api.getAlertas("Buenos Aires")).thenReturn(Arrays.asList(AlertaMeteorologica.GRANIZO));
    listadoDeAlertas.actualizarAlertas();
    verify(usuario1,atLeastOnce()).realizarAccionesSegun(any());
  }
}
