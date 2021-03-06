package dashboard;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import News.DisplayNews;
import News.LuceneSearcher;
import News.MongoWorker;
import akash.configuration.Configuration;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.lucene.queryparser.classic.ParseException;
import reco.DbForWeb;

/**
 *
 * @author noones
 */
@WebServlet(urlPatterns = {"/dashboard/index"})
public class Dashboard extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        
        session.setAttribute("testName", "Ganesh Pandey");
        
        DbForWeb dfw = new DbForWeb();
//        String u_id = (String) session.getAttribute("user");
        String u_id = request.getParameter("user");
        long user_id = Long.parseLong(u_id);
        session.setAttribute("UserID", user_id);
        dfw.fetchAll(user_id);
        session.setAttribute("screenName", dfw.getScreenName());
        session.setAttribute("fullName", dfw.getFullName());
        session.setAttribute("profileImage", dfw.getImageURL());
        session.setAttribute("location", dfw.getLocation());
        session.setAttribute("userDescription", dfw.getUserDescription());
        session.setAttribute("createdDate", dfw.getStringDate());
        session.setAttribute("following", dfw.getFollowingNum());
        
//        Dash dashObject = new Dash();
//        request.setAttribute("user", dashObject);
        Configuration config = new Configuration(getServletConfig().getServletContext());
        LuceneSearcher searcher = new LuceneSearcher(config.getLuceneLocation());
        MongoWorker mongo = new MongoWorker(config.getMongoHost(), config.getMongoPort(), config.getMongoDB(), config.getMongoCollection());
        try {
//            request.setAttribute("recentNews", renderNews( mongo.findDocumentById(matchIDs.get(0)) ));

            DbForWeb dWeb = new DbForWeb();
            String searchString = dWeb.makeSearchString(dWeb.getKeywordsFromMongo(user_id));
            List<String> matchIDs = searcher.search(searchString);
            for (String id : matchIDs)
                System.out.println(id);
            if(mongo.findAllDocumentByID(matchIDs.toArray(new String[matchIDs.size()])) == null){
                System.out.println("Hello How Are YOu?");
            }
            request.setAttribute("recentNewsList", mongo.findAllDocumentByID(matchIDs.toArray(new String[matchIDs.size()])) );
        } catch (ParseException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("/dashboard/index.jsp").forward(request, response);
        /* TODO output your page here. You may use following sample code. */
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
