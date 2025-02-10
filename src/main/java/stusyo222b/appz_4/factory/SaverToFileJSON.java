package stusyo222b.appz_4.factory;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import stusyo222b.appz_4.entities.OfficeWorker;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class SaverToFileJSON implements SaverToFile {
    @Override
    public boolean save(List<OfficeWorker> list, String filename) {
        boolean flOK = false;
        if (list != null) {
            XStream xstream = new XStream(new JsonHierarchicalStreamDriver());
            xstream.alias("officeworkers", OfficeWorker[].class); // Псевдонім для об'єктів
            OfficeWorker[] array = list.stream().toArray(OfficeWorker[]::new);
            String jsonContent = xstream.toXML(array);

            try (FileWriter fw = new FileWriter(filename); PrintWriter out = new PrintWriter(fw)) {
                out.println(jsonContent);
                flOK = true;
            } catch (IOException e) {
                flOK = false;
                e.printStackTrace();
            }
        } else {
            System.err.println("List is null");
        }
        return flOK;
    }
}