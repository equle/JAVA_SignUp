package main;

import java.util.Scanner;


import dao.UserDAO;
import dto.UserDTO;

public class MainClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean tf = true;

		for (;;) {
			System.out.println("1. 회원가입");
			System.out.println("2. 회원보기");
			System.out.print("3. 종료하기 >>");
			int i = sc.nextInt();
			if (i == 1) {
				UserDTO dto = new UserDTO();

				while (tf) {
					System.out.print("email >> ");
					String email = sc.next();
					dto.setEmail(email);
					tf = UserDAO.email_select(dto.getEmail());
					//email  중복 검사
				}
				
				String email = dto.getEmail();
				String g = "@";
				int end = email.indexOf(g);
				String id = email.substring(0,end);
				dto.setId(id);
				
				System.out.print("비밀번호 >> ");
				dto.setPw(sc.next());
				
				System.out.print("이름 >> ");
				dto.setName(sc.next());
				
				System.out.print("핸드폰 >> ");
				
				String phone = sc.next();
				if(phone.length()==11) {
					StringBuffer sb = new StringBuffer();
					sb.append(phone);
					sb.insert(3,"-");
					sb.insert(8,"-");
					phone = sb.toString();			
				}
				dto.setPhone(phone);
				
				System.out.print("확인하시겠습니까? (y,n) >> ");
				String ok = sc.next();
				if(ok.equals("y")) {
					System.out.println("입력 디버깅");
					UserDAO.insert(dto);					
				}
				
			} else if (i == 2) {
				System.out.println("< 회원 정보 >");
				UserDAO.select();
			} else if (i == 3) {
				System.out.println("종료합니다.");
				break;
			} else {
				System.out.println("다시 입력해 주세요.");
			}
		}

	}

}
