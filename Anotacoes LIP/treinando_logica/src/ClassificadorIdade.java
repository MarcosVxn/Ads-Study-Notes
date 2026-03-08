import java.util.Scanner;

public class ClassificadorIdade {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // O import pega uma classe da biblioteca java.util chamada Scanner que serve para Ler os dados digitado pelo usuario usando o scan pora guardar essa função

        System.out.print("Qual sua idade? ");
        int idade = scan.nextInt();
        // No int falamos que a idade vai ser oque for escrito no scan que sera um numero inteiro
        
        // Minha logica foi verificar os Numeros maiores primeiros

        // Primeiro If vai verificar se a idade é  maior usando o algoritimo seguinte ">=" 
        if (idade >= 60) { System.out.println("Você é idoso");
            
          // Primeiro Else If vai verificar se alem de maior que é usando o seguinte algoritmo ">=" ele vai verificar se é menor que 57 usando o seguinte algorimo "<="

        } else if ( idade >= 18 && idade <= 57) { System.out.println("Você é Adulto");
            
        } else if ( idade >= 13) {System.out.println("Você é Adolescente");

        } else { System.out.println("Você é Criança");

        }
        
        scan.close();
    }
}