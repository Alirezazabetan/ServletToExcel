package isun.web;

import isun.banking.controller.JsonCreator;
import isun.banking.entity.BankAccount;
import isun.service.ExcelUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HtmlCRUDServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        StringBuffer jb = new StringBuffer();
//        String line = null;
//        try {
//            BufferedReader reader = request.getReader();
//            while ((line = reader.readLine()) != null)
//                jb.append(line);
//        } catch (Exception e) { /*report an error*/ }
//
//
//
////        String number = request.getParameter("number");
////        String owner = request.getParameter("owner");
////        String balance = request.getParameter("balance");
////        String operate = request.getParameter("operate");
////        int num = Integer.parseInt(number);
//
//        BankAccount ba = new BankAccount();
//
//        ba = JsonCreator.loadJson(jb.toString());
////        ba.setBalance(Long.parseLong(balance));
////        ba.setOwner(owner);
////        ba.setNumber(Integer.parseInt(number));
//
////        Writesheet writesheet = new Writesheet();
//        ExcelUtils excelUtils = new ExcelUtils();
//
//
////            writesheet.save(request);
//            excelUtils.save(ba);
//
//        response.setContentType("text/html;charset=UTF-8");
//
//        PrintWriter out = response.getWriter();
//        out.println("<html>");
//        if (ba == null){
//            out.println("the account is not exist ");
//            out.println("<a href=http://localhost:8080/BankingWeb/bankForm.html>Back</a>");
//        }else {
//            out.println("Number: " );
//            out.println("<br>");
//            out.println("Owner: " );
//            out.println("<br>");
//            out.println("Balance: ");
//            out.println("<br>");
//            out.println("<a href=http://localhost:8080/BankingWeb/bankForm.html>Back</a>");
//        }
//        out.println("</html>");
//        out.close();
//        /*if (operate.equals("find"))
//        {
//            ba = controller.findByNumber(num);
//            response.setContentType("text/html;charset=UTF-8");
//            PrintWriter out = response.getWriter();
//            out.println("<html>");
//            if (ba == null){
//                out.println("the account is not exist ");
//                out.println("<a href=http://localhost:8080/BankingWeb/bankForm.html>Back</a>");
//            }else {
//            out.println("Number: " + ba.getNumber());
//            out.println("<br>");
//            out.println("Owner: " + ba.getOwner());
//            out.println("<br>");
//            out.println("Balance: " + ba.getBalance());
//            out.println("<br>");
//            out.println("<a href=http://localhost:8080/BankingWeb/bankForm.html>Back</a>");
//            }
//            out.println("</html>");
//            out.close();
//        }
//        else if (operate.equals("create"))
//        {
//            long bal = Long.parseLong(balance);
//            ba.setNumber(num);
//            ba.setOwner(owner);
//            ba.setBalance(bal);
//            controller.createAccount(ba);
//            PrintWriter out = response.getWriter();
//            out.println("<html>");
//            out.println("Create account for " + ba.getOwner());
//            out.println("<br>");
//            out.println("<a href=http://localhost:8080/BankingWeb/bankForm.html>Back</a>");
//            out.println("</html>");
//            out.close();
//        }
//        else if (operate.equals("delete"))
//        {
//            String msg = controller.deleteByNumber(num);
//            response.setContentType("text/html;charset=UTF-8");
//            PrintWriter out = response.getWriter();
//            out.println("<html>");
//            out.println(msg);
//            out.println("<br>");
//            out.println("<a href=http://localhost:8080/BankingWeb/bankForm.html>Back</a>");
//            out.println("</html>");
//            out.close();
//        }
//        else if (operate.equals("update"))
//        {
//            long bal = Long.parseLong(balance);
//            ba.setNumber(num);
//            ba.setOwner(owner);
//            ba.setBalance(bal);
//            String msg = controller.updateAccount(ba);
//            PrintWriter out = response.getWriter();
//            out.println("<html>");
//            out.println(msg);
//            out.println("<br>");
//            out.println("<a href=http://localhost:8080/BankingWeb/bankForm.html>Back</a>");
//            out.println("</html>");
//            out.close();
//        }*/
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
//        processRequest(request, response);
        String number = request.getParameter("number");
        String owner = request.getParameter("owner");
        String balance = request.getParameter("balance");
        String operate = request.getParameter("operate");
        int num = Integer.parseInt(number);

        BankAccount ba = new BankAccount();

        ba.setBalance(Long.parseLong(balance));
        ba.setOwner(owner);
        ba.setNumber(Integer.parseInt(number));

        ExcelUtils excelUtils = new ExcelUtils();
        excelUtils.save(ba);

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.println("<html>");
            out.println("<table border=\"1\" style=\"width: 100%\">" );
            out.println("<tr>\n" +
                    "        <td>Number</td>\n" +
                    "        <td>Owner</td>\n" +
                    "        <td>Balance</td>\n" +
                    "    </tr>");
            out.println("<tr> " );
            out.println("<td>"+ba.getNumber()+"</td>");
            out.println("<td>"+ba.getOwner()+"</td>");
            out.println("<td>"+ba.getBalance()+"</td>");
        out.println("</html>");
        out.close();
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
//        processRequest(request, response);
        StringBuffer jb = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null)
                jb.append(line);
        } catch (Exception e) { /*report an error*/ }

        BankAccount ba = new BankAccount();

        ba = JsonCreator.loadJson(jb.toString());
        ExcelUtils excelUtils = new ExcelUtils();
        excelUtils.save(ba);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        if (ba == null){
            out.println("the account is not exist ");
            out.println("<a href=http://localhost:8080/BankingWeb/bankForm.html>Back</a>");
        }else {
            out.println("Number: " );
            out.println("<br>");
            out.println("Owner: " );
            out.println("<br>");
            out.println("Balance: ");
            out.println("<br>");
            out.println("<a href=http://localhost:8080/BankingWeb/bankForm.html>Back</a>");
        }
        out.println("</html>");
        out.close();

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
