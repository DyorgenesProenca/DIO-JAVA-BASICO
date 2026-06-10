import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Banco {
    private final String nome;
    private final List<Conta> contas;

    public Banco(String nome) {
        this.nome = nome;
        this.contas = new ArrayList<>(); // Evita NullPointerException ao tentar usar a lista
    }

    public void adicionarConta(Conta conta) {
        if (conta == null) {
            throw new IllegalArgumentException("Não é possível adicionar uma conta nula ao banco.");
        }
        this.contas.add(conta);
    }

    public void listarContas() {
        System.out.printf("%n=== Lista de Contas - %s ===%n", this.nome);
        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta registrada neste banco.");
            return;
        }
        contas.forEach(conta ->
            System.out.printf("Cliente: %-12s | Agência: %04d | Conta: %d%n",
                    conta.getCliente().getNome(), conta.getAgencia(), conta.getNumero())
        );
    }
}