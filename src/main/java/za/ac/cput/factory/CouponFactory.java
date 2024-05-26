package za.ac.cput.factory;

import za.ac.cput.domain.Coupon;
import za.ac.cput.domain.Order;
import za.ac.cput.util.Helper;

import java.util.Date;

public class CouponFactory {
    public static Coupon buildCoupon(String couponId, String Code, double Reduction, Date Expires){
        if(Helper.isNullOrEmpty(couponId)
               || Helper.isNullOrEmpty(Code)
               || Helper.isNull(Reduction)
               || Helper.isNullOrEmpty(Expires))
            return null;

        return new Coupon.Builder()
                    .setCouponId(couponId)
                    .setCode(Code)
                    .setReduction(Reduction)
                    .setExpires(Expires)
                    .build();
        }

    public static Coupon buildCoupon(String couponId) {
        if (Helper.isNullOrEmpty(couponId)) {
            return null;
        }
        return new Coupon.Builder()
                .setCouponId(couponId)
                .build();
    }

    }

