package ar.edu.utn.frba.dds.QMP;

import ar.edu.utn.frba.dds.QMP.excepciones.NoSeDeshacePropuestaNoAceptada;
import ar.edu.utn.frba.dds.QMP.prenda.Prenda;
import ar.edu.utn.frba.dds.QMP.usuario.EstadoPropuesta;
import ar.edu.utn.frba.dds.QMP.usuario.Guardarropas;
import ar.edu.utn.frba.dds.QMP.usuario.Propuesta;
import ar.edu.utn.frba.dds.QMP.usuario.PropuestaAgregar;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.verification.VerificationMode;

import static org.mockito.Mockito.*;

public class PropuestaTest {

  private Prenda prenda = mock(Prenda.class);
  private Guardarropas guardarropas = mock(Guardarropas.class);

  @Test
  public void SiAceptoUnaPropuestaCambiaSuEstadoAAceptado() {
    Propuesta propuesta = new PropuestaAgregar(prenda,guardarropas);
    propuesta.aceptarPropuesta();
    Assert.assertEquals(propuesta.getEstado(), EstadoPropuesta.ACEPTADO);
  }

  @Test
  public void SiAceptoUnaPropuestaYLaDeshagoCambiaSuEstadoAPendiente() {
    Propuesta propuesta = new PropuestaAgregar(prenda,guardarropas);
    propuesta.aceptarPropuesta();
    propuesta.deshacerPropuesta();
    Assert.assertEquals(propuesta.getEstado(), EstadoPropuesta.PENDIENTE);
  }

  @Test
  public void NoSeDeshaceUnaPropuestaNoAceptada() {
    Propuesta propuesta = new PropuestaAgregar(prenda,guardarropas);
    try {
      propuesta.deshacerPropuesta();
    }
    catch (NoSeDeshacePropuestaNoAceptada exception){
      Assert.assertEquals(
          NoSeDeshacePropuestaNoAceptada.class,exception.getClass()
      );
    }
  }
}
