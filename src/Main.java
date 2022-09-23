import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Produto p = new Produto();
		
		ArrayList<Produto> Produtos = new ArrayList<Produto>();
		
		Produtos = p.ArrayProdutos();
		
		Usuarios u = new Usuarios();
		
		ArrayList<Usuarios> Usuarios = new ArrayList<Usuarios>();
		
		Usuarios = u.ArrayUsuarios();
		
		Compras_realizadas c = new Compras_realizadas();
		
		ArrayList<Compras_realizadas> arrayRealizadas = new ArrayList<Compras_realizadas>();
		
		arrayRealizadas = c.Compras(Usuarios, Produtos);
		
		for (int i = 0; i < arrayRealizadas.size(); i++) {
			float total = 0;
			System.out.println("ID da compra: " + arrayRealizadas.get(i).getId());
			System.out.println("Cliente: " + arrayRealizadas.get(i).getName());
			
			
			for (int j = 0; j < arrayRealizadas.get(i).getProdutos().size(); j++) {
				System.out.println("Comprou " + arrayRealizadas.get(i).getQuantProdutos().get(j) + " unidade(s) do produto: " 
						+ arrayRealizadas.get(i).getProdutos().get(j) + " - que custam " + 
						Produtos.get(j).getPrice() + " cada");
				total += Produtos.get(j).getPrice()*arrayRealizadas.get(i).getQuantProdutos().get(j);
			}
			System.out.println("O cliente comprou um total de R$" + total);
		}		
	}
}
