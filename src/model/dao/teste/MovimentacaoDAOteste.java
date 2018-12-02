package model.dao.teste;

import java.time.LocalDate;
import java.util.List;
import model.Categoria;
import model.Movimentacao;
import model.TipoDeMovimentacao;
import model.dao.CategoriaDAO;
import model.dao.MovimentacaoDAO;
import model.dao.TipoDeMovimentacaoDAO;

public class MovimentacaoDAOteste {

    public static void main(String[] args) {

//================ Validação do método adicionaMovimentacao no BD. ================  
//        TipoDeMovimentacao tipoDeMovimentacao = new TipoDeMovimentacao();
//        tipoDeMovimentacao.setIdTipoMovimentacao(1);
//        tipoDeMovimentacao.setDescricao("Tipo de movimentação");
//        TipoDeMovimentacaoDAO tipo = new TipoDeMovimentacaoDAO();
//        tipo.adicionaTipoDeMovimentacao(tipoDeMovimentacao);
//        System.out.println(tipoDeMovimentacao.getIdTipoMovimentacao());
//        System.out.println(tipoDeMovimentacao.getDescricao());
//
//        Categoria categoria = new Categoria();
//        categoria.setIdCategoria(1);
//        categoria.setDescricao("Descricao");
//        CategoriaDAO conectaCategoria = new CategoriaDAO();
//        conectaCategoria.adicionaCategoria(categoria);
//        System.out.println(categoria.getIdCategoria());
//        System.out.println(categoria.getDescricao());
//
//        MovimentacaoDAO conectaBDMovimentacao = new MovimentacaoDAO();
//        Movimentacao movimentacao = new Movimentacao();
//        movimentacao.setIdMovimentacao(125);
//        movimentacao.setValor(150);
//        movimentacao.setCategoria(categoria);
//        movimentacao.setData(LocalDate.now());
//        movimentacao.setParaOfuturo(true);
//        movimentacao.setDescricao("Primeira descricao");
//        movimentacao.setTipo(tipoDeMovimentacao);
//        
//        if (conectaBDMovimentacao.adicionaMovimentacao(movimentacao)) {
//            System.out.println("Movimentação adicionada com sucesso.");
//        } else{
//            System.out.println("Movimentação não adicionada.");
//        }
//      ================ Validação do método retorna lista de Movimentacao no BD. ================
//        MovimentacaoDAO conectaBanco = new MovimentacaoDAO();
//        List<Movimentacao> listaMovimentacao = conectaBanco.retornaListaDeMovimentacoes();
//        if (listaMovimentacao != null) {
//            System.out.println("Listagem das movimentações:");
//            for (int i = 0; i < listaMovimentacao.size(); i++) {
//                listaMovimentacao.get(i).exibeTodasMovimentacoes();
//            }
//        } else {
//            System.out.println("Lista nula");
//        }
//      ================ Validação do método remove Movimentacao no BD. ================  
//        MovimentacaoDAO conectaBD = new MovimentacaoDAO();
//        Movimentacao movimentacao = new Movimentacao();
//        movimentacao.setIdMovimentacao(1);
//        if (conectaBD.removeMovimentacao(movimentacao)) {
//            System.out.println("Movimentação removida com sucesso.");
//        } else {
//            System.out.println("Movimentação NÃO removida!");
//        }
//      ================ Validação do método retorna uma Movimentacao no BD. ================
//        MovimentacaoDAO conectaBD = new MovimentacaoDAO();
//        Movimentacao movimentacao = new Movimentacao();
//        movimentacao.setIdMovimentacao(2);
//        conectaBD.retornaUmaMovimentacao(movimentacao).exibeTodasMovimentacoes();
    }
}
