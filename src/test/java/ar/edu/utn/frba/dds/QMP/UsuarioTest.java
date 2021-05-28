package ar.edu.utn.frba.dds.QMP;

import ar.edu.utn.frba.dds.QMP.atuendo.Atuendo;
import ar.edu.utn.frba.dds.QMP.atuendo.InstitutoJohnson;
import ar.edu.utn.frba.dds.QMP.prenda.*;
import ar.edu.utn.frba.dds.QMP.usuario.*;
import ar.edu.utn.frba.dds.serviciosMeteorologicos.Temperatura;
import ar.edu.utn.frba.dds.serviciosMeteorologicos.UnidadTemperatura;
import org.junit.Assert;
import org.junit.Test;
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

  @Test
  public void PuedoAgregarUnaPrendaACualquierGuardarropa() {
    Usuario fran = new Usuario(null,generadorDeSugerencias);
    Guardarropas guardarropasPropuesto = new Guardarropas(null,null);

    fran.agregarGuardarropas(guardarropasPropuesto);
    fran.agregarPrendaAGuardarropas(guardarropasPropuesto,mock(Prenda.class));

    assertEquals(guardarropasPropuesto.cantidadDePrendas(),1);
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

  @Test
  public void PuedoAgregarPropuestaDeAgregarAAlguien() {
    Usuario fran = new Usuario(null,generadorDeSugerencias);
    Usuario ale = new Usuario(null,generadorDeSugerencias);

    fran.agregarPropuestaDeAgregarA(ale,mock(Prenda.class),guardarropas);
    assertEquals(ale.cantidadDePropuestas(),1);
  }

  @Test
  public void AlguienAceptaPropuestaDeAgregarPrendaEnUnoVacioYLuegoTieneUnaPrenda() {
    Usuario fran = new Usuario(null,generadorDeSugerencias);
    Usuario ale = new Usuario(null,generadorDeSugerencias);
    Guardarropas guardarropasPropuesto = new Guardarropas(null,null);

    ale.agregarGuardarropas(guardarropasPropuesto);

    fran.agregarPropuestaDeAgregarA(ale,mock(Prenda.class),guardarropasPropuesto);
    ale.aceptarPropuestas();

    assertEquals(guardarropasPropuesto.cantidadDePrendas(),1);
  }

  @Test
  public void PuedoAgregarPropuestaDeSacarAAlguien() {
    Usuario fran = new Usuario(null,generadorDeSugerencias);
    Usuario ale = new Usuario(null,generadorDeSugerencias);

    fran.agregarPropuestaDeSacarA(ale,mock(Prenda.class),guardarropas);
    assertEquals(ale.cantidadDePropuestas(),1);
  }

  @Test
  public void AlguienAceptaPropuestaDeSacarPrendaEnUnoConUnaPredaYLuegoEstaVacio() {
    Prenda prendaMock = mock(Prenda.class);

    Usuario fran = new Usuario(null,generadorDeSugerencias);
    Usuario ale = new Usuario(null,generadorDeSugerencias);
    Guardarropas guardarropasPropuesto = new Guardarropas(null,null);

    ale.agregarGuardarropas(guardarropasPropuesto);
    guardarropasPropuesto.agregarPrenda(prendaMock);

    fran.agregarPropuestaDeSacarA(ale,prendaMock,guardarropasPropuesto);
    ale.aceptarPropuestas();

    assertEquals(guardarropasPropuesto.cantidadDePrendas(),0);
  }

  @Test
  public void PuedoRechazarLasPropuestasQueTenga() {
    Usuario fran = new Usuario(null,generadorDeSugerencias);
    Usuario ale = new Usuario(null,generadorDeSugerencias);

    fran.agregarPropuestaDeSacarA(ale,mock(Prenda.class),guardarropas);
    fran.agregarPropuestaDeAgregarA(ale,mock(Prenda.class),guardarropas);

    ale.rechazarPropuestas();

    assertEquals(ale.cantidadDePropuestas(),0);
  }

  @Test
  public void PuedoRechazarLasPropuestasQueAcepteParaVolverAlEstadoAnteriorDelGuardarropas() {
    Prenda prendaMock1 = mock(Prenda.class);
    Prenda prendaMock2 = mock(Prenda.class);

    Usuario fran = new Usuario(null,generadorDeSugerencias);
    Usuario ale = new Usuario(null,generadorDeSugerencias);
    Guardarropas guardarropasPropuesto = new Guardarropas(null,null);

    ale.agregarGuardarropas(guardarropasPropuesto);
    fran.agregarPropuestaDeAgregarA(ale,prendaMock1,guardarropasPropuesto);
    fran.agregarPropuestaDeAgregarA(ale,prendaMock2,guardarropasPropuesto);

    ale.aceptarPropuestas();
    ale.deshacerPropuestasAceptadas();

    assertEquals(guardarropasPropuesto.cantidadDePrendas(),0);
  }
}
