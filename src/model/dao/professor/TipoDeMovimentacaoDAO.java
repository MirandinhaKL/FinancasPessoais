package model.dao.professor;

import model.dao.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.TipoDeMovimentacao;
import model.conexao.ConexaoBancoDeDados;

/**
 * @author Mirandinha
 */
public class TipoDeMovimentacaoDAO {

    private Connection conexao;

    /**
     * Classe construtora que cria a conexão com o banco de dados.
     */
    public TipoDeMovimentacaoDAO() {
        this.conexao = new ConexaoBancoDeDados().getConexao();
    }

    /**
     * Adiciona um novo tipo de movimentação no BD.
     *
     * @param novoTipo - Atributo descrição configurado.
     * @return boolean - Verdadeiro se o tipo de movimentação foi adicionado com
     * sucesso.
     */
//    public boolean adicionaTipoDeMovimentacao(TipoDeMovimentacao novoTipo) {
//        String sql = "INSERT INTO tipos_movimentacao (descricao) VALUES (?);";
//        try {
//            PreparedStatement declaracao = conexao.prepareStatement(sql);
//            declaracao.setString(1, novoTipo.getDescricao());
//            declaracao.execute();
//            declaracao.close();
//            conexao.close();
//            return true;
//        } catch (SQLException excecao) {
//            System.out.println(excecao.getMessage());
//            excecao.getMessage();
//            return false;
//        }
//    }
    /**
     * Atualiza um tipo de movimentação existente no banco.
     *
     * @param tipoRetornado - Atributo descrição atualizado.
     * @return boolean - Verdadeiro se o tipo de movimentação foi atualizado com
     * sucesso.
     */
//    public boolean atualizaTipoDeMovimentacao(TipoDeMovimentacao tipoRetornado) {
//        String sql = "UPDATE tipos_movimentacao SET descricao = ? WHERE id = ?;";
//        try {
//            PreparedStatement declaracao = conexao.prepareStatement(sql);
//            declaracao.setString(1, tipoRetornado.getDescricao());
//            declaracao.setInt(2, tipoRetornado.getIdTipoMovimentacao());
//            declaracao.execute();
//            declaracao.close();
//            conexao.close();
//            return true;
//        } catch (SQLException excecao) {
//            System.out.println(excecao.getMessage());
//            return false;
//        }
//    }
    /**
     * Remove um tipo de movimentação existente no banco.
     *
     * @param tipoAremover - Informar o id do tipo de movimentação a ser
     * removida.
     * @return boolean - Verdadeiro se o tipo de movimentação foi removida com
     * sucesso.
     */
//    public boolean removeTipoDeMovimentação(TipoDeMovimentacao tipoAremover) {
//        String sql = "DELETE FROM tipos_movimentacao WHERE id = ?;";
//        try {
//            PreparedStatement declaracao = conexao.prepareStatement(sql);
//            declaracao.setInt(1, tipoAremover.getIdTipoMovimentacao());
//            declaracao.execute();
//            declaracao.close();
//            conexao.close();
//            return true;
//        } catch (SQLException excecao) {
//            System.out.println(excecao.getMessage());
//            return false;
//        }
//    }
    /**
     * Apaga todos os tipos de movimentação cadastradas no BD.
     *
     * @return boolean - Verdadeiro se todos os tipos de movimentação
     * cadastrados forem apagados.
     */
//    public boolean apagaTodosOsTipoDeMovimentação() {
//        String sql = "DELETE FROM tipos_movimentacao;";
//        try {
//            PreparedStatement declaracao = conexao.prepareStatement(sql);
//            declaracao.execute();
//            declaracao.close();
//            conexao.close();
//            return true;
//        } catch (SQLException excecao) {
//            System.out.println(excecao.getMessage());
//            return false;
//        }
//    }
    /**
     * Retorna todos os tipos de movimentaçãoes cadastradas no BD.
     *
     * @return observableList<TipoDeMovimentacao> - Retorna uma lista contendo
     * todas as movimentacoes cadastrado no BD.
     */
    public ObservableList<TipoDeMovimentacao> retornaListaDosTiposDeMovimentaoesObservable() {
        ObservableList<TipoDeMovimentacao> listaDeTiposDeMovimentacoes = FXCollections.observableArrayList();
        String sql = "SELECT * FROM tipos_movimentacao;";
        try {
            PreparedStatement declaracao = conexao.prepareStatement(sql);
            ResultSet consultaBD = declaracao.executeQuery();
            while (consultaBD.next()) {
                TipoDeMovimentacao tipo = new TipoDeMovimentacao();
                tipo.setIdTipoMovimentacao(consultaBD.getInt("id"));
                tipo.setDescricao(consultaBD.getString("descricao"));
                listaDeTiposDeMovimentacoes.add(tipo);
            }
            declaracao.close();
            consultaBD.close();
            conexao.close();
            return listaDeTiposDeMovimentacoes;
        } catch (Exception excecao) {
            excecao.printStackTrace();
            System.out.println("Erro! Lista não retornada!");
            throw new RuntimeException(excecao);
        }
    }

    /**
     * Retorna todos os tipos de movimentaçãoes cadastrados no BD.
     *
     * @return List<TipoDeMovimentacao> - Retorna uma lista contendo todos os
     * tipos de movimentacoes cadastrados no BD.
     */
    public TipoDeMovimentacao retornaUmTipoPeloId(int idTipoDeMovimentacao) {
        String sql = "SELECT * FROM tipos_movimentacao WHERE id = ?;";
        TipoDeMovimentacao tipoRetornado = new TipoDeMovimentacao();
        try {
            PreparedStatement declaracao = conexao.prepareStatement(sql);
            declaracao.setInt(1, idTipoDeMovimentacao);
            ResultSet consultaBD = declaracao.executeQuery();
            if (consultaBD.next()) {
                tipoRetornado.setDescricao(consultaBD.getString("descricao"));
                tipoRetornado.setIdTipoMovimentacao(consultaBD.getInt("id"));
            }
            declaracao.close();
            consultaBD.close();
            conexao.close();
            return tipoRetornado;
        } catch (SQLException excecao) {
            System.out.println(excecao.getMessage());
            System.out.println("Tipo de movimentação não retornada - classe DAO");
            throw new RuntimeException(excecao);
        }
    }
}
