public class PessoaBuilder {
    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa.PessoaBuilder()
            .nome("Isaac")
            .sobrenome("Santana")
            .user("isaacsant_")
            .email("isaac@gmail.com")
            .build(); 

        System.out.println(pessoa1);
    }
}
