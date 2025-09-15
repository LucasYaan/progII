import java.util.List;
import java.util.Scanner;
import java.math.BigDecimal;

public class App {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:postgresql://aws-1-sa-east-1.pooler.supabase.com:6543/postgres?user=postgres.ccapgwvpnjgbirhlektm&password=IGKqXWUwyIEtumZT";
        ContaDao dao = new ContaDao(ConnectionFactory.getConnection(url));
        Scanner sc = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("(1) Listar todas as contas");
            System.out.println("(2) Buscar uma conta específica pelo número");
            System.out.println("(3) Criar uma nova conta");
            System.out.println("(4) Alterar o saldo de uma conta");
            System.out.println("(5) Apagar uma conta");
            System.out.println("(0) Sair");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    List<Conta> contas = dao.lerTodas();
                    for (Conta conta : contas) {
                        System.out.println(conta);
                    }
                    break;

                case 2:
                    System.out.print("Número da conta: ");
                    long nroBusca = sc.nextLong();
                    Conta c1 = dao.buscarPeloNumero(nroBusca);
                    if (c1 != null) {
                        System.out.println(c1);
                    } else {
                        System.out.println("Conta não encontrada!");
                    }
                    break;

                case 3:
                    System.out.print("Número da conta: ");
                    long nro = sc.nextLong();
                    System.out.print("Saldo inicial: ");
                    BigDecimal saldo = sc.nextBigDecimal();
                    Conta nova = new Conta(nro, saldo);
                    if (dao.criar(nova)) {
                        System.out.println("Conta criada!");
                    } else {
                        System.out.println("Erro ao criar conta!");
                    }
                    break;

                case 4:
                    System.out.print("Número da conta: ");
                    long nroAlt = sc.nextLong();
                    System.out.print("Novo saldo: ");
                    BigDecimal novoSaldo = sc.nextBigDecimal();
                    Conta c2 = new Conta(nroAlt, novoSaldo);
                    if (dao.atualizar(c2)) {
                        System.out.println("Conta atualizada!");
                    } else {
                        System.out.println("Erro ao atualizar!");
                    }
                    break;

                case 5:
                    System.out.print("Número da conta: ");
                    long nroDel = sc.nextLong();
                    Conta c3 = new Conta(nroDel, BigDecimal.ZERO);
                    if (dao.apagar(c3)) {
                        System.out.println("Conta apagada!");
                    } else {
                        System.out.println("Erro ao apagar!");
                    }
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        sc.close();
    }
}