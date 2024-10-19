package list.Ordenacao;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class OrdenacaoPessoas {
    //atributos
   private List <Pessoa> pessoaList;

    public OrdenacaoPessoas() {
        this.pessoaList = new ArrayList<>();
    }

    public void adicionarPessoa(String nome, int idade, double altura){
        pessoaList.add(new Pessoa(nome, idade, altura));
    }

     public List<Pessoa> ordenarPorIdade(){
        List <Pessoa>pessoasPorIdade = new ArrayList<>(pessoaList);
        if (!pessoaList.isEmpty()) {
            Collections.sort(pessoasPorIdade);
            return pessoasPorIdade;
          } else {
            throw new RuntimeException("A lista está vazia!");
          }
     }
    
     public List<Pessoa> ordenarPorAltura(){
        List <Pessoa>pessoasPorAltura = new ArrayList<>(pessoaList);
        if (!pessoaList.isEmpty()) {
            Collections.sort(pessoasPorAltura, new ComparatorPorAltura());
            return pessoasPorAltura;
          } else {
            throw new RuntimeException("A lista está vazia!");
          }
     }

     public static void main(String[] args) {
        OrdenacaoPessoas ordenacaoPessoas = new OrdenacaoPessoas();

        ordenacaoPessoas.adicionarPessoa("Nome 1", 20,1.56);
        ordenacaoPessoas.adicionarPessoa("Nome 2", 30,1.80);
        ordenacaoPessoas.adicionarPessoa("Nome 3", 25,1.70);
        ordenacaoPessoas.adicionarPessoa("Nome 4", 17,1.56);

        // Exibindo a lista de pessoas adicionadas
        System.out.println("Exibindo pessoas adicionadas à lista");
        System.out.println(ordenacaoPessoas.pessoaList);

        System.out.println(ordenacaoPessoas.ordenarPorIdade());
         System.out.println(ordenacaoPessoas.ordenarPorAltura());
     }
}
