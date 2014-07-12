///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//import News.DisplayNews;
//import News.LuceneSearcher;
//import News.MongoWorker;
//import akash.configuration.Configuration;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.util.HashMap;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import org.apache.lucene.queryparser.classic.ParseException;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//
///**
// *
// * @author noones
// */
//@WebServlet(urlPatterns = {"/news/"})
//public class ShowEachNews extends HttpServlet {
//
//    /**
//     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
//     * methods.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        String id = request.getParameter("id"); // news ID
//        if (id==null){
//            // @TODO
//        }
//        Configuration config = new Configuration(getServletConfig().getServletContext());
//        LuceneSearcher searcher = new LuceneSearcher(config.getLuceneLocation());
//        MongoWorker mongo = new MongoWorker(config.getMongoHost(), config.getMongoPort(), config.getMongoDB(), config.getMongoCollection());
//        try {
//            List<String> matchIDs = searcher.search("suarez");
//            List<DisplayNews> docList = mongo.findAllDocumentByID(matchIDs.toArray(new String[matchIDs.size()]));
//            HashMap<String, String> imageTitle = new HashMap<String, String>();
//            int count = 0;
//            for (DisplayNews docEach : docList){
//                String docX = docEach.getNewsContent();
//                if(docX.contains("img")){
//                    Document jsoup = Jsoup.parse(docX);
//                    Element get = jsoup.getElementsByTag("img").get(0);
//                    imageTitle.put(docEach.getHeadLine(), get.attr("src"));
//                    count++;
//                    if(count==6){break;}
//                }
//            }
//            request.setAttribute("imageTitle", imageTitle);
//            //Document doc = mongo.findAllDocumentByID(matchIDs.);
//            //request.setAttribute("nowShowingNews", mongo.findDocumentById(id) );
//        } catch (ParseException ex) {
//            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (URISyntaxException ex) {
//            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        
//        request.getRequestDispatcher("/dashboard/news.jsp").forward(request, response);
//        /* TODO output your page here. You may use following sample code. */;
//        
//    }
//
//    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//
//}
