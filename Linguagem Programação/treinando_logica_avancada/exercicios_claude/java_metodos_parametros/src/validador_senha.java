package java_metodos_parametros.src;

import java.util.Scanner;

public class validador_senha {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Qual sua Senha: ");
        String senha = scan.next();
        boolean resultado = verificarSenha(senha);

        if (resultado == true) {
            System.out.println("Parabens senha correta");
        }else{
            System.out.println("Senha invalida");
        }

        scan.close();
    }

    private static final int QUANTIDADE_MIN = 8;

    private static boolean verificarSenha(String senha) {
        int quantidade = senha.length();
        boolean quantidademin = false;
        boolean encontrouUpper = false;
        boolean encontrouNum = false;

        if (quantidade < QUANTIDADE_MIN) {
            System.out.println("A senha deve ter no minimo 8 caracteres");
            quantidademin = false;
        } else {
            quantidademin = true;
        }
        for (int i = 0; i < senha.length(); i++) {
            char letras = senha.charAt(i);

            if (Character.isUpperCase(letras)) {
                encontrouUpper = true;
            }
            
            if (Character.isDigit(letras)) {
                encontrouNum = true;
            }
        }

        return encontrouUpper && encontrouNum && quantidademin;
    }

}
