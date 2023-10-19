package main.java.robytech.cam;

import java.util.ArrayList;
import java.util.Scanner;

import main.java.robytech.cam.controllers.Aluno;
import main.java.robytech.cam.controllers.Atividade;

public class aplication {
    public static void main(String[] args) {
        ArrayList<Aluno> alunos = new ArrayList<>();
        ArrayList<Atividade> atividades = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opçao:");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Cadastrar Atividade");
            System.out.println("3. Visualizar atividades a partir da matricula");
            System.out.println("4. Alterar status de aproveitamento da atividade");
            System.out.println("7. Sair");

            if (scanner.hasNextInt()) {
                int escolha = scanner.nextInt();
                scanner.nextLine();

                switch (escolha) {
                    case 1:
                        Aluno aluno = Aluno.cadatrarAluno(alunos);
                        break;
                    case 2:
                        Atividade atividade = Atividade.cadastrarAtividade(alunos, atividades);
                        break;
                    case 3:
                        System.out.print("Digite a matrícula do aluno para pesquisar atividades: ");
                        int matricula = scanner.nextInt();
                        Atividade.exibirAtividadesPorMatricula(atividades, matricula);
                        break;
                    case 4:
                        Atividade.alterarStatusAproveitamento(atividades, alunos);
                        break;
                    case 7:
                        System.out.println(
                                "Obrigado por usar o sistema de gestao da atividades complementares. Tchau tchau!");
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Opçao invalida. Por favor, escolha novamente.");
                }
            } else {
                System.out.println("Opçao inválida. Por favor, escolha novamente.");
                scanner.nextLine();
            }
        }
    }
}