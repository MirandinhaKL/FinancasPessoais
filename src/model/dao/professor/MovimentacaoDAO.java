package model.dao.professor;

import model.dao.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import model.conexao.ConexaoBancoDeDados;
import model.property.Categoria;
import model.property.Movimentacao;
import model.property.ResultadoCategoriaMes;
import model.property.TipoDeMovimentacao;

/**
 * @author Mirandinha
 */
public class MovimentacaoDAO {

    private Connection conexao;

    /**
     * Classe construtora que cria a conexão com o banco de dados.
     */
    public MovimentacaoDAO() {
        this.conexao = new ConexaoBancoDeDados().getConexao();
    }

    /**
     * Adiciona uma nova movimentação ao BD.
     *
     * @param move - Obtido id do tipo de movimentação e o id da categoria, é
     * configurado então a data, valor, descrição e status da movimentação.
     * @return boolean - Verdadeiro se a movimentação foi adicionada com
     * sucesso.
     */
    public boolean adicionaMovimentacao(Movimentacao move) {
        String sql = "INSERT INTO movimentacao(tipo, categoria, datas, valor, descricao, pago) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement declaracao = conexao.prepareStatement(sql);
            declaracao.setInt(1, move.getTipo().getIdTipoMovimentacao());
            declaracao.setInt(2, move.getCategoria().getIdCategoria());
            declaracao.setDate(3, Date.valueOf(move.getData()));
            declaracao.setDouble(4, move.getValor());
            declaracao.setString(5, move.getDescricao());
            declaracao.setBoolean(6, move.getParaOfuturo());
            declaracao.execute();
            declaracao.close();
            conexao.close();
            return true;
        } catch (SQLException excecao) {
            System.out.println(excecao.getErrorCode());
            System.out.println(excecao.getMessage());
            Logger.getLogger(MovimentacaoDAO.class.getName()).log(Level.SEVERE, null, excecao);
        }
        return true;
    }

    /**
     * Retorna uma lista contendo todas as movimentações realizadas.
     *
     * @return ObservableList<Movimentacao> - Lista contendo os dados cadastrado
     * para todas as movimentações.
     */
    public ObservableList<Movimentacao> retornaListaDeMovimentacoes() {
        ObservableList<Movimentacao> listaRetornada = FXCollections.observableArrayList();
        String sql = "SELECT * FROM movimentacao;";

        try {
            PreparedStatement declaracao = conexao.prepareStatement(sql);
            ResultSet consultaBD = declaracao.executeQuery();

            while (consultaBD.next()) {
                Movimentacao movimentacao = new Movimentacao();

                movimentacao.setIdMovimentacao(consultaBD.getInt("id"));
                movimentacao.setData(consultaBD.getDate("datas").toLocalDate());
                movimentacao.setValor(consultaBD.getDouble("valor"));
                movimentacao.setDescricao(consultaBD.getString("descricao"));
                movimentacao.setParaOfuturo(consultaBD.getBoolean("pago"));

                //Obtendo os dados completos do TipoDeMovimentação
                TipoDeMovimentacaoDAO tipoMovimentacaoDao = new TipoDeMovimentacaoDAO();
                TipoDeMovimentacao tipoMovimentacao = tipoMovimentacaoDao.retornaUmTipoPeloId(consultaBD.getInt("tipo"));
                movimentacao.setTipo(tipoMovimentacao);

                //Obtendo os dados completos da Categoria.
                CategoriaDAO categoriaDAO = new CategoriaDAO();
                Categoria categoria = categoriaDAO.retornaCategoriaPeloId(consultaBD.getInt("categoria"));
                movimentacao.setCategoria(categoria);
                listaRetornada.add(movimentacao);
            }
            declaracao.close();
            consultaBD.close();
            conexao.close();
            return listaRetornada;
        } catch (SQLException excecao) {
            System.out.println(excecao.getErrorCode());
            System.out.println(excecao.getMessage());
            Logger.getLogger(MovimentacaoDAO.class.getName()).log(Level.SEVERE, null, excecao);
            throw new RuntimeException(excecao);
        }
    }

    public ObservableList<Movimentacao> retornaListaDeAnos() {
        ObservableList<Movimentacao> listaRetornada = FXCollections.observableArrayList();
        String sql = "SELECT DISTINCT YEAR(datas) AS ano FROM movimentacao ORDER BY ano DESC;";

        try {
            PreparedStatement declaracao = conexao.prepareStatement(sql);
            ResultSet consultaBD = declaracao.executeQuery();

            while (consultaBD.next()) {
                Movimentacao movimentacao = new Movimentacao();

                movimentacao.setIdMovimentacao(consultaBD.getInt("id"));
                movimentacao.setData(consultaBD.getDate("datas").toLocalDate());
//                movimentacao.setValor(consultaBD.getDouble("valor"));
//                movimentacao.setDescricao(consultaBD.getString("descricao"));
//                movimentacao.setParaOfuturo(consultaBD.getBoolean("pago"));

//                //Obtendo os dados completos do TipoDeMovimentação
//                TipoDeMovimentacaoDAO tipoMovimentacaoDao = new TipoDeMovimentacaoDAO();
//                TipoDeMovimentacao tipoMovimentacao = tipoMovimentacaoDao.retornaUmTipoPeloId(consultaBD.getInt("tipo"));
//                movimentacao.setTipo(tipoMovimentacao);
//
//                //Obtendo os dados completos da Categoria.
//                CategoriaDAO categoriaDAO = new CategoriaDAO();
//                Categoria categoria = categoriaDAO.retornaCategoriaPeloId(consultaBD.getInt("categoria"));
//                movimentacao.setCategoria(categoria);
//                listaRetornada.add(movimentacao);
            }
            declaracao.close();
            consultaBD.close();
            conexao.close();
            return listaRetornada;
        } catch (SQLException excecao) {
            System.out.println(excecao.getErrorCode());
            System.out.println(excecao.getMessage());
            Logger.getLogger(MovimentacaoDAO.class.getName()).log(Level.SEVERE, null, excecao);
            throw new RuntimeException(excecao);
        }
    }

    public ObservableList<Movimentacao> filtroMes(int mesSelecionado) {
        ObservableList<Movimentacao> listaRetornada = FXCollections.observableArrayList();
        String sql = "SELECT * FROM movimentacao WHERE MONTH(datas) = " + mesSelecionado + ";";
        try (Connection conexao = new ConexaoBancoDeDados().getConexao()) {
            PreparedStatement declaracao = conexao.prepareStatement(sql);
            ResultSet consultaBD = declaracao.executeQuery();
            while (consultaBD.next()) {
                Movimentacao movimentacao = new Movimentacao();
                movimentacao.setIdMovimentacao(consultaBD.getInt("id"));
                movimentacao.setData(consultaBD.getDate("datas").toLocalDate());
                movimentacao.setValor(consultaBD.getDouble("valor"));
                movimentacao.setDescricao(consultaBD.getString("descricao"));
                movimentacao.setParaOfuturo(consultaBD.getBoolean("pago"));

                Categoria categoria = new CategoriaDAO().retornaCategoriaPeloId(consultaBD.getInt("categoria"));
                movimentacao.setCategoria(categoria);

                TipoDeMovimentacao tipoMovimentacao = new TipoDeMovimentacaoDAO().retornaUmTipoPeloId(consultaBD.getInt("tipo"));
                movimentacao.setTipo(tipoMovimentacao);

                movimentacao.exibeTodasMovimentacoes();
                listaRetornada.add(movimentacao);
            }
            declaracao.close();
            consultaBD.close();
            conexao.close();
            return listaRetornada;
        } catch (SQLException excecao) {
            System.out.println(excecao.getErrorCode());
            System.out.println(excecao.getMessage());
            Logger.getLogger(MovimentacaoDAO.class.getName()).log(Level.SEVERE, null, excecao);
            throw new RuntimeException(excecao);
        }
    }

    /**
     * Remove um item movimentação do BD.
     *
     * @param movimentacao - Recebe um objeto (através do seu id) movimentação.
     * @return - Verdadeiro se a movimentação foi removida com sucesso.
     */
    public boolean removeMovimentacao(Movimentacao movimentacao) {
        String sql = "DELETE FROM movimentacao WHERE id = ?;";
        try {
            PreparedStatement declaracao = conexao.prepareStatement(sql);
            declaracao.setInt(1, movimentacao.getIdMovimentacao());
            declaracao.execute();
            declaracao.close();
            conexao.close();
            return true;
        } catch (SQLException excecao) {
            System.out.println(excecao.getMessage());
            Logger.getLogger(MovimentacaoDAO.class.getName()).log(Level.SEVERE, null, excecao);
            return false;
        }
    }

