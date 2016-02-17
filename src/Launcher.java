import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import javax.swing.SwingUtilities;

import app.Application;
import app.Model;
import model.Aluno;
import model.Pessoa;
import model.Professor;
import model.Usuario;

public class Launcher {

	public static String stripAccents(String s) 
	{
	    s = Normalizer.normalize(s, Normalizer.Form.NFD);
	    s = s.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "").replace(" ", "").toLowerCase();
	    return s;
	}
	
	public static void main(String args[]) throws Exception
	{
		
		/*for(Pessoa p : (ArrayList<Professor>)Model.all(Professor.class))
		{
			String login = stripAccents(p.getNome()),
				   senha = login;
			
			/*if(!(p.getId() == 7))
			{
				Usuario u = new Usuario();
				u.setLogin(login);
				u.setSenha(login);
				u.setPessoaId(p.getId());
				u.setTipo("Professor");
				Model.createModel(u);
			}*/
			
			/*System.out.println(p.getId() + ": " + p.getNome() + " - " + login);
		}
		

		System.out.println("------------------------------------------");
		
		for(Pessoa p : (ArrayList<Aluno>)Model.all(Aluno.class))
		{
			String login = stripAccents(p.getNome()),
				   senha = login;
			
			System.out.println(p.getId() + ": " + p.getNome() + " - " + login);
		}
		
		System.out.println("------------------------------------------");
		
		for(Usuario u : (ArrayList<Usuario>)Model.all(Usuario.class)){
			System.out.println(u.getLogin() + " - " + u.getPessoaId());
		}*/
		
		
		ArrayList<String> models = new ArrayList<String>();

		final String path = "model";

		final File jarFile = new File(
			URLDecoder.decode(
				new Model().getClass().getProtectionDomain()
				.getCodeSource().getLocation().getPath(), "UTF-8"
			)
		);
		
		if (jarFile.isFile())
		{
			final JarFile jar = new JarFile(jarFile);
			final Enumeration<JarEntry> entries = jar.entries();

			while (entries.hasMoreElements())
			{
				final String name = entries.nextElement().getName();
				
				if( name.startsWith(path + "/") &&
				   !name.endsWith("/"))
				{
					models.add(name);
				}
			}
			jar.close();
		}
		else
		{
			final URL url = Launcher.class.getResource("/" + path);
			
			if(url != null)
			{
				try
				{
					final File apps = new File(url.toURI());
					
					for (File app : apps.listFiles())
					{
						models.add(app.getName());
					}
				}
				catch (URISyntaxException ex)
				{
					ex.printStackTrace();
				}
			}
		}
		
		for(String s : models)
			Model.initModel(Class.forName("model." + s.replace(".class", "")));
		
		SwingUtilities.invokeLater(new Runnable(){
			public void run()
			{
				new Application();
			}
		});
		
	}
	
}
