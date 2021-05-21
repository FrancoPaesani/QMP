package ar.edu.utn.frba.dds.QMP;

import ar.edu.utn.frba.dds.QMP.prenda.Temperatura;
import ar.edu.utn.frba.dds.QMP.prenda.UnidadTemperatura;
import org.junit.Assert;
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
}