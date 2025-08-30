public class CriterioMarca implements CriterioBusca {
    public boolean testar(Produto p, String valor) {
        return p.getDescricao().contains(valor);
    }
}