package ar.edu.utn.frba.dds.serviciosMeteorologicos;

import ar.edu.utn.frba.dds.QMP.alertas.AlertaMeteorologica;

import java.util.List;
import java.util.Map;

public interface Api {
  public List<Map<String, Object>> getWeather(String ciudad);
  //TODO: no sería alertas
  public List<AlertaMeteorologica> getAlertas(String ciudad);
}
