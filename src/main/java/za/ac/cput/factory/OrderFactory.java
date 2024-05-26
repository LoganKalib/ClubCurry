package za.ac.cput.factory;

import za.ac.cput.domain.Delivery;
import za.ac.cput.domain.Order;
import za.ac.cput.util.Helper;

import java.time.LocalTime;
import java.util.Date;

public class OrderFactory {
    public static Order buildOrder(String orderId, LocalTime Ordered, Cart cart, Date dateOrdered, boolean Completed){
        if(Helper.isNullOrEmpty(orderId)
               || Helper.isNullOrEmpty(Ordered)
               || Helper.isNullOrEmpty(cart)
               || Helper.isNullOrEmpty(dateOrdered)
               || Helper.isNullOrEmpty(Completed))
            return null;

        return new Order.Builder()
                    .setOrderId(orderId)
                    .setOrdered(Ordered)
                    .setCart(cart)
                    .setDateOrdered(dateOrdered)
                    .setCompleted(Completed)
                    .build();
        }

    public static Order buildOrder(String orderId) {
        if (Helper.isNullOrEmpty(orderId)) {
            return null;
        }
        return new Order.Builder()
                .setOrderId(orderId)
                .build();
    }
}

