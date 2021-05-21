import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main (String [ ] args) {
        List<Integer> x = new ArrayList<>();
        x.add(1);x.add(2);x.add(10);
        System.out.println(x.stream().filter(y->y<10).collect(Collectors.toList()));
        System.out.println(x);
    }
}
