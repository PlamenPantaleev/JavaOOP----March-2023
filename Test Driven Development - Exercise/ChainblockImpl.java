import java.util.*;
import java.util.stream.Collectors;

public class ChainblockImpl implements Chainblock {
    private Map<Integer, Transaction> transactionMap;

    public ChainblockImpl() {
        transactionMap = new HashMap<>();
    }

    public int getCount() {
        return this.transactionMap.size();
    }

    public void add(Transaction transaction) {
        if (!contains(transaction)) {
            this.transactionMap.put(transaction.getId(), transaction);
        }
    }

    public boolean contains(Transaction transaction) {
        return this.transactionMap.containsValue(transaction);
    }

    public boolean contains(int id) {
        return this.transactionMap.containsKey(id);
    }

    public void changeTransactionStatus(int id, TransactionStatus newStatus) {
        if (transactionMap.containsKey(id)) {
            transactionMap.get(id).setStatus(newStatus);
        } else {
            throw new IllegalArgumentException("No such transaction exists!");
        }
    }

    public void removeTransactionById(int id) {
        if (transactionMap.containsKey(id)) {
            transactionMap.remove(id);
        } else {
            throw new IllegalArgumentException("No such transaction!");
        }
    }

    public Transaction getById(int id) {
        if (transactionMap.containsKey(id)) {
            return transactionMap.get(id);
        } else {
            throw new IllegalArgumentException("No such transaction exists!");
        }
    }

    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {
        List<Transaction> transactions = getNeededTransactions(status, transactionMap);
        if (transactions.size() != 0) {
            return transactions;
        } else {
            throw new IllegalArgumentException("No transactions with such status!");
        }
    }

    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
        List<Transaction> senders = getNeededTransactions(status, transactionMap);
        if (senders.size() == 0) {
            throw new IllegalArgumentException("no such transaction");
        }
        return senders.stream().map(Transaction::getFrom).collect(Collectors.toList());
    }

    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {
        List<Transaction> transactions = getNeededTransactions(status, transactionMap);

        if (transactions.size() == 0) {
            throw new IllegalArgumentException("no such transaction");
        }
        List<String> receivers = transactions.stream().map(Transaction::getTo).collect(Collectors.toList());
        return receivers;
    }

    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        List<Transaction> transactions = new ArrayList<>();
        transactions.addAll(transactionMap.values());

        transactions.sort(Comparator.comparing(Transaction::getAmount).thenComparing(Transaction::getTo).reversed());

        return transactions;
    }

    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {
        List<Transaction> transactions = new ArrayList<>();

        for (Transaction value : transactionMap.values()) {
            if (value.getFrom().equals(sender)) {
                transactions.add(value);
            }
        }
        if (transactions.size() == 0) {
            throw new IllegalArgumentException("no such sender");
        }

        return transactions.stream().sorted(Comparator.comparing(Transaction::getAmount).reversed()).collect(Collectors.toList());
    }

    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        List<Transaction> transactions = new ArrayList<>();

        for (Transaction value : transactionMap.values()) {
            if (value.getTo().equals(receiver)) {
                transactions.add(value);
            }
        }
        if (transactions.size() == 0) {
            throw new IllegalArgumentException("no such receiver");
        }

        return transactions.stream()
                .sorted(Comparator.comparing(Transaction::getAmount)
                        .thenComparing(Transaction::getId))
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
        List<Transaction> transactions = new ArrayList<>();

        for (Transaction value : transactionMap.values()) {
            if (value.getStatus().equals(status) && value.getAmount() <= amount) {
                transactions.add(value);
            }
        }
        return transactions.stream()
                .sorted(Comparator.comparing(Transaction::getAmount)
                        .reversed())
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        List<Transaction> transactions = new ArrayList<>();
        for (Transaction value : transactionMap.values()) {
            if (value.getFrom().equals(sender) && value.getAmount() >= amount) {
                transactions.add(value);
            }
        }
        if (transactions.size() == 0) {
            throw new IllegalArgumentException("no such transaction");
        }
        return transactions.stream()
                .sorted((Comparator.comparing(Transaction::getAmount)
                        .reversed()))
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        List<Transaction> transactions = new ArrayList<>();
        for (Transaction value : transactionMap.values()) {
            if (value.getTo().equals(receiver) && value.getAmount() >= lo && value.getAmount() < hi) {
                transactions.add(value);
            }
        }
        if (transactions.size() == 0) {
            throw new IllegalArgumentException("no such transaction");
        }
        return transactions.stream()
                .sorted((Comparator.comparing(Transaction::getAmount)
                        .thenComparing(Transaction::getId)
                        .reversed()))
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        List<Transaction> transactions = new ArrayList<>();
        for (Transaction value : transactionMap.values()) {
            if (value.getAmount() >= lo && value.getAmount() <= hi) {
                transactions.add(value);
            }
        }
        return transactions.stream()
                .sorted((Comparator.comparing(Transaction::getAmount)))
                .collect(Collectors.toList());
    }

    public Iterator<Transaction> iterator() {
        return null;
    }


    private List<Transaction> getNeededTransactions(TransactionStatus status, Map<Integer, Transaction> transactionMap) {
        List<Transaction> transactions = new ArrayList<>();
        for (Transaction value : transactionMap.values()) {
            if (value.getStatus().equals(status)) {
                transactions.add(value);
            }
        }
        List<Transaction> sorted = transactions.stream().sorted(Comparator.comparing(Transaction::getAmount).reversed()).toList();
        return sorted;
    }
}
