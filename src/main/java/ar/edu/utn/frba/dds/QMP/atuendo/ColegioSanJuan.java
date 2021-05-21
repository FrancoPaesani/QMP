package ar.edu.utn.frba.dds.QMP.atuendo;
import ar.edu.utn.frba.dds.QMP.prenda.Color;
import ar.edu.utn.frba.dds.QMP.prenda.Material;
import ar.edu.utn.frba.dds.QMP.prenda.Prenda;
import ar.edu.utn.frba.dds.QMP.prenda.Tipo;

public class ColegioSanJuan extends Atuendo{

    public ColegioSanJuan(Prenda prendaSuperior, Prenda prendaInferior, Prenda calzado) {
        super(prendaSuperior, prendaInferior, calzado);
    }

    public static Atuendo crearUniforme() { return new Atuendo(crearPrendaSuperior(),crearPrendaInferior(),crearCalzado()); }
    private static Prenda crearPrendaSuperior() {
         return Prenda
                .tipo(Tipo.CHOMBA)
                .setMaterial(Material.PIQUE)
                .setColorPrincipal(new Color("#03fc52"))
                .build();
    }
    private static Prenda crearPrendaInferior() {
        return Prenda
                .tipo(Tipo.PANTALON)
                .setMaterial(Material.ACETATO)
                .setColorPrincipal(new Color("#808080"))
                .build();
    }
    private static Prenda crearCalzado() {
        return Prenda
                .tipo(Tipo.ZAPATILLAS)
                .setMaterial(Material.ALGODON)
                .setColorPrincipal(new Color("#ffffff"))
                .build();
    }
}
