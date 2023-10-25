/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Common.Library;
import Model.Validation;
import java.util.Locale;

/**
 *
 * @author hieu
 */
public class LoginBankDao {
    private static LoginBankDao instance = null;
    Library l = new Library();
    Validation val = new Validation();
    public static LoginBankDao Instance() {
        if (instance == null)
            synchronized (LoginBankDao.class) {
                if (instance == null)
                    instance = new LoginBankDao();
            }
        return instance;        
    }
    public void login(Locale language) {
        val.getWordLanguage(language, "enterAccountNumber");
        String account = l.getString("");
        while (!val.checkAccount(language, account)) {
            val.getWordLanguage(language, "enterAccountNumber");
            account = l.getString("");
        }
        val.getWordLanguage(language, "enterPassword");
        String password = l.getString("");
        while(val.checkPassword(language, password) == null) {
            val.getWordLanguage(language, "enterPassword");
            password = l.getString("");
        }
        String captchaGenerated = l.generateCaptchaText();
        System.out.println(captchaGenerated);
        val.getWordLanguage(language, "enterCaptcha");
        String captchaInput = l.getString("");
        while (!val.checkCaptcha(language, captchaGenerated, captchaInput)) {
            captchaGenerated = l.generateCaptchaText();
            System.out.println(captchaGenerated);
            val.getWordLanguage(language, "enterCaptcha");
            captchaInput = l.getString("");
        }
        val.getWordLanguage(language, "loginSuccess");   
        System.out.println("");
    }
}
