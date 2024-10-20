package za.ac.cput.factory;

import za.ac.cput.domain.Booking;
import za.ac.cput.domain.GeneralStaff;
import za.ac.cput.domain.enums.OrderStatus;
import za.ac.cput.domain.enums.Section;
import za.ac.cput.domain.enums.BookingStatus;
import za.ac.cput.utils.Validation;

public class BookingFactory {
    public static Booking buildBooking(Long id, String time, String date, int tableNo, Section sectionNo, BookingStatus status, GeneralStaff bookedBy, OrderStatus orderStatus, String fullName, String phoneNumber){
        if(id>0 &&tableNo>0 && sectionNo !=null && status !=null && bookedBy !=null && orderStatus != null && fullName != null && Validation.isValidMobileNo(phoneNumber)){
                    return new Booking.Builder().setBookingId(id)
                            .setTime(String.valueOf(time))
                            .setDate(String.valueOf(date))
                            .setTableNo(tableNo)
                            .setSectionNo(sectionNo)
                            .setBookedBy(bookedBy)
                            .setStatus(status)
                            .setOrderStatus(orderStatus)
                            .setFullName(fullName)
                            .setPhoneNumber(phoneNumber)
                            .build();
        }
        return null;
    }

    public static Booking buildBooking(String time, String date, int tableNo, Section sectionNo, BookingStatus status, GeneralStaff bookedBy, OrderStatus orderStatus, String fullName, String phoneNumber){
        if(tableNo>0 && sectionNo !=null && status !=null && bookedBy !=null && orderStatus != null && fullName != null && Validation.isValidMobileNo(phoneNumber)){
                    return new Booking.Builder()
                            .setTime(String.valueOf(time))
                            .setDate(String.valueOf(date))
                            .setTableNo(tableNo)
                            .setSectionNo(sectionNo)
                            .setBookedBy(bookedBy)
                            .setStatus(status)
                            .setOrderStatus(orderStatus)
                            .setFullName(fullName)
                            .setPhoneNumber(phoneNumber)
                            .build();


        }
        return null;
    }
    public static Booking buildBooking(String time, String date, int tableNo, Section sectionNo, BookingStatus status, OrderStatus orderStatus, String fullName, String phoneNumber){
        if(tableNo>0 && sectionNo !=null && status !=null && fullName != null && Validation.isValidMobileNo(phoneNumber) ){
                    return new Booking.Builder()
                            .setTime(String.valueOf(time))
                            .setDate(String.valueOf(date))
                            .setTableNo(tableNo)
                            .setSectionNo(sectionNo)
                            .setStatus(status)
                            .setOrderStatus(orderStatus)
                            .setFullName(fullName)
                            .setPhoneNumber(phoneNumber)
                            .build();


        }
        return null;
    }

}
