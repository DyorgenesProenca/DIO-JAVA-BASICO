# DIO-JAVA-BASICO

**Apresentação do Repositório**

- **Resumo:** Coleção de exercícios e exemplos em Java focada em fundamentos de POO, herança, interfaces, exceções e controle de fluxo.
- **BancoDigital:** Exemplo de sistema bancário com `Banco`, `Cliente`, `Conta`, `ContaCorrente`, `ContaPoupanca`, `IConta` e `Main` — demonstra modelagem de classes, encapsulamento e operações básicas de conta.
- **conta banco:** Aplicação terminal `ContaTerminal` que mostra interação via linha de comando e operações simples de conta.
- **desafio controle de fluxo:** Exercício com `Contador` e `ParametrosInvalidosException` para praticar estruturas de repetição, condicionais e tratamento de exceções.
- **iPhone POO:** Projeto orientado a objetos com `AparelhoTelefonico`, `Iphone`, `NavegadorInternete`, `ReprodutorMusical` e `Main` — ilustra interfaces, polimorfismo e composição.

**Exemplos de código**

- `IConta` (interface):

```java
public interface IConta {
	 void sacar(double valor);
	 void depositar(double valor);
	 void transferir(double valor, Conta contaDestino);
	 void imprimirExtrato();
}
```

- `Conta` (trecho com regras de negócio básicas):

```java
@Override
public void sacar(double valor) {
	if (valor <= 0) throw new IllegalArgumentException("O valor do saque deve ser maior que zero.");
	if (this.saldo < valor) throw new IllegalArgumentException("Saldo insuficiente. Saldo atual: R$ " + this.saldo);
	this.saldo -= valor;
}

@Override
public void depositar(double valor) {
	if (valor <= 0) throw new IllegalArgumentException("O valor do depósito deve ser maior que zero.");
	this.saldo += valor;
}

@Override
public void transferir(double valor, Conta contaDestino) {
	this.sacar(valor);
	contaDestino.depositar(valor);
}
```

- `ContaCorrente` (imprimindo extrato):

```java
public class ContaCorrente extends Conta {
	public ContaCorrente(Cliente cliente){ super(cliente); }
	@Override
	public void imprimirExtrato() {
		System.out.println("---- Extrato da conta Corrente ----");
		super.imprimirInfoComuns();
	}
}
```

- `Contador` (controle de fluxo com exceção customizada):

```java
static void contar(int p1, int p2 ) throws ParametrosInvalidosException {
	if (p1 > p2) throw new ParametrosInvalidosException("O segundo parâmetro deve ser maior que o primeiro");
	for (int i = 0; i <= (p2 - p1); i++) {
		System.out.println(p1 + i);
	}
}
```

- `Iphone` (implementação de múltiplas interfaces):

```java
public class Iphone implements AparelhoTelefonico, NavegadorInternete, ReprodutorMusical {
	public void ligar(String numero) { System.out.println("Ligando para " + numero + "..."); }
	public void atender() { System.out.println("Atendendo a ligação..."); }
	public void exibirPagina(String url) { System.out.println("Exibindo a página: " + url); }
	public void tocarMusica() { System.out.println("Tocando a música..."); }
}
```