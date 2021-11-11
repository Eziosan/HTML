package com.shoppoing.ui;

import java.util.*;

import com.shopping.control.AdminManager;
import com.shopping.control.ShoppingManager;
import com.shopping.control.UserManager;
import com.shopping.vo.*;

public class ShoppingUI {
	private Scanner scan = new Scanner(System.in);
	private UserManager userManager = new UserManager();
	private ShoppingManager shoppingManager = new ShoppingManager();
	private AdminManager adminManager = new AdminManager();
	
	public ShoppingUI() {
		while(true) {
			mainUI();
			int input = scan.nextInt();
			
			switch(input) {
				case 1:userUI(); break;
				case 2:orderUI(); break;
				case 3:getOrderListById(); break;
				case 4:adminUI();break;
				default:System.out.println("번호를 잘못 입력했습니다.");
			}
		}
	}
	
	// 메인메뉴
	public void mainUI() {
		System.out.println("-------------------------");
		System.out.println("ABC 도시락에 오신것을 환영 합니다.");
		System.out.println("-------------------------");
		if (!userManager.isLogin()) {
			System.out.println("1. 로그인/회원가입");
		} else {
			System.out.println("1. 로그아웃");
		}
		System.out.println("2. 주문하기");
		System.out.println("3. 주문내역");
		System.out.println("4. 관리자 모드");
		System.out.println("-------------------------");
		System.out.print("선택 : ");
	}
	
	public void userUI() {
		if (userManager.isLogin()) {
			userManager.logout();
			System.out.println("로그아웃 합니다.");
		} else {
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.println("-------------------------");
			System.out.print("선택 : ");
			
			int input = scan.nextInt();
			
			switch(input) {
				case 1:loginUI(); break;
				case 2:joinUserUI(); break;
				default:System.out.println("번호를 잘못 입력했습니다.");
			}
		}
	}
	
	public void loginUI() {
		System.out.print("아이디 : ");
		String user_id = scan.next();
		System.out.print("패스워드 : ");
		String passwd = scan.next();
		if (userManager.login(user_id, passwd)) {
			System.out.println("로그인 되었습니다.");
		} else {
			System.out.println("아이디/패스워드가 일치하지 않습니다.");
		}
	}
	
	public void joinUserUI() {
		scan.nextLine();
		System.out.println("회원가입");
		System.out.println("-------------------------");
		System.out.print("아이디 : ");
		String user_id = scan.nextLine();
		System.out.print("패스워드 : ");
		String passwd = scan.nextLine();
		System.out.print("이름 : ");
		String name = scan.nextLine();
		System.out.print("생년월일 : ");
		String birth = scan.nextLine();
		System.out.print("이메일 : ");
		String email = scan.nextLine();
		System.out.print("전화번호 : ");
		String phone = scan.nextLine();
		System.out.print("주소 : ");
		String address = scan.nextLine();
		
		User user = new User(user_id, passwd, name, birth, email, phone, address);
		
		if (userManager.joinUser(user)) {
			System.out.println("회원가입에 성공 했습니다.");
		} else {
			System.out.println("중복된 아이디가 있습니다.");
		}
	}
	
	public void orderUI() {
		if (!userManager.isLogin()) {
			System.out.println("로그인이 필요합니다.");
			return;
		}
		
		ArrayList<Product> productList = shoppingManager.getProductList();
		System.out.println("메뉴표");
		System.out.println("-------------------------");
		System.out.println("NO\t제품명\t\t가격\t재고량\t");
		if (productList != null && productList.size() > 0) {
			for (Product product : productList) {
				System.out.println(product);
			}
		} else {
			System.out.println("현재 등록된 상품이 없습니다.");
		}
		System.out.println("-------------------------");
		orderProductUI();
	}
	
	public void orderProductUI() {
		HashMap<Integer, Integer> orderList = new HashMap<>();
		System.out.println("주문 NO와 수량을 입력해 주세요(NO에 0 입력 시 주문을 완료합니다.)");
		while (true) {
			System.out.print("메뉴 NO : ");
			int menuNo = scan.nextInt();
			if (menuNo == 0) break;
			System.out.print("주문수량 : ");
			int cnt = scan.nextInt();
			orderList.put(menuNo, cnt);
		}
		
		System.out.println("주문내역");
		Set<Integer> keys = orderList.keySet();
		for (Integer key : keys) {
			System.out.println("NO : " + key + " 주문수량 : " + orderList.get(key));
		}
		
		if (shoppingManager.orderProduct(orderList, userManager.getLogin_id())) {
			System.out.println("상품 주문에 성공했습니다.");
		} else {
			System.out.println("상품 주문에 실패했습니다.");
		}
	}
	
	public void getOrderListById() {
		if (!userManager.isLogin()) {
			System.out.println("로그인이 필요합니다.");
			return;
		}
		
		System.out.println("전체 주문내역");
		ArrayList<Order> orderList = shoppingManager.selectOrderListById(userManager.getLogin_id());
		
		for (Order order : orderList) {
			System.out.println(order);
		}	
	}
	
	public void adminUI() {
		System.out.print("관리자 패스워드 : ");
		String admin_passwd = scan.next();
		
		if (adminManager.admin_login(admin_passwd)) {
			System.out.println("전체 주문내역");
			System.out.println("-------------------------");
			ArrayList<Order> orderList = shoppingManager.selectOrderList();
			
			for (Order order : orderList) {
				System.out.println(order);
			}
			
			System.out.print("취소할 주문번호를 선택하세요 : ");
			int order_no = scan.nextInt();
			
			if (adminManager.cancel_order(order_no)) {
				System.out.println("삭제에 성공했습니다.");
			} else {
				System.out.println("주문정보가 없거나 삭제에 실패 했습니다.");
			}
			
		} else {
			System.out.println("패스워드가 다릅니다.");
		}
		
	}
	
	public static void main(String[] args) {
		new ShoppingUI();
	}
}
