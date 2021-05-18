package ar.edu.utn.frba.dds.QMP.uniforme;

import ar.edu.utn.frba.dds.QMP.Color;
import ar.edu.utn.frba.dds.QMP.Material;
import ar.edu.utn.frba.dds.QMP.Prenda;
import ar.edu.utn.frba.dds.QMP.Tipo;

public class InstitutoJohnson extends CasaDeUniformes{

    @Override
    public Uniforme crearUniforme() {
        return new Uniforme(crearPrendaSuperior(),crearPrendaInferior(),crearCalzado());
    }
    private Prenda crearPrendaSuperior() {
        return Prenda
                .tipo(Tipo.CAMISA)
                .setMaterial(Material.ALGODON)
                .setColorPrincipal(new Color("#ffffff"))
                .build();
    }
    private Prenda crearPrendaInferior() {
        return Prenda
                .tipo(Tipo.PANTALON)
                .setMaterial(Material.ALGODON)
                .setColorPrincipal(new Color("#000000"))
                .build();
    }
    private Prenda crearCalzado() {
        return Prenda
                .tipo(Tipo.ZAPATOS)
                .setMaterial(Material.CUERO)
                .setColorPrincipal(new Color("#000000"))
                .build();
    }
}
