import java.util.HashMap;
import java.util.Map;

public class UsuarioFactory {

    private static Map<String, Usuario> usuarios = new HashMap<>();

    public static Usuario getUsuario(String cpf, String nome, String telefone) {
        Usuario usuario = usuarios.get(cpf);
        if (usuario == null) {
            usuario = new Usuario(cpf, nome, telefone);
            usuarios.put(cpf, usuario);
        }
        return usuario;
    }

    public static Usuario getUsuario(String cpf) {
        Usuario usuario = usuarios.get(cpf);
        return usuario;
    }

    public static void addUsuario(Usuario usuario) {
        usuarios.put(usuario.getCpf(), usuario);
    }

    public static int getTotalUsuarios() { return usuarios.size(); }

    public static void clear() {
        usuarios.clear();
    }
}
