public interface Transaction {
    int getId();
    void setStatus(TransactionStatus status);
    TransactionStatus getStatus();
    String getFrom();
    double getAmount();
    String getTo();
}
