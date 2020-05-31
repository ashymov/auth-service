package kg.megacom.authservice.services.impl;

import kg.megacom.authservice.dao.AccountRepository;
import kg.megacom.authservice.exceptions.IncorrectPassword;
import kg.megacom.authservice.exceptions.NoSuchUser;
import kg.megacom.authservice.models.Account;
import kg.megacom.authservice.services.LoginService;
import kg.megacom.authservice.services.UserSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private UserSessionService userSessionService;
    @Override
    public String login(String login, String password) {

        Account account=accountRepository.findByLogin(login);
        if (account==null){
            throw new NoSuchUser("Пользователь не найден");
        }
        if (!account.getPassword().equals(password)){
            throw  new IncorrectPassword("неверный пароль!");
        }
        String token= userSessionService.getToken();
        userSessionService.saveUserSession(account,token);
        return token;
    }
}
