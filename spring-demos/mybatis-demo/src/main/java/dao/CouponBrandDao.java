package dao;

import entity.CouponBrandEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface CouponBrandDao {
    @Select("select * from coupon_brand where id = #{UID}")
    CouponBrandEntity getEntityById(@Param("UID") Long id);

    @Insert("INSERT INTO test_db.coupon_brand (brandID,couponClassID,storeID) VALUES (#{brandID},#{couponClassID},#{storeID})")
    void addCouponBrand(CouponBrandEntity couponBrand);
}
