package Model;

import java.util.ArrayList;
import java.util.HashMap;

public class GestaoEstudantes {
	private ArrayList<Estudante> listaEstudantes = null;
	private ArrayList<Materia> listaMaterias = null;
	
	public GestaoEstudantes() {
        this.listaEstudantes = new ArrayList<>();
        this.listaMaterias = new ArrayList<>();
    }

	public ArrayList<Estudante> getListaEstudantes() {
		return listaEstudantes;
	}
	
	public ArrayList<Materia> getListaMaterias() {
		return listaMaterias;
	}

	public void setListaEstudantes(ArrayList<Estudante> listaEstudantes) {
		this.listaEstudantes = listaEstudantes;
	}
	
	public void adicionarMateria(Materia materia) {
		this.listaMaterias.add(materia);
		atualizarMateriasEstudantes();
	}
	
	private void atualizarMateriasEstudantes() {
        for (Estudante estudante : listaEstudantes) {
            HashMap<String, String> notas = estudante.getNotas();
            for (Materia materia : listaMaterias) {
                notas.putIfAbsent(materia.getNome(), null);
            }
            estudante.setNotas(notas);
        }
    }
	
	public double calcularNota(Estudante estudante) {
		return estudante.calcularMedia();
	}
	
	public void adicionarEstudante(Estudante estudante) {
		this.listaEstudantes.add(estudante);
	}
}
