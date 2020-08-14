import java.util.Arrays;

interface AccountService {
    /**
     * It finds an account by owner id
     * @param id owner unique identifier
     * @return account or null
     */
    Account findAccountByOwnerId(long id);
    /**
     * It count the number of account with balance > the given value
     * @param value
     * @return the number of accounts
     */
    long countAccountsWithBalanceGreaterThan(long value);
}

// Declare and implement your AccountServiceImpl here
class AccountServiceImpl implements AccountService {
    Account[] accounts;
    public AccountServiceImpl(Account[] accounts) {
        if (accounts == null) {
            this.accounts = new Account[0];
        } else {
            this.accounts = Arrays.copyOf(accounts, accounts.length);
        }

    }

    @Override
    public Account findAccountByOwnerId(long id) {
        for (Account account : accounts) {
            if (account.getOwner().getId() == id) {
                return account;
            }
        }
        return null;
    }

    @Override
    public long countAccountsWithBalanceGreaterThan(long value) {
        long x = 0L;
        for (Account account : accounts) {
            if (account.getBalance() > value) {
                x += 1;
            }
        }
        return x;
    }
}

class Account {

    private final long id;
    private final long balance;
    private final User owner;

    public Account(long id, long balance, User owner) {
        this.id = id;
        this.balance = balance;
        this.owner = owner;
    }

    public long getId() { 
        return id; 
    }

    public long getBalance() { 
        return balance; 
    }

    public User getOwner() { 
        return owner; 
    }
}

class User {

    private final long id;
    private final String firstName;
    private final String lastName;

    public User(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() { 
        return id; 
    }

    public String getFirstName() { 
        return firstName; 
    }

    public String getLastName() { 
        return lastName; 
    }
}
