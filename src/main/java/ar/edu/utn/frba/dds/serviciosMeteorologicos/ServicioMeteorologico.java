package ar.edu.utn.frba.dds.serviciosMeteorologicos;

import ar.edu.utn.frba.dds.QMP.alertas.AlertaMeteorologica;

import java.util.List;

public interface ServicioMeteorologico {
  public Temperatura getTemperatura(String ciudad);
  public List<AlertaMeteorologica> getAlertas(String ciudad);
}
