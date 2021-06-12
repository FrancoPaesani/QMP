package ar.edu.utn.frba.dds.QMP;

import ar.edu.utn.frba.dds.QMP.usuario.Guardarropas;
import ar.edu.utn.frba.dds.QMP.prenda.*;
import ar.edu.utn.frba.dds.serviciosMeteorologicos.Temperatura;
import ar.edu.utn.frba.dds.serviciosMeteorologicos.UnidadTemperatura;
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
        Set<Prenda> setPrendas = new HashSet<>(Arrays.asList(remeraComun, pantalonComun));
        Guardarropas guardarropas = new Guardarropas(new HashSet<>());
        assertEquals(guardarropas
                .prendasParaTemperatura(setPrendas, tempActual).size(),1);
    }

    @Test
    public void NoGeneraSugerenciaSiFaltaAlgunaCategoria() {
        Set<Prenda> prendas = new HashSet<>(Arrays.asList(remeraComun, pantalonComun));
        Guardarropas guardarropas =
                new Guardarropas(prendas);
        GeneradorDeSugerencias generadorDeSugerencias = new GeneradorDeSugerencias();
        assertEquals(guardarropas.sugerenciaParaTemperatura(tempActual,generadorDeSugerencias)
                .size(), 0);
    }
}
