
	// 안 만들어져있는 부분 추가해주세요!
	//메인화면
	public void mainUI() {
		System.out.println("===========================");

		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡ 메인화면 ㅡㅡㅡㅡㅡㅡㅡㅡ");
		if(!um.isLogin()) {
		System.out.println("1. 로그인/회원가입");
		}else {
			System.out.println("1. 로그아웃");
		}
		System.out.println("2. 곡 검색");
		System.out.println("3. 곡 등록");
		//조회수/ 별점 순 추가해야
		System.out.println("4. TOP10");
		// 전체 콘서트 / 가수명으로 검색 추가해야
		System.out.println("5. 콘서트 정보");
		//본인 리스트 확인 가능 . 하위 메뉴 추가 해야 함
		// 1. 본인 전체리스트 보기 2. 리스트 삭제. 
		System.out.println("6. 리스트 확인");
		System.out.println("7. 관리자 모드(등록, 검색, 수정, 삭제)");
		System.out.println("===========================");
		System.out.print("번호 입력 : ");

	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UI();
	}

}
