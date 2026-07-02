import java.util.ArrayList;

public class CarrinhoItem {
    private Produto produto;
    private int quantidade;

    ArrayList<CarrinhoItem> carrinhoItems = new ArrayList<>();

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
