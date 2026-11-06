package Jobsheet11.Praktikum1;

import java.util.Map;
import java.util.Collection;
import java.util.LinkedHashMap;

public class InMemoryAccountRepository implements AccountRepository {
    private Map<String, Account> accounts = new LinkedHashMap<>();

    @Override
    public void save(Account account) {
        accounts.put(account.getAccountNumber(), account);
    }

    @Override
    public Account findByNumber(String accountNumber) {
        return accounts.get(accountNumber);
    }

    @Override
    public Collection<Account> findAll() {
        return accounts.values();
    }
}
