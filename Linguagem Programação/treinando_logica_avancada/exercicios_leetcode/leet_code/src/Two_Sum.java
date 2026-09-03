import java.util.Arrays;

public class Two_Sum {
    public static void main(String[] args) {
        
        int[] array = new int[] {9,4,3,8,5,7,8};
        int target = 16;

        for(int i=0; i<array.length; i++){
            int parUm = array[i];

            for(int j = 0; j <array.length; j++){
                int parDois = array[j];
                if (i != j && parUm +parDois == target) {
                    System.out.println("A soma do Par Um "+ parUm +" e do Par Dois " + parDois + " é igual o target " + target);
                    
                    
                    int[] SumArray = {parUm, parDois};
                    String textArray = Arrays.toString(SumArray);
                    System.out.println("A posição do array" + textArray);

                }
            }
        }
            
    }
        
}

