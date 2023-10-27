import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num1, num2;
        char operador;

        System.out.print("Ingresa el primer número: ");
        num1 = scanner.nextDouble();

        System.out.print("Ingresa un operador (+, -, *, /): ");
        operador = scanner.next().charAt(0);

        System.out.print("Ingresa el segundo número: ");
        num2 = scanner.nextDouble();

        double resultado;

        switch (operador) {
            case '+':
                resultado = num1 + num2;
                break;
            case '-':
                resultado = num1 - num2;
                break;
            case '*':
                resultado = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    resultado = num1 / num2;
                } else {
                    System.out.println("No se puede dividir por cero.");
                    return;
                }
                break;
            default:
                System.out.println("Operador no válido.");
                return;
        }

        System.out.println("Resultado: " + resultado);
    }
}