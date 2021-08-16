public class Funcionario {

    private boolean permissao;

    public Funcionario(boolean permissao) {
        this.permissao = permissao;
    }

    public boolean temPermissao() {
        return permissao;
    }

    public void setPermissao(boolean permissao) {
        this.permissao = permissao;
    }
}
