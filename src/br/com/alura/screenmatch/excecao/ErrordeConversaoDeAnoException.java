package br.com.alura.screenmatch.excecao;

public class ErrordeConversaoDeAnoException extends RuntimeException {

    private String mensagem;

    public ErrordeConversaoDeAnoException(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage(){
        return this.mensagem;
    }
}
