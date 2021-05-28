package ar.edu.utn.frba.dds.QMP;

import ar.edu.utn.frba.dds.QMP.atuendo.Atuendo;
import ar.edu.utn.frba.dds.QMP.atuendo.ColegioSanJuan;
import ar.edu.utn.frba.dds.QMP.atuendo.InstitutoJohnson;
import ar.edu.utn.frba.dds.QMP.prenda.*;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class AtuendoTest {
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
    Prenda gorrita = Prenda
            .tipo(Tipo.GORRA)
            .setMaterial(Material.JEAN)
            .setColorPrincipal(new Color("#00000"))
            .build();
    Prenda muniequera = Prenda
            .tipo(Tipo.MUNIEQUERA)
            .setMaterial(Material.CUERO)
            .setColorPrincipal(new Color("#00000"))
            .build();

    @Test
    public void unAtuendoTienePrendaInferior() {
        Atuendo conjunto = new Atuendo(remeraComun,pantalonComun,zapatosComun);
        assertEquals(conjunto.getPrendaInferior(),pantalonComun);
    }

    @Test
    public void unAtuendoConGorroYMuniequeraTiene2Accesorios() {
        Atuendo conjunto = new Atuendo(remeraComun,pantalonComun,zapatosComun, Arrays.asList(gorrita,muniequera));
        assertEquals(conjunto.getAccesorios().size(),2);
    }

    @Test
    public void uniformeJohnsonTieneZapatosNegros() {
        Atuendo uniformeJohnson = InstitutoJohnson.crearUniforme();
        assertEquals(uniformeJohnson.getCalzado().getColorPrincipal().getRgb(),new Color("#000000").getRgb());
    }

    @Test
    public void uniformeSanJuanTieneChombaPique() {
        Atuendo uniformeSanJuan = ColegioSanJuan.crearUniforme();
        assertEquals(uniformeSanJuan.getPrendaSuperior().getMaterial(), Material.PIQUE);
    }
}
