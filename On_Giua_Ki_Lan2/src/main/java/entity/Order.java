package entity;

import java.time.LocalDate;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {
//	{"shipCity":"Reims","orderID":"10248","freight":"32.38","requiredDate"│
//		│:"1996-08-01 00:00:00.000","employeeID":"5","shipName":"Vins et alcool│
//		│s Chevalier","shipPostalCode":"51100","shipCountry":"France","shipAddr│
//		│ess":"59 rue de l'Abbaye","shipVia":"3","customerID":"VINET","shippedD│
//		│ate":"1996-07-16 00:00:00.000","orderDate":"1996-07-04 00:00:00.000","│
//		│shipRegion":"NULL"}   
	@SerializedName("orderID")
	private String orderId;
	private String employeeId;
	private Customer customer;
	private String freight;

	private String shipName;
	private LocalDate requireDate;
	private LocalDate shippedDate;
	private LocalDate orderDate;
    private transient Address shipAddress;

}
