package za.ac.cput.domain;

import jakarta.persistence.*;
import za.ac.cput.domain.enums.OrderStatus;
import za.ac.cput.domain.enums.Section;
import za.ac.cput.domain.enums.BookingStatus;

import java.util.Objects;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookingId;
    private String date;
    private String time;
    private int tableNo;
    private Section sectionNo;
    private BookingStatus status;
    private OrderStatus orderStatus;
    private String fullName;
    private String phoneNumber;

    @ManyToOne
    private GeneralStaff bookedBy;

    protected Booking() {
    }

    public Booking(Builder obj){
        this.bookingId = obj.bookingId;
        this.date = obj.date;
        this.time = obj.time;
        this.tableNo = obj.tableNo;
        this.sectionNo = obj.sectionNo;
        this.status = obj.status;
        this.bookedBy = obj.bookedBy;
        this.orderStatus = obj.orderStatus;
        this.fullName = obj.fullName;
        this.phoneNumber = obj.phoneNumber;
    }

    public long getBookingId() {
        return bookingId;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public int getTableNo() {
        return tableNo;
    }

    public Section getSectionNo() {
        return sectionNo;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public GeneralStaff getBookedBy() {
        return bookedBy;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return bookingId == booking.bookingId && tableNo == booking.tableNo && Objects.equals(date, booking.date) && Objects.equals(time, booking.time) && sectionNo == booking.sectionNo && status == booking.status && Objects.equals(bookedBy, booking.bookedBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, date, time, tableNo, sectionNo, status, bookedBy);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", date=" + date +
                ", time=" + time +
                ", tableNo=" + tableNo +
                ", sectionNo=" + sectionNo +
                ", status=" + status +
                ", bookedBy=" + bookedBy +
                '}';
    }

    public static class Builder{
        private long bookingId;
        private String date;

        private String time;

        private int tableNo;

        private Section sectionNo;

        private BookingStatus status;

        private OrderStatus orderStatus;

        private String fullName;

        private String phoneNumber;

        @ManyToOne
        private GeneralStaff bookedBy;

        public Builder setBookingId(long bookingId) {
            this.bookingId = bookingId;
            return this;
        }

        public Builder setDate(String date) {
            this.date = date;
            return this;
        }

        public Builder setTime(String time) {
            this.time = time;
            return this;
        }

        public Builder setTableNo(int tableNo) {
            this.tableNo = tableNo;
            return this;
        }

        public Builder setSectionNo(Section sectionNo) {
            this.sectionNo = sectionNo;
            return this;
        }

        public Builder setStatus(BookingStatus status) {
            this.status = status;
            return this;
        }

        public Builder setBookedBy(GeneralStaff bookedBy) {
            this.bookedBy = bookedBy;
            return this;
        }

        public Builder setOrderStatus(OrderStatus orderStatus) {
            this.orderStatus = orderStatus;
            return this;
        }

        public Builder setFullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder copy(Booking obj){
            this.bookingId = obj.bookingId;
            this.date = obj.date;
            this.time = obj.time;
            this.tableNo = obj.tableNo;
            this.sectionNo = obj.sectionNo;
            this.status = obj.status;
            this.bookedBy = obj.bookedBy;
            this.orderStatus = obj.orderStatus;
            this.fullName = obj.fullName;
            this.phoneNumber = obj.phoneNumber;
            return this;
        }

        public Booking build(){
            return new Booking(this);
        }
    }
}
