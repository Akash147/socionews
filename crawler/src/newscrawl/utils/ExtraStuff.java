package newscrawl.utils;

import jpt.FileWorker;

/**
 *
 * @author Akash
 */
public class ExtraStuff {
//    FileWorker fileWorker;
    BaseURLManager baseURLManager;
    LuceneWorker luceneWorker;
    MongoWorker mongoWorker;
    CSVWorker csvWorker;

    /*public void setFileWorker(FileWorker fileWorker) {
        this.fileWorker = fileWorker;
    }*/

    public void setBaseURLManager(BaseURLManager baseURLManager) {
        this.baseURLManager = baseURLManager;
    }

    /*public FileWorker getFileWorker() {
        return fileWorker;
    }*/

    public CSVWorker getCsvWorker() {
        return csvWorker;
    }

    public void setCsvWorker(CSVWorker csvWorker) {
        this.csvWorker = csvWorker;
    }


    public BaseURLManager getBaseURLManager() {
        return baseURLManager;
    }

    public LuceneWorker getLuceneWorker() {
        return luceneWorker;
    }

    public MongoWorker getMongoWorker() {
        return mongoWorker;
    }

    public void setLuceneWorker(LuceneWorker luceneWorker) {
        this.luceneWorker = luceneWorker;
    }

    public void setMongoWorker(MongoWorker mongoWorker) {
        this.mongoWorker = mongoWorker;
    }
    
}
