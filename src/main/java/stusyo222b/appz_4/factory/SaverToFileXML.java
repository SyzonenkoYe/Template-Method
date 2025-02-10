package stusyo222b.appz_4.factory;

import com.thoughtworks.xstream.XStream;
import stusyo222b.appz_4.entities.OfficeWorker;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class SaverToFileXML implements SaverToFile {
        @Override
        public boolean save(List<OfficeWorker> list, String filename) {
            boolean flOK = false;
            if (list!=null) {
                XStream xStream = new XStream();
                xStream.alias("officeworkers", OfficeWorker[].class);
                OfficeWorker[] array = list.stream().toArray(OfficeWorker[]::new);
                String xmlContent = xStream.toXML(array);
                try (FileWriter fw = new FileWriter(filename); PrintWriter out = new PrintWriter(fw)) {
                    out.println(xmlContent);
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


