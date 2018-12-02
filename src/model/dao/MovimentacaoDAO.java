package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Categoria;
import model.Movimentacao;
import model.TipoDeMovimentacao;
import model.conexao.ConexaoBancoDeDados;

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
     * @param move - Obtido id do tipo de movimentação e o id da categoria, é 
     * configurado então a data, valor, descrição e status da movimentação.
     * @return boolean - Verdadeiro se a movimentação foi adicionada com sucesso.
     */
    public boolean adicionaMovimentacao(Movimentacao move) {
        String sql = "INSERT INTO movimentacao(tipo, categoria, datas, valor, descricao, pago) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement declaracao = conexao.prepareStatement(sql);
            declaracao.setInt(1, move.getTipo().getIdTipoMovimentacao());
            // System.out.println("id categoria = " + move.getCategoria().getIdCategoria());
            declaracao.setInt(2, move.getCategoria().getIdCategoria());
            //   System.out.println("id tipo = " + move.getTipo().getIdTipoMovimentacao());
            declaracao.setDate(3, Date.valueOf(move.getData()));
            //     System.out.println("data = " + java.sql.Date.valueOf(move.getData()));
            declaracao.setDouble(4, move.getValor());
            //  System.out.println("valor = " + move.getValor());
            declaracao.setString(5, move.getDescricao());
            //  System.out.println("descrição = " + move.getDescricao());
            declaracao.setBoolean(6, move.getParaOfuturo());
            //   System.out.println("operação para o futuro: " + String.valueOf(move.getParaOfuturo()));
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
     * @return List<Movimentacao> - Lista contendo os dados cadastrado para
     * todas as movimentações.
     */
     public List<Movimentacao> retornaListaDeMovimentacoes() {
        List<Movimentacao> listaRetornada = new ArrayList<>();
        String sql = "SELECT * FROM movimentacao;";
        try {
            PreparedStatement declaracao = conexao.prepareStatement(sql);
            ResultSet consultaBD = declaracao.executeQuery();
            while (consultaBD.next()) {
                Movimentacao movimentacao = new Movimentacao();
                Categoria categoria = new Categoria();
                TipoDeMovimentacao tipoMovimentacao = new TipoDeMovimentacao();

                movimentacao.setIdMovimentacao(consultaBD.getInt("id"));
                movimentacao.setData(consultaBD.getDate("datas").toLocalDate());
                movimentacao.setValor(consultaBD.getDouble("valor"));
                movimentacao.setDescricao(consultaBD.getString("descricao"));
                movimentacao.setParaOfuturo(consultaBD.getBoolean("pago"));
                categoria.setIdCategoria(consultaBD.getInt("id"));
                categoria.setDescricao(consultaBD.getString("descricao"));
                tipoMovimentacao.setIdTipoMovimentacao(consultaBD.getInt("id"));
                tipoMovimentacao.setDescricao(consultaBD.getString("descricao"));

                //Obtendo os dados completos da Categoria.
                CategoriaDAO categoriaDAO = new CategoriaDAO();
                categoria = categoriaDAO.retornaUmaCategoria(categoria);
              
                //Obtendo os dados completos do TipoDeMovimentação
                TipoDeMovimentacaoDAO tipoMovimentacaoDao = new TipoDeMovimentacaoDAO();
                tipoMovimentacao = tipoMovimentacaoDao.retornaUmTipo(tipoMovimentacao);
                
                movimentacao.setCategoria(categoria);
                movimentacao.setTipo(tipoMovimentacao);
                listaRetornada.add(movimentacao);
            }
            declaracao.close();
            consultaBD.close();
            conexao.close();
        } catch (SQLException excecao) {
            System.out.println(excecao.getErrorCode());
            System.out.println(excecao.getMessage());
            Logger.getLogger(MovimentacaoDAO.class.getName()).log(Level.SEVERE, null, excecao);
        }
        return listaRetornada;
    }
     
     /**
      * Remove um item movimentação do BD.
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
     
      public Movimentacao retornaUmaMovimentacao(Movimentacao movimentacao){
          String sql = "SELECT * FROM movimentacao WHERE id = ?;";
          Movimentacao retornaMovimentacao = new Movimentacao();
          try {
              PreparedStatement declaracao = conexao.prepareStatement(sql);
              declaracao.setInt(1, movimentacao.getIdMovimentacao());
              ResultSet consultaBD = declaracao.executeQuery();
              if (consultaBD.next()) {
                  Categoria categoria = new Categoria();
                  TipoDeMovimentacao tipoDeMovimentacao = new TipoDeMovimentacao();
                  movimentacao.setIdMovimentacao(consultaBD.getInt("id"));
                  movimentacao.setData(consultaBD.getDate("datas").toLocalDate());
                  movimentacao.setDescricao(consultaBD.getString("descricao"));
                  movimentacao.setParaOfuturo(consultaBD.getBoolean("pago"));
                  movimentacao.setValor(consultaBD.getDouble("valor"));
                  categoria.setIdCategoria(consultaBD.getInt("id"));
                  categoria.setDescricao(consultaBD.getString("descricao"));
                  tipoDeMovimentacao.setIdTipoMovimentacao(consultaBD.getInt("id"));
                  tipoDeMovimentacao.setDescricao(consultaBD.getString("descricao"));
                  movimentacao.setCategoria(categoria);
                  movimentacao.setTipo(tipoDeMovimentacao);
                  retornaMovimentacao = movimentacao;
                  System.out.println("DAO Movimentação retornada com sucesso.");
              }
          } catch (SQLException excecao) {
               System.out.println(excecao.getMessage());
                Logger.getLogger(MovimentacaoDAO.class.getName()).log(Level.SEVERE, null, excecao);
                return null;
          }
          return retornaMovimentacao;
      }
}
