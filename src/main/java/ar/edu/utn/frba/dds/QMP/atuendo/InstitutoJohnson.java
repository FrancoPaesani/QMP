package ar.edu.utn.frba.dds.QMP.atuendo;

import ar.edu.utn.frba.dds.QMP.prenda.Color;
import ar.edu.utn.frba.dds.QMP.prenda.Material;
import ar.edu.utn.frba.dds.QMP.prenda.Prenda;
import ar.edu.utn.frba.dds.QMP.prenda.Tipo;

public class InstitutoJohnson extends Atuendo{

    public InstitutoJohnson(Prenda prendaSuperior, Prenda prendaInferior, Prenda calzado) {
        super(prendaSuperior, prendaInferior, calzado);
    }

    public static Atuendo crearUniforme() { return new Atuendo(crearPrendaSuperior(),crearPrendaInferior(),crearCalzado()); }
    private static Prenda crearPrendaSuperior() {
        return Prenda
                .tipo(Tipo.CAMISA)
                .setMaterial(Material.ALGODON)
                .setColorPrincipal(new Color("#ffffff"))
                .build();
    }
    private static Prenda crearPrendaInferior() {
        return Prenda
                .tipo(Tipo.PANTALON)
                .setMaterial(Material.ALGODON)
                .setColorPrincipal(new Color("#000000"))
                .build();
    }
    private static Prenda crearCalzado() {
        return Prenda
                .tipo(Tipo.ZAPATOS)
                .setMaterial(Material.CUERO)
                .setColorPrincipal(new Color("#000000"))
                .build();
    }
}
