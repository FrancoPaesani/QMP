package ar.edu.utn.frba.dds.QMP;

import ar.edu.utn.frba.dds.QMP.prenda.Prenda;
import ar.edu.utn.frba.dds.QMP.usuario.Guardarropas;
import ar.edu.utn.frba.dds.QMP.usuario.Usuario;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class SugerenciasTest {

    @Test
    public void dosPrendasPorCategoriaPrimariasGeneran8Atuendos() {
        //GeneradorDeSugerencias generador = Mockito.mock(GeneradorDeSugerencias.class);
        GeneradorDeSugerencias generador = new GeneradorDeSugerencias();
        Prenda prenda = mock(Prenda.class);
        Prenda prenda2 = mock(Prenda.class);
        Set<Prenda> prendas = new HashSet<>();
        prendas.add(prenda);prendas.add(prenda2);
        assertEquals(generador
                .combinacionPrendasPrimarias(prendas,prendas,prendas).size(),8);
    }

    @Test
    public void dosPrendasPorCategoriaConAccesoriosGeneran16Atuendos() {
        //GeneradorDeSugerencias generador = Mockito.mock(GeneradorDeSugerencias.class);
        GeneradorDeSugerencias generador = new GeneradorDeSugerencias();
        Prenda prenda = mock(Prenda.class);
        Prenda prenda2 = mock(Prenda.class);
        Set<Prenda> prendas = new HashSet<>();
        prendas.add(prenda);prendas.add(prenda2);
        assertEquals(generador
                .sugerenciaUnaPorCategoria(prendas,prendas,prendas,prendas).size(),16);
    }

    @Test
    public void dosPrendasPorCategoriaCon2AccesoriosYMaximoEnAtuendo2Generan16AtuendosConAccesorios() {
        //GeneradorDeSugerencias generador = Mockito.mock(GeneradorDeSugerencias.class);
        GeneradorDeSugerencias generador = new GeneradorDeSugerencias();
        Prenda prenda = mock(Prenda.class);
        Prenda prenda2 = mock(Prenda.class);
        Set<Prenda> prendas = new HashSet<>();
        prendas.add(prenda);prendas.add(prenda2);
        assertEquals(generador
                .generarSugerenciaConAccesorios(prendas,prendas,prendas,prendas,1).size(),8);
    }

    @Test
    public void GetSugerenciaDiariaUtilizaLaSugerenciaDelGuardarropas() {
        ArrayList<Guardarropas> guardarropas = new ArrayList<>();
        Usuario usuario = new Usuario(guardarropas,new GeneradorDeSugerencias());
        Guardarropas guardarropa = mock(Guardarropas.class);
        usuario.agregarGuardarropas(guardarropa);
        usuario.calcularSugerenciaDiaria();
        verify(guardarropa,atLeastOnce()).getSugerencia(any());
    }
}
