package ar.edu.utn.frba.dds.QMP.uniforme;
import ar.edu.utn.frba.dds.QMP.*;

public class ColegioSanJuan extends CasaDeUniformes{
    @Override
    public Uniforme crearUniforme() {
        return new Uniforme(crearPrendaSuperior(),crearPrendaInferior(),crearCalzado());
    }
    private Prenda crearPrendaSuperior() {
        return Prenda
                .tipo(Tipo.CHOMBA)
                .setMaterial(Material.PIQUE)
                .setColorPrincipal(new Color("#03fc52"))
                .build();
    }
    private Prenda crearPrendaInferior() {
        return Prenda
                .tipo(Tipo.PANTALON)
                .setMaterial(Material.ACETATO)
                .setColorPrincipal(new Color("#808080"))
                .build();
    }
    private Prenda crearCalzado() {
        return Prenda
                .tipo(Tipo.ZAPATILLAS)
                .setMaterial(Material.ALGODON)
                .setColorPrincipal(new Color("#ffffff"))
                .build();
    }
}
