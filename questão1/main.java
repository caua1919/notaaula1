package questão1;

import java.util.Scanner;

public class main {
    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a primeira nota: ");
        double nota1 = scanner.nextDouble();
        
        System.out.print("Digite a segunda nota: ");
        double nota2 = scanner.nextDouble();
        
        System.out.print("Digite a terceira nota: ");
        double nota3 = scanner.nextDouble();

        double media = (nota1 + nota2 + nota3) / 3;

        if (media >= 70) {
            System.out.println("Aluno " + nome + " está APROVADO com média: " + media);
        } else if (media < 40) {
            System.out.println("Aluno " + nome + " está REPROVADO com média: " + media);
        } else {
            System.out.println("Aluno " + nome + " está na FINAL com média: " + media);
        }

        scanner.close();
    }
}

