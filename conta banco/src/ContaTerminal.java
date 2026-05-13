import java.util.Scanner;

public class ContaTerminal {
    public int numeroConta;
    public int numeroAgencia;
    public String nomeTitular;
    public double saldo;
    public double valor_solicitado;
    public static void main(String[] args) {
        ContaTerminal conta = new ContaTerminal();
        conta.criarConta(conta.numeroConta, conta.numeroAgencia, conta.nomeTitular, conta.saldo);
        conta.transferencia(conta.saldo);
        ContaTerminal conta2 = new ContaTerminal();
        conta2.criarConta(conta2.numeroConta, conta2.numeroAgencia, conta2.nomeTitular, conta2.saldo);
        conta2.transferencia(conta2.saldo);
    }

    public void criarConta(int numeroConta, int numeroAgencia, String nomeTitular, double saldo) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o número da conta: ");
        numeroConta = scan.nextInt();
        System.out.println("Digite o número da agência: ");
        numeroAgencia = scan.nextInt();
        System.out.println("Digite o nome do titular da conta: ");
        nomeTitular = scan.next();
        System.out.println("Digite o saldo inicial: ");
        saldo = scan.nextDouble();
        this.numeroConta = numeroConta;
        this.numeroAgencia = numeroAgencia;
        this.nomeTitular = nomeTitular;
        this.saldo = saldo; // Saldo inicial fixo para teste
        System.out.println("Conta criada com sucesso! Número da conta: " + numeroConta + ", Agência: " + numeroAgencia + ", Titular: " + nomeTitular + ", Saldo inicial: R$ " + saldo);

    }

     public void transferencia(double valor) {
            Scanner scan = new Scanner(System.in);
        System.out.println("Digite o valor a ser transferido: ");
        valor_solicitado = scan.nextDouble();
        if (valor_solicitado > saldo) {
            System.out.println("Saldo insuficiente para transferência.");
        } else {
            saldo -= valor_solicitado;
            System.out.println("Transferência de R$ " + valor_solicitado + " realizada com sucesso. Saldo atual: R$ " + saldo);
        }
    }
}