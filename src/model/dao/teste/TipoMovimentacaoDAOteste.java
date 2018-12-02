package model.dao.teste;

import java.util.List;
import model.TipoDeMovimentacao;
import model.dao.TipoDeMovimentacaoDAO;

public class TipoMovimentacaoDAOteste {

//    public static void main(String[] args) {

//================ Validação do método adiciona TipoDeMovimentação no BD. ================
//        TipoDeMovimentacaoDAO conexaoTipoDeMovimentacao = new TipoDeMovimentacaoDAO();
//        TipoDeMovimentacao tipo = new TipoDeMovimentacao("Teste100");
//        if (conexaoTipoDeMovimentacao.adicionaTipoDeMovimentacao(tipo)) {
//            System.out.println("Tipo de movimentação adicionado com sucesso!");
//        } else {
//            System.out.println("Tipo de movimentação NÃO adicionado");
//        }
// ================ Validação do método atualiza TipoDeMovimentação no BD. ================
//        TipoDeMovimentacaoDAO conexaoTipoDeMovimentacao = new TipoDeMovimentacaoDAO();
//        TipoDeMovimentacao tipo = new TipoDeMovimentacao();
//        tipo.setIdTipoMovimentacao(1);
//        tipo.setDescricao("Alterado");
//        if (conexaoTipoDeMovimentacao.atualizaTipoDeMovimentacao(tipo)) {
//            System.out.println("Tipo de movimentação atualizado com sucesso!");
//        } else {
//            System.out.println("Tipo de movimentação NÃO atualizado!");
//        }
// ================ Validação do método remove TipoDeMovimentação no BD. ================
//        TipoDeMovimentacaoDAO conexaoTipoDeMovimentacao = new TipoDeMovimentacaoDAO();
//        TipoDeMovimentacao tipo = new TipoDeMovimentacao();
//        tipo.setIdTipoMovimentacao(1);
//        if (conexaoTipoDeMovimentacao.removeTipoDeMovimentação(tipo)) {
//            System.out.println("Tipo de movimentação removida com sucesso!");
//        } else {
//            System.out.println("Tipo de movimentação NÃO foi removida.");
//        }
// ================ Validação do método remove TODOS os TipoDeMovimentação no BD. ================
//        TipoDeMovimentacaoDAO conexaoTipoDeMovimentacao = new TipoDeMovimentacaoDAO();
//        conexaoTipoDeMovimentacao.apagaTodosOsTipoDeMovimentação();
//================ Validação do método que retorna uma lista com todos os tipos de movimentação do BD. ================
//        TipoDeMovimentacaoDAO dataBaseTipoDeMovimentacao = new TipoDeMovimentacaoDAO();
//        List<TipoDeMovimentacao> tiposDeMovDoBD = dataBaseTipoDeMovimentacao.retornaListaDosTiposDeMovimentaoes();
//        if (tiposDeMovDoBD != null) {
//            System.out.println("Listagem dos tipos de movimentações: ");
//            for (int i = 0; i < tiposDeMovDoBD.size(); i++) {
//                tiposDeMovDoBD.get(i).exibeTiposDeMovimetacoes();
//            }
//        } else {
//            System.out.println("Lista nula");
//        }
//================ Validação do método que retorna um tipo de movimentação do BD. ================
//        TipoDeMovimentacaoDAO conexaoTipoDeMovimentacao = new TipoDeMovimentacaoDAO();
//        TipoDeMovimentacao tipo = new TipoDeMovimentacao();
//        tipo.setIdTipoMovimentacao(2);
//        conexaoTipoDeMovimentacao.retornaUmTipo(tipo).exibeTiposDeMovimetacoes();
//    }
}
