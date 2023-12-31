package com.example.spring_boot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "customer")
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private long phone;

    @Column(name = "id_address")
    private long id_address;

    @Column(name = "email")
    private long email;

    @Column(name = "isDelete")
    private Boolean isDelete = false;

    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    private List<Bill> bills;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "idStrideStylePay", updatable = false, insertable = false)
    private StrideStylePay strideStylePay;


}
