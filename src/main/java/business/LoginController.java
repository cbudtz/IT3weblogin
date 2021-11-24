package business;

import datalayer.UserDao;
import model.LoginData;

public class LoginController {
    private static UserDao userDao = new UserDao();

    public String doLogin(LoginData loginData){
        LoginData user = userDao.findUser(loginData.getUsername());
        if (user!=null && loginData.getPassword().equals(user.getPassword())){
            return JWThandler.generateToken(loginData.getUsername());
        }
        return ":(";
    }

}
