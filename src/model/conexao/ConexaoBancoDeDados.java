package model.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Mirandinha
 */
public class ConexaoBancoDeDados {
    
   private static Connection conexao = null;

    private static final String user = "root";
    private static final String password = "";
    private static final String url = "jdbc:mysql://localhost:3306/financas?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"; //localhost/teste

    public static Connection getConexao() {
        try {
            conexao = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão efetuada com sucesso ao financas");
            return conexao;

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage() + " \nHouve um erro ao conectar com o Banco de Dados.");
        }
    }

    public static void fechar() throws SQLException {
        if (conexao != null) {
            conexao.close();
        }
    }
}