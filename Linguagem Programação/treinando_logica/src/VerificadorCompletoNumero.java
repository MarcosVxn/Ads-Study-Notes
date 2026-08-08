public class VerificadorCompletoNumero {
    public static void main(String[] args) {
        int numero = -11;
            // Crei a Variavel para pode colocar o numero para verificar

            // a primeira If foi usada para verificar se o numero é igual zero usando o sinal == significa igual
        if (numero == 0) {
            System.out.println(numero + " é  zero");
        } else if (numero %2 == 0 && numero > 0) { // O primeiro Else If foi usado para verificar se o numero é par verificando o resto da divisão com o % e depois verificando se ele era positivo com o sinal de maior >
            System.out.println(numero + " é um par positivo");
        } else if (numero %2 != 0 && numero > 0) { // Aqui nesse Else eu resolvi fazer diferente usei o sinal de diferente ! para verificar se o resto da divisão seria diferente de zero então seria impar e depois verifiquei sera era positivo ainda usando o mesmo sinal de maior >
            System.out.println(numero + " é impar positivo");
        } else if (numero %2 == 0 && numero < 0){ // aqui foi verificando sera era negativo usando o sinal de menor <
            System.out.println(numero + " é par negativo");
        } else { // o Else foi criado pos se não fosse um par negativo só sobraria o impar negativo então não teria o porque criar mais else if ou if
            System.out.println(numero + " é impar negativo");
        }
    }
}
