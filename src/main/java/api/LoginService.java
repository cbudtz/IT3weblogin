package api;

import business.LoginController;
import model.LoginData;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("login")
public class LoginService {
    static LoginController loginController = new LoginController();

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public String doLogin(LoginData loginData){
        return loginController.doLogin(loginData);
    }
}
