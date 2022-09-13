package super_market.models;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "sale")
public class Sale {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String sale_record;
    private Date date;
    private Double value;
    
    @ManyToOne
    private Product product;
    @ManyToOne
    private User user;
    @ManyToOne
    private Status status;

    public Sale() {
        
    }

    public Sale(Integer id, String sale_record, Double value, Product product, User user, Status status) {
        this.id = id;
        this.sale_record = sale_record;
        this.value = value;
        this.product = product; 
        this.user = user;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSale_record() {
        return sale_record;
    }

    public void setSale_record(String sale_record) {
        this.sale_record = sale_record;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    
}
