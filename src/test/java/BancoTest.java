import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BancoTest {

    @BeforeEach
    void setUp() {
        UsuarioFactory.clear();
    }

    @Test
    void deveRetornarContas() {
        Banco banco = new Banco();
        banco.cadastrar("000.000.000-00", "Madalena", "000", "1111-6666");
        banco.cadastrar("111.111.111-11", "Joaquim", "001", "5555-2222");
        banco.cadastrar("222.222.222-22", "Leandro", "002", "4444-3333");

        List<String> mensagem = Arrays.asList(
                "Número da Conta: 000\nDono da Conta:\nNome: Madalena\nCpf: 000.000.000-00",
                "Número da Conta: 001\nDono da Conta:\nNome: Joaquim\nCpf: 111.111.111-11",
                "Número da Conta: 002\nDono da Conta:\nNome: Leandro\nCpf: 222.222.222-22");

        assertEquals(mensagem, banco.obterContas());
    }

    @Test
    void deveRetornarTotalUsuarios() {
        Banco banco = new Banco();
        banco.cadastrar("000.000.000-00", "Madalena", "000", "1111-6666");
        banco.cadastrar("111.111.111-11", "Joaquim", "001", "5555-2222");
        banco.cadastrar("222.222.222-22", "Leandro", "002", "4444-3333");
        banco.cadastrar("222.222.222-22", "Leandro", "002", "4444-3333");
        assertEquals(3, UsuarioFactory.getTotalUsuarios());
    }

}