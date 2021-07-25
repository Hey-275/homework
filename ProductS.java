public class ProductS {

    private Integer Id;

    private String Describe;

    private volatile Integer amount;

    private Integer Cost;


    @Override
    public String toString() {
        return "ProductS{" +
                "Id=" + Id +
                ", Describe='" + Describe + '\'' +
                ", amount=" + amount +
                ", Cost=" + Cost +
                '}';
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getDescribe() {
        return Describe;
    }

    public void setDescribe(String describe) {
        Describe = describe;
    }

    public synchronized Integer getAmount() {
        return amount;
    }

    public synchronized void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getCost() {
        return Cost;
    }

    public void setCost(Integer cost) {
        Cost = cost;
    }
}
