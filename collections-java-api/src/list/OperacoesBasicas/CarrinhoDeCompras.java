package list.OperacoesBasicas;
import java.util.List;
import java.util.ArrayList;

public class CarrinhoDeCompras {

    private List <Item> carrinhoDeCompras;

    public CarrinhoDeCompras(){
    this.carrinhoDeCompras = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade){
        carrinhoDeCompras.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome){
        List<Item> itensParaRemover = new ArrayList<>();

        for(Item item : carrinhoDeCompras){
            if(item.getNome().equalsIgnoreCase(nome)){
                itensParaRemover.add(item);
            }
        }
        carrinhoDeCompras.removeAll(itensParaRemover);
    }

    public void calcularValorTotal(){
        double total = 0.0;
        for(Item item : carrinhoDeCompras){
        double preco = item.getPreco(); 
        int quantidade = item.getQuantidade();
        total = total + (preco * quantidade);
        }
        System.out.println("O Valor total do Carrinho é: R$ " + total);
    }

    public void exibirItens(){
        System.out.println(carrinhoDeCompras);
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

        carrinhoDeCompras.adicionarItem("Caixa",35.0,10);
        carrinhoDeCompras.adicionarItem("Chocolate",13.5,10);
        carrinhoDeCompras.adicionarItem("Caixa",35.0,10);
        carrinhoDeCompras.adicionarItem("Chiclete",2.0,12);
        carrinhoDeCompras.adicionarItem("Bombom",10.0,3);

        carrinhoDeCompras.removerItem("Chiclete");

        carrinhoDeCompras.calcularValorTotal();

        carrinhoDeCompras.exibirItens();
    }


}
