package ar.edu.utn.frba.dds.QMP;

import ar.edu.utn.frba.dds.serviciosMeteorologicos.Temperatura;
import ar.edu.utn.frba.dds.serviciosMeteorologicos.UnidadTemperatura;
import org.junit.Test;
import static org.junit.Assert.*;

public class TemperaturaTest {

    @Test
    public void UnCelsiusEsMayorA32FHT() {
        Temperatura celsius = new Temperatura(1, UnidadTemperatura.CELSIUS);
        Temperatura fh = new Temperatura(32, UnidadTemperatura.FAHRENHEIT);
        assertTrue(celsius.esMayor(fh));
    }

    @Test
    public void UnFHNoEsMayorQue260Kelvin() {
        Temperatura kelvin = new Temperatura(260, UnidadTemperatura.KELVIN);
        Temperatura fh = new Temperatura(1, UnidadTemperatura.FAHRENHEIT);
        assertFalse(fh.esMayor(kelvin));
    }
    @Test
    public void VeinteCelsMayora16Cels() {
        Temperatura tempActual = new Temperatura(16, UnidadTemperatura.CELSIUS);
        Temperatura temp2 = new Temperatura(20,UnidadTemperatura.CELSIUS);
        assertTrue(temp2.esMayor(tempActual));
    }

    @Test
    public void CeroCelsiusSon32F() {
        Temperatura tempC = new Temperatura(0, UnidadTemperatura.CELSIUS);
        assertEquals(tempC.toFarenheit(),32,0);
    }
}
