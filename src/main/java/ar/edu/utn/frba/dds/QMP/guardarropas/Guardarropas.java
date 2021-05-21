package ar.edu.utn.frba.dds.QMP.guardarropas;

import ar.edu.utn.frba.dds.QMP.prenda.Prenda;
import ar.edu.utn.frba.dds.QMP.atuendo.Atuendo;
import com.google.common.collect.Sets;

import java.util.*;
import java.util.stream.Collectors;

import static com.google.common.collect.Sets.combinations;

public class Guardarropas {
    private Set<Prenda> prendasSuperiores = new HashSet<>();
    private Set<Prenda> prendasInferiores = new HashSet<>();
    private Set<Prenda> calzados = new HashSet<>();
    private Set<Prenda> accesorios = new HashSet<>();

    public Set<Atuendo> combinacionPrendasPrimarias() {
        return Sets
                .cartesianProduct(prendasSuperiores,prendasInferiores,calzados)
                .stream()
                .map((list) -> new Atuendo(list.get(0),list.get(1),list.get(2)))
                .collect(Collectors.toSet());
    }

    public Set<Atuendo> generarSugerencia(Integer maxAccesoriosUsuario) {
        Set<Atuendo> combinacion = combinacionPrendasPrimarias();
        List<Set<Prenda>> combAcc = new ArrayList<>(combinations(accesorios, maxAccesoriosUsuario));
        combinacion
                .forEach(atuendo ->
                {
                    int x = genNum(combAcc.size());
                    atuendo.agregarAccesorios(new ArrayList<>(combAcc.get(x)));
                    combAcc.remove(combAcc.get(x));
                });
        return combinacion;
    }

    private int genNum(Integer limite) { return (int) (Math.random() * limite); }
}
