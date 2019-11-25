package Conexao;

import java.sql.*;

public class Conexao {

    // ExercicioA
    public static Connection exercicioA() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/amigos", "postgres","admin");
            conn.setAutoCommit(true);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Exercícios B, C, D, E
    public void demaisExercicios() throws SQLException {

        Connection connection = exercicioA();
        try {
            final String query = "select 1 + 1 as soma";

            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                System.out.println("Resultado da query: " + rs.getString("soma") + "\n\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }

    }

    // Complementar 1
    public Double exercicioComplementarUm() throws SQLException {
        Long inicio = System.currentTimeMillis();
        for (int x = 0; x < 100; x++) {
            System.out.println("=== " + x+1 + " ===");
            demaisExercicios();
        }
        return (double) (System.currentTimeMillis() - inicio)/1000;
    }

    // Complementar 2
    public Double exercicioComplementarDois() throws SQLException {
        Long inicio = System.currentTimeMillis();
        Connection connection = exercicioA();

        for (int x = 0; x < 100; x++) {
            try {
                final String query = "select 1 + 1 as soma";

                PreparedStatement ps = connection.prepareStatement(query);
                ResultSet rs = ps.executeQuery();

                if(rs.next()) {
                    System.out.println((x+1) + ") Resultado da query: " + rs.getString("soma") + "\n\n");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        connection.close();
        return (double) (System.currentTimeMillis() - inicio)/1000;
    }

    // Complementar 3
    public Double exercicioComplementarTres() throws SQLException {
        Long inicio = System.currentTimeMillis();

        for (int x = 0; x < 100; x++) {
            Connection connection = exercicioA();
            try {
                final String query = "select 1 + 1 as soma";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.executeQuery();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                connection.close();
            }
        }

        return (double) (System.currentTimeMillis() - inicio)/1000;
    }
}