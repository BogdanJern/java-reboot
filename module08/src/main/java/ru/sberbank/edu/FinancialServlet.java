package ru.sberbank.edu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Hello world!
 */
@WebServlet("/finance")
public class FinancialServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        getServletContext().getRequestDispatcher("/WEB-INF/finance.jsp").forward(req, resp);
    }

    /**
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try{
            CalcInfo calcInfo = new CalcInfo(Double.parseDouble(req.getParameter("sum")),
                                             Double.parseDouble(req.getParameter("rate")),
                                             Integer.parseInt(req.getParameter("years")));

            req.setAttribute("sum",calcInfo.getFinallSum().toString());
            getServletContext().getRequestDispatcher("/WEB-INF/result.jsp").forward(req,resp);

        } catch (NumberFormatException e){
            getServletContext().getRequestDispatcher("/WEB-INF/resultType.jsp").forward(req,resp);
        }catch (IllegalAccessError e){
            getServletContext().getRequestDispatcher("/WEB-INF/error.jsp").forward(req,resp);
        }
    }
}