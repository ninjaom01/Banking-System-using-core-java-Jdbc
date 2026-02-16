package Bank.app;

import java.sql.*;

public class Service {

    // CREATE ACCOUNT
    public void createAccount(Account acc) throws Exception {

        Connection con = DBConnection.getConnection();

        PreparedStatement check =
                con.prepareStatement("SELECT acc_no FROM account WHERE acc_no=?");
        check.setInt(1, acc.accNo);
        ResultSet rs = check.executeQuery();

        if (rs.next()) {
            throw new BankException("Account already exists: " + acc.accNo);
        }

        PreparedStatement ps =
                con.prepareStatement("INSERT INTO account VALUES(?,?,?,?,?,?)");

        ps.setInt(1, acc.accNo);
        ps.setString(2, acc.name);
        ps.setString(3, acc.address);
        ps.setString(4, acc.accType);
        ps.setDouble(5, acc.balance);
        ps.setDouble(6, acc.minBalance);

        ps.executeUpdate();
        System.out.println("Account created successfully");

        con.close();
    }

    // DELETE ACCOUNT
    public void deleteAccount(int accNo) throws Exception {

        Connection con = DBConnection.getConnection();

        PreparedStatement ps =
                con.prepareStatement("DELETE FROM account WHERE acc_no=?");
        ps.setInt(1, accNo);

        if (ps.executeUpdate() == 0) {
            throw new BankException("Account not found: " + accNo);
        }

        System.out.println("Account deleted");
        con.close();
    }

    // DEPOSIT
    public void deposit(int accNo, double amount) throws Exception {

        Connection con = DBConnection.getConnection();

        PreparedStatement ps =
                con.prepareStatement(
                        "UPDATE account SET balance = balance + ? WHERE acc_no=?");
        ps.setDouble(1, amount);
        ps.setInt(2, accNo);

        if (ps.executeUpdate() == 0) {
            throw new BankException("Account not found: " + accNo);
        }

        System.out.println("Deposit successful");
        con.close();
    }

    // WITHDRAW
    public void withdraw(int accNo, double amount) throws Exception {

        Connection con = DBConnection.getConnection();

        PreparedStatement check =
                con.prepareStatement(
                        "SELECT balance, min_balance FROM account WHERE acc_no=?");
        check.setInt(1, accNo);

        ResultSet rs = check.executeQuery();

        if (!rs.next()) {
            throw new BankException("Account not found: " + accNo);
        }

        double balance = rs.getDouble("balance");
        double minBal = rs.getDouble("min_balance");

        if (balance - amount < minBal) {
            throw new BankException(
                    "Insufficient balance. Minimum required: " + minBal);
        }

        PreparedStatement ps =
                con.prepareStatement(
                        "UPDATE account SET balance = balance - ? WHERE acc_no=?");
        ps.setDouble(1, amount);
        ps.setInt(2, accNo);
        ps.executeUpdate();

        System.out.println("Withdrawal successful");
        con.close();
    }

    // SHOW BALANCE
    public void showBalance(int accNo) throws Exception {

        Connection con = DBConnection.getConnection();

        PreparedStatement ps =
                con.prepareStatement("SELECT balance FROM account WHERE acc_no=?");
        ps.setInt(1, accNo);

        ResultSet rs = ps.executeQuery();

        if (!rs.next()) {
            throw new BankException("Account not found: " + accNo);
        }

        System.out.println("Current Balance: " + rs.getDouble("balance"));
        con.close();
    }

    // SHOW ACCOUNT DETAILS
    public void showAccount(int accNo) throws Exception {

        Connection con = DBConnection.getConnection();

        PreparedStatement ps =
                con.prepareStatement("SELECT * FROM account WHERE acc_no=?");
        ps.setInt(1, accNo);

        ResultSet rs = ps.executeQuery();

        if (!rs.next()) {
            throw new BankException("Account not found: " + accNo);
        }

        System.out.println("Account No   : " + rs.getInt("acc_no"));
        System.out.println("Name         : " + rs.getString("name"));
        System.out.println("Address      : " + rs.getString("address"));
        System.out.println("Account Type : " + rs.getString("acc_type"));
        System.out.println("Balance      : " + rs.getDouble("balance"));
        System.out.println("Min Balance  : " + rs.getDouble("min_balance"));

        con.close();
    }
}
