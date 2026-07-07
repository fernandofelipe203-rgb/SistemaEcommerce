
import java.util.ArrayList;
import java.util.Scanner;

public class SistemaDeCompras{
    private ArrayList<Usuario> usuarios;
    private ArrayList<Produto> produtos;


    Scanner scanner = new Scanner(System.in);


    public void menuCarrinho(Usuario usuario) {

        Usuario usuarioLogado = null;
        System.out.print("Digite o CPF do usuario: ");
        String cpf = scanner.nextLine();

        for(Usuario u: usuarios){
            if(u.getCpf().equalsIgnoreCase(cpf)) {
                usuarioLogado = u;
                break;
            }
        }
        if(usuarioLogado==null){
            System.out.println("Nao foi possivel localizar usuario");
        return;
        }
        System.out.println("Seja bem vindo ao carrinho " + usuarioLogado.getNome());


        int opcao = -1;
        while (opcao != 7) {
            System.out.println("===== CARRINHO =======");
            System.out.println(" 1 Adicionar Produto ao carrinho ");
            System.out.println(" 2 Ver carrinho ");
            System.out.println(" 3 Alterar Quantidade");
            System.out.println(" 4 Remover produto ");
            System.out.println(" 5 Esvaziar Carrinho ");
            System.out.println(" 6 Finalizar compra ");
            System.out.println(" 7 Sair ");
            System.out.print("Digite sua opcao: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao){
                case 1:
                    adicionarProduto(usuarioLogado);
                    break;
                case 2:
                    verCarrinho(usuarioLogado);
                    break;
                case 3:
                    alterarQuantidade(usuarioLogado);
                    break;
                case 4:
                    removerProduto(usuarioLogado);
                    break;
                case 5:
                    esvaziarCarrinho(usuarioLogado);
                case 6:
                    finalizarCompra(usuarioLogado);
                    System.exit(0);
                    break;
                case 7:
                    System.exit(0);

            }
        }
    }
    public void adicionarProduto(Usuario usuario){
        System.out.print("Digite o ID do produto: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Produto produtoEncontrado = null;
        for (Produto p : produtos){
            if(p.getId()==id){
                produtoEncontrado = p;
                break;
            }
        }
        if(produtoEncontrado == null){
            System.out.println("Produto nao Cadastrado ");
            return;
        }

        System.out.print("Quantidade desejada: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        if(quantidade <=0){
            System.out.println(" Nao foi possivel adicionar essa quantidade ");
            return;
        }
        if(quantidade > produtoEncontrado.getQuantidade()){
            System.out.println(" Estoque insuficiente ");
            return;
        }

        CarrinhoItem carrinhoItem = new CarrinhoItem();
        carrinhoItem.setProduto(produtoEncontrado);
        carrinhoItem.setQuantidade(quantidade);

        usuario.getCarrinho().adicionarItem(carrinhoItem);
        System.out.println("Produto adicionado com sucesso!");

    }
    public void verCarrinho(Usuario usuario){
        if(usuario.getCarrinho().getItensDoCarrinho().isEmpty()){
            System.out.println("Carrinho vazio!");
        return;
        }
        System.out.println("===ITENS DO CARRINHO===");
        double total = 0;
        for(CarrinhoItem item : usuario.getCarrinho().getItensDoCarrinho()){
            System.out.println("Nome do produto: " +item.getProduto().getNomeProduto() + " Quantidade: " + item.getQuantidade() + " Preco: R$ " + item.getProduto().getPreco());
            double subtotal = item.getProduto().getPreco() * item.getQuantidade();
            total +=subtotal;
            System.out.printf("Subtotal: R$ %.2f%n", subtotal);
            System.out.println("---------------------------------");


        }
        System.out.printf("Valor total do carrinho: RS: %.2f%n", total);
        System.out.println("------------------------");
    }
    public void alterarQuantidade(Usuario usuario){
        System.out.println("===Alterar Quantidade===");
        for(CarrinhoItem item : usuario.getCarrinho().getItensDoCarrinho()){
            System.out.println("ID do produto:"+item.getProduto().getId() +" | Nome do produto " +item.getProduto().getNomeProduto() + " | Quantidade: " +item.getQuantidade());
        }
        System.out.print("Digite o id do produto: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        for(CarrinhoItem  carrinhoItem: usuario.getCarrinho().getItensDoCarrinho()){
            if(carrinhoItem.getProduto().getId()==id){
                System.out.print("Digite a nova quantidade");
                int quantidade = scanner.nextInt();
                scanner.nextLine();
                if (quantidade<=0){
                    System.out.println("Quantidade invalida");
                return;
                }
                if(quantidade>carrinhoItem.getProduto().getQuantidade()){
                    System.out.println("Estoque insuficiente");
                return;
                }
                carrinhoItem.setQuantidade(quantidade);
                System.out.println(" Quantidade alterada com sucesso ");
            return;
            }
        }
        System.out.println("Produto nao encontrado");
    }
    public void removerProduto(Usuario usuario){
        System.out.println("===Remover Produto ===");
        for(CarrinhoItem item : usuario.getCarrinho().getItensDoCarrinho()){
            System.out.println("ID do produto:"+item.getProduto().getId() +" | Nome do produto " +item.getProduto().getNomeProduto() + " | Quantidade: " +item.getQuantidade() + " | Preco " +item.getProduto().getPreco());
        }
        System.out.print("Digite o id do produto: ");
        int id = scanner.nextInt();
        scanner.nextLine();
      for(int i = 0; i < usuario.getCarrinho().getItensDoCarrinho().size();i++){
          CarrinhoItem item = usuario.getCarrinho().getItensDoCarrinho().get(i);

          if(item.getProduto().getId()==id){
              usuario.getCarrinho().getItensDoCarrinho().remove(i);
              System.out.println("Produto removido com sucesso!");
          return;
          }
      }
      System.out.println("Produto nao encontrado no carrinho");
    }
    public void esvaziarCarrinho(Usuario usuario){
        usuario.getCarrinho().getItensDoCarrinho().clear();
        System.out.println("Carrinho esvaziado com sucesso! ");
    }

    public void finalizarCompra(Usuario usuario){
        if(usuario.getCarrinho().getItensDoCarrinho().isEmpty()){
            System.out.println("Carrinho esta vazio.");
        return;
        }
        double total =0;

        for(CarrinhoItem item: usuario.getCarrinho().getItensDoCarrinho()){
            double subtotal = item.getProduto().getPreco() * item.getQuantidade();

            total +=subtotal;

            item.getProduto().diminuirEstoque(item.getQuantidade());

        }
        System.out.println("Compra finalizada com sucesso!");
        System.out.printf("Valor total da compra: R$ %.2f%n", total);
        System.out.println("Obrigado pela compra!!! Volte sempre!!!");
        usuario.getCarrinho().getItensDoCarrinho().clear();
    }

    public SistemaDeCompras(ArrayList<Usuario> usuarios, ArrayList<Produto> produtos) {
        this.usuarios = usuarios;
        this.produtos = produtos;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }
}
