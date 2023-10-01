package Escola;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import Model.Estudante;
import Model.GestaoEstudantes;
import Model.MenuHandler;

public class Escola {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		String nomes[] = { "Arthur", "Geovane", "Pedro" };
		int idades[] = { 25, 26, 18 };
		String materias[] = { "Historia", "Matematica", "Portugues" };

		GestaoEstudantes gs = new GestaoEstudantes();

		
		
		Random rnd = new Random();

		MenuHandler menu = new MenuHandler(gs);
		
		boolean opcao = false;
		
		do {
			menu.showMenu();
			menu.processUserInput(sc.nextInt());
		} while (opcao != true);
		
		for (int i = 0; i < nomes.length; i++) {
			Estudante estudante = new Estudante();

			estudante.setNome(nomes[i]);
			estudante.setIdade(idades[i]);

			HashMap<String, String> notas = new HashMap<String, String>();

			for (int j = 0; j < materias.length; j++) {
				int nota = rnd.nextInt(11);
				notas.put(materias[j], Integer.toString(nota));
			}

			estudante.setNotas(notas);

			gs.adicionarEstudante(estudante);
		}

		ArrayList<Estudante> estudantes = gs.getListaEstudantes();

		estudantes.forEach(estudante -> {
			System.out.println(estudante.getNome());
			System.out.println(estudante.getIdade());

			HashMap<String, String> notas = estudante.getNotas();
			notas.forEach((materia, nota) -> {
				System.out.println(materia + ": " + nota);
			});
		});
		
		
	}
	
	

}
