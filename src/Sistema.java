import java.util.ArrayList;
import java.util.Scanner;
public class Sistema {
    private Produto produto;
    private Usuario usuario;
    private ArrayList<Produto> produtos = new ArrayList<>();
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    SistemaDeCompras sistemaDeCompras = new SistemaDeCompras(usuarios,produtos);


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
            System.out.println(" 7 Sair ");
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
                    break;
                case 4:
                    atualizarProduto();
                    break;
                case 5:
                    removerProduto();
                    break;
                case 6:
                    menuPrincipal();
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Opcao invalida");
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
            System.out.println(" [1] Produtos ");
            System.out.println(" [2] Usuarios ");
            System.out.println(" [3] Carrinho ");
            System.out.println(" [4] Sair ");
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
                    sistemaDeCompras.menuCarrinho(usuario);
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
    public void menuUsuarios() {
        int opcao = -1;
        while (opcao != 6) {
            System.out.println("===== USUARIOS =======");
            System.out.println(" 1 Cadastrar Usuário ");
            System.out.println(" 2 Listar Usuários ");
            System.out.println(" 3 Buscar Usuário");
            System.out.println(" 4 Atualizar Usuário");
            System.out.println(" 5 Remover Usuário ");
            System.out.println(" 6 Voltar ");
            System.out.print("Digite sua opcao");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao){
                case 1:
                    cadastrarUsuario();
                    break;
                case 2:
                    listarUsuarios();
                    break;
                case 3:
                    buscarUsuario();
                    break;
                case 4:
                    atualizarUsuario();
                    break;
                case 5:
                    removerUsuario();
                case 6:
                    menuPrincipal();
            }
        }
    }
    public void cadastrarUsuario(){
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        Usuario usuario = new Usuario(nome,cpf);
        usuarios.add(usuario);
        System.out.println("Usuario cadastrado com sucesso.");
    }
    public void listarUsuarios(){
        System.out.println("====LISTA DE USUARIOS====");
        for(Usuario u: usuarios){
            u.exibirUsuario();

        }
    }
    public void buscarUsuario(){
        System.out.println("===BUSCAR USUARIO===");
        System.out.println("Digite o CPF do usuario: ");
        String cpf = scanner.nextLine();
        for(Usuario u: usuarios){
            if(u.getCpf().equalsIgnoreCase(cpf)){
                System.out.println("Usuario encontrado!");
                u.exibirUsuario();
            return;
            }
        }
        System.out.println("Usuario nao encontrado");
    }
    public void atualizarUsuario(){
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("===ATUALIZAR===");
        System.out.println("=== 1 NOME===");
        System.out.println("=== 2 CPF===");
        System.out.println("=== 3 TODOS OS CAMPOS===");
        System.out.print(" Escolha sua opcao ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        for(Usuario u :usuarios){
            if(u.getId()==id){
                if (opcao==1) {
                    System.out.print("Novo nome: ");
                    String nNome = scanner.nextLine();
                    u.setNome(nNome);
                    System.out.println("Usuario atualizado!");
                    System.out.println("---------------------");
        return;
                } else if (opcao==2) {
                    System.out.println("novo cpf: ");
                    String cpf = scanner.nextLine();
                    u.setCpf(cpf);
                    System.out.println("Usuario atualizado!");
                    System.out.println("---------------------");

        return; } else if (opcao==3) {
                    System.out.print("Novo nome: ");
                    String nNome = scanner.nextLine();
                    u.setNome(nNome);
                    System.out.print("novo cpf: ");
                    String cpf = scanner.nextLine();
                    u.setCpf(cpf);
                    System.out.println("Usuario atualizado!");
                    System.out.println("---------------------");
        return; }
            }
        }

    }
    public void removerUsuario(){
        System.out.println("===EXCLUIR USUARIO===");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();


        for(int i=0; i<usuarios.size(); i++){
            if(usuarios.get(i).getId()==id){
                usuarios.remove(i);
                System.out.println("Produto removido com sucesso!");
            return;
            }
        }
        System.out.println("Usuario nao encontrado");
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
