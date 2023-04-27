package util.filecontroller;

import java.io.File;
import java.io.Serializable;

import constants.Constants;
import storage.Page;


public class FileDeleter {
	
	public static void deleteFile(Serializable toBeDeleted, FileType type) {
		File folder = new File(FileCreator.getAbsPath(toBeDeleted, type));
		if (folder.isDirectory()) {
			File[] files = folder.listFiles();
			if (files != null)
				if (type==FileType.PAGE) {
				  deletePageFile((Page) toBeDeleted, files);
				} else {
					deleteTableFolder(files, folder);
				}
		}
	}
	
	private static void deletePageFile(Page page, File[] files) {
		for (File file : files)
			if (file.getName().equals(page.getName()+Constants.DATA_EXTENSTION))
				file.delete();
	}
	
	private static void deleteTableFolder(File[] files, File folder) {
		for (File file : files)
			file.delete();
		folder.delete();
	}
	
}
