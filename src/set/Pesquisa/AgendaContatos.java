package set.Pesquisa;

import java.util.HashSet;
import java.util.Set;

public class AgendaContatos {
    private Set<Contato> contatoSet;
    public AgendaContatos() {
        this.contatoSet = new HashSet<>();
    }
    public void adicionarContato(String nome, int numero) {
        contatoSet.add(new Contato(nome, numero));
    }
    public void exibirContato() {
        if(!contatoSet.isEmpty()) {
            System.out.println(contatoSet);
        } else {
            System.out.println("O conjunto está vazio!");
        }
    }
    public Set<Contato> pesquisaPorNome(String nome) {
        Set<Contato> contatosPorNome = new HashSet<>();
        if(!contatoSet.isEmpty()) {
            for(Contato c : contatoSet) {
                if(c.getNome().startsWith(nome)) {
                    contatosPorNome.add(c);
                }
            }
            return contatosPorNome;
        } else {
            throw new RuntimeException("O conjunto está vazio!");
        }
    }
    public Contato atualizarNumeroContato(String nome, int novoNumero) {
        Contato contatoAtualizado = null;
        if(!contatoSet.isEmpty()) {
            for(Contato c : contatoSet) {
                if(c.getNome().equalsIgnoreCase(nome)) {
                    c.setNumero(novoNumero);
                    contatoAtualizado = c;
                    break;
                }
            }
            return contatoAtualizado;
        } else {
            throw new RuntimeException("O conjunto está vazio!");
        }
    }
    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();

        agendaContatos.exibirContato();

        agendaContatos.adicionarContato("Camila", 12345);
        agendaContatos.adicionarContato("Camila", 5566);
        agendaContatos.adicionarContato("Camila", 5566);
        agendaContatos.adicionarContato("Camila Cavalcante", 11111111);
        agendaContatos.adicionarContato("Camila DIO", 654865);
        agendaContatos.adicionarContato("Maria Silva", 11111111);

        agendaContatos.exibirContato();

        System.out.println(agendaContatos.pesquisaPorNome("Maria"));
        System.out.println("Contato Atualizado: " + agendaContatos.atualizarNumeroContato("Maria Silva", 55555555));

        agendaContatos.exibirContato();

    }
}
