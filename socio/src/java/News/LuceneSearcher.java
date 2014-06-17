/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package News;

import com.mongodb.DBObject;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexableField;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.apache.lucene.queryparser.classic.QueryParser;

/**
 *
 * @author Akash
 */
public class LuceneSearcher {
    private String indexLocation;
    private Directory dir;
    private IndexSearcher searcher;
    private Analyzer analyzer;
    private static int hitsPerPage = 1000;
    

    public LuceneSearcher(String _indexLocation) throws IOException {
        this.indexLocation = _indexLocation;
        this.init();
    }

    private void init() throws IOException {
        dir = FSDirectory.open( new File(indexLocation) );
        IndexReader reader = DirectoryReader.open(dir);
        searcher = new IndexSearcher(reader);
        analyzer = new StandardAnalyzer(Version.LUCENE_47);
    }
    
    public List<String> search(String keyword) throws ParseException, IOException{
//        Query q = new QueryParser(Version.LUCENE_47, "Content;Title;", analyzer).parse(keyword);
        Query q = new MultiFieldQueryParser(Version.LUCENE_47, new String[]{"Content", "Title"},analyzer).parse(keyword);
        TopScoreDocCollector collector = TopScoreDocCollector.create(hitsPerPage, true);
        searcher.search(q, collector);
        ScoreDoc[] hits = collector.topDocs().scoreDocs;
        List<String> resultIds = new ArrayList<String>();
//        System.out.println("Found " + hits.length + " hits.");
        for(int i=0;i<hits.length;++i) {
            int docId = hits[i].doc;
            Document d = searcher.doc(docId);
            resultIds.add( d.getField("_id").stringValue() );
        }
        return resultIds;
    }
    
    public static void main(String[] args) {
        try {
            LuceneSearcher searcher = new LuceneSearcher("/home/siranami/NetBeansProjects/newsIndex");
            MongoWorker m = new MongoWorker("localhost", 27017, "newscrawl", "news");
            DisplayNews obj = m.findDocumentById(searcher.search("messi").get(1));
            System.out.println( obj.getHeadLine() );
            for(String id : searcher.search("messi"))
                System.out.println(id);
            
        } catch (IOException ex) {
            Logger.getLogger(LuceneSearcher.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(LuceneSearcher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
