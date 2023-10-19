package main.java.robytech.cam.controllers;

import java.util.ArrayList;
import java.util.Scanner;

public class Atividade {
    private String nomeAluno;
    private int matricula;
    private int numeroRegistro;
    private int grupoAtividade;
    private String descricaoAtividade;
    private boolean statusAproveitamento;
    private int cargaHorariaConsiderada;

    public Atividade(String nomeAluno, int matricula, int grupoAtividade, String descricaoAtividade) {
        this.nomeAluno = nomeAluno;
        this.matricula = matricula;
        this.grupoAtividade = grupoAtividade;
        this.descricaoAtividade = descricaoAtividade;
        this.statusAproveitamento = false;
        this.cargaHorariaConsiderada = 0;
        this.numeroRegistro = numeroRegistro++;
    }

    public int getNumeroRegistro() {
        return numeroRegistro;
    }

    public void setNumeroRegistro(int numeroRegistro) {
        this.numeroRegistro = numeroRegistro;
    }

    public int getGrupoAtividade() {
        return grupoAtividade;
    }

    public void setGrupoAtividade(int grupoAtividade) {
        this.grupoAtividade = grupoAtividade;
    }

    public String getdescricaoAtividade() {
        return descricaoAtividade;
    }

    public void setdescricaoAtividade(String descricaoAtividade) {
        this.descricaoAtividade = descricaoAtividade;
    }

    public boolean isStatusAproveitamento() {
        return statusAproveitamento;
    }

    public void setStatusAproveitamento(boolean statusAproveitamento) {
        this.statusAproveitamento = statusAproveitamento;
    }

    public int getCargaHorariaConsiderada() {
        return cargaHorariaConsiderada;
    }

    public void setCargaHorariaConsiderada(int cargaHorariaConsiderada) {
        this.cargaHorariaConsiderada = cargaHorariaConsiderada;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public static boolean salvarAtividade(ArrayList<Atividade> atividades, Atividade atividade) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Deseja salvar as informações da atividade? (s/n): ");
        String respostaSalvar = scanner.nextLine();

        if (respostaSalvar.equalsIgnoreCase("s")||respostaSalvar.equalsIgnoreCase("sim")) {
            System.out.println("Informaçoes salvas!");
            atividades.add(atividade);
            return true;
        } else {
            System.out.println("Informaçoes nao salvas.");
            return false;
        }
    }

    public static Atividade cadastrarAtividade(ArrayList<Aluno> alunos, ArrayList<Atividade> atividades) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a matrícula do aluno: ");
        int matricula = scanner.nextInt();
        Aluno alunoEncontrado = encontrarAlunoPorMatricula(matricula, alunos);
        if (alunoEncontrado != null) {

            String nomeAluno = alunoEncontrado.getNomeCompleto();
            scanner.nextLine();
            System.out.print("Digite o grupo da atividade: ");
            int grupoAtividade = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Digite a descriçao da atividade: ");
            String descricaoAtividade = scanner.nextLine();

            Atividade atividade = new Atividade(nomeAluno, matricula, grupoAtividade, descricaoAtividade);
            boolean dadosSalvos = salvarAtividade(atividades, atividade);
            if (dadosSalvos) {
                System.out.println("Atividade cadastrada com sucesso!");
            } else {
                System.out.println("Cadastro da atividade cancelado.");
            }

            return atividade;
        } else {

            System.out.println("Matrícula nao encontrada. Nao é possível cadastrar a atividade.");
            return null;
        }
    }

    private static Aluno encontrarAlunoPorMatricula(int matricula, ArrayList<Aluno> alunos) {
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula() == matricula) {
                return aluno;
            }
        }
        return null;
    }

    public void exibirAtividade() {
        System.out.println("Número de Registro: " + numeroRegistro);
        System.out.println("Nome do Aluno: " + nomeAluno);
        System.out.println("Matrícula: " + matricula);
        System.out.println("Grupo da Atividade: " + grupoAtividade);
        System.out.println("Descriçao da Atividade: " + descricaoAtividade);
        System.out.println("Status de Aproveitamento: " + statusAproveitamento);
        System.out.println("Carga Horária Considerada: " + cargaHorariaConsiderada + " horas\n");
    }

    public static void exibirAtividadesPorMatricula(ArrayList<Atividade> atividades, int matricula) {
        boolean encontrou = false;
        for (Atividade atividade : atividades) {
            if (atividade.getMatricula() == matricula) {
                atividade.exibirAtividade();
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhuma atividade encontrada para a matrícula " + matricula + ".");
        }
    }

    public static void alterarStatusAproveitamento(ArrayList<Atividade> atividades, ArrayList<Aluno> alunos) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a matrícula do aluno: ");
        int matricula = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite o número de registro da atividade: ");
        int numeroRegistro = scanner.nextInt();
        scanner.nextLine();

        Atividade atividadeEncontrada = encontrarAtividadePorMatriculaENumeroRegistro(matricula, numeroRegistro,
                atividades);
        if (atividadeEncontrada != null) {
            System.out.print("Digite o novo status de aproveitamento (TRUE ou FALSE): ");
            boolean novoStatusAproveitamento = scanner.nextBoolean();
            scanner.nextLine();
            System.out.print("Digite a carga horária considerada: ");
            int cargaHorariaConsiderada = scanner.nextInt();
            scanner.nextLine();

            atividadeEncontrada.setStatusAproveitamento(novoStatusAproveitamento);
            atividadeEncontrada.setCargaHorariaConsiderada(cargaHorariaConsiderada);

            if (novoStatusAproveitamento) {
                Aluno aluno = encontrarAlunoPorMatricula(matricula, alunos);
                if (aluno != null) {
                    aluno.setCargaHorariaTotal(aluno.getCargaHorariaTotal() + cargaHorariaConsiderada);
                    aluno.setQuantidadeAtividades(aluno.getQuantidadeAtividades() + 1);
                    System.out.println(
                            "Atividade aprovada. Carga horária total atualizada para: " + aluno.getCargaHorariaTotal());
                }
            } else {
                System.out.println("Atividade reprovada.");
            }
        } else {
            System.out.println("Atividade não encontrada para a matrícula e número de registro fornecidos.");
        }
    }

    private static Atividade encontrarAtividadePorMatriculaENumeroRegistro(int matricula, int numeroRegistro,
            ArrayList<Atividade> atividades) {
        for (Atividade atividade : atividades) {
            if (atividade.getMatricula() == matricula && atividade.getNumeroRegistro() == numeroRegistro) {
                return atividade;
            }
        }
        return null;
    }

}
