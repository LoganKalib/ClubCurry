package za.ac.cput.factory;

import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Orders;
import za.ac.cput.domain.enums.CollectionType;
import za.ac.cput.domain.enums.OrderStatus;
import za.ac.cput.domain.enums.PaymentMethod;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;

public class OrderFactory {

    public static Orders buildOrder(Date ordered, Cart cart, double total, PaymentMethod paymentMethod, CollectionType collectionType, LocalTime time, OrderStatus orderStatus){
        if(total > 0 && cart !=null && paymentMethod !=null && collectionType !=null){
            return new Orders.Builder()
                    .setOrdered(ordered)
                    .setCart(cart)
                    .setTotal(total)
                    .setPaymentMethod(paymentMethod)
                    .setCollectionType(collectionType)
                    .setTime(time)
                    .setOrderStatus(orderStatus)
                    .build();
        }
        return null;
    }
    public static Orders buildOrder(Long id, Date ordered, Cart cart, double total, PaymentMethod paymentMethod, CollectionType collectionType, LocalTime time, OrderStatus orderStatus){
        if(total > 0 && cart !=null && paymentMethod !=null && collectionType !=null){
            return new Orders.Builder()
                    .setId(id)
                    .setOrdered(ordered)
                    .setCart(cart)
                    .setTotal(total)
                    .setPaymentMethod(paymentMethod)
                    .setCollectionType(collectionType)
                    .setTime(time)
                    .setOrderStatus(orderStatus)
                    .build();
        }
        return null;
    }
}
