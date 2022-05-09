package org.project.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.project.entity.enumeration.WorkStatus;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
/*@SqlResultSetMapping(
        name = "orders",
        classes = @ConstructorResult(
                targetClass = Order.class,
                columns = {
                        @ColumnResult(name = "id",type = Budget.class),
                        @ColumnResult(name = "time",type = LocalDateTime.class),
                        @ColumnResult(name = "offerprice",type = Double.class),
                        @ColumnResult(name = "timeforwork",type = LocalDateTime.class),
                        @ColumnResult(name = "describe",type = String.class),
                        @ColumnResult(name = "customers_id",type = Customer.class)

                })

)*/
@Entity
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
/*
@Table(name = "ord")
*/
public class Orders extends BaseClass {
    private Integer offerPrice;
    private LocalDateTime timeForWork;
    private String address;
    private String describe;
    @Enumerated(EnumType.STRING)
    private WorkStatus workStatus;
    @ManyToOne
    private Customer customers;
   /* @OneToMany(mappedBy = "order")
    private List<Offer> offers;*/
    @ManyToOne
    private SubService subService;

    public Orders(Integer id, LocalDateTime time, Integer offerPrice, LocalDateTime timeForWork, String address, String describe, Customer customers) {
        super(id, time);
        this.offerPrice = offerPrice;
        this.timeForWork = timeForWork;
        this.address = address;
        this.describe = describe;
        this.customers = customers;
    }
}