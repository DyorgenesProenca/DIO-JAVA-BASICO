public class Main {
    public static void main(String[] args) {
        Iphone meuIphone = new Iphone();

        // Testando as funcionalidades do Aparelho Telefonico
        meuIphone.ligar("123456789");
        meuIphone.atender();
        meuIphone.iniciarCorreioVoz();

        // Testando as funcionalidades do Navegador Internete
        meuIphone.exibirPagina("www.exemplo.com");
        meuIphone.atualizarPagina();
        meuIphone.adicionarNovaAba();

        // Testando as funcionalidades do Reprodutor Musical
        meuIphone.tocarMusica();
        meuIphone.pausar();
        meuIphone.selecionarMusica("Minha Música Favorita");
    }
}
