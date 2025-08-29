import java.util.Scanner;

public class AppStreaming {
    public static void main(String[] args) throws Exception {
        List<Midia> midias = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("(1) Adicionar novo Filme.");
            System.out.println("(2) Adicionar nova Série.");
            System.out.println("(3) Listar todas as mídias.");
            System.out.println("(4) Sair.");

            item = sc.nextInt();

            switch (item) {
                case 1:
                    System.out.println("Qual o título do filme?");   
                    filme = sc.nextLine();
                    System.out.println("Qual a duração do filme?");   
                    filmeDuracao = sc.nextLong();
                    Midia novoFilme = new Filme(filme, filmeDuracao);
                    midias.add(novoFilme);
                    break;
                case 2:
                    System.out.println("Qual o título da série?");
                    serie = sc.nextLine();
                    System.out.println("Quantas temporadas você quer adicionar?");
                    temporadas = sc.nextInt();
                    Midia serie = new Serie(serie, temporadas);


                    
                    System.out.println("Você deseja adicionar um episódio? (digite s ou n)");
                    resposta = sc.nextLine();
                    if (resposta == "s") {
                        for (String temporada : temporadas) {
                            for (String episodio : temp) {
                                System.out.println("Qual o nome deste episódio?");
                                episodioNome = sc.nextLine();
                            }
                        }
                    }
                    


                    }
                    break;
            
                default:
                    break;
            }
        } while (condition);









        //Não funciona porque classes abstratas não podem ser instanciadas
        //Midia midia = new Midia("A volta dos que não foram");
        //System.out.println(midia.info());

        /**
        Midia midia = new Filme("Titanic 2 and Knuckles", 300);
        System.out.println(midia.info());
        System.out.println(midia.getDuracao());

        Temporada temporada = new Temporada(1);
        temporada.adicionar(new Episodio("Piloto", 60));
        temporada.adicionar(new Episodio("Surpresa", 45));
        temporada.adicionar(new Episodio("Continuação", 30));
        System.out.println(temporada.info());
        System.out.println(temporada.getDuracao());  **/
    }
}