import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioProxyTest {
    @BeforeEach
    void setUp() {
        Usuario usuario = new Usuario("111.111.111-11", "Felipe", "0000-0000");
        Usuario usuario2 = new Usuario("222.222.222-22", "Eduarda", "1212-1200");
        UsuarioFactory.addUsuario(usuario);
        UsuarioFactory.addUsuario(usuario2);
    }

    @Test
    void deveRetornarDadosBasicosUsuario() {
        UsuarioProxy usuarioA = new UsuarioProxy("111.111.111-11");

        assertEquals(Arrays.asList("Felipe", "0000-0000"), usuarioA.obterDadosBasicos());
    }

    @Test
    void deveRetonarDadosSensiveisUsuario() {
        Funcionario funcionario = new Funcionario( true);
        UsuarioProxy usuarioB = new UsuarioProxy("222.222.222-22");

        assertEquals(Arrays.asList("222.222.222-22"), usuarioB.obterDadosSensiveis(funcionario));
    }

    @Test
    void deveRetonarExcecaoFuncionarioNaoAutorizado() {
        try {
            Funcionario funcionarioB = new Funcionario( false);
            UsuarioProxy usuarioB = new UsuarioProxy("222.222.222-22");

            usuarioB.obterDadosSensiveis(funcionarioB);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Funcionário não autorizado", e.getMessage());
        }
    }
}