public class PascalCase {
    public static void main(String[] args) {
        int[] array = new int[]{10,45,32,20,27};
        int target = 47;

        for(int i=0; i< array.length; ++i){
            int num1 = array[i];
            int num2 = array[i];

            if (num1 + num2 == target) {
                System.out.println("a soma de " + num1 + " e " + num2 + " e igual a " + target);
            }
        }
    }
}
