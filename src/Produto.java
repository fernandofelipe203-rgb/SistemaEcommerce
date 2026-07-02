import java.util.ArrayList;
import java.util.Scanner;
public class Produto {
    private static int proximoId = 1;
    private long id;
    private String nomeProduto;
    private Double preco;
    private int quantidade;


    ArrayList<CarrinhoItem> carrinhoItems = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    public void exibirProduto(){
        System.out.println("ID: " +getId());
        System.out.println("NOME DO PRODUTO: " +getNomeProduto());
        System.out.println("PRECO: " +getPreco());
        System.out.println("QUANTIDADE: " +getQuantidade());
        System.out.println("--------------------------------");
    }

    public Produto(String nomeProduto, Double preco, int quantidade) {
        this.nomeProduto = nomeProduto;
        this.preco = preco;
        this.quantidade = quantidade;
        this.id = proximoId++;
    }

    public void diminuirEstoque(int quantidade){
        this.quantidade -= quantidade;
    }
    public long getId() {
        return id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public Double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setId(long id) {
        this.id = id;
    }

    public static int getProximoId() {
        return proximoId;
    }

    public static void setProximoId(int proximoId) {
        Produto.proximoId = proximoId;
    }
}
