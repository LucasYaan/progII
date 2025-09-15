import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContaDao implements IContaDao {
    private PreparedStatement pstmCreate;
    private PreparedStatement pstmRead;
    private PreparedStatement pstmReadByNumber;
    private PreparedStatement pstmUpdate;
    private PreparedStatement pstmDelete;

    public ContaDao(Connection c) throws Exception {
        pstmCreate = c.prepareStatement("INSERT INTO CONTAS (nro_conta, saldo) VALUES (?, ?)");
        pstmRead = c.prepareStatement("SELECT * FROM CONTAS");
        pstmReadByNumber = c.prepareStatement("SELECT * FROM CONTAS WHERE nro_conta = ?");
        pstmUpdate = c.prepareStatement("UPDATE CONTAS SET saldo = ? WHERE nro_conta = ?");
        pstmDelete = c.prepareStatement("DELETE FROM CONTAS WHERE nro_conta = ?");
    }

    @Override
    public boolean criar(Conta c) throws Exception {
        pstmCreate.setLong(1, c.getNumero());
        pstmCreate.setBigDecimal(2, c.getSaldo());
        return pstmCreate.executeUpdate() > 0;
    }

    @Override
    public List<Conta> lerTodas() throws Exception {
        List<Conta> contas = new ArrayList<>();
        ResultSet resultados = pstmRead.executeQuery();
        while (resultados.next()) {
            long n = resultados.getLong("nro_conta");
            BigDecimal s = resultados.getBigDecimal("saldo");
            Conta c = new Conta(n, s);
            contas.add(c);
        }
        return contas;
    }

    @Override
    public Conta buscarPeloNumero(long id) throws Exception {
        Conta c = null;
        pstmReadByNumber.setLong(1, id);
        ResultSet resultado = pstmReadByNumber.executeQuery();
        if (resultado.next()) {
            long n = resultado.getLong("nro_conta");
            BigDecimal s = resultado.getBigDecimal("saldo");
            c = new Conta(n, s);
        }
        return c;
    }

    @Override
    public boolean atualizar(Conta c) throws Exception {
        pstmUpdate.setBigDecimal(1, c.getSaldo());
        pstmUpdate.setLong(2, c.getNumero());
        return pstmUpdate.executeUpdate() > 0;
    }

    @Override
    public boolean apagar(Conta c) throws Exception {
        pstmDelete.setLong(1, c.getNumero());
        return pstmDelete.executeUpdate() > 0;
    }
}