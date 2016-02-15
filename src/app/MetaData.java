package app;

import java.util.ArrayList;

public class MetaData {
	
	private ArrayList<ModelMetaData> metaDatas;
	
	public MetaData()
	{
		metaDatas = new ArrayList<ModelMetaData>();
	}
	
	public void addModel(Class modelClass)
	{
		metaDatas.add(new ModelMetaData(modelClass, 0));
	}
	
	public int getModelLastId(Class modelClass) throws RuntimeException
	{
		for(ModelMetaData mmd : metaDatas)
			if(mmd.modelClass.equals(modelClass))
				return mmd.lastId;
		
		throw new RuntimeException("Class " + modelClass.getName() + " was not found!");
	}
	
	private class ModelMetaData
	{
		Class modelClass;
		int lastId;
		
		ModelMetaData(Class c, int i)
		{
			modelClass = c;
			lastId = i;
		}
	}
	
}
