package ar.edu.utn.frba.dds.QMP;
import org.junit.Test;
import static org.junit.Assert.*;


public class PrendaBuilderTest {

  @Test
  public void RemeraDeAlgodonDeColorRojoTieneCategoriaPrenda_Superior() {
    Prenda prenda = Prenda.tipo(Tipo.REMERA)
        .setMaterial(Material.ALGODON)
        .setColorPrincipal(ColorEnum.ROJO)
        .build();
    assertEquals(prenda.getCategoria().toString(),"PRENDA_SUPERIOR");
  }

  @Test
  public void noPuedoCrearRemeraSinMaterial() {
    try {
      Prenda prenda = Prenda
          .tipo(Tipo.REMERA)
          .setColorPrincipal(ColorEnum.AZUL)
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
            .setMaterial(Material.LANA)
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
          .setMaterial(Material.LANA)
          .build();
    } catch (CamposObligatoriosIncompletosException exception) {
      assertTrue(exception.getMessage().contains("La prenda debe tener por lo menos un tipo, material y color principal."));
    }
  }

  @Test
  public void usuarioAgregaAGuardarropasPantalonDeAlgodonDeColorAzul() {
    Usuario pepe = new Usuario();
    pepe.agregarPrenda(
        Prenda
        .tipo(Tipo.PANTALON)
        .setMaterial(Material.ALGODON)
        .setColorPrincipal(ColorEnum.AZUL)
        .build()
    );
    assertEquals(pepe.getGuardarropa().getPrendas().size(),1);
  }
}
