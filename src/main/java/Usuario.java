import java.util.Arrays;
import java.util.List;

public class Usuario implements IUsuario{

    private String nome;
    private String cpf;
    private String telefone;

    public Usuario(String cpf, String nome, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public Usuario(String cpf) {
        this.cpf = cpf;
        Usuario objeto = UsuarioFactory.getUsuario(cpf);
        this.nome = objeto.nome;
        this.telefone = objeto.telefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public List<String> obterDadosBasicos() {
        return Arrays.asList(this.nome, this.telefone);
    }

    @Override
    public List<String> obterDadosSensiveis(Funcionario funcionario) {
        return Arrays.asList(this.cpf);
    }
}
