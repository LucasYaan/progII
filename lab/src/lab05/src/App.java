import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        ContaDao dao;
        String url = "jdbc:postgresql://aws-1-sa-east-1.pooler.supabase.com:6543/postgres?user=postgres.ccapgwvpnjgbirhlektm&password=IGKqXWUwyIEtumZT";
        dao = new ContaDao(ConnectionFactory.getConnection(url));
        Scanner sc = new Scanner(System.in);
        List<Conta> contas;
        contas = dao.lerTodas();
        int item = sc.nextInt();

        do {
            System.out.println("(1) Listar todas as contas");
            System.out.println("(2) Buscar uma conta específica pelo número");
            System.out.println("(3) Criar uma nova conta");
            System.out.println("(4) Alterar o saldo de uma conta");
            System.out.println("(5) Apagar uma conta");
            System.out.println("(0) Sair");

            switch (item) {
                case 1:
                    System.out.println(contas);
                    break;
            
                default:
                    break;
            }
        } while (item != 0);
    }
}