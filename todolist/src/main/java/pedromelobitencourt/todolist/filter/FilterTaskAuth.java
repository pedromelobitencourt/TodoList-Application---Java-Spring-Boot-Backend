package pedromelobitencourt.todolist.filter;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pedromelobitencourt.todolist.user.IUserRepository;

@Component
public class FilterTaskAuth extends OncePerRequestFilter {

    @Autowired
    private IUserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        var servletPath = request.getServletPath();

        if(servletPath.equals("/tasks/")) {
            // Get user and password
            var authorization = request.getHeader("Authorization");
            var authEncoded = authorization.substring("Basic".length()).trim();
            
            byte[] authDecoded = Base64.getDecoder().decode(authEncoded);
            var authString = new String(authDecoded);
    
            String[] credentials = authString.split(":");
            String username = credentials[0];
            String password = credentials[1];
    
            // Validate the user
            var user = this.userRepository.findByUsername(username);
    
            if(user == null) {
                response.sendError(401); /* Unanthorized */
            }
            else {
                // Validate the password
                var passwordVerifyer = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());
                
                if(passwordVerifyer.verified) { // Correct password
                    request.setAttribute("idUser", user.getId());
                    filterChain.doFilter(request, response);
                }
                else {
                    response.sendError(401);
                }
        
            }
    
        }
        else {
            filterChain.doFilter(request, response);
        }
    }
        

    
    
}
