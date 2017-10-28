package isun.banking;

import isun.banking.controller.HttpClient;
import isun.banking.controller.JsonCreator;
import isun.banking.entity.BankAccount;

/**
 * Created by Fenic on 10/27/2017.
 */
public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setNumber(11111);
        bankAccount.setOwner("Lili");
        bankAccount.setBalance(999999);
        String request = JsonCreator.saveAsJson(bankAccount);
        try {
            HttpClient.sendPost(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
