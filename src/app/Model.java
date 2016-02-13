package app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public abstract class Model implements Serializable{
	
	public static final String DEFAULT_PATH = 
			System.getProperty("user.home") +
			File.separator + 
			"SadeData" + 
			File.separator;
	
	public static final String DEFAULT_EXTENSION = ".data";
	
	protected static ArrayList getData(String model)
	{
		String path = DEFAULT_PATH + model + DEFAULT_EXTENSION;
		
		return readObject(path);
	}
	
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
	
	public static void appendObject(Object object, String path)
	{
		try
		{
			ArrayList objects = readObject(path);
			objects.add(objects);
			writeObject(objects, path);
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
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
