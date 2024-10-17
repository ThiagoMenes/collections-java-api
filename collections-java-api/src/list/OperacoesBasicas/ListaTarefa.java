package list.OperacoesBasicas;
import java.util.List;
import java.util.ArrayList;

public class ListaTarefa {
    //atributo
    private List <Tarefa> tarefaList;

    public ListaTarefa() {
        this.tarefaList = new ArrayList<>();
    }

    public void adicionarTarefa(String descricao){
        tarefaList.add(new Tarefa(descricao));
    }

    //realizando um laço de repetição para encontrar as descrições semelhantes à fornecida
    //pelo usuário e add na lista tarefasParaRemover
    // depois utilizando o comando removeAll para remover todas as correspondências da tarefaLista utilizando
    //utilizando a tarefasParaRemover como parâmetro
    public void removerTarefa(String descricao){
        List<Tarefa> tarefasParaRemover = new ArrayList<>();

        for (Tarefa tarefa : tarefaList) {
            if(tarefa.getDescricao().equalsIgnoreCase(descricao)){
                tarefasParaRemover.add(tarefa);
            }
        }
        tarefaList.removeAll(tarefasParaRemover);

    }
    //trazendo o número total de tarefas == tamanho da lista
    public int obterNumeroTotalTarefas(){
        return tarefaList.size();
    }
    // imprimindo a lista de tarefas
    public void obterDescricoesTarefas(){
        System.out.println(tarefaList);
    }

    public static void main(String[] args) {
        ListaTarefa listaTarefa = new ListaTarefa();

        System.out.println("O Número total de elementos na lista é: "+ listaTarefa.obterNumeroTotalTarefas());
        

        listaTarefa.adicionarTarefa("Tarefa 1");
        listaTarefa.adicionarTarefa("Tarefa 1");
        listaTarefa.adicionarTarefa("Tarefa 2");
        listaTarefa.adicionarTarefa("Tarefa 3");

        System.out.println("O Número total de elementos na lista é: "+ listaTarefa.obterNumeroTotalTarefas());

        listaTarefa.removerTarefa("Tarefa 1");

        System.out.println("O Número total de elementos na lista é: "+ listaTarefa.obterNumeroTotalTarefas());
    
        listaTarefa.obterDescricoesTarefas();
    }
    
}
