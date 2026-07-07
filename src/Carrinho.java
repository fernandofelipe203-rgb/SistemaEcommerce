import java.util.ArrayList;

public class Carrinho {
    private ArrayList<CarrinhoItem> itensDoCarrinho = new ArrayList<>();


    public Carrinho() {
        this.itensDoCarrinho = new ArrayList<>();
    }

    public ArrayList<CarrinhoItem> getItensDoCarrinho() {
        return itensDoCarrinho;
    }

    public void setItensDoCarrinho(ArrayList<CarrinhoItem> itensDoCarrinho) {
        this.itensDoCarrinho = itensDoCarrinho;
    }
    public void adicionarItem(CarrinhoItem item){
        itensDoCarrinho.add(item);

    }
}

