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
				default:System.out.println("��ȣ�� �߸� �Է��߽��ϴ�.");
			}
		}
	}
	
	// ���θ޴�
	public void mainUI() {
		System.out.println("-------------------------");
		System.out.println("ABC ���ö��� ���Ű��� ȯ�� �մϴ�.");
		System.out.println("-------------------------");
		if (!userManager.isLogin()) {
			System.out.println("1. �α���/ȸ������");
		} else {
			System.out.println("1. �α׾ƿ�");
		}
		System.out.println("2. �ֹ��ϱ�");
		System.out.println("3. �ֹ�����");
		System.out.println("4. ������ ���");
		System.out.println("-------------------------");
		System.out.print("���� : ");
	}
	
	public void userUI() {
		if (userManager.isLogin()) {
			userManager.logout();
			System.out.println("�α׾ƿ� �մϴ�.");
		} else {
			System.out.println("1. �α���");
			System.out.println("2. ȸ������");
			System.out.println("-------------------------");
			System.out.print("���� : ");
			
			int input = scan.nextInt();
			
			switch(input) {
				case 1:loginUI(); break;
				case 2:joinUserUI(); break;
				default:System.out.println("��ȣ�� �߸� �Է��߽��ϴ�.");
			}
		}
	}
	
	public void loginUI() {
		System.out.print("���̵� : ");
		String user_id = scan.next();
		System.out.print("�н����� : ");
		String passwd = scan.next();
		if (userManager.login(user_id, passwd)) {
			System.out.println("�α��� �Ǿ����ϴ�.");
		} else {
			System.out.println("���̵�/�н����尡 ��ġ���� �ʽ��ϴ�.");
		}
	}
	
	public void joinUserUI() {
		scan.nextLine();
		System.out.println("ȸ������");
		System.out.println("-------------------------");
		System.out.print("���̵� : ");
		String user_id = scan.nextLine();
		System.out.print("�н����� : ");
		String passwd = scan.nextLine();
		System.out.print("�̸� : ");
		String name = scan.nextLine();
		System.out.print("������� : ");
		String birth = scan.nextLine();
		System.out.print("�̸��� : ");
		String email = scan.nextLine();
		System.out.print("��ȭ��ȣ : ");
		String phone = scan.nextLine();
		System.out.print("�ּ� : ");
		String address = scan.nextLine();
		
		User user = new User(user_id, passwd, name, birth, email, phone, address);
		
		if (userManager.joinUser(user)) {
			System.out.println("ȸ�����Կ� ���� �߽��ϴ�.");
		} else {
			System.out.println("�ߺ��� ���̵� �ֽ��ϴ�.");
		}
	}
	
	public void orderUI() {
		if (!userManager.isLogin()) {
			System.out.println("�α����� �ʿ��մϴ�.");
			return;
		}
		
		ArrayList<Product> productList = shoppingManager.getProductList();
		System.out.println("�޴�ǥ");
		System.out.println("-------------------------");
		System.out.println("NO\t��ǰ��\t\t����\t���\t");
		if (productList != null && productList.size() > 0) {
			for (Product product : productList) {
				System.out.println(product);
			}
		} else {
			System.out.println("���� ��ϵ� ��ǰ�� �����ϴ�.");
		}
		System.out.println("-------------------------");
		orderProductUI();
	}
	
	public void orderProductUI() {
		HashMap<Integer, Integer> orderList = new HashMap<>();
		System.out.println("�ֹ� NO�� ������ �Է��� �ּ���(NO�� 0 �Է� �� �ֹ��� �Ϸ��մϴ�.)");
		while (true) {
			System.out.print("�޴� NO : ");
			int menuNo = scan.nextInt();
			if (menuNo == 0) break;
			System.out.print("�ֹ����� : ");
			int cnt = scan.nextInt();
			orderList.put(menuNo, cnt);
		}
		
		System.out.println("�ֹ�����");
		Set<Integer> keys = orderList.keySet();
		for (Integer key : keys) {
			System.out.println("NO : " + key + " �ֹ����� : " + orderList.get(key));
		}
		
		if (shoppingManager.orderProduct(orderList, userManager.getLogin_id())) {
			System.out.println("��ǰ �ֹ��� �����߽��ϴ�.");
		} else {
			System.out.println("��ǰ �ֹ��� �����߽��ϴ�.");
		}
	}
	
	public void getOrderListById() {
		if (!userManager.isLogin()) {
			System.out.println("�α����� �ʿ��մϴ�.");
			return;
		}
		
		System.out.println("��ü �ֹ�����");
		ArrayList<Order> orderList = shoppingManager.selectOrderListById(userManager.getLogin_id());
		
		for (Order order : orderList) {
			System.out.println(order);
		}	
	}
	
	public void adminUI() {
		System.out.print("������ �н����� : ");
		String admin_passwd = scan.next();
		
		if (adminManager.admin_login(admin_passwd)) {
			System.out.println("��ü �ֹ�����");
			System.out.println("-------------------------");
			ArrayList<Order> orderList = shoppingManager.selectOrderList();
			
			for (Order order : orderList) {
				System.out.println(order);
			}
			
			System.out.print("����� �ֹ���ȣ�� �����ϼ��� : ");
			int order_no = scan.nextInt();
			
			if (adminManager.cancel_order(order_no)) {
				System.out.println("������ �����߽��ϴ�.");
			} else {
				System.out.println("�ֹ������� ���ų� ������ ���� �߽��ϴ�.");
			}
			
		} else {
			System.out.println("�н����尡 �ٸ��ϴ�.");
		}
		
	}
	
	public static void main(String[] args) {
		new ShoppingUI();
	}
}
