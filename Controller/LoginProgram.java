/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import java.util.Locale;
import Repository.ILoginRepository;
import Repository.LoginRepository;
import View.Menu;

/**
 *
 * @author hieu
 */
public class LoginProgram extends Menu<String> {
    static String[] options = {"Vietnamese", "English", "Exit"};
    private ILoginRepository loginRepository;
    Locale vietnamese = new Locale("vi");
    Locale english = new Locale("en");
    public LoginProgram() {
        super("===== LOGIN PROGRAM =====", options);
        loginRepository = new LoginRepository();
    }

    @Override
    public void execute(int n) {
        switch(n) {
            case 1: loginRepository.login(vietnamese);
            case 2: loginRepository.login(english);
            case 3: System.exit(0);
        }
    }

}
