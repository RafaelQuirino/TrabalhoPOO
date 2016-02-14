package app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public abstract class Model implements Serializable{
	
	// Constants --------------------------------------------------------------
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6743215224482974701L;

	public static final String DEFAULT_PATH = 
			System.getProperty("user.home") +
			File.separator + 
			"SadeData" + 
			File.separator;
	
	public static final String DEFAULT_EXTENSION = ".data";
	
	// Methods ----------------------------------------------------------------
	
	/**
	 * 
	 */
	protected static ArrayList getData(Class model)
	{
		return readObject(getPath(model));
	}
	
	/**
	 * 
	 */
	public static void createModel(Model model)
	{
		appendObject(model, getPath(model));
	}
	
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
	public static ArrayList readObject(String path)
	{
		ArrayList objects = null;
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
	public static void appendObject(Object object, String path)
	{
		try
		{
			ArrayList objects = readObject(path);
			System.out.println("apend begin");
			System.out.println(objects.size());
			System.out.println(objects);
			System.out.println("apend end");
			objects.add(object);
			writeObject(objects, path);
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * 
	 */
	public static void writeObject(Object object, String path)
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
