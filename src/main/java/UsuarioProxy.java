import java.util.List;

public class UsuarioProxy implements IUsuario {

    private Usuario usuario;
    private String cpf;

    public UsuarioProxy(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public List<String> obterDadosBasicos() {
        if (this.usuario == null){
            this.usuario = new Usuario(this.cpf);
        }
        return this.usuario.obterDadosBasicos();
    }

    @Override
    public List<String> obterDadosSensiveis(Funcionario funcionario) {
        if (!funcionario.temPermissao()) {
            throw new IllegalArgumentException("Funcionário não autorizado");
        }
        if (this.usuario == null) {
            this.usuario = new Usuario(this.cpf);
        }
        return this.usuario.obterDadosSensiveis(funcionario);
    }
}
