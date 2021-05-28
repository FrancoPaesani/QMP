package ar.edu.utn.frba.dds.QMP;

import ar.edu.utn.frba.dds.QMP.atuendo.Atuendo;
import ar.edu.utn.frba.dds.QMP.atuendo.InstitutoJohnson;
import ar.edu.utn.frba.dds.QMP.prenda.*;
import ar.edu.utn.frba.dds.QMP.usuario.Guardarropas;
import ar.edu.utn.frba.dds.QMP.usuario.Usuario;
import ar.edu.utn.frba.dds.serviciosMeteorologicos.Temperatura;
import ar.edu.utn.frba.dds.serviciosMeteorologicos.UnidadTemperatura;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class UsuarioTest {
  private Guardarropas guardarropas = mock(Guardarropas.class);
  private GeneradorDeSugerencias generadorDeSugerencias = mock(GeneradorDeSugerencias.class);
  private Atuendo atuendoInstituto = InstitutoJohnson.crearUniforme();
  private Temperatura temperatura20F = new Temperatura(20, UnidadTemperatura.FAHRENHEIT);
  private Temperatura temperatura15F = new Temperatura(15, UnidadTemperatura.FAHRENHEIT);

  @BeforeEach
  public void initGuardarropas() {
    guardarropas = mock(Guardarropas.class);
    generadorDeSugerencias = mock(GeneradorDeSugerencias.class);
  }

  @Test
  public void SugerenciaParaUsuarioConUnGuardarropasLollamaUnaVez() {
    Usuario fran = new Usuario(null,generadorDeSugerencias);
    fran.agregarGuardarropas(guardarropas);
    fran.getSugerenciaParaTemperatura(temperatura20F);

    verify(guardarropas,times(1)).sugerenciaParaTemperatura(any(),any());
  }

  @Test
  public void SugerenciaParaUsuarioConUnGuardarropasDevuelveUnSetDeAtuendos() {
    when(guardarropas.sugerenciaParaTemperatura(any(Temperatura.class),
        any(GeneradorDeSugerencias.class))).thenReturn(new HashSet<>(Arrays.asList(atuendoInstituto)));

    Usuario fran = new Usuario(null,generadorDeSugerencias);
    fran.agregarGuardarropas(guardarropas);

    assertEquals(fran.getSugerenciaParaTemperatura(temperatura20F).size(),1);
  }

    @Test
  public void PuedoCompartirMiGuardarropasConUnAmigo() {
    Usuario fran = new Usuario(null,generadorDeSugerencias);
    fran.agregarGuardarropas(guardarropas);
    Usuario tomi = new Usuario(null,generadorDeSugerencias);

    fran.compartirGuardarropasCon(tomi,guardarropas);
    assertEquals(tomi.cantidadDeGuardarropas(),1);
  }
}
