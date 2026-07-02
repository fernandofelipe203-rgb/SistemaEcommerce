import java.util.ArrayList;
import java.util.Scanner;
public class Sistema {
    private Produto produto;
    private Usuario usuario;
    private ArrayList<Produto> produtos = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void menuProdutos() {
        int opcao = -1;
        while (opcao != 4) {
            System.out.println("=====PRODUTOS=======");
            System.out.println(" 1 Cadastrar Produto");
            System.out.println(" 2 Listar produtos");
            System.out.println(" 3 Buscar produto");
            System.out.println(" 4 Atualizar produto");
            System.out.println(" 5 Remover produto ");
            System.out.println(" 6 Voltar ");
            System.out.print("Digite sua opcao: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    listarProdutos();
                    break;
                case 3:
                    buscarProduto();
                case 4:
                    atualizarProduto();
                    break;
                case 5:
                    removerProduto();
            }

        }
    }
    public void cadastrarProduto(){
        System.out.print(" Nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print(" Preco: ");
        double preco = scanner.nextDouble();
        scanner.nextLine();
        System.out.print(" Quantidade: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();
        Produto produto = new Produto(nome,preco,quantidade);
        System.out.println(" Produto cadastrado com sucesso! ");
        System.out.println("ID: " + produto.getId() +" | NOME: "+produto.getNomeProduto() + " | PRECO: " + produto.getPreco() + " | Quantidade " + produto.getQuantidade());
        System.out.println("------------------------------------------------------");
        produtos.add(produto);
    }
    public void listarProdutos(){
        for(Produto p: produtos){
            System.out.println("ID: "+p.getId() +" | NOME: "+ p.getNomeProduto() + " | PRECO: " + p.getPreco() + " | Quantidade " + p.getQuantidade());
            System.out.println("------------------------------------------------------");
        }
    }
    public void buscarProduto(){
        System.out.println("===BUSCAR PRODUTO===");
        System.out.println(" 1 Buscar por NOME: ");
        System.out.println(" 2 Buscar por ID: ");
        System.out.print("Escolha ");
        int escolha = scanner.nextInt();
        scanner.nextLine();
        if(produtos.isEmpty()){
            System.out.println("Nenhum produto cadastrado. ");
        return;
        }
        switch (escolha){
            case 1:
                System.out.print("Nome do produto: ");
                String nomeProduto = scanner.nextLine();
                for(Produto p : produtos){
                    if(p.getNomeProduto().equalsIgnoreCase(nomeProduto)){
                        System.out.println("Produto encontrado com sucesso");
                        p.exibirProduto();
                        return;
                    }
                }
                System.out.println("Produto nao encontrado");
                break;
            case 2:
                System.out.print("ID do produto: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                for(Produto p: produtos){
                    if(p.getId()==id){
                        System.out.println("Produto encontrado com sucesso");
                        p.exibirProduto();
                        return;
                    }
                }
                System.out.println("Produto nao encontrado");
                break;

            default:
                System.out.println("Opcao invalida");
        }

    }
    public void atualizarProduto(){
        System.out.print("ID Produto:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("==ATUALIZAR===");
        System.out.println(" 1 NOME");
        System.out.println(" 2 PRECO");
        System.out.println(" 3 QUANTIDADE");
        System.out.println(" 4 TODOS OS CAMPOS");

        System.out.print(" Oque deseja atualizar: " );
        int opcao =scanner.nextInt();
        scanner.nextLine();

            for (Produto p : produtos) {
                if(p.getId()==id) {
                    if (opcao == 1) {
                        System.out.print("Nome do produto: ");
                        String nome = scanner.nextLine();
                        p.setNomeProduto(nome);
                        System.out.println("Produto atualizado com sucesso.");
                    return;
                        } else if (opcao == 2) {
                        System.out.print("Preco: ");
                        double preco = scanner.nextDouble();
                        scanner.nextLine();
                        p.setPreco(preco);
                        System.out.println("Produto atualizado com sucesso.");
                    return;
                    } else if (opcao == 3) {
                        System.out.print("Quantidade: ");
                        int quantidade = scanner.nextInt();
                        scanner.nextLine();
                        p.setQuantidade(quantidade);
                        System.out.println("Produto atualizado com sucesso.");
                    return;
                    } else if (opcao==4) {
                        System.out.print("Nome do produto: ");
                        String nome = scanner.nextLine();
                        p.setNomeProduto(nome);
                        System.out.print("Preco: ");
                        double preco = scanner.nextDouble();
                        scanner.nextLine();
                        p.setPreco(preco);
                        System.out.print("Quantidade: ");
                        int quantidade = scanner.nextInt();
                        scanner.nextLine();
                        p.setQuantidade(quantidade);
                        System.out.println("Produto atualizado com sucesso.");
                    return;
                    }


                }
                }
                    System.out.println("Produto nao encontrado.");
        }
    public void removerProduto(){
        System.out.println("=====REMOVER PRODUTO=====");
        listarProdutos();
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        for(int i =0; i < produtos.size(); i++){
            if(produtos.get(i).getId()==id){
                produtos.remove(i);
                System.out.println("Produto removido com sucesso.");
            return;
            }
        }
        System.out.println("Produto nao encontrado");
    }



    public void menuPrincipal() {
        int opcao = -1;
        while (opcao != 5) {
            System.out.println("===== SISTEMA DE COMPRAS =======");
            System.out.println(" 1 Produtos ");
            System.out.println(" 2 Usuarios ");
            System.out.println(" 3 Carrinho ");
            System.out.println(" 4 Finalizar compra ");
            System.out.println(" 5 Sair ");
            System.out.print("Digite sua opcao ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao){

                case 1:
                    menuProdutos();
                    break;
                case 2:
                    menuUsuarios();
                    break;
                case 3:
                    menuCarrinho();
                    break;
                case 4:
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }
    public void menuUsuarios() {
        int opcao = -1;
        while (opcao != 5) {
            System.out.println("===== USUARIOS =======");
            System.out.println(" 1 Cadastrar Usuário ");
            System.out.println(" 2 Listar Usuários ");
            System.out.println(" 3 Buscar Usuário");
            System.out.println(" 4 Remover Usuário ");
            System.out.println(" 5 Voltar ");
            System.out.print("Digite sua opcao");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao){
                case 1:
                    break;

            }
        }
    }
    public void menuCarrinho() {
        int opcao = -1;
        while (opcao != 6) {
            System.out.println("===== CARRINHO =======");
            System.out.println(" 1 Adicionar Produto ");
            System.out.println(" 2 Remover Produto ");
            System.out.println(" 3 Alterar Quantidade");
            System.out.println(" 4 Ver Carrinho ");
            System.out.println(" 5 Esvaziar Carrinho ");
            System.out.println(" 6 Sair ");
            System.out.print("Digite sua opcao");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao){
                case 1:
                break;
            }
        }
    }


        public Produto getProduto () {
            return produto;
        }

        public void setProduto (Produto produto){
            this.produto = produto;
        }

        public Usuario getUsuario () {
            return usuario;
        }

        public void setUsuario (Usuario usuario){
            this.usuario = usuario;
        }
    }
