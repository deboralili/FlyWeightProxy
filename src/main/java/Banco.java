import java.util.ArrayList;
import java.util.List;

public class Banco {

    private List<Conta> contas = new ArrayList<>();

    public void cadastrar(String cpf, String nome, String numero, String telefone){
        Usuario usuario = UsuarioFactory.getUsuario(cpf, nome, telefone);
        Conta conta = new Conta(numero, usuario);
        contas.add(conta);
    }

    public List<String> obterContas(){
        List<String> mensagem = new ArrayList<String>();
        for (Conta conta : this.contas) {
            mensagem.add(conta.obterConta());
        }
        return mensagem;
    }

}
