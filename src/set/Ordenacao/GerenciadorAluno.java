package set.Ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAluno {
    //atributos
    private Set<Aluno> alunoSet;
    public GerenciadorAluno() {
        this.alunoSet = new HashSet<>();
    }
    public void adicionarAluno(String nome, Long matricula, double media) {
        alunoSet.add(new Aluno(nome, matricula, media));
    }
    public void removerAlunoPorMatricula(long matricula) {
        Aluno alunoParaRemover = null;
        if(!alunoSet.isEmpty()) {
            for(Aluno a : alunoSet) {
                if(a.getMatricula() == matricula) {
                    alunoParaRemover = a;
                    break;
                }
            }
            alunoSet.remove(alunoParaRemover);
        } else {
            throw new RuntimeException("O conjunto está vazio!");
        }
        if(alunoParaRemover == null) {
            System.out.println("Matrícula não encontrada!");
        }
    }
    public void exibirAlunoPorNome() {
        Set<Aluno> alunoPorNome = new TreeSet<>(alunoSet);
        if(!alunoSet.isEmpty()) {
            System.out.println(alunoPorNome);
        } else {
            System.out.println("O conjunto está vazio!");
        }
    }
    public void exibirAlunosPorNota() {
        Set<Aluno> alunosPorNota = new TreeSet<>(new ComparatorNota());
        if(!alunoSet.isEmpty()) {
            alunosPorNota.addAll(alunoSet);
            System.out.println(alunosPorNota);
        } else {
            System.out.println("O conjunto está vazio!");
        }
    }
    public void exibirAlunos() {
        Set<Aluno> setAlunos = new TreeSet<>(alunoSet);
        if(!alunoSet.isEmpty()) {
            System.out.println(setAlunos);
        } else {
            System.out.println("O conjunto está vazio!");
        }
    }

    public static void main(String[] args) {
        GerenciadorAluno gerenciadorAlunos = new GerenciadorAluno();

        gerenciadorAlunos.adicionarAluno("Aluno 1", 123456l, 6d);
        gerenciadorAlunos.adicionarAluno("Aluno 2", 1234567l, 8d);
        gerenciadorAlunos.adicionarAluno("Aluno 3", 12345678l, 1d);
        gerenciadorAlunos.adicionarAluno("Aluno 4", 123456789l, 9d);

        System.out.println(gerenciadorAlunos.alunoSet);



        gerenciadorAlunos.removerAlunoPorMatricula(000l);
        gerenciadorAlunos.removerAlunoPorMatricula(123456789l);
        System.out.println(gerenciadorAlunos.alunoSet);

        gerenciadorAlunos.exibirAlunoPorNome();
        gerenciadorAlunos.exibirAlunos();
        gerenciadorAlunos.exibirAlunosPorNota();

    }
}
