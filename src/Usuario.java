public class Usuario {
    private static int proximoId = 1;
    private long id;
    private String nome;
    private String cpf;
    private Carrinho carrinho;
    public Usuario(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.id = proximoId++;
        this.carrinho = new Carrinho();
    }

    public void exibirUsuario(){
        System.out.println("ID: " +getId()+ " | NOME: " +getNome() + " | CPF: " +getCpf());

    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public static int getProximoId() {
        return proximoId;
    }

    public static void setProximoId(int proximoId) {
        Usuario.proximoId = proximoId;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }
}
