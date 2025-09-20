package ps2.titular_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import static ps2.titular_app.ES.*;

import java.util.Optional;

@SpringBootApplication
public class TitularAppApplication implements CommandLineRunner {

	@Autowired
	private TitularRepo titularrepo;

	public static void main(String[] args) {
		SpringApplication.run(TitularAppApplication.class, args);
	}

	public void criar() {
		Titular t;
		t = new Titular();
		String nome = input("Nome do novo titular: ");
		t.setNome(nome);
		String cpf = input("Nome do novo titular: ");
		t.setCpf(cpf);
		titularrepo.save(t);
		System.out.println("Titular criado com o id " + t.getId());
	}

	
	public void lerTudo() {
		Iterable<Titular> titulares = titularrepo.findAll();
		for (Titular t : titulares) {
			System.out.println(t);
		}
	}
	
	public Optional<Titular> buscarId(long id) {
		return titularrepo.findById(id);
	}

	public void alterarDadosTitular(Titular t) {
		t.setNome(input("Nome: "));
		t.setCpf(input("CPF: "));
		titularrepo.save(t);
	}

	public apagarTitular() {
		
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("# GERENCIADOR DE TITULARES!");
		boolean sair = false;
		String menu = "\n(1) Mostrar todos os titulares";
		menu += "\n(2) Buscar um titular específico pelo número"; /* TODO */
		menu += "\n(3) Criar um novo titular";
		menu += "\n(4) Alterar os dados do titular";
		menu += "\n(5) Apagar um titular";
		menu += "\n(0) Sair ";
		menu += "\nEscolha uma opção: ";

		while (!sair) {
			String op = input(menu);
			switch (op) {
				case "1":
					lerTudo();
					break;
				case "2":
					// (2) Buscar um titular específico pelo número
					String idBuscado = input("Digite o id a ser buscado: ");
					Optional<Titular> buscarTitular = buscarId(Long.parseLong(idBuscado));
					if (buscarTitular.isPresent()) {
						print(buscarTitular.get().toString());
					} else {
						print("Titular não encontrado");
					}
					break;
				case "3":
					criar();
					break;
				case "4":
					// (4) Alterar os dados do titular
					String idAlt = input("Digite o id do Titular para alterar seus dados: ");
					Optional<Titular> alterarTitular = buscarId(Long.parseLong(idAlt));
					if (alterarTitular.isPresent()) {
						print(alterarTitular.get().toString());
						alterarDadosTitular(alterarTitular.get());
					} else {
						print("Titular não encontrado");
					}
					break;
				case "5":
					String idDel = input("Digite o id do Titular para alterar seus dados: ");
					Optional<Titular> delTitular = buscarId(Long.parseLong(idDel));
					if (delTitular.isPresent()) {
						print(delTitular.get().toString());
						apagarTitular(delTitular.get());
					} else {
						print("Titular não encontrado");
					}
					break;
				case "0":
					sair = true;
					break;
				default:
					print("Opção inválida!");
			}
		}
	}

}