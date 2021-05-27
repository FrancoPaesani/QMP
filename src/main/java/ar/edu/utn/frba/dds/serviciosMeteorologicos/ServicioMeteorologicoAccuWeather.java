package ar.edu.utn.frba.dds.serviciosMeteorologicos;

import ar.edu.utn.frba.dds.QMP.prenda.UnidadTemperatura;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ServicioMeteorologicoAccuWeather implements ServicioMeteorologico{
  private AccuWeatherAPI api;
  private int llamadasEnDia = 0;
  private LocalDate fechaUltimaLlamada = LocalDate.now();

  public ServicioMeteorologicoAccuWeather(AccuWeatherAPI api) {
    this.api = api;
  }
  @Override
  public Temperatura getTemperatura(String ciudad) {
    Map<String ,Object> response = api.getWeather(ciudad).get(0);
    return new Temperatura((double) response.get("Temperatura"), UnidadTemperatura.FAHRENHEIT);
  }

  public boolean validarCantLlamads() {
    if(fechaUltimaLlamada.equals(LocalDate.now()))
      llamadasEnDia += 1;
    else
      fechaUltimaLlamada = LocalDate.now();
    return llamadasEnDia < 10;
  }
}
