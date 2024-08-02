package com.onetool.server.diabetes;

import com.onetool.server.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Diabetes extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="diabetes_name")
    private String diabetesName;
    @Column(name="category_id")
    private Long categoryId;
    @Column(name = "standard_price")
    private Long standardPrice;
    @Column(name = "diabetes_details")
    private String diabetesDetails;
    @Column(name = "diabetes_img")
    private String diabetesImg;
    @Column(name = "diabetes_details_img")
    private String diabetesDetailsImg;
    @Column(name = "capacity")
    private String capacity;
    @Column(name="calorie")
    private String calorie;
    @Column(name="storage")
    private String storage;
    @Column(name = "hits")
    private BigInteger hits;
    @Column(name = "sale_price")
    private Long salePrice;
    @Column(name = "sale_expired_date")
    private LocalDateTime saleExpiredDate;

    //TODO 일단 장바구니&주문 맵핑 나중에
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "order_blueprint_id")
//    private OrderBlueprint orderBlueprint;
//
//    @OneToMany(mappedBy = "blueprint")
//    private List<CartBlueprint> cartBlueprints = new ArrayList<>();

    @Builder
    public Diabetes(Long id, String diabetesName, Long categoryId, Long standardPrice, String diabetesDetails, String diabetesImg, String diabetesDetailsImg, String capacity, String calorie, String storage, BigInteger hits, Long salePrice, LocalDateTime saleExpiredDate) {
        this.id = id;
        this.diabetesName = diabetesName;
        this.categoryId = categoryId;
        this.standardPrice = standardPrice;
        this.diabetesDetails = diabetesDetails;
        this.diabetesImg = diabetesImg;
        this.diabetesDetailsImg = diabetesDetailsImg;
        this.capacity = capacity;
        this.calorie = calorie;
        this.storage = storage;
        this.hits = hits;
        this.salePrice = salePrice;
        this.saleExpiredDate = saleExpiredDate;
    }

}