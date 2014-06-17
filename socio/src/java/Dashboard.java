/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import News.DisplayNews;
import News.LuceneSearcher;
import News.MongoWorker;
import akash.configuration.Configuration;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.lucene.queryparser.classic.ParseException;

/**
 *
 * @author noones
 */
@WebServlet(urlPatterns = {"/dash"})
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
//        Dash dashObject = new Dash();
//        request.setAttribute("user", dashObject);
        Configuration config = new Configuration(getServletContext());
        LuceneSearcher searcher = new LuceneSearcher(config.getLuceneLocation());
        MongoWorker mongo = new MongoWorker(config.getMongoHost(), config.getMongoPort(), config.getMongoDB(), config.getMongoCollection());
        try {
            List<String> matchIDs = searcher.search("messi");
            request.setAttribute("recentNews", renderNews( mongo.findDocumentById(matchIDs.get(0)) ));
        } catch (ParseException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("dashboard/index.jsp").forward(request, response);
        /* TODO output your page here. You may use following sample code. */;
        
    }
    
    private String renderNews(DisplayNews news){
        String text = "<div class=\"row-fluid experience\">"
                + "<h4>%s</h4>" //headling
                + "%s" // content
                + "<a href=\"http://www.techtach.com#\">www.techtach.com</a><div class=\"pull-right\">"
                + "<span class=\"small italic\">Category:<a href=\"cricket.jsp\">cricket </a></span>"
                + "</div>"
                + "</div>";
        return String.format(text, news.getHeadLine(), news.getNewsContent());
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