//    public List<ResultadoCategoriaMes> retornaDespesaMensalPorCategoria(int mesSelecionado) {
//        List<ResultadoCategoriaMes> listaRetornada = new ArrayList<>();
//        String sql = "SELECT categoria.descricao, SUM(valor) as valor "
//                + "FROM movimentacao "
//                + "INNER JOIN categoria ON categoria.id = movimentacao.categoria "
//                + "WHERE movimentacao.tipo = 2 AND MONTH(movimentacao.datas) = " + mesSelecionado + " "
//                + "GROUP BY movimentacao.categoria;";
//        try {
//            PreparedStatement declaracao = conexao.prepareStatement(sql);
//            ResultSet consultaBD = declaracao.executeQuery();
//
//            while (consultaBD.next()) {
//                listaRetornada.add(new ResultadoCategoriaMes(consultaBD.getString("descricao"), consultaBD.getDouble("valor")));
//            }
//            declaracao.close();
//            consultaBD.close();
//            conexao.close();
//            return listaRetornada;
//        } catch (SQLException excecao) {
//            System.out.println(excecao.getErrorCode());
//            System.out.println(excecao.getMessage());
//            Logger.getLogger(MovimentacaoDAO.class.getName()).log(Level.SEVERE, null, excecao);
//            throw new RuntimeException(excecao);
//        }
//    }
//}
    
     public ObservableList<PieChart.Data> retornaDespesaMensalPorCategoria(int mesSelecionado) {
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        
        String sql = "SELECT categoria.descricao, SUM(valor) as valor "
                + "FROM movimentacao "
                + "INNER JOIN categoria ON categoria.id = movimentacao.categoria "
                + "WHERE movimentacao.tipo = 2 AND MONTH(movimentacao.datas) = " + mesSelecionado + " "
                + "GROUP BY movimentacao.categoria;";
        try {
            PreparedStatement declaracao = conexao.prepareStatement(sql);
            ResultSet consultaBD = declaracao.executeQuery();

            while (consultaBD.next()) {
                pieChartData.add(new PieChart.Data(consultaBD.getString("descricao"), consultaBD.getDouble("valor")));
            }
            declaracao.close();
            consultaBD.close();
            conexao.close();
            return pieChartData;
        } catch (SQLException excecao) {
            System.out.println(excecao.getErrorCode());
            System.out.println(excecao.getMessage());
            Logger.getLogger(MovimentacaoDAO.class.getName()).log(Level.SEVERE, null, excecao);
            throw new RuntimeException(excecao);
        }
    }
}

