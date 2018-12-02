package model;

public class Categoria {
    
    private int idCategoria;
    private String descricao;

    public Categoria() {

    }

    public Categoria(String descricao) {
        this.descricao = descricao;
    }

    public Categoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Categoria(int idCategoria, String descricao) {
        this.idCategoria = idCategoria;
        this.descricao = descricao;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricaoBD) {
        this.descricao = descricaoBD;
    }
    public void exibeDadosCategoria() {
        System.out.println("=========================== ");
        System.out.println("ID = " + getIdCategoria());
        System.out.println("Descrição= " + getDescricao());
    }

    @Override
    public String toString() {
        return getDescricao();
    }
}

