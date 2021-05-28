package ar.edu.utn.frba.dds.serviciosMeteorologicos;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

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
    HashMap<String, Object> temperature = (HashMap<String, Object>) response.get("Temperature");
    Object value = temperature.get("Value");
    Double tempValue = new Double((int) value);
    this.llamadasEnDia++;
    return new Temperatura(tempValue, UnidadTemperatura.FAHRENHEIT);
  }

  public boolean validarCantLlamads() {
    if(fechaUltimaLlamada.equals(LocalDate.now()))
      llamadasEnDia += 1;
    else
      fechaUltimaLlamada = LocalDate.now();
    return llamadasEnDia < 10;
  }
}
