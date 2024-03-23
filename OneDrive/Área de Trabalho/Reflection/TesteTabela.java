public class TesteTabela {
    public static void main(String[] args) throws Exception{
        
        if(ClasseTabela.class.isAnnotationPresent(Tabela.class)){
            Tabela tab = ClasseTabela.class.getAnnotation(Tabela.class);

            System.out.println("O nome da tabela eh: " + tab.valor());
        }

    }
}
