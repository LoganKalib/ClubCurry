package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Coupon;
import za.ac.cput.factory.CouponFactory;
import za.ac.cput.service.CouponService;

import java.util.List;

@RestController
@RequestMapping("/coupon")
public class CouponController {

    private CouponService couponService;

    @Autowired

    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }

    @PostMapping("/create")
    public Coupon create(@RequestBody Coupon obj){
        Coupon coupon = CouponFactory.buildCoupon(
                obj.getCouponId(),
                obj.getCode(),
                obj.getReduction(),
                obj.getExpires());
        return couponService.create(coupon);
    }

    @GetMapping("/read/{id}")
    public Coupon read(@PathVariable String id){
        return couponService.read(id);
    }

    @PostMapping("/delete/{id}")
    public void delete(@PathVariable String id){
        Coupon coupon = CouponFactory.buildCoupon(id);
        couponService.delete(coupon);
    }

    @GetMapping("/getAll")
    public List<Coupon> getAll(){
        return couponService.getAll();
    }

}
