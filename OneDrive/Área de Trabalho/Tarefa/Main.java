package Tarefa;

public class Main {
    public static void main(String[] args) throws Exception{
        
        if(NomeTabela.class.isAnnotationPresent(Tabela.class)){
            Tabela tab = NomeTabela.class.getAnnotation(Tabela.class);

            System.out.println(tab.nome());
        }

    }
}
