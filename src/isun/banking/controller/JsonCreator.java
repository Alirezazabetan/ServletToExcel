package isun.banking.controller;

import isun.banking.entity.BankAccount;
import com.google.gson.Gson;

public class JsonCreator {

    public static String saveAsJson(BankAccount ba) {

        Gson gson = new Gson();
        String jsonString = gson.toJson(ba);
        return jsonString;

    }

    public static BankAccount loadJson(String json) {

        BankAccount obj = null;
        Gson gson = new Gson();   
        obj = gson.fromJson(json, BankAccount.class);
        return obj;

    }

}
