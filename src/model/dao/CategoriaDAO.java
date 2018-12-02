package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Categoria;
import model.conexao.ConexaoBancoDeDados;

/**
 * @author Mirandinha
 */
public class CategoriaDAO {

    private static Connection conexao;

    /**
     * Classe construtora que cria a conexão com o banco de dados.
     */
    public CategoriaDAO() {
        this.conexao = new ConexaoBancoDeDados().getConexao();
    }

    /**
     * Adiciona uma nova categoria ao BD.
     *
     * @param novaCategoria - Atributo descrição é configurado.
     * @return boolean - Verdadeiro se a categoria foi adicionada com sucesso.
     */
    public boolean adicionaCategoria(Categoria novaCategoria) {
        String sql = "INSERT INTO categoria (descricao) VALUES (?);";
        try {
            PreparedStatement declaracao = conexao.prepareStatement(sql);
            declaracao.setString(1, novaCategoria.getDescricao());
            declaracao.execute();
            declaracao.close();
            conexao.close();
            return true;
        } catch (SQLException excecao) {
            System.out.println(excecao.getMessage());
            excecao.getMessage();
            return false;
        }
    }

    /**
     * Atualiza uma categoria existente no banco.
     *
     * @param categoria - Atributo descrição atualizado.
     * @return boolean - Verdadeiro sea categoria foi atualizada com sucesso.
     */
    public boolean atualizaCategoria(Categoria categoria) {
        String sql = "UPDATE categoria SET descricao = ? WHERE id = ?;";
        try {
            PreparedStatement declaracao = conexao.prepareStatement(sql);
            declaracao.setString(1, categoria.getDescricao());
            declaracao.setInt(2, categoria.getIdCategoria());
            declaracao.execute();
            declaracao.close();;
            conexao.close();
            return true;
        } catch (Exception excecao) {
            System.out.println(excecao.getMessage());
            return false;
        }
    }

    /**
     * Remove uma categoria existente no banco.
     *
     * @param categoria - Informar o id da categoria a ser removido.
     * @return boolean - Verdadeiro se a categoria foi removido com sucesso.
     */
    public boolean removeCategoria(Categoria categoria) {
        String sql = "DELETE FROM categoria WHERE id = ?;";
        try {
            PreparedStatement declaracao = conexao.prepareStatement(sql);
            declaracao.setInt(1, categoria.getIdCategoria());
            declaracao.execute();
            declaracao.close();
            conexao.close();
            return true;
        } catch (SQLException excecao) {
            System.out.println(excecao.getMessage());
            return false;
        }
    }

    /**
     * Remove todos os itens da tabela categoria.
     * @return boolean - Verdadeiro se todos os dados da tabela categoria forem
     * apagados.
     */
    public boolean removeTodasAsCategorias() {
        String sql = "DELETE FROM categoria;";
        try {
            PreparedStatement declaracao = conexao.prepareStatement(sql);
            declaracao.execute();
            declaracao.close();
            conexao.close();
            return true;
        } catch (SQLException excecao) {
            System.out.println(excecao.getMessage());
            return false;
        }
    }
    
    /**
     * Retorna todos os categorias cadastradas no BD alunos.
     * @return List<Categoria> - Retorna uma lista contendo todas as categorias
     * cadastradas no BD.
     */
    public static List<Categoria> retornaListaDeCategorias() {
        List<Categoria> listaDeCategorias = new ArrayList<>();
        String sql = "SELECT * FROM categoria;";
        try {
            PreparedStatement declaracao = conexao.prepareStatement(sql);
            ResultSet consultaBD = declaracao.executeQuery();
            while (consultaBD.next()) {
                Categoria itemCategoria = new Categoria();
                itemCategoria.setIdCategoria(consultaBD.getInt("id"));
                itemCategoria.setDescricao(consultaBD.getString("descricao"));
                listaDeCategorias.add(itemCategoria);
            }
            declaracao.close();
            consultaBD.close();;
            conexao.close();
        } catch (SQLException excecao) {
            System.out.println(excecao.getMessage());
            System.out.println("Lista NÃO retornada");
            return null;
        }
        return listaDeCategorias;
    }
    
    /**
     * Retorna uma categoria cadastrada no BD.
     * @param categoria - Recebe o id da Categoria.
     * @return Categoria - Retorna o objeto Categoria.
     */
    public Categoria retornaUmaCategoria(Categoria categoria){
        String sql = "SELECT * FROM categoria WHERE id=?;";
        Categoria retornaCategoria = new Categoria();
        try {
            PreparedStatement declaracao = conexao.prepareStatement(sql);
            declaracao.setInt(1, categoria.getIdCategoria());
            ResultSet consultaBD = declaracao.executeQuery();
            if (consultaBD.next()) {
                categoria.setDescricao(consultaBD.getString("descricao"));
                categoria.setIdCategoria(consultaBD.getInt("id"));
                retornaCategoria = categoria;
            }
        } catch (SQLException excecao) {
            System.out.println(excecao.getMessage());
            System.out.println("Categoria não retornada - classe DAO");
        }
        return retornaCategoria;
    }
}
