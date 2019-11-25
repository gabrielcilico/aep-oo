package Conexao;

import java.sql.SQLException;

public class App {

    public static void main(String[] args) throws SQLException {
        Conexao conexao = new Conexao();
        Double tempoCompUm = conexao.exercicioComplementarUm();
        Double tempoCompDois = conexao.exercicioComplementarDois();
        Double tempoCompTres = conexao.exercicioComplementarTres();

        System.out.println("=== TEMPO DE EXECUÇÃO ===");
        System.out.println(String.format("Complementar 1: %f segundos", tempoCompUm));
        System.out.println(String.format("Complementar 2: %f segundos", tempoCompDois));
        System.out.println(String.format("Complementar 3: %f segundos", tempoCompTres));
    }
}
