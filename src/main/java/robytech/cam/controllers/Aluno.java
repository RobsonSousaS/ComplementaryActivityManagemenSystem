package main.java.robytech.cam.controllers;

import java.util.ArrayList;
import java.util.Scanner;

public class Aluno {
    private String nomeCompleto;
    private int matricula;
    private String curso;
    private int cargaHorariaTotal;
    private int quantidadeAtividades;

    Scanner scanner = new Scanner(System.in);

    public Aluno(String nomeCompleto, int matricula, String curso) {
        this.nomeCompleto = nomeCompleto;
        this.matricula = matricula;
        this.curso = curso;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getCargaHorariaTotal() {
        return cargaHorariaTotal;
    }

    public void setCargaHorariaTotal(int cargaHorariaTotal) {
        this.cargaHorariaTotal = cargaHorariaTotal;
    }

    public int getQuantidadeAtividades() {
        return quantidadeAtividades;
    }

    public void setQuantidadeAtividades(int quantidadeAtividades) {
        this.quantidadeAtividades = quantidadeAtividades;
    }
    /*
     * corrigir erros de salvar dados no caso de espaço
     * e verificar correção de erros do "s" "sim" ou "nao"
     */
    public static boolean salvarAluno(ArrayList<Aluno> alunos, Aluno aluno) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Deseja salvar os dados do aluno? (s/n): ");
        String respostaSalvar = scanner.nextLine();

        if (respostaSalvar.equalsIgnoreCase("s") || respostaSalvar.equalsIgnoreCase("sim")) {
            System.out.println("Dados salvos!");
            alunos.add(aluno);
            return true;
        } else {
            System.out.println("Dados nao salvos.");
            return false;
        }
    }
    /*
     * corrigir erros cadastro, nome, matricula, curso
     * 
     */
    public static Aluno cadatrarAluno(ArrayList<Aluno> alunos) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o Nome Completo do aluno: ");
        String nomeCompleto = scanner.nextLine();
        System.out.println("Informe a Matrícula do Aluno: ");
        int matricula = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Informe o Curso do Aluno: ");
        String curso = scanner.nextLine();
        Aluno aluno = new Aluno(nomeCompleto, matricula, curso);
        boolean dadosSalvos = salvarAluno(alunos, aluno);
        if (dadosSalvos) {
            System.out.println("Aluno cadastrado com sucesso!");
        } else {
            System.out.println("Cadastro do aluno cancelado.");
        }

        return aluno;
    }

    public static boolean verificarMatriculaExistente(int matricula, ArrayList<Aluno> alunos) {
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula() == matricula) {
                return true;
            }
        }
        return false;
    }

    public static void mostrarCargaHorariaTotal(ArrayList<Aluno> alunos) {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno está cadastrado.");
        } else {
            System.out.println("Carga horária total das atividades complementares de todos os alunos cadastrados:");
            for (Aluno aluno : alunos) {
                System.out.println("Nome: " + aluno.getNomeCompleto());
                System.out.println("Matrícula: " + aluno.getMatricula());
                System.out.println("Curso: " + aluno.getCurso());
                System.out.println("Carga Horária Total: " + aluno.getCargaHorariaTotal() + " horas");
                System.out.println("Quantidade de Atividades Complementares: " + aluno.getQuantidadeAtividades());
                System.out.println("------------------------");
            }
        }
    }

    public static void mostrarCargaHorariaAlunoPorMatricula(int matricula, ArrayList<Aluno> alunos) {
        boolean encontrado = false;
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula() == matricula) {
                System.out.println("Nome: " + aluno.getNomeCompleto());
                System.out.println("Matrícula: " + aluno.getMatricula());
                System.out.println("Curso: " + aluno.getCurso());
                System.out.println("Carga Horária Total: " + aluno.getCargaHorariaTotal() + " horas");
                System.out.println("Quantidade de Atividades Complementares: " + aluno.getQuantidadeAtividades());
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Aluno com a matrícula " + matricula + " nao encontrado, ou nao foi cadastrado no sistema");
        }
    }
}
