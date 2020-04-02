package eu.sig.training.ch04;

// tag::CheckingAccount[]
public class CheckingAccount extends Accounts {
    private int transferLimit = 100;

    public Transfer makeTransfer(String counterAccount, Money amount)
        throws BusinessException {
        // 1. Check withdrawal limit:
        if (amount.greaterThan(this.transferLimit)) {
            throw new BusinessException("Limit exceeded!");
        }
        // 2. Assuming result is 9-digit bank account number, validate 11-test:
        elevenTest(counterAccount);
        int sum = 0;
        return checkAccountAndMakeTransfer(counterAccount, amount, sum);
    }

    private Transfer checkAccountAndMakeTransfer(String counterAccount, Money amount, int sum) throws BusinessException {
        if (sum % 11 == 0) {
            // 3. Look up counter account and make transfer object:
            CheckingAccount acct = Accounts.findAcctByNumber(counterAccount);
            Transfer result = new Transfer(this, acct, amount);
            return result;
        } else {
            throw new BusinessException("Invalid account number!");
        }
    }
}
// end::CheckingAccount[]
