package hu.flowacademy.bider.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @SequenceGenerator(name="idSeqGenerator", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "idSeqGenerator", strategy = GenerationType.SEQUENCE)
    @Column
    private long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private long minPrice;

    @Column
    private LocalDate dateAdded;

    @Column
    private LocalDate bidEnd;

    @OneToMany(mappedBy = "product")
    private List<Bid> bids;

    public Product(String name, String description, long minPrice, LocalDate dateAdded, LocalDate bidEnd) {
        this.name = name;
        this.description = description;
        this.minPrice = minPrice;
        this.dateAdded = dateAdded;
        this.bidEnd = bidEnd;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(long minPrice) {
        this.minPrice = minPrice;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }

    public LocalDate getBidEnd() {
        return bidEnd;
    }

    public void setBidEnd(LocalDate bidEnd) {
        this.bidEnd = bidEnd;
    }
}
