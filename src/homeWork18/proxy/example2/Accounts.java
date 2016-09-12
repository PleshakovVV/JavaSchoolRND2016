package homeWork18.proxy.example2;

/**
 * Created by Master on 11.09.2016.
 */
public class Accounts {
    public static IAccount getAccount(String account) throws IllegalArgumentException{
        for (int i = account.length() - 1; i >= 0; i--) {
            if (!Character.isDigit(account.charAt(i))) {
                throw new IllegalArgumentException("Account must consist only digits");
            }
        }
        return new Account(account);
    }

    private static class Account implements IAccount {
        private String account;
        private Double sum = 0D;

        public Account(String account) {
            this.account = account;
        }

        @Override
        public String getAccount() {
            return this.account;
        }

        @Override
        public Double getSum() {
            return sum;
        }

        @Override
        public void add(Double sum) {
            this.sum += sum;
        }

        @Override
        public boolean reduce(Double sum) {
            if (this.sum < sum) {
                return false;
            }
            this.sum -= sum;
            return true;
        }

        @Override
        public String toString() {
            return account;
        }
    }
}
