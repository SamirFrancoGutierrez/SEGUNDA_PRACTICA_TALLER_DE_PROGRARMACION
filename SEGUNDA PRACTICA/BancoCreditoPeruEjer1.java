import java.util.Scanner;

public class BancoCreditoPeruEjer1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar al cliente su nombre y saldo inicial
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese su saldo inicial: ");
        double saldo = scanner.nextDouble();
        double saldoInicial = saldo;

        boolean salir = false;

        while (!salir) {
            System.out.println("\nOpciones:");
            System.out.println("1. Depósito");
            System.out.println("2. Retiro");
            System.out.println("3. Salir");
            System.out.print("Ingrese la opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\nDepósito");
                    System.out.println("1. Efectivo");
                    System.out.println("2. Cheque");
                    System.out.print("Elija el tipo de depósito (1 o 2): ");
                    int tipoDeposito = scanner.nextInt();
                    if (tipoDeposito == 1) {
                        System.out.print("Ingrese la cantidad a depositar en efectivo: ");
                        double deposito = scanner.nextDouble();
                        saldo += deposito;
                    } else if (tipoDeposito == 2) {
                        System.out.print("Ingrese la cantidad del cheque: ");
                        double cheque = scanner.nextDouble();
                        double comision = cheque * 0.01; // 1% de comisión
                        saldo += cheque - comision;
                    } else {
                        System.out.println("Opción no válida. Intente de nuevo.");
                    }
                    break;
                case 2:
                    System.out.println("\nRetiro");
                    System.out.print("Ingrese la cantidad a retirar: ");
                    double retiro = scanner.nextDouble();
                    if (retiro <= saldo) {
                        saldo -= retiro;
                    } else {
                        System.out.println("¡Sobregiro! No tiene suficientes fondos para retirar esa cantidad.");
                    }
                    break;
                case 3:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }

        // Mostrar información al finalizar con asteriscos
        System.out.println("************************");
        System.out.println("Resumen:");
        System.out.println("Nombre del cliente: " + nombre);
        System.out.println("Saldo inicial: " + saldoInicial);
        System.out.println("Saldo final: " + saldo);
        System.out.println("************************");
        scanner.close();
    }
}
