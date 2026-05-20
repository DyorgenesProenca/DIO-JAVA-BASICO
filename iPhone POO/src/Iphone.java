public class Iphone implements AparelhoTelefonico,NavegadorInternete,ReprodutorMusical {
    @Override
    public void ligar(String numero) {
        System.out.println("Ligando para " + numero + "...");
    }

    @Override
    public void atender() {
        System.out.println("Atendendo a ligação...");
    }
    @Override
    public void iniciarCorreioVoz() {
        System.out.println("Iniciando correio de voz...");
    }
    @Override
    public void exibirPagina(String url) {
        System.out.println("Exibindo a página: " + url);
    }
    public void atualizarPagina() {
        System.out.println("Atualizando a página...");
    }
    public void adicionarNovaAba() {
        System.out.println("Adicionando nova aba...");
    }
    @Override
    public void tocarMusica() {
        System.out.println("Tocando a música...");
    }

    @Override
    public void pausar() {
        System.out.println("Pausando a música...");
    }

    @Override
    public void selecionarMusica(String musica) {
        System.out.println("Selecionando a música: " + musica);
    }

}
