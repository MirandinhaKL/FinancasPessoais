package model;

/**
 *
 * @author Mirandinha
 */
public class TipoDeMovimentacao {

    private int idTipoMovimentacao;
    private String descricao;

    public TipoDeMovimentacao(int idTipoMovimentacao, String descricao) {
        this.idTipoMovimentacao = idTipoMovimentacao;
        this.descricao = descricao;
    }

    public TipoDeMovimentacao() {

    }

    public TipoDeMovimentacao(int idTipoDeMovimentacao) {
        this.idTipoMovimentacao = idTipoDeMovimentacao;
    }

    public TipoDeMovimentacao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdTipoMovimentacao() {
        return idTipoMovimentacao;
    }

    public void setIdTipoMovimentacao(int idMovimentacao) {
        this.idTipoMovimentacao = idMovimentacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void exibeTiposDeMovimetacoes() {
        System.out.println("=========================== ");
        System.out.println("ID = " + getIdTipoMovimentacao());
        System.out.println("Descrição= " + getDescricao());
    }

    @Override
    public String toString() {
        return getDescricao();
    }
}
