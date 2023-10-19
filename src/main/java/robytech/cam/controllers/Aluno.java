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

    public static boolean salvarAluno(ArrayList<Aluno> alunos, Aluno aluno) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Deseja salvar os dados do aluno? (s/n): ");
        String respostaSalvar = scanner.nextLine();

        if (respostaSalvar.equalsIgnoreCase("s")) {
            System.out.println("Dados salvos!");
            alunos.add(aluno);
            return true;
        } else {
            System.out.println("Dados nao salvos.");
            return false; 
        }
    }

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

}
