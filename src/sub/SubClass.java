package sub;

import java.util.Scanner;

import dao.UserDAO;
import dto.UserDTO;

public class SubClass {
	Scanner sc = new Scanner(System.in);

	public String phone (String phone) {
		StringBuffer sb = new StringBuffer();
		sb.append(phone);
		sb.insert(3,"-");
		sb.insert(8,"-");
		return sb.toString();
	}
	
	public String edata() {
		boolean tf = true;
		String email=null;
		while (tf) {
			System.out.print("email >> ");
			email = sc.next();
			tf = UserDAO.email_select(email);
			// email 중복 검사
		}
		return email;
	}
	
	public String iddata(UserDTO dto) {
		String email = dto.getEmail();
		String g = "@";
		int end = email.indexOf(g);
		return email.substring(0,end);
	}
	
	public void doinsert(UserDTO dto) {
		System.out.print("확인하시겠습니까? (y,n) >> ");
		String ok = sc.next();
		if(ok.equals("y")) {
			System.out.println("입력 디버깅");
			UserDAO.insert(dto);					
		}
	}
}
