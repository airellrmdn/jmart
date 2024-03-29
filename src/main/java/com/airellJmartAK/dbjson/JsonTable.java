package com.airellJmartAK.dbjson;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Vector;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;

public class JsonTable<T> extends Vector<T>{
	public final String filepath;
	private static final Gson gson = new Gson();
	
	@SuppressWarnings("unchecked")
	public JsonTable(Class<T> clazz, String filepath) throws IOException{
		this.filepath = filepath;
		try {
			Class<T[]> array = (Class<T[]>) Array.newInstance(clazz, 0).getClass();
			
			T[] result = readJson(array, filepath);
			if(result != null)
				Collections.addAll(this, result);
		}
		catch(FileNotFoundException e) {
		}
	}
	
	public static <T> T readJson(Class<T>clazz, String filepath) throws FileNotFoundException{
		final JsonReader read = new JsonReader(new FileReader(filepath));
		return gson.fromJson(read, clazz);
	}
	
	public void writeJson() throws IOException{
		writeJson(this, this.filepath);
	}
	
	public static void writeJson(Object object, String filepath) throws IOException{
		File file = new File(filepath);
		if(!file.exists()) {
			File parent = file.getParentFile();
			if(parent != null)
				parent.mkdirs();
			file.createNewFile();
		}
		final FileWriter fwrite = new FileWriter(filepath);
		fwrite.write(gson.toJson(object));
		fwrite.close();
	}

}
