package set.Ordenacao;
import java.util.Set;
import java.util.TreeSet;
// import java.util.Comparator;
import java.util.HashSet;

public class CadastroProdutos {
    private Set<Produto> produtoSet;

    public CadastroProdutos() {
        this.produtoSet = new HashSet<>();
    }

    public void adicionarProduto(long codigo, String nome, double preco, int quantidade){
        produtoSet.add(new Produto(nome, codigo, preco, quantidade));
    }

    public Set<Produto> exibirProdutosPorNome(){
        Set<Produto> produtosPorNome = new TreeSet<>(produtoSet);

        return produtosPorNome;
    }

    public Set<Produto> exibirProdutosPorPreco(){
        Set<Produto> produtosPorPreco = new TreeSet<>(new ComparatorPorPreco());

        produtosPorPreco.addAll(produtoSet);
        return produtosPorPreco;
    }

    public static void main(String[] args) {
        CadastroProdutos cadastroProdutos = new CadastroProdutos();

        cadastroProdutos.adicionarProduto(1L, "Produto 5", 15, 5);
        cadastroProdutos.adicionarProduto(2L, "Produto 0", 20, 10);
        cadastroProdutos.adicionarProduto(1L, "Produto 3", 10, 12);
        cadastroProdutos.adicionarProduto(9L, "Produto 9", 2, 2);
        cadastroProdutos.adicionarProduto(12L, "Produto 2", 3, 2);

        //System.out.println(cadastroProdutos.produtoSet);

        // System.out.println(cadastroProdutos.exibirProdutosPorNome());

        System.out.println(cadastroProdutos.exibirProdutosPorPreco());
    }

}
