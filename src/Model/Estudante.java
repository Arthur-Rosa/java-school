package Model;

import java.util.HashMap;

public class Estudante extends Pessoa {
	private HashMap<String, String> notas = new HashMap<String, String>();

	public HashMap<String, String> getNotas() {
		return notas;
	}

	public void setNotas(HashMap<String, String> notas) {
		this.notas = notas;
	}
	
	public double calcularMedia() {
        HashMap<String, String> notas = getNotas();
        int soma = 0;
        int count = 0;

        for (String notaStr : notas.values()) {
            if (notaStr != null) {  // Ignora matérias sem nota
                int nota = Integer.parseInt(notaStr);
                soma += nota;
                count++;
            }
        }

        return (count > 0) ? (double) soma / count : 0;
    }
}
