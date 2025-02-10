package stusyo222b.appz_4.factory;

import stusyo222b.appz_4.entities.OfficeWorker;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;


public class SaverToFileTXT implements SaverToFile {
    @Override
    public boolean save(List<OfficeWorker> list, String filename) {
        boolean flOK = false;
        if (list!=null) {
            List<String> lines = list.stream().map((empl) -> empl.toString()).toList();
            Path filepath = Paths.get(filename);
            try {
                // Выводим абсолютный путь для файла
                System.out.println("[DEBUG] Attempting to save file at: " + filepath.toAbsolutePath());
                Files.write(filepath, lines, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);
                flOK = true;
            } catch (IOException e) {
                flOK = false;
                e.printStackTrace();
            }
        } else {
            System.err.println("List is null");
            flOK = false;
        }
        return flOK;
    }

}

