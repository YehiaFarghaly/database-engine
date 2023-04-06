package filecontroller;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Paths;

import constants.Constants;
import storage.Page;
import storage.Table;

public class FileCreator {

	public static void createTableFolder(Table table) throws IOException {
		File createFolder = new File(table.getName());
		createFolder.mkdir();
	}

	public static void createFile(Object file, FileType type) throws IOException {
		
		String path = getAbsPath((Page)file,FileType.PAGE);
		String directoryName = ((Page)file).getName();
		  	
		 if(type == FileType.TABLE) {
			path = ((Table)file).getName();
			directoryName = ((Table)file).getName();
		}
		 
		File createFile = new File(path + "//" + directoryName + Constants.DATA_EXTENSTION);
		createFile.createNewFile();
	}

	protected static String getAbsPath(Serializable file,FileType type) {
		String folderName = ((Page)file).getTableName();
		if(type==FileType.TABLE) folderName = ((Table)file).getName();
		return Paths.get("").toAbsolutePath().toString() + "//" + folderName;
	}
}
