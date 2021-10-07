package entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class CouponBrandEntity   {
    private Long ID;

    private Long brandID;

    private Long couponClassID;
    private Long storeID;

    private Timestamp dataChange_LastTime;
    private Timestamp dataChange_CreateTime;

    public CouponBrandEntity() {
    }

    public CouponBrandEntity(Long brandID, Long couponClassID, Long storeID) {
        this.brandID = brandID;
        this.couponClassID = couponClassID;
        this.storeID = storeID;
    }
}