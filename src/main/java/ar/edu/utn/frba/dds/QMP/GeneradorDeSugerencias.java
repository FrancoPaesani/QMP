package ar.edu.utn.frba.dds.QMP;

import ar.edu.utn.frba.dds.QMP.atuendo.Atuendo;
import ar.edu.utn.frba.dds.QMP.prenda.Prenda;
import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.google.common.collect.Sets.combinations;

public class GeneradorDeSugerencias {


    public Set<Atuendo> combinacionPrendasPrimarias(Set<Prenda> superiores,
                                                    Set<Prenda> inferiores, Set<Prenda> calzados)
    {
        return Sets
                .cartesianProduct(superiores,inferiores,calzados)
                .stream()
                .map((list) -> new Atuendo(list.get(0),list.get(1),list.get(2)))
                .collect(Collectors.toSet());
    }

    public Set<Atuendo> sugerenciaUnaPorCategoria(Set<Prenda> superiores,
                                                    Set<Prenda> inferiores, Set<Prenda> calzados, Set<Prenda> accesorios)
    {
        return Sets
                .cartesianProduct(superiores,inferiores,calzados, accesorios)
                .stream()
                .map((list) ->
                    new Atuendo(list.get(0),list.get(1),list.get(2), Arrays.asList(list.get(3)))
                )
                .collect(Collectors.toSet());
    }

    public Set<Atuendo> generarSugerenciaConAccesorios(Set<Prenda> superiores,
                                          Set<Prenda> inferiores, Set<Prenda> calzados,
                                          Set<Prenda> accesorios, Integer cantAccesoriosUsuario)
    {
        Set<Atuendo> combinacion = combinacionPrendasPrimarias(superiores,inferiores,calzados);
        List<Set<Prenda>> combAcc = new ArrayList<>(combinations(accesorios, cantAccesoriosUsuario));
        combinacion
                .forEach(atuendo ->
                {
                    int x = genNum(combAcc.size());
                    atuendo.agregarAccesorios(new ArrayList<>(combAcc.get(x)));
                });
        return combinacion;
    }

    private int genNum(Integer limite) {
        if(limite == 0)
            return 0;
        else
         return (int) Math.max((Math.random() * limite-1),0); }
}
