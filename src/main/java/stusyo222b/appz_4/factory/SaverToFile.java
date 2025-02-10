package stusyo222b.appz_4.factory;

import stusyo222b.appz_4.entities.OfficeWorker;

import java.util.List;

public interface SaverToFile {
    boolean save(List<OfficeWorker> list, String filename);
}
