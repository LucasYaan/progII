import java.util.List;

public interface IContaDao {
    boolean criar(Conta c) throws Exception;
    List<Conta> lerTodas() throws Exception;
    Conta buscarPeloNumero(long id) throws Exception;
    boolean atualizar(Conta c) throws Exception;
    boolean apagar(Conta c) throws Exception;
}