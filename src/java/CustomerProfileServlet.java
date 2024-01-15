
package Controller;

import Bean.CustomerLoginBean;
import Dao.CustomerProfileDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ProfileServlet", urlPatterns = {"/ProfileServlet"})
public class CustomerProfileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String) request.getAttribute("username");
        String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");

        if (newPassword.equals(confirmPassword)) {
            CustomerLoginBean customerLoginBean = new CustomerLoginBean(username, newPassword);
            CustomerProfileDao customerProfileDao = new CustomerProfileDao();

            if (customerProfileDao.updateProfile(customerLoginBean)) {
                request.setAttribute("successMessage", "Profile updated successfully");
                request.getRequestDispatcher("/CustomerProfile.jsp").forward(request, response);
            } else {
                request.setAttribute("errMessage", "Failed to update profile");
                request.getRequestDispatcher("/CustomerProfile.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("errMessage", "Passwords do not match");
            request.getRequestDispatcher("/CustomerProfile.jsp").forward(request, response);
        }
    }
}
