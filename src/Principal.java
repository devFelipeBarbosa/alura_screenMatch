public class Principal {
    public static void main(String[] args) {

        Filme meuFilme = new Filme();

        meuFilme.nome = "O Poderoso Chefão";
        meuFilme.anodeLancamento = 1970;
        meuFilme.duracaoEmMinutos = 180;

        System.out.println(meuFilme.nome);
        System.out.println(meuFilme.anodeLancamento);

    }
}