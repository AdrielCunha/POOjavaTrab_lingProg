import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class Produto{

	private int id;
	private String titulo;
	private float price;
	
	public ArrayList<Produto> ArrayProdutos() throws IOException {
		
//		** Faculdade **	
//		Path pathP = Path.of("C:\\Users\\Aluno\\Documents\\2021023510\\Trabalho\\4.2.Trabalho.Produtos.json");
//		** Casa **		
		Path pathP = Path.of("C:\\Users\\cunha\\Documents\\Adriel\\Java\\Trabalho\\4.2.Trabalho.Produtos.json");
		
		String conteudoP = Files.readString(pathP);
		
		JSONArray arrayP = new JSONArray(conteudoP);
		
		ArrayList<Produto> Produtos = new ArrayList<Produto>();
		
		for (int i = 0; i < arrayP.length(); i++) {
			JSONObject objP = arrayP.getJSONObject(i);
			
			Produto p = new Produto();
			
			p.setId(objP.getInt("id"));
			p.setTitulo(objP.getString("title"));
			p.setPrice(objP.getFloat("price"));
			
			Produtos.add(p);
		}
		return Produtos;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	
	
	
}
