package stusyo222b.appz_4.factory;

import stusyo222b.appz_4.entities.OfficeWorker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OfficeWorkerListSaveToFile {

    private static Map<String, FileType> fileTypes = null;

    public static boolean save(List<OfficeWorker> spisok, String filename) {
        boolean flOK = false;
        System.out.println("[DEBUG] Starting save process...");

        // Load supported file types
        loadFileTypeList();
        System.out.println("[DEBUG] Loaded file types: " + fileTypes);

        // Check if file types are available
        if (fileTypes.size() == 0) {
            System.err.println("[ERROR] No file types available for saving.");
            return false;
        }

        // Check the filename
        String[] s = filename.split("\\.");
        if (s.length <= 1) {
            System.err.println("[ERROR] Filename does not have an extension. Filename: " + filename);
            return false;
        }

        String ext = s[1].toUpperCase();
        System.out.println("[DEBUG] Extracted file extension: " + ext);

        FileType fileType = fileTypes.get(ext);
        if (fileType == null) {
            System.err.println("[ERROR] Unsupported file extension: " + ext);
            return false;
        }

        System.out.println("[DEBUG] Selected file type: " + fileType);

        SaverToFile fs = null;
        try {
            String saverName = "stusyo222b.appz_3.factory.SaverToFile" + fileType.getExtension().toUpperCase();
            System.out.println("[DEBUG] Attempting to load class: " + saverName);

            fs = (SaverToFile) Class.forName(saverName).newInstance();
            System.out.println("[DEBUG] Successfully created instance of: " + saverName);

            flOK = fs.save(spisok, filename);
            if (flOK) {
                System.out.println("[INFO] File saved successfully: " + filename);
            } else {
                System.err.println("[ERROR] Failed to save file: " + filename);
            }
        } catch (InstantiationException e) {
            flOK = false;
            System.err.println("[ERROR] Instantiation error for SaverToFile: " + e.getMessage());
        } catch (IllegalAccessException e) {
            flOK = false;
            System.err.println("[ERROR] Illegal access while creating SaverToFile instance: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            flOK = false;
            System.err.println("[ERROR] SaverToFile class not found: " + e.getMessage());
        }

        return flOK;
    }

    public static void loadFileTypeList() {
        fileTypes = new HashMap<>();
        System.out.println("[DEBUG] Loading file types...");
        for (FileType fileType : FileType.getAllFileTypes()) {
            fileTypes.put(fileType.name(), fileType);
            System.out.println("[DEBUG] Added file type: " + fileType.name() + " with extension: " + fileType.getExtension());
        }
    }

    public static Map<String, FileType> getFileTypeList() {
        System.out.println("[DEBUG] Returning file type list.");
        return fileTypes;
    }
}
