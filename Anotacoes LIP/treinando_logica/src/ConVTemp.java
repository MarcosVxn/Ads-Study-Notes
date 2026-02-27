public class ConVTemp {
    public static void main(String[] args){ 
        // Essa Primeira Variável foi criada para guardar o valor de Celsius
        double Celsius = 10;
        // A segunda Variável para foi feita para Converter Celcius em Fahrenheit
        double Fahrenheit;
        // Essa terceira Variável foi somente para dificultar o desafio e conseguir converter novamente
        double CelsConvertido;

        // Primeira converção é feita pegando a Variável Celsius e Multiplicando por 9 e Depois Dividindo por 5 e no final Somando com 32
        Fahrenheit = (Celsius * 9/5) + 32;
        // Agora para converter novamento é diferente precissamos Subtrair por 32 e depois disso Multiplicar 5 e depois Dividir novamente por 9
        CelsConvertido = (Fahrenheit -32 ) * 5/9;

        // Primeiro south foi usado para mostrar a Temperatua Atual no caso o Celsius
        System.out.println("Temperatura em Celsius atualmente é " + Celsius);
        // O segundo south foi usado para mostrar a converção
        System.out.println("Temperatura em Fahrenheit atualmente é " + Fahrenheit);
        // O terceiro south foi somente usado para reconverter
        System.out.println("Temperatura em Celsius Convertida é " + CelsConvertido);

    }     
    
}