import java.io.File;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;

import app.Application;
import app.Model;

public class Launcher {

	public static final String[] MODELS = {
		"model.Aluno",
		"model.Aula",
		"model.Avaliacao",
		"model.Pessoa",
		"model.Professor",
		"model.Turma",
		"model.Usuario"
	};
	
	public static void main(String args[]) throws Exception
	{
		showFileChooser();
		
		for(String model : MODELS)
			Model.initModel(Class.forName(model));
		
		//initModels();
		
		// Start application
		
		SwingUtilities.invokeLater(new Runnable(){
			public void run()
			{
				new Application();
			}
		});
		
	}
	
	private static void showFileChooser()
	{
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new java.io.File("."));
		chooser.setDialogTitle("Arquivos de dados");
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		chooser.setAcceptAllFileFilterUsed(false);
		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
			Model.DEFAULT_PATH = chooser.getSelectedFile().getAbsolutePath() + File.separator;
		}
	}
	
	private static void initModels() throws Exception
	{
		ArrayList<String> models = new ArrayList<String>();

		final String path = "model";

		final File jarFile = new File(
			URLDecoder.decode(
				new Model().getClass().getProtectionDomain()
				.getCodeSource().getLocation().getPath(), "UTF-8"
			)
		);
		
		if (jarFile.isFile()){
			final JarFile jar = new JarFile(jarFile);
			final Enumeration<JarEntry> entries = jar.entries();

			while (entries.hasMoreElements()){
				final String name = entries.nextElement().getName();
				
				if( name.startsWith(path + "/") && !name.endsWith("/"))
					models.add(name);
			}
			jar.close();
		}
		else {
			final URL url = Launcher.class.getResource("/" + path);
			
			if(url != null){
					final File apps = new File(url.toURI());
					
					for (File app : apps.listFiles())
						models.add(app.getName());
			}
		}
		
		for(String s : models)
			Model.initModel(Class.forName("model." + s.replace(".class", "")));

	}
	
}
