package SeriExam_Data;

import java.util.List;

import ReqResGet_LombokAPI.User;
import ReqResGet_LombokAPI.User.Support;
import ReqResGet_LombokAPI.User.UserData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Item {
	
	private List<userData>data;
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@Builder
	public static class userData{
		private String id;
		private String type;
		
		
	}
	
	

}
