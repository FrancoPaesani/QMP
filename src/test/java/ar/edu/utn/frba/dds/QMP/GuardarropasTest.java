package ar.edu.utn.frba.dds.QMP;

import ar.edu.utn.frba.dds.QMP.guardarropas.Guardarropas;
import ar.edu.utn.frba.dds.QMP.prenda.*;
import ar.edu.utn.frba.dds.serviciosMeteorologicos.Temperatura;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class GuardarropasTest {
    private final Temperatura tempActual = new Temperatura(16, UnidadTemperatura.CELSIUS);

    Prenda remeraComun = Prenda
            .tipo(Tipo.REMERA)
            .setMaterial(Material.ALGODON)
            .setTrama(Trama.A_CUADROS)
            .setColorPrincipal(new Color("#00000"))
            .setTemperatura(new Temperatura(10,UnidadTemperatura.CELSIUS))
            .build();
    Prenda pantalonComun = Prenda
            .tipo(Tipo.PANTALON)
            .setMaterial(Material.CUERO)
            .setTrama(Trama.A_CUADROS)
            .setColorPrincipal(new Color("#00000"))
            .setTemperatura(new Temperatura(20,UnidadTemperatura.CELSIUS))
            .build();
    @Test
    public void UnGuardarropaFiltraPrendasDependiendoLaTemperaturaDeCadaPrendaYLaTempActual() {
        Guardarropas guardarropas = new Guardarropas(null,null,null,null);
        Set<Prenda> setPrendas = new HashSet<>(Arrays.asList(remeraComun, pantalonComun));
       assertEquals(guardarropas
                .prendasParaTemperatura(setPrendas, tempActual).size(),1);
    }

    @Test
    public void DosPrendasXCategoriaYUnaSolaAptaTemperaturaMeGenera1SoloAtuendo() {
        Set<Prenda> prendas = new HashSet<>(Arrays.asList(remeraComun, pantalonComun));
        Guardarropas guardarropas =
                new Guardarropas(prendas,prendas,prendas,prendas);
        GeneradorDeSugerencias generadorDeSugerencias = new GeneradorDeSugerencias();
        assertEquals(guardarropas.sugerenciaParaTemperatura(tempActual,generadorDeSugerencias)
                .size(), 1);
    }
}
