import java.util.List;

public interface IUsuario {
    List<String> obterDadosBasicos();
    List<String> obterDadosSensiveis(Funcionario funcionario);
}