//      public Movimentacao retornaUmaMovimentacao(Movimentacao movimentacao){
//          String sql = "SELECT * FROM movimentacao WHERE id = ?;";
//          Movimentacao retornaMovimentacao = new Movimentacao();
//          try {
//              PreparedStatement declaracao = conexao.prepareStatement(sql);
//              declaracao.setInt(1, movimentacao.getIdMovimentacao());
//              ResultSet consultaBD = declaracao.executeQuery();
//              if (consultaBD.next()) {
//                  Categoria categoria = new Categoria();
//                  TipoDeMovimentacao tipoDeMovimentacao = new TipoDeMovimentacao();
//                  movimentacao.setIdMovimentacao(consultaBD.getInt("id"));
//                  movimentacao.setData(consultaBD.getDate("datas").toLocalDate());
//                  movimentacao.setDescricao(consultaBD.getString("descricao"));
//                  movimentacao.setParaOfuturo(consultaBD.getBoolean("pago"));
//                  movimentacao.setValor(consultaBD.getDouble("valor"));
//                  categoria.setIdCategoria(consultaBD.getInt("id"));
//                  categoria.setDescricao(consultaBD.getString("descricao"));
//                  tipoDeMovimentacao.setIdTipoMovimentacao(consultaBD.getInt("id"));
//                  tipoDeMovimentacao.setDescricao(consultaBD.getString("descricao"));
//                  movimentacao.setCategoria(categoria);
//                  movimentacao.setTipo(tipoDeMovimentacao);
//                  retornaMovimentacao = movimentacao;
//                  System.out.println("DAO Movimentação retornada com sucesso.");
//              }
//      declaracao.close();
//            consultaBD.close();;
//            conexao.close();
//            return autorRetornado; (REVISAR!!!!!!!!!)
//          } catch (SQLException excecao) {
//               System.out.println(excecao.getMessage());
//                Logger.getLogger(MovimentacaoDAO.class.getName()).log(Level.SEVERE, null, excecao);
//                return null;
//          }
//          return retornaMovimentacao;
//      }
//}
