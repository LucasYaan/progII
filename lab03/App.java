import java.util.List;

public class App {
    static sc = new Scanner(System.in);

    static List<Produto> pesquisar(List<Produto> produtos, String valor,  CriterioBusca criterio) {
        List<Produto> resultado = new ArrayList<>();
        for (Produto p : produtos) {
            if (criterio.testar(p, valor)) resultado.add(p);
        }
        return resultado;
    }
}