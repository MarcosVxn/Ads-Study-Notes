import java.util.Scanner;

public class ClassificadorIdade {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Qual sua idade? ");
        int idade = scan.nextInt();

        if (idade >= 60 && idade <= 119)  System.out.println("Você é idoso");  
        if (idade >= 120) { System.out.println("Você é mumia");
        
            
        } else if ( idade >= 18 && idade <= 57) { System.out.println("Você é Adulto");
            
        } else if ( idade >= 13 && idade <= 0) {System.out.println("Você é Adolescente");

        } else { System.out.println("Você é Criança");

        }
        
        scan.close();
    }
}
