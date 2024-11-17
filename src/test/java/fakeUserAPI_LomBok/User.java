package fakeUserAPI_LomBok;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class User {

	

	private String email;
	private String username;
	private String password;
	private String phone;
	private Name name;
	private Address address;
	//private String geolocation;
	

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@Builder
	public static class Name {
		private String username;
		private String lastname;
	}

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@Builder
	public static class Address {
		private String city;
		private String street;
		private int number;
		private String zipcode;
		private Geolocation geolocation;
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@Builder
	public static class Geolocation {
		private String lati;
		private String longitude;
	}
	}

}
