public class ParOuImpar {
    public static void main(String[] args) {
        int numeroA = 5;
        int numeroB = 6;
        int numeroC = 3;
        // Nas Linhas acima eu criei 3 variaves do tipo Int(Inteira) para repetir a logica com valores diferente


        // Nas linhas abaixo eu pratiquei o If e resolvi testar o Else
        if (numeroA % 2 == 0) {
            System.out.println(numeroA + " É par");
        }else{
            System.out.println(numeroA + " É impar");
        }
        // o If criei com a condição se o resto da divisão for Zero o numero sera par e usei a segunte operação aritmética %
        if (numeroB % 2 == 0) {
            System.out.println(numeroB + " É par");
        }else{
            System.out.println(numeroB + " É impar");
        }
        // O Else não criei uma condição pos se a condição do If não for atendida quer dizer que não ira dar zero então ira ser impar
        if (numeroC % 2 == 0) {
            System.out.println(numeroC + " É par");
        }else{
            System.out.println(numeroC + " É impar");
        }

    }
}
