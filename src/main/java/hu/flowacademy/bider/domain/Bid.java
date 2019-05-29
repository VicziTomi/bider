package hu.flowacademy.bider.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "bid")
public class Bid {

    @Id
    @SequenceGenerator(name="bidIdSeqGenerator", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "bidIdSeqGenerator", strategy = GenerationType.SEQUENCE)
    @Column
    private long id;

    @Column
    private long bidPrice;

    @Column
    private String name;

    @Column
    private LocalDate bidDate;

    @ManyToOne
    @JoinColumn(name = "product_id", foreignKey = @ForeignKey(name = "fk_product_bid"))
    private Product product;

    public Bid(long bidPrice, String name, LocalDate bidDate, Product product) {
        this.bidPrice = bidPrice;
        this.name = name;
        this.bidDate = bidDate;
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Bid() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(long bidPrice) {
        this.bidPrice = bidPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBidDate() {
        return bidDate;
    }

    public void setBidDate(LocalDate bidDate) {
        this.bidDate = bidDate;
    }
}
