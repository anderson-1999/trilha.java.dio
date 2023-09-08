package sem.dominio;

import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numeroAgencia = 0;

        while (numeroAgencia == 0) {
            System.out.println("Por favor, digite o número da Agência!");
            numeroAgencia = numerarAgencia(scanner.nextLine());
        }

        String numeroConta = "";
        while (numeroConta.isBlank()) {
            System.out.println("Por favor, digite o número da Conta!");
            numeroConta = numerarConta(scanner.nextLine());
        }

        String nome = "";
        while (nome.isBlank()) {
            System.out.println("Por favor, digite o nome do titular da Conta");
            nome = scanner.nextLine();
        }

        double saldo = 0.0;
        while (saldo == 0.0) {
            System.out.println("Por favor, digite o valor em conta!");
            saldo = gerarSaldo(scanner.nextLine());
        }

        System.out.printf("Olá %s," +
                " obrigado por criar uma conta em nosso banco, sua agência é %d," +
                " conta %s e seu saldo" +
                " %.2f já está disponível para saque", nome, numeroAgencia, numeroConta, saldo);

    }
    public static int numerarAgencia(String numero) {

        try {
            if(numero.length() != 4) {
                System.out.println("por favor, digite um agência com 4 digitos");
                return 0;
            }
            return Integer.parseInt(numero);
        } catch (NumberFormatException e) {
            System.out.println("Por favor, digite sequência númerica");
            return 0;
        }
    }

    public static String numerarConta(String numero) {

        boolean z = false;
        String novoNumero = "";
        for(int i = 0; i < numero.length(); i++) {

            novoNumero = novoNumero + (numero.charAt(i));

            if(i == (numero.length() - 2)){
                z = numero.charAt(i) == '-';
                novoNumero = novoNumero.concat("-");
            }

            if(!(Character.isDigit(numero.charAt(i))) && !z) {
                System.out.println("numero de conta inválido");
                return "";
            }
        }

        if (z){
            return numero;
        }
        return novoNumero;
    }

    public static double gerarSaldo(String numero) {
        try {
            return Double.parseDouble(numero.replace(",", "."));
        } catch (NumberFormatException e) {
            System.out.println("Você deve ter digita uma letra, por favor apenas números");
            return 0.0;
        }
    }
}