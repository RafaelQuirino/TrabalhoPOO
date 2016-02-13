package app;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Model {

	public Model()
	{
		String parts[] = getClass().getName().split("\\.");	
		String name = parts[parts.length-1];
		
		File file = new File(name + ".data");
		
		if(!file.exists() && !file.isDirectory()) { 
		    try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
