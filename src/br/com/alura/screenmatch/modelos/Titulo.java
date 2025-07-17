package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.excecao.ErrordeConversaoDeAnoException;
import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo> {

    private String nome;
    private int anodeLancamento;
    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacoes;
    private int duracaoEmMinutos;


    public Titulo(String nome, int anodeLancamento) {
        this.nome = nome;
        this.anodeLancamento = anodeLancamento;
    }

    public Titulo(TituloOmdb meuTituloOmdb) {
        this.nome = meuTituloOmdb.title();

        if (meuTituloOmdb.year().length() > 4) {
            throw new ErrordeConversaoDeAnoException("Não conseguimos converter o ano. Mais de 4 caracteres!");
        }
        this.anodeLancamento = Integer.valueOf(meuTituloOmdb.year());
        this.duracaoEmMinutos = Integer.valueOf(meuTituloOmdb.runtime().substring(0, 2));

    }

    public String getNome() {
        return nome;
    }

    public int getAnodeLancamento() {
        return anodeLancamento;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public int getTotalDeAvaliacoes(){
        return totalDeAvaliacoes;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAnodeLancamento(int anodeLancamento) {
        this.anodeLancamento = anodeLancamento;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public void exibeFichaTecnica(){
        System.out.println("Nome do br.com.alura.screenmatch.modelos.Filme: " + nome);
        System.out.println("Ano de lançamento: " + anodeLancamento);
    }

    public void avalia(double nota){
        somaDasAvaliacoes += nota;
        totalDeAvaliacoes++;
    }

    public double pegaMedia(){
        return somaDasAvaliacoes / totalDeAvaliacoes;
    }

    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }

    @Override
    public String toString() {
        return  "nome = '" + nome + '\'' +
                ", ano " + anodeLancamento + ", com" +
                " duração de " + duracaoEmMinutos + " minutos.";
    }
}
