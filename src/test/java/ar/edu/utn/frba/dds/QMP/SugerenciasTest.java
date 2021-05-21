package ar.edu.utn.frba.dds.QMP;

import ar.edu.utn.frba.dds.QMP.prenda.Prenda;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class SugerenciasTest {

    @Test
    public void dosPrendasPorCategoriaPrimariasGeneran8Atuendos() {
        //GeneradorDeSugerencias generador = Mockito.mock(GeneradorDeSugerencias.class);
        GeneradorDeSugerencias generador = new GeneradorDeSugerencias();
        Prenda prenda = Mockito.mock(Prenda.class);
        Prenda prenda2 = Mockito.mock(Prenda.class);
        Set<Prenda> prendas = new HashSet<>();
        prendas.add(prenda);prendas.add(prenda2);
        assertEquals(generador
                .combinacionPrendasPrimarias(prendas,prendas,prendas).size(),8);
    }

    @Test
    public void dosPrendasPorCategoriaConAccesoriosGeneran16Atuendos() {
        //GeneradorDeSugerencias generador = Mockito.mock(GeneradorDeSugerencias.class);
        GeneradorDeSugerencias generador = new GeneradorDeSugerencias();
        Prenda prenda = Mockito.mock(Prenda.class);
        Prenda prenda2 = Mockito.mock(Prenda.class);
        Set<Prenda> prendas = new HashSet<>();
        prendas.add(prenda);prendas.add(prenda2);
        assertEquals(generador
                .sugerenciaUnaPorCategoria(prendas,prendas,prendas,prendas).size(),16);
    }

    @Test
    public void dosPrendasPorCategoriaCon2AccesoriosYMaximoEnAtuendo2Generan16AtuendosConAccesorios() {
        //GeneradorDeSugerencias generador = Mockito.mock(GeneradorDeSugerencias.class);
        GeneradorDeSugerencias generador = new GeneradorDeSugerencias();
        Prenda prenda = Mockito.mock(Prenda.class);
        Prenda prenda2 = Mockito.mock(Prenda.class);
        Set<Prenda> prendas = new HashSet<>();
        prendas.add(prenda);prendas.add(prenda2);
        assertEquals(generador
                .generarSugerenciaConAccesorios(prendas,prendas,prendas,prendas,1).size(),8);
    }
}
