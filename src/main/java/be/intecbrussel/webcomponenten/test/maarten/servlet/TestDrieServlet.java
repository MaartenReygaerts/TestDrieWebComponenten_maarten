package be.intecbrussel.webcomponenten.test.maarten.servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/testdrie")
public class TestDrieServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //req.getSession() creert een nieuwe session
        // dit kan een bug veroorzaken, je zou in je sessie met een of andere parameter moeten bijhouden of iemand ingelogd is
        // probeer de volgende stappen:
        // 1 - surf naar http://localhost:8080/maarten/testdrie
        // 2 - refresh de pagina f5 of iets dergelijks
        // 3 - ?
        // 4 - profit? je krijgt de welcome page te zien zonder ingelogd te zijn.
        if (req.getSession().isNew()){
            req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req,resp);
        } else {
            req.getRequestDispatcher("/WEB-INF/pages/welcome.jsp").forward(req, resp);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // je gebruikt deze string niet
        String nameResult = "";
        String name = req.getParameter("name");


        //hier had je HttpSession session = req.getSession(); kunnen schrijven

        if (name.equals("")){
            //1ste keer HttpSession session = req.getSession();
            HttpSession session = req.getSession();
            String message =", gelieve een geldige naam in te voeren!";
            //je set deze messge maar je gaat ze nooit meer uit je session halen, vanaf nu krijg je dus altijd weer deze tekst te zien
            // tot je geldig inlogt of je session verloopt
            session.setAttribute("message",message);
            req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req,resp);

        }
        else{
            //2e keer HttpSession session = req.getSession();
            HttpSession session = req.getSession();
            session.setAttribute("name",name);
            req.getRequestDispatcher("/WEB-INF/pages/welcome.jsp").forward(req,resp);
        }


    }
}
