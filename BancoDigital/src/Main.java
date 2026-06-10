public class Main {
    public static void main(String[] args) {
        // Inicializando o ecossistema do banco
        Banco javaBank = new Banco("JavaBank International");

        // Criando clientes usando o construtor do Lombok
        Cliente dyorgenes = new Cliente("Dyorgenes");
        Cliente lucas = new Cliente("Lucas");

        // Abrindo contas
        Conta ccDyorgenes = new ContaCorrente(dyorgenes);
        Conta cpLucas = new ContaPoupanca(lucas);

        // Registrando as contas no banco
        javaBank.adicionarConta(ccDyorgenes);
        javaBank.adicionarConta(cpLucas);

        // --- Fluxo de Sucesso ---
        System.out.println("=== EXECUTANDO OPERAÇÕES DE SUCESSO ===");
        ccDyorgenes.depositar(500.00);
        ccDyorgenes.imprimirExtrato();

        System.out.println("\n--- Transferindo R$ 150,00 para Lucas ---");
        ccDyorgenes.transferir(150.00, cpLucas);

        ccDyorgenes.imprimirExtrato();
        cpLucas.imprimirExtrato();

        // --- Fluxo de Exceção (Programação Defensiva) ---
        System.out.println("\n=== SIMULANDO ERRO DE NEGÓCIO (SALDO INSUFICIENTE) ===");
        try {
            // Dyorgenes só tem R$ 350,00 restantes, mas tentará transferir R$ 1000,00
            ccDyorgenes.transferir(1000.00, cpLucas);
        } catch (IllegalArgumentException e) {
            System.err.println("ALERTA DO SISTEMA: " + e.getMessage());
        }

        // Verificando que o saldo de ninguém foi alterado após a falha da transferência
        System.out.println("\n=== VERIFICANDO SALDOS APÓS O ERRO ===");
        ccDyorgenes.imprimirExtrato();

        // Listando todas as contas gerenciadas pelo banco
        javaBank.listarContas();
    }
}