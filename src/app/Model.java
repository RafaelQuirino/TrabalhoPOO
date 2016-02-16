package app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import model.Pessoa;
import model.Turma;
import model.Usuario;

public class Model implements Serializable {
	
	// Constants --------------------------------------------------------------
	
	private static final long serialVersionUID = -6743215224482974701L;

	public static final String DEFAULT_PATH = 
			System.getProperty("user.home") +
			File.separator + 
			"SadeData" + 
			File.separator;
	
	public static final String DEFAULT_EXTENSION = ".data";
	
	public static final String DEFAULT_USER_LOGIN = "admin";
	
	public static final String DEFAULT_USER_PASSWORD = "admin";
	
	// Instance Fields --------------------------------------------------------
	
	private int id;
	
	// Constructors -----------------------------------------------------------
	
	public Model()
	{
		
	}
	
	// Setters and Getters ---------------------------------------------------
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	// Public static methods ---------------------------------------------------------
	
	/**
	 * 
	 */
	public static void initModel(Class model)
	{
		File file = new File(getPath(model));
		
		if(!file.exists())// && !file.isDirectory())
		{
			ApplicationLogger.log("Creating file " + file.getAbsolutePath() + "...");
			
			try
			{
				file.getParentFile().mkdirs();
				file.createNewFile();
				
				ArrayList arrayList = new ArrayList();
				
				if(model.getName().equals("model.Usuario"))
				{
					Pessoa p = new Pessoa();
					p.setNome("Administrador");
					initModel(Pessoa.class);
					p.setId(Model.createModel(p));
					
					Usuario usuario = new Usuario();
					usuario.setLogin(DEFAULT_USER_LOGIN);
					usuario.setSenha(DEFAULT_USER_PASSWORD);
					usuario.setTipo(Usuario.ADMINISTRADOR);
					//usuario.setId(1);
					usuario.setPessoaId(p.getId());
					arrayList.add(usuario);
					
					
				}
				
				Model.writeObject(arrayList, file.getAbsolutePath());
				
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 
	 */
	public static ArrayList all(Class model)
	{
		return readObject(getPath(model));
	}
	
	/**
	 * 
	 */
	public static Model find(Class model, int id)
	{
		ArrayList objects = readObject(getPath(model));
		
		ArrayList filteredObjects = new ArrayList();
		
		for(Object o : objects)
			if(((Model)o).getId() == id)
				return (Model)o;
		
		return null;
	}
	
	/**
	 * 
	 */
	public static ArrayList findAll(Class model, ArrayList<Integer> ids)
	{
		ArrayList models = new ArrayList<Model>();
		
		for(Model m : (ArrayList<Model>)Model.all(model))
			if(ids.contains(m.getId()))
				models.add(m);
		
		return models;
	}
	
	/**
	 * 
	 */
	public static int createModel(Model model)
	{
		return appendModel(model, getPath(model));
	}
	
	/**
	 * 
	 */
	public static void updateModel(Model model)
	{
		ArrayList<Model> objects = Model.all(model.getClass());
		
		for(int i = 0; i < objects.size(); i++)
		{
			Model m = objects.get(i);
			
			if(m.getId() == model.getId())
			{
				objects.remove(i);
				objects.add(i, model);
			}
		}
		
		writeObject(objects, getPath(model));
	}
	
	// Private static methods -------------------------------------------------
	
	/**
	 * 
	 */
	private static String getPath(Object object)
	{
		String path = DEFAULT_PATH;
		String parts[];
		
		if(object instanceof Class)
			parts = ((Class)object).getName().split("\\.");
		else
			parts = object.getClass().getName().split("\\.");
		
		path += parts[parts.length-1].toLowerCase();
		path += DEFAULT_EXTENSION;
		return path;
	}
	
	/**
	 * 
	 */
	private static ArrayList readObject(String path)
	{
		ArrayList<Model> objects = null;
		try
		{
			FileInputStream fin = new FileInputStream(path);
			ObjectInputStream ois = new ObjectInputStream(fin);
			objects = (ArrayList) ois.readObject();
			ois.close();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		return objects;
	}
	
	/**
	 * 
	 */
	private static int appendModel(Model model, String path)
	{
		try
		{
			ArrayList models = (ArrayList) readObject(path);
			int lastId = 0;
			
			for(Model m : (ArrayList<Model>)models)
				if(m.getId() > lastId)
					lastId = m.getId();
			
			model.setId(lastId + 1);
			models.add(model);
			writeObject(models, path);
			return model.getId();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * 
	 */
	private static void writeObject(Object object, String path)
	{
		try
		{
			FileOutputStream fout = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(object);
			oos.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
