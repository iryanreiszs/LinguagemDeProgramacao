import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("P1: ");
        double P1 = input.nextDouble();
        System.out.println("E1: ");
        double E1 = input.nextDouble();
        System.out.println("E2: ");
        double E2 = input.nextDouble();
        System.out.println("X: ");
        double X = input.nextDouble();
        System.out.println("Sub: ");
        double sub = input.nextDouble();
        System.out.println("API: ");
        double api =  input.nextDouble();

        double y = P1 * 0.5 + (E1 * 0.2) + (E2 * 0.3) + X + (sub * 0.15) - 5.9;

        double media = ((P1*0.5 + (E1 * 0.2) + (E2 * 0.3) + X + (sub*0.15)) * 0.5)+ Math.max(y,0) / y * (api * 0.5);

        System.out.println("Media: " + media);


        // Média = ((P1*0.5+E1*0.2+E2*0.3+X+SUB*0.15)*0.5)
        // +(max(P1*0.5+E1*0.2+E2*0.3+X+(SUB*0.15)-5.9, 0)
        // /(P1*0.5+E1*0.2+E2*0.3+X+(SUB*0.15)-5.9))*API*0.5
    }
}
