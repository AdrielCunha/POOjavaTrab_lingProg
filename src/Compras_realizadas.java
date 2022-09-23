import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class Compras_realizadas {

	private int id;
	private String name;
	private ArrayList<String> produtos;
	private ArrayList<Integer> quantProdutos;

	public ArrayList<Compras_realizadas> Compras(ArrayList<Usuarios> Usuarios, ArrayList<Produto> Produtos) throws IOException{
//		** Faculdade **
//		Path pathC = Path.of("C:\\Users\\Aluno\\Documents\\2021023510\\Trabalho\\4.2.Trabalho.Compras.json");
//		** Casa **
		Path pathC = Path.of("C:\\Users\\cunha\\Documents\\Adriel\\Java\\Trabalho\\4.2.Trabalho.Compras.json");
		
		String conteudoC = Files.readString(pathC);
		
		JSONArray arrayC = new JSONArray(conteudoC);
		
		ArrayList<Compras_realizadas> arrayRealizadas = new ArrayList<Compras_realizadas>();
		
		for (int i = 0; i < arrayC.length(); i++) {
			JSONObject objC = arrayC.getJSONObject(i);
			
			int id = objC.getInt("id");
			int userId = objC.getInt("userId");
			
			Compras_realizadas r = new Compras_realizadas();
			
			r.setId(id);
			
			for (int j = 0; j < Usuarios.size(); j++) {
				if (userId == Usuarios.get(j).getId()) {
					r.setName(Usuarios.get(j).getNome());
				}
			}
			
			JSONArray produto = objC.getJSONArray("products");
			
			ArrayList<String> nameProdutos = new ArrayList<String>();
			
			for (int j = 0; j < produto.length(); j++) {
				for (int k = 0; k < Produtos.size(); k++) {
					if (produto.getJSONObject(j).getInt("productId") == Produtos.get(k).getId()) {
						nameProdutos.add(Produtos.get(k).getTitulo());
					}
				}
			}
			r.setProdutos(nameProdutos);
			
			ArrayList<Integer> quantProdutos = new ArrayList<Integer>();
			
			for (int j = 0; j < produto.length(); j++) {
				quantProdutos.add(produto.getJSONObject(j).getInt("quantity"));
			}
			r.setQuantProdutos(quantProdutos);
			
			arrayRealizadas.add(r);
		}
		return arrayRealizadas;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<String> getProdutos() {
		return produtos;
	}
	public void setProdutos(ArrayList<String> produtos) {
		this.produtos = produtos;
	}
	public ArrayList<Integer> getQuantProdutos() {
		return quantProdutos;
	}
	public void setQuantProdutos(ArrayList<Integer> quantProdutos) {
		this.quantProdutos = quantProdutos;
	}
	
}
