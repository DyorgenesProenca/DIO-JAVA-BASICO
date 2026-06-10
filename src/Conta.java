import lombok.Getter;

@Getter
public abstract class Conta implements IConta {
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    // Atributos privados e imutáveis (final) onde faz sentido
    private final int agencia;
    private final int numero;
    private final Cliente cliente;
    private double saldo; // Alteração de estado controlada internamente

    public Conta(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("O cliente associado à conta não pode ser nulo.");
        }
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.saldo = 0.0; // Inicialização explícita
    }

    @Override
    public void sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do saque deve ser maior que zero.");
        }
        if (this.saldo < valor) {
            // Lançamos uma RuntimeException para sinalizar erro de negócio
            throw new IllegalArgumentException("Saldo insuficiente para realizar o saque. Saldo atual: R$ " + this.saldo);
        }
        this.saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do depósito deve ser maior que zero.");
        }
        this.saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        if (contaDestino == null) {
            throw new IllegalArgumentException("A conta de destino não pode ser nula.");
        }
        // Se o saque falhar por falta de saldo, o fluxo quebra aqui
        // e o depósito na conta de destino nunca é executado.
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    protected void imprimirInfoComuns() {
        System.out.printf("Titular: %s%n", this.cliente.getNome());
        System.out.printf("Agência: %d | Conta: %d%n", this.agencia, this.numero);
        System.out.printf("Saldo: R$ %.2f%n", this.saldo);
    }
}