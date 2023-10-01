package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class MenuHandler {
	private GestaoEstudantes gs;

	Scanner sc = new Scanner(System.in);

	public MenuHandler(GestaoEstudantes gs) {
		this.gs = gs;
	}

	public void showMenu() {
		System.out.println("1 - Criar");
		System.out.println("2 - Visualizar");
		System.out.println("3 - Configuracoes");
		System.out.println("0 - Sair");
	}

	public void processUserInput(int userInput) {
		switch (userInput) {
		case 1:
			System.out.println("1 - Criar Novo Estudante");
			System.out.println("2 - Criar Nova Materia");
			criacaoDeServicos(sc.nextInt());
			break;
		case 2:
			System.out.println("1 - Visualizar todos os Estudantes");
			System.out.println("2 - Visualizar todas as Materias");
			System.out.println("3 - Visualizar quem passou");
			System.out.println("4 - Visualizar todas as Notas");
			visualizarServicos(sc.nextInt());
			break;
		case 3:
			System.out.println("1 - Gerar Notas");
			System.out.println("2 - Gerar Materias");
			System.out.println("3 - Gerar Estudantes");
			System.out.println("4 - Gera tudo e mais um pouco");
			funcionalidadesServicos(sc.nextInt());
			break;
		case 0:
			System.exit(0);
		default:
			System.out.println("Digite novamente - Valor invalido");
			break;
		}
	}

	public void criacaoDeServicos(int userInput) {
		switch (userInput) {
		case 1:
			Estudante est = new Estudante();

			System.out.println("Digite o nome:");
			est.setNome(sc.next());

			System.out.println("Digite a idade:");
			est.setIdade(sc.nextInt());
			gs.adicionarEstudante(est);
			break;
		case 2:
			Materia m = new Materia();

			System.out.println("Digite o nome da matéria:");
			m.setNome(sc.next());

			gs.adicionarMateria(m);
			break;
		default:
			break;
		}
	}

	public void visualizarServicos(int userInput) {
		switch (userInput) {
		case 1:
			ArrayList<Estudante> estudantes = gs.getListaEstudantes();
			System.out.println("####################");
			if (!(estudantes.isEmpty())) {
				estudantes.forEach(estudante -> {
					System.out.println("Nome: " + estudante.getNome() + " Idade: " + estudante.getIdade());
				});
			} else {
				System.out.println("Sem estudantes cadastrados");
			}
			System.out.println("####################");
			break;
		case 2:
			ArrayList<Materia> materias = gs.getListaMaterias();
			System.out.println("####################");
			if (!(materias.isEmpty())) {
				materias.forEach(materia -> {
					System.out.println(materia.getNome());
				});
			} else {
				System.out.println("Sem materias cadastradas");
			}
			System.out.println("####################");
			break;
		case 3:
			ArrayList<Estudante> alunos = gs.getListaEstudantes();

			alunos.forEach(estudante -> {
				System.out.println("Estudante: " + estudante.getNome() + ", Resultado: "
						+ ((estudante.calcularMedia()) >= 5 ? "Passou" : "Não passou"));
			});
			break;
		case 4:
			System.out.println("#############################");
			System.out.println("Todas as notas dos estudantes");

			ArrayList<Estudante> estudantes2 = gs.getListaEstudantes();
			estudantes2.forEach(estudante -> {
				System.out.println("Nome: " + estudante.getNome() + " Idade: " + estudante.getIdade());

				HashMap<String, String> notas = estudante.getNotas();
				System.out.println("-----------------------------");
				notas.forEach((materia, nota) -> {
					System.out.println(materia + ": " + nota);
				});
				System.out.println("-----------------------------");
			});
			System.out.println("#############################");
			break;
		default:
			break;
		}
	}

	public void funcionalidadesServicos(int userInput) {

		switch (userInput) {
		case 1:
			ArrayList<Estudante> estudantes = gs.getListaEstudantes();
			ArrayList<Materia> materias = gs.getListaMaterias();

			Random rnd = new Random();

			estudantes.forEach(estudante -> {
				HashMap<String, String> notas = new HashMap<String, String>();

				materias.forEach(materia -> {
					int nota = rnd.nextInt(11);
					notas.put(materia.getNome(), Integer.toString(nota));
				});
				estudante.setNotas(notas);
			});

			gs.setListaEstudantes(estudantes);
			System.out.println("Notas atualizadas");
			break;
		case 2:
			String m[] = { "Historia", "Matematica", "Portugues", "Geografia", "Fisica", "Quimica", "Biologia",
					"Sociologia" };

			for (int i = 0; i < m.length; i++) {
				Materia m1 = new Materia();
				m1.setNome(m[i]);
				gs.adicionarMateria(m1);
			}
			System.out.println("Materias criados!");
			break;
		case 3:
			String nomes[] = { "Valcinei", "Shekira", "Cristosvaldo", "Sherolaine", "Gertulio", "Guidovaldo", "Zaroldo",
					"Ruan" };
			Random rndom = new Random();

			for (int i = 0; i < nomes.length; i++) {
				Estudante est = new Estudante();

				est.setNome(nomes[i]);
				est.setIdade(rndom.nextInt(101));

				gs.adicionarEstudante(est);
			}
			System.out.println("Estudantes criados!");
			break;
		case 4:
			String m2[] = { "Historia", "Matematica", "Portugues", "Geografia", "Fisica", "Quimica", "Biologia",
					"Sociologia" };

			for (int i = 0; i < m2.length; i++) {
				Materia m1 = new Materia();
				m1.setNome(m2[i]);
				gs.adicionarMateria(m1);
			}
			System.out.println("Materias criados!");

			String nomes2[] = { "Valcinei", "Shekira", "Cristosvaldo", "Sherolaine", "Gertulio", "Guidovaldo",
					"Zaroldo", "Ruan" };
			Random random = new Random();

			for (int i = 0; i < nomes2.length; i++) {
				Estudante est = new Estudante();

				est.setNome(nomes2[i]);
				est.setIdade(random.nextInt(101));

				gs.adicionarEstudante(est);
			}
			System.out.println("Estudantes criados!");

			ArrayList<Estudante> estudantes3 = gs.getListaEstudantes();
			ArrayList<Materia> materias3 = gs.getListaMaterias();

			Random randomnd = new Random();

			estudantes3.forEach(estudante -> {
				HashMap<String, String> notas = new HashMap<String, String>();

				materias3.forEach(materia -> {
					int nota = randomnd.nextInt(11);
					notas.put(materia.getNome(), Integer.toString(nota));
				});
				estudante.setNotas(notas);
			});

			gs.setListaEstudantes(estudantes3);
			System.out.println("Notas atualizadas");
		default:
			break;
		}
	}
}
