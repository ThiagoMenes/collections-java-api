package map.Pesquisa;
import java.util.Map;
import java.util.HashMap;
public class EstoqueProdutos {
    
    private Map<Long, Produto> estoqueProdutosMap;

    public EstoqueProdutos() {
        this.estoqueProdutosMap = new HashMap<>();
    }

    public void adicionarProduto(long codigo, String nome, int quantidade, double preco){
        estoqueProdutosMap.put(codigo, new Produto(nome, preco, quantidade));
    }

    public void exibirProdutos(){
        System.out.println(estoqueProdutosMap);
    }

    public double calcularValorTotalEstoque(){
        double valorTotalEstoque = 0;
        if(!estoqueProdutosMap.isEmpty()){
            for (Produto produto : estoqueProdutosMap.values()){
                valorTotalEstoque += produto.getQuantidade() * produto.getPreco();
            }
        }
        return valorTotalEstoque;
    }

    public Produto obterProdutoMaisCaro(){
        Produto produtoMaisCaro = null;
        double maiorPreco = Double.MIN_VALUE;
        if(!estoqueProdutosMap.isEmpty()){
            for (Produto produto : estoqueProdutosMap.values()){
                if(produto.getPreco() > maiorPreco){
                    maiorPreco = produto.getPreco();
                    produtoMaisCaro = produto;
                }
            }
        }
        return produtoMaisCaro;
    }
    public Produto obterProdutoMaisBarato(){
        Produto produtoMaisBarato = null;
        double menorPreco = Double.MAX_VALUE;
        for(Produto produto : estoqueProdutosMap.values()){
            if(produto.getPreco() < menorPreco){
                menorPreco = produto.getPreco();
                produtoMaisBarato = produto;
            }
        }
        return produtoMaisBarato;
    }

    public Produto obterProdutoMaiorQuantidadeValorTotalNoEstoque(){
        Produto produtoMaiorQuantidadeValor = null;
        double produtoMultiplicacaoQTDxValor = 0;
        double produtoFinalTotal = 0;
        for(Produto produto : estoqueProdutosMap.values()){
                produtoMultiplicacaoQTDxValor= produto.getPreco() * produto.getQuantidade();
                if(produtoMultiplicacaoQTDxValor > produtoFinalTotal){
                    produtoFinalTotal = produtoMultiplicacaoQTDxValor;
                    produtoMaiorQuantidadeValor = produto;
                }    
        }
        return produtoMaiorQuantidadeValor;
    }

    public static void main(String[] args) {
        EstoqueProdutos estoqueProdutos = new EstoqueProdutos();
        estoqueProdutos.exibirProdutos();

        estoqueProdutos.adicionarProduto(1, "Produto A", 10, 5);
        estoqueProdutos.adicionarProduto(2, "Produto B", 7, 1);
        estoqueProdutos.adicionarProduto(3, "Produto C", 15, 2);
        estoqueProdutos.adicionarProduto(4, "Produto D", 10, 80);
        estoqueProdutos.adicionarProduto(5, "Produto E", 10, 9);

        estoqueProdutos.exibirProdutos();

        System.out.println("Valor total do estoque: R$ " + estoqueProdutos.calcularValorTotalEstoque());

        System.out.println("Produto mais caro: "+ estoqueProdutos.obterProdutoMaisCaro());
        System.out.println("Produto mais barato: "+ estoqueProdutos.obterProdutoMaisBarato());
        System.out.println("Produto maior quantidade x valor: "+ estoqueProdutos.obterProdutoMaiorQuantidadeValorTotalNoEstoque());
    }
}
