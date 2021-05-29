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

    ale.agregarPropuesta(new PropuestaAgregar(mock(Prenda.class),guardarropas));
    assertEquals(ale.cantidadDePropuestas(),1);
  }

  @Test
  public void AlguienAceptaPropuestaDeAgregarPrendaEnUnoVacioYLuegoTieneUnaPrenda() {
    Usuario fran = new Usuario(null,generadorDeSugerencias);
    Usuario ale = new Usuario(null,generadorDeSugerencias);
    Guardarropas guardarropasPropuesto = new Guardarropas(null,null);

    ale.agregarGuardarropas(guardarropasPropuesto);

    ale.agregarPropuesta(new PropuestaAgregar(mock(Prenda.class),guardarropasPropuesto));
    ale.aceptarPropuestas();

    assertEquals(guardarropasPropuesto.cantidadDePrendas(),1);
  }

  @Test
  public void PuedoAgregarPropuestaDeSacarAAlguien() {
    Usuario fran = new Usuario(null,generadorDeSugerencias);
    Usuario ale = new Usuario(null,generadorDeSugerencias);

    ale.agregarPropuesta(new PropuestaSacar(mock(Prenda.class),guardarropas));
    assertEquals(ale.cantidadDePropuestas(),1);
  }

  @Test
  public void PuedoAceptarUnaPropuesta() {
    Usuario ale = new Usuario(null,generadorDeSugerencias);
    Propuesta propuesta = new PropuestaSacar(mock(Prenda.class),guardarropas);

    ale.agregarPropuesta(propuesta);
    propuesta.aceptarPropuesta();

    assertEquals(propuesta.getEstado(),EstadoPropuesta.ACEPTADO);
  }

  @Test
  public void AlguienAceptaPropuestaDeSacarPrendaEnUnoConUnaPredaYLuegoEstaVacio() {
    Prenda prendaMock = mock(Prenda.class);

    Usuario ale = new Usuario(null,generadorDeSugerencias);
    Guardarropas guardarropasPropuesto = new Guardarropas(null,null);

    ale.agregarGuardarropas(guardarropasPropuesto);
    guardarropasPropuesto.agregarPrenda(prendaMock);

    ale.agregarPropuesta(new PropuestaSacar(prendaMock,guardarropasPropuesto));
    ale.aceptarPropuestas();

    assertEquals(guardarropasPropuesto.cantidadDePrendas(),0);
  }

  @Test
  public void PuedoRechazarUnaPropuestaQueTenga() {
    Usuario ale = new Usuario(null,generadorDeSugerencias);
    Propuesta propuesta = new PropuestaSacar(mock(Prenda.class),guardarropas);

    ale.agregarPropuesta(propuesta);
    ale.agregarPropuesta(propuesta);

    ale.rechazarPropuesta(propuesta);

    assertEquals(ale.cantidadDePropuestas(),1);
  }

  @Test
  public void PuedoRechazarLasPropuestasQueAcepteParaEliminarlas() {
    Prenda prendaMock1 = mock(Prenda.class);
    Prenda prendaMock2 = mock(Prenda.class);

    Usuario ale = new Usuario(null,generadorDeSugerencias);
    Guardarropas guardarropasPropuesto = new Guardarropas(null,null);
    Propuesta propuesta1 = new PropuestaAgregar(prendaMock1,guardarropasPropuesto);
    Propuesta propuesta2 = new PropuestaAgregar(prendaMock2,guardarropasPropuesto);
    ale.agregarGuardarropas(guardarropasPropuesto);
    ale.agregarPropuesta(propuesta1);
    ale.agregarPropuesta(propuesta2);

    ale.rechazarPropuesta(propuesta1);
    ale.rechazarPropuesta(propuesta2);

    assertEquals(guardarropasPropuesto.cantidadDePrendas(),0);
  }
}
