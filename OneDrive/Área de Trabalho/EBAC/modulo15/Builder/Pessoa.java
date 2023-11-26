public class Pessoa{
    
    private String nome;
    private String sobrenome;
    private String user;
    private String email;

    private Pessoa(String nome, String sobrenome, String user, String email) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.user = user;
        this.email = email;
    }

    public static class PessoaBuilder{
        private String nome;
        private String sobrenome;
        private String user;
        private String email;

        public PessoaBuilder nome(String nome){
            this.nome = nome;
            return this;
        }

        public PessoaBuilder sobrenome(String sobrenome){
            this.sobrenome = sobrenome;
            return this;
        }

        public PessoaBuilder user(String user){
            this.user = user;
            return this;
        }

        public PessoaBuilder email(String email){
            this.email = email;
            return this;
        }

        public Pessoa build(){
            return new Pessoa(nome, sobrenome, user, email);
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Nome = " + nome + " " + sobrenome + ", User = " + user + ", Email = " + email;
    }

    

}