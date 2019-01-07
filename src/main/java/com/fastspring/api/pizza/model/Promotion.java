package com.fastspring.api.pizza.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long promotionId;

    @Column(unique=true)
    private String promotionCode;

    @Column(name = "EXPIRY_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expiryDate;

    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    private int percentageOff;

    public Promotion() {

    }

    public Promotion(String promotionCode, Date expiryDate, Date dateCreated, int percentageOff) {
        this.promotionCode = promotionCode;
        this.expiryDate = expiryDate;
        this.dateCreated = dateCreated;
        this.percentageOff = percentageOff;
    }


    public Long getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(Long promotionId) {
        this.promotionId = promotionId;
    }

    public String getPromotionCode() {
        return promotionCode;
    }

    public void setPromotionCode(String promotionCode) {
        this.promotionCode = promotionCode;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public int getPercentageOff() {
        return percentageOff;
    }

    public void setPercentageOff(int percentageOff) {
        this.percentageOff = percentageOff;
    }

}
