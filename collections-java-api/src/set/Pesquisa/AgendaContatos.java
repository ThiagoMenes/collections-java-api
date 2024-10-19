package set.Pesquisa;
import java.util.Set;
import java.util.HashSet;

public class AgendaContatos {
    private Set<Contato> contatoSet;

    public AgendaContatos() {
        this.contatoSet = new HashSet<>();
    }

    public void adicionarContatos(String nome, int numero){
        contatoSet.add(new Contato(nome, numero));
    }

    public void exibirContatos(){
        System.out.println(contatoSet);
    }

    public Set <Contato> pesquisarPorNome(String nome){
        Set<Contato> contatosPorNome = new HashSet<>();

        for(Contato contato : contatoSet){
            if(contato.getNome().startsWith(nome)){
                contatosPorNome.add(contato);
            }
        }
        return contatosPorNome;
    }

    public Contato atualizarNumeroContato (String nome, int novoNumero){
        Contato contatoAtualizado = null;

        for(Contato contato: contatoSet){
            if(contato.getNome().equalsIgnoreCase(nome)){
                contato.setNumeroTelefone(novoNumero);
                contatoAtualizado = contato;
                break;
            }
        }
        return contatoAtualizado;
    }

    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();

        agendaContatos.exibirContatos();

        agendaContatos.adicionarContatos("Camila", 123456);
        agendaContatos.adicionarContatos("Camila", 0);
        agendaContatos.adicionarContatos("Camila Cavalcante", 11111);
        agendaContatos.adicionarContatos("Camila DIO", 654987);
        agendaContatos.adicionarContatos("Maria Silva", 11111);

        agendaContatos.exibirContatos();

        System.out.println(agendaContatos.pesquisarPorNome("Maria"));

        System.out.println("Contato atualizado: "+ agendaContatos.atualizarNumeroContato("Maria Silva", 55555));
    }
}
