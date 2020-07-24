package main;

import java.util.Scanner;


import dao.UserDAO;
import dto.UserDTO;
import sub.SubClass;

public class MainClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SubClass sub = new SubClass();
		boolean tf = true;

		for (;;) {
			System.out.println("\n1. 회원가입");
			System.out.println("2. 회원보기");
			System.out.print("3. 종료하기 >>");
			int i = sc.nextInt();
			if (i == 1) {
				UserDTO dto = new UserDTO();

				dto.setEmail(sub.edata());
				dto.setId(sub.iddata(dto));
				
				System.out.print("비밀번호 >> ");
				dto.setPw(sc.next());
				
				System.out.print("이름 >> ");
				dto.setName(sc.next());
				
				System.out.print("핸드폰 >> ");
				
				String phone = sc.next();
				if(phone.length()==11) {
					phone = sub.phone(phone);			
				}
				dto.setPhone(phone);
				
				sub.doinsert(dto);
				
			} else if (i == 2) {
				System.out.println("\n1. 전체보기");
				System.out.print("2. 회원번호로 보기 >>");
				int j = sc.nextInt();
				if(j==1) {
					System.out.println("\n< 회원 정보 >");
					UserDAO.select();					
				}else if(j==2) {
					System.out.println("\n회원번호 >> ");
					int num = sc.nextInt();
					System.out.println("\n< 회원 정보 >");
					UserDAO.unum_select(num);
				}
			} else if (i == 3) {
				System.out.println("종료합니다.");
				break;
			} else {
				System.out.println("다시 입력해 주세요.");
			}
		}

	}

}
