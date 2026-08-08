import java.util.Scanner;

public class CalcuradoraIMC {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Primeiro Scan foi usado para conhecer o User
        System.out.print("Olá, qual o seu nome?");
        String nome = scan.nextLine();
        // Segundo foi usado para saber o genero do User apenas para testar o comparador de String
        System.out.print("Qual o seu genero?");
        String genero = scan.nextLine();
        // Nesse scan eu ja comecei a criar as variaveis para fazer a conta do IMC
        System.out.print("Qual sua altura?");
        double altura = scan.nextDouble();
        System.out.print("qual seu peso em (kg)?");
        double peso = scan.nextDouble();
        double imc;

        // Nessa If foi usado o EqualsIgnoreCase que é para comparar string e ignorar as letras maiuculas e assim poder comparar o femino e masculino
        if (genero.equalsIgnoreCase("Masculino")) {
            imc = peso / (altura * altura);
            // O printF serve para formatação e o simbolo %s serve para mostrar onde vai o texto o S é de String e o %.2f serve para mostrar quantas casas decimais deve mostrar
            System.out.printf("Olá %s eu IMC: %.2f", nome, imc);

            
        } else if (genero.equalsIgnoreCase("Feminino")) {
            // nessa parte eu fiz o calculo do IMC primeiro oque esta dentro dos parentes() que era a multiplicação e depois dividi
            imc = peso / (altura * altura);
            System.out.printf("Olá %s eu IMC: %.2f", nome, imc);
        }

        // Aqui fechei o Scan para não ter chance de Sobrecarregar ele
        scan.close();
    }
}
