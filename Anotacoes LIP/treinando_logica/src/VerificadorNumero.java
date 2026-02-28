public class VerificadorNumero {
    public static void main(String[] args) {
        // Essa variavel foi criada para numeros inteiros sem virgula para assim poder avaliar se é inteiro ou não
        int A = -10;
        int B = 10;
        int C = 0;

        // A primeira if vai comparar se o numero é maior que zero sendo assim positivo e usando o sinal usando > para comparar
        if (A > 0)System.out.println("Letra A " + A + " Ele é positivo");
        // A segunda if ira comparar se o numero é menor que zero sendo assim negativo e usando o sinal < para comparar
        if (A < 0)System.out.println("Letra A " + A + " Ele é negativo");
        // Nessa if iremos verificar se o numero é zero para mostrar o valor dele no terminal
        if (A == 0)System.out.println("Letra A " + A + " Ele é zero");
        if (B > 0)System.out.println("Letra B " + B + " Ele é positivo");
        if (B < 0)System.out.println("Letra B " + B + " Ele é negativo");
        if (B == 0)System.out.println("Letra B " + B + " Ele é zero");
        if (C > 0)System.out.println("Letra C " + C + " Ele é positivo");
        if (C < 0)System.out.println("Letra C " + C + " Ele é negativo");
        if (C == 0)System.out.println("Letra C " + C + " Ele é zero");
            
                
    }
}
