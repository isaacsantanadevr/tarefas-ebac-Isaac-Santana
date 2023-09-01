package pessoas;

public class CadastroPessoas {
    public static void main(String[] args) {
        
        PessoaFisica pessoa1 = new PessoaFisica();
        pessoa1.setNome("João Paulo");
        pessoa1.setSobrenome(" Oliveira");
        pessoa1.setCpf(12345678910l);
        
        System.out.println(pessoa1.getNome() + pessoa1.getSobrenome());
        System.out.println("O CPF eh: " + pessoa1.getCpf());
        System.out.println("s");

        PessoaJuridica pessoa2 = new PessoaJuridica();
        pessoa2.setNome("Mário");
        pessoa2.setSobrenome(" Alberto");
        pessoa2.setCnpj(10987654321l);
        System.out.println(pessoa2.getNome() + pessoa2.getSobrenome());
        System.out.println("O CNPJ eh: " + pessoa2.getCnpj());

    }
}
