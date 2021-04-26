package ar.edu.utn.frba.dds.QMP;
import org.junit.Test;
import static org.junit.Assert.*;


public class PrendaBuilderTest {
  final Material tela  = new Material();
  final Material lana  = new Material();
  final Material algodon  = new Material();
  final Material jean = new Material();

  @Test
  public void RemeraDeAlgodonDeColorNegraTieneCategoriaPrenda_Superior() {
    Prenda prenda = Prenda.tipo(Tipo.REMERA)
        .setMaterial(algodon)
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
    } catch (CamposObligatoriosIncompletosException exception) {
      assertTrue(exception.getMessage().contains("La prenda debe tener por lo menos un tipo, material y color principal."));
    }
  }

    @Test
    public void noPuedoCrearRemeraSinColorPrincipal() {
      try {
        Prenda prenda = Prenda
            .tipo(Tipo.REMERA)
            .setMaterial(lana)
            .build();
      } catch (CamposObligatoriosIncompletosException exception) {
        assertTrue(exception.getMessage().contains("La prenda debe tener por lo menos un tipo, material y color principal."));
      }
    }

  @Test
  public void noPuedoCrearRemeraSinTipo() {
    try {
      Prenda prenda = Prenda
          .tipo(null)
          .setMaterial(lana)
          .build();

    } catch (CamposObligatoriosIncompletosException exception) {
      assertTrue(exception.getMessage().contains("La prenda debe tener un tipo."));
    }
  }

  @Test
  public void remeraNegraDeAlgodonSinTramaEsLisa() {
    Prenda remeraNegra = Prenda
        .tipo(Tipo.REMERA)
        .setMaterial(algodon)
        .setColorPrincipal(new Color("#ffffff"))
        .build();
    assertEquals(remeraNegra.getTrama(),Trama.LISA);
  }

  @Test
  public void puedoCrearUnPantalonBlancoACuadros() {
    Prenda remeraNegra = Prenda
        .tipo(Tipo.PANTALON)
        .setMaterial(jean)
        .setTrama(Trama.A_CUADROS)
        .setColorPrincipal(new Color("#00000"))
        .build();
    assertEquals(remeraNegra.getTrama(),Trama.A_CUADROS);
  }


}
