import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class Usuarios {

	private int id;
	private String email;
	private String nome;
	
	public ArrayList<Usuarios> ArrayUsuarios() throws IOException {
//		** Faculdade **
//		Path pathU = Path.of("C:\\Users\\Aluno\\Documents\\2021023510\\Trabalho\\4.2.Trabalho.Usuarios.json")
//		** Casa **
		Path pathU = Path.of("C:\\Users\\cunha\\Documents\\Adriel\\Java\\Trabalho\\4.2.Trabalho.Usuarios.json");
		
		String conteudoU = Files.readString(pathU);
		
		JSONArray arrayU = new JSONArray(conteudoU);
		
		ArrayList<Usuarios> Usuarios = new ArrayList<Usuarios>();
		
		for (int i = 0; i < arrayU.length(); i++) {
			JSONObject objU = arrayU.getJSONObject(i);
			
			Usuarios u = new Usuarios();
			
			u.setId(objU.getInt("id"));
			u.setEmail(objU.getString("email"));
			
			JSONObject nome = objU.getJSONObject("name");
			u.setNome(nome.getString("firstname") + " " + nome.getString("lastname"));
			
			Usuarios.add(u);
		}
		return Usuarios;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
