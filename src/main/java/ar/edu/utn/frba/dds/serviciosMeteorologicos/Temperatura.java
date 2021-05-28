package ar.edu.utn.frba.dds.serviciosMeteorologicos;

public class Temperatura {
    private double digito;
    private UnidadTemperatura unidad;

    public Temperatura(double digito, UnidadTemperatura unidad) {
        this.digito = digito;
        this.unidad = unidad;
    }

    public boolean esMayor(Temperatura temperatura) {
        if(this.unidad.equals(temperatura.getUnidad()))
            return this.digito > temperatura.getDigito();
        return this.toFarenheit() > temperatura.toFarenheit();
    }

    private double toFarenheit() {
        if(this.unidad.equals(UnidadTemperatura.CELSIUS))
            return this.digito*1.8+32;
        return 1.8*(this.digito-273) + 32;
    }

    public double getDigito() { return digito; }
    public UnidadTemperatura getUnidad() { return unidad; }
}
