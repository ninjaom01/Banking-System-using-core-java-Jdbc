package Bank.app;

import javax.security.auth.login.AccountNotFoundException;

public class BankException extends Exception {

    public BankException(String message) {
        super(message);
    }
}

