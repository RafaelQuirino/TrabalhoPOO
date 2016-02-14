import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import app.Application;
import app.Model;
import model.Pessoa;
import model.Usuario;

public class Launcher {

	public static void main(String args[])
	{
		String models[] = {
			"aluno",
			"avaliacao",
			"pessoa",
			"professor",
			"turma",
			"usuario"
		};
		
		for(int i = 0; i < models.length; i++)
		{
			String path = Model.DEFAULT_PATH + models[i] + Model.DEFAULT_EXTENSION;
			
			File file = new File(path);
			
			if(!file.exists() && !file.isDirectory())
			{
				try
				{
					file.getParentFile().mkdirs();
					file.createNewFile();
					
					ArrayList arrayList = new ArrayList();
					
					if(models[i].equals("usuario"))
					{
						Usuario usuario = new Usuario();
						usuario.setLogin("admin");
						usuario.setSenha("admin");
						usuario.setTipo(Usuario.ADMINISTRADOR);
						Pessoa p = new Pessoa();
						p.setNome("Administrador");
						usuario.setPessoa(p);
						arrayList.add(usuario);
					}
					
					Model.writeObject(arrayList, path);
				}
				catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		new Application();
	}
	
}
