import java.util.ArrayList;
import java.util.HashMap;

public class User {

    private HashMap<ProductS,Integer> purchased;

    private Integer integral;

    private Integer id;

    public User(Integer ID) {
        this.id = ID;
        this.purchased = new HashMap<ProductS,Integer>();
        this.integral = 1000000;
    }

    @Override
    public String toString() {
        return "User{" +
                "purchased=" + purchased +
                ", integral=" + integral +
                '}';
    }

    public HashMap<ProductS, Integer> getPurchased() {
        return purchased;
    }

    public void setPurchased(HashMap<ProductS, Integer> purchased) {
        this.purchased = purchased;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }
}
