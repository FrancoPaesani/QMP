package ar.edu.utn.frba.dds.QMP;
import ar.edu.utn.frba.dds.QMP.excepciones.CamposObligatoriosIncompletosException;
import ar.edu.utn.frba.dds.QMP.excepciones.MaterialYTipoIncompatiblesException;
import ar.edu.utn.frba.dds.QMP.uniforme.ColegioSanJuan;
import ar.edu.utn.frba.dds.QMP.uniforme.InstitutoJohnson;
import ar.edu.utn.frba.dds.QMP.uniforme.Uniforme;
import org.junit.Test;
import static org.junit.Assert.*;


public class PrendaBuilderTest {
  Prenda remeraComun = Prenda
      .tipo(Tipo.REMERA)
      .setMaterial(Material.ALGODON)
      .setTrama(Trama.A_CUADROS)
      .setColorPrincipal(new Color("#00000"))
      .build();
  Prenda pantalonComun = Prenda
      .tipo(Tipo.PANTALON)
      .setMaterial(Material.CUERO)
      .setTrama(Trama.A_CUADROS)
      .setColorPrincipal(new Color("#00000"))
      .build();
  Prenda zapatosComun = Prenda
      .tipo(Tipo.ZAPATOS)
      .setMaterial(Material.CUERO)
      .setTrama(Trama.A_CUADROS)
      .setColorPrincipal(new Color("#00000"))
      .build();

  @Test
  public void RemeraDeAlgodonDeColorNegraTieneCategoriaPrenda_Superior() {
    Prenda prenda = Prenda.tipo(Tipo.REMERA)
        .setMaterial(Material.ALGODON)
        .setColorPrincipal(new Color("#ffffff"))
        .build();
    assertEquals(prenda.getCategoria().toString(),"PRENDA_SUPERIOR");
  }

  @Test
  public void noPuedoCrearRemeraSinMaterial() {
    try {
      Prenda prenda = Prenda
          .tipo(Tipo.REMERA)
          .setColorPrincipal(new Color("#ffffff"))
          .build();
    } catch (NullPointerException exception) {
      assertTrue(exception.getMessage().contains("La prenda debe tener un material."));
    }
  }

    @Test
    public void noPuedoCrearRemeraSinColorPrincipal() {
      try {
        Prenda prenda = Prenda
            .tipo(Tipo.REMERA)
            .setMaterial(Material.ALGODON)
            .build();
      } catch (NullPointerException exception) {
        assertTrue(exception.getMessage().contains("La prenda debe tener un color principal."));
      }
    }

  @Test
  public void noPuedoCrearRemeraSinTipo() {
    try {
      Prenda prenda = Prenda
          .tipo(null)
          .setMaterial(Material.LANA)
          .build();

    } catch (CamposObligatoriosIncompletosException exception) {
      assertTrue(exception.getMessage().contains("La prenda debe tener un tipo."));
    }
  }

  @Test
  public void remeraNegraDeAlgodonSinTramaEsLisa() {
    Prenda remeraNegra = Prenda
        .tipo(Tipo.REMERA)
        .setMaterial(Material.ALGODON)
        .setColorPrincipal(new Color("#ffffff"))
        .build();
    assertEquals(remeraNegra.getTrama(),Trama.LISA);
  }

  @Test
  public void puedoCrearUnPantalonBlancoACuadros() {
    Prenda remeraNegra = Prenda
        .tipo(Tipo.PANTALON)
        .setMaterial(Material.JEAN)
        .setTrama(Trama.A_CUADROS)
        .setColorPrincipal(new Color("#00000"))
        .setColorSecundario(new Color("#99dd77"))
        .build();
    assertEquals(remeraNegra.getTrama(),Trama.A_CUADROS);
  }

  @Test
  public void unaRemeraNoPuedeSerDeMaterialJean() {
    try {
      Prenda
              .tipo(Tipo.REMERA)
              .setMaterial(Material.JEAN);
    }
    catch (MaterialYTipoIncompatiblesException exception) {
      assertTrue(exception.getMessage().contains("El tipo [REMERA] no permite al material [JEAN]"));
    }
  }

  @Test
  public void uniformeJohnsonTieneZapatosNegros() {
    Uniforme uniformeJohnson = new InstitutoJohnson().crearUniforme();
    assertEquals(uniformeJohnson.getCalzado().getColorPrincipal().getRgb(),new Color("#000000").getRgb());
  }

  @Test
  public void uniformeSanJuanTieneChombaPique() {
    Uniforme uniformeSanJuan = new ColegioSanJuan().crearUniforme();
    assertEquals(uniformeSanJuan.getPrendaSuperior().getMaterial(),Material.PIQUE);
  }

}
