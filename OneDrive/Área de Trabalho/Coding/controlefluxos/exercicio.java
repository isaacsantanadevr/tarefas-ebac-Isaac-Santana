package controlefluxos;
import java.util.Scanner;

public class exercicio {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int nota1, nota2, nota3, nota4;
        float media;

        System.out.print("Digite a primeira nota: ");
        nota1 = s.nextInt();

        System.out.print("Digite a segunda nota: ");
        nota2 = s.nextInt();
        
        System.out.print("Digite a terceira nota: ");
        nota3 = s.nextInt();

        System.out.print("Digite a quarta nota: ");
        nota4 = s.nextInt();

        media = (nota1 + nota2 + nota3 + nota4) / 4;

        s.close();

        System.out.println("Sua média é: " + media);
        
        String mediaSt = getMedia(media);
        System.out.println(mediaSt);
    }

    public static String getMedia(float media){
        String result;
        if(media <= 10 && media >= 7){
            result = "Você foi aprovado";
        }
        else if(media < 7 && media >= 5){
            result = "Você está na recuperação";
        }
        else{
            result = "Você perdeu";
        }

        return result;
    }

}
