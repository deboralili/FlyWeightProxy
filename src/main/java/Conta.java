public class Conta {
    private String numero;
    private Usuario usuario;

    public Conta(String numero, Usuario usuario){
        this.numero = numero;
        this.usuario = usuario;
    }

    public String obterConta(){
        return "Número da Conta: " + this.numero +
                "\nDono da Conta:\n" +
                "Nome: " + usuario.getNome() +
                "\nCpf: " + usuario.getCpf();
    }
}
