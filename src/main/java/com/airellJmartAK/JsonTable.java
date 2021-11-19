package com.airellJmartAK;

import java.io.*; 
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Vector;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;

public class JsonTable<T> extends Vector<T>{
	public final String filepath;
	private static final Gson gson = new Gson();
	
	public JsonTable(Class<T> clazz, String filepath) throws IOException{
		this.filepath = filepath;
		try {
			@SuppressWarnings("unchecked")
			Class<T[]> array = (Class<T[]>) Array.newInstance(clazz, 0).getClass();
			
			T[] result = JsonTable.readJson(array, filepath);
			Collections.addAll(this, result);
		}
		catch(FileNotFoundException e) {
			File file = new File(filepath);
		}
	}
	
	public static <T> T readJson(Class<T>clazz, String filepath) throws FileNotFoundException{
		final JsonReader read = new JsonReader(new FileReader(filepath));
		return gson.fromJson(read, clazz);
	}
	
	public void writeJson() throws IOException{
		writeJson(this, this.filepath);
	}
	
	public void writeJson(Object object, String filepath) throws IOException{
		final FileWriter fwrite = new FileWriter(filepath);
		fwrite.write(gson.toJson(object));
		fwrite.close();
	}

}
