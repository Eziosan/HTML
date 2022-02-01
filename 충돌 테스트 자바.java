package com.mini.ui;

import java.util.ArrayList;
import java.util.Scanner;

import com.mini.control.MusicManager;
import com.mini.control.UserManager;
import com.mini.dao.UserDAO;
import com.mini.vo.Song;
import com.mini.vo.UserInfo;

/*
 * UserMapper : 로그인/ 회원가입
 * MusicMapper
 * 
 * AdminManager : 관리자모드(전체 곡 검색, 곡/콘서트 등록, 곡/콘서트 수정, 곡/ 콘서트 삭제, 리스트 검색)
 * MusicManager : 나머지 모두
 * UserManager : 로그인/회원가입만
 * 
 * MusicDAO : Admin, MusicManager에서 할일 다 처리
 * UserDAO : 로그인 / 회원가입
 * 
 * 항상 염두에 둘 것 : 예외처리 /		//가져온 객체 or 리스트가 null일 때 처리

 */

// try - catch???
public class UI {
	Scanner sc = new Scanner(System.in);
	// 유저 / 곡 / 관리자 매니저 객체 각각 설정
	UserManager um = new UserManager();
	MusicManager mm = new MusicManager();
	
	public UI() {
		boolean flag = true;
		
		while(flag) {
			mainUI();
			int num = sc.nextInt();
			
			
			switch(num) {
				case 1: 
					if(um.isLogin()) {
						//로그아웃 시켜주는 메소드 실행
						um.logout();
						
		
		}
	}

	//충돌 테스트
	public void conflict() {
		System.out.println("전진 메세지");


		sys("마스터에서 추가한 메세지
	}

voidsa(asdasd) 
 마스터에서 추가한 함수
d

	
	//1. 회원가입, 로그인 메뉴를 표시하는 함수
	public void loginPage() {
		
		
		
			System.out.println("===================");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 메인화면으로 돌아가기");
			System.out.println("===================");
			int num = sc.nextInt();
			
			// 1. 회원가입, 2. 로그인 실행
			switch(num) {
				case 1: signUp(); break;
				case 2:	login(); break;
				case 3: break;

				default: System.out.println("잘못 입력하셨습니다!!");

			}
			
		}
		

	
	
	//1-1 로그인
	public void login() {
		
		 boolean flag=true;
		 
		while(flag) {
		System.out.print("ID : ");
		String user_id = sc.next();
		System.out.print("패스워드 : ");
		String password = sc.next();
		
		if(um.login(user_id, password)) {
			System.out.println("로그인 성공!!");
			um.login(user_id, password);
			
			flag=false;
			break;
			
		}else {
			System.out.println("로그인 실패!");
			
		}
		}
	}
	
	//1-2 회원가입
	public void signUp() {
		System.out.print("ID : ");
		String user_id = sc.next();
		System.out.print("패스워드 : ");
		String password = sc.next();
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("성별 : ");
		String sex = sc.next();
		System.out.print("생년월일 : ");
		String birth = sc.next();
		System.out.print("이메일 : ");
		String email = sc.next();
		System.out.print("전화번호 : ");
		String phone = sc.next();
		System.out.print("주소 : ");
		String address = sc.next();
		
		UserInfo ui = new UserInfo(user_id, password, name, sex, birth, email, phone,
				address);
		
		if(um.signUp(ui)) {
			System.out.println("회원가입 성공"); 
		}else {
			System.out.println("회원가입 실패!!");
		}
		
		
	}
	
	// 2. 곡 검색
	//default설정. 메인화면으로 가기 추가
	public void searchMusic() {
		System.out.println("===================");

		//몇 글자만 입력해도 인식해서 찾아주도록 -> Like(선택??)
		//가사 검색 추가??
		System.out.println("1. 가수명으로 검색");
		System.out.println("2. 곡명으로 검색");
		System.out.println("3. 가사로 검색");
		System.out.println("===================");

		System.out.print("번호 입력 : ");
		int num = sc.nextInt();
		
		switch(num) {
			case 1: searchMusicBySinger(); break;
			case 2: break;
			case 3: searchMusicByLyric(); break;
			default : System.out.println("잘못 입력하셨습니다!!");
		}
	}
	
	//곡 검색
	//조회수 : 검색될 때마다 증가
	public void searchMusicBySinger() {
		System.out.println("가수명 입력받으면 아래 화면이 뜸");
		System.out.println("===================");
		System.out.println("곡명 : 신호등");
		System.out.println("가수 : 이무진");
		System.out.println("발매일 : 2021.05.14");
		System.out.println("작사 : 이무진");
		System.out.println("작곡 : 이무진");
		System.out.println("===================");
		System.out.println("조회수 : 10000000000000");
		//ex) 4점대는 별 4개로 표시
		System.out.println("★★★★☆ 4.2");
		System.out.println("[코멘트] : 3개 정도 출력");
		System.out.println("코멘트 옛시(200자)ㄴㅇㅁㄴㅇㄴㅁㅇㅁ\n"
				+ "글자수채우기 ㅁㅈㄱㅈㄱㅂㅈㄱㅂㅈㄱㅂㅈㄱㅂㅈㄱㅈㄷㄱㅈㄷ \n"
				+ "귀찮아아아아아아아아아ㅏ아아아아아아아ㅏ아아아아아아아아아\n"
				+ "자고싶다아아아아아아ㅏ앙아아아아아아아앙아아앙아아앙앙아ㅏ\n");
		
		System.out.println("===================");
		//로그인 안되어있으면 번호를 선택해도 못하도록
		// 별점 남기기 추가
		//코멘트 삭제 추가(보류)
		/*[고민중]
		 * 별점을 이미 입력한 경우  다시 입력 기능 추가???(이거 안하려면 별점 입력 메뉴를 없애든지)
		 */
		//이미 특정 리스트에 이 곡이 들어가 있다면 추가로 못넣도록 해야 됨!!!
		System.out.println("1. 가사 보기");
		System.out.println("2. 별점 등록");    // 2,3,4번은 로그인을 했을때만 할수 있도록.
		System.out.println("3. 리스트에 추가");
		System.out.println("4. 코멘트 남기기");
		System.out.println("5. 메인화면으로 이동");
		
		int num = sc.nextInt();
		
		switch(num) {
			case 1: break;
			case 2: return ;
		}
		//✪
	}
	//가수명으로 검색
	public void searchMusicByName() {
		
	}
	
	/*
	 *  2-3. 가사로 곡 검색. 가사를 입력받아 곡 테이블에서 곡을 찾아옴
		해당 가사를 포함하고 있는 곡 리스트 가져옴
		그 중 보고 싶은 곡을 선택(song_id)
		곡 정보 표시!
	 */
	//각 곡마다 가사를 보여줘야(보류)
	public void searchMusicByLyric() {
		System.out.print("가사입력 : ");
		String lyrics = sc.next();
		//가사가 포함되어 있는 곡 가져옴
		//null일 경우
		ArrayList<Song> songList = mm.musicByLyric(lyrics);
		
		//가져온 객체 or 리스트가 null일 때 처리
		if(songList == null) return;
		
		//가사로 찾은 곡 리스트 출력
		System.out.println("===============================");
		System.out.println("곡 ID\t곡 이름\t가수 이름");
		//만약에 가수가 여러명이야 -> 가수를 다 찾아야됨???
		for(Song song : songList) {
			System.out.print(song.getSong_id() +"\t"+ song.getSong_name()+"\n");
			
		}
		System.out.println("===============================");
		System.out.print("찾고 싶은 곡 ID 입력 : ");
		int num = sc.nextInt();
		//사용자가 입력한 song_id로 곡을 가져옴
		Song song = mm.showSong(num);
		
		//값이 null이면 검색결과가 없습니다 출력
		
		//이 밑에는 이제 어떻게 보여줄지 짜야됨(보류)
		System.out.println(song);
		
		
	}
	
	//로그인 체크
	//입력 받을 거 더 추가
	//가수도 추가(가수가 이미 존재하는지 검색해서 확인 하고 있으면 곡 테이블에 가수 이름 바로 넣으면 되고 없으면 가수/곡 테이블 둘 다 추가하도록)
	//3. 곡 등록
	public void enroll() {
		
		// 가수가 있는지 확인할 필요가 있다.
		
		if(um.isLogin()) {
			System.out.print("곡명 : ");
			String name = sc.next();
			System.out.print("가수 : ");
			String singer = sc.next();
			System.out.print("발매일 : ");
			String date = sc.next();
			System.out.print("작사 : ");
			String writer = sc.next();
			System.out.print("작곡 : ");
			String composer = sc.next();
			
		}else {
			System.out.println("로그인이 필요한 서비스 입니다.");
		}
		
	}
	
	//4. top 10, 조회수나 별점 기반으로 지정
	public void top10() {
		System.out.println("============================================");
		System.out.println("1	리무진");
		System.out.println("2	회전목마");
		System.out.println("3	만남은 쉽고 이별은 어려워");
		System.out.println("4	쉬어");
		System.out.println("5	Wake Up");
		System.out.println("6	MBTI");
		System.out.println("7	strawberry moon");
		System.out.println("8	불협화음");
		System.out.println("9	Savage");
		System.out.println("10	다정히 내 이름을 부르면");
		System.out.println("아니면 조회수나 별점 순으로 해서 top10 매겨도 되고");
		System.out.println("============================================");
	}
	
	// 콘서트 정보 확인
	
	public void concertInfo() {
			// 메뉴 2가지 가수명으로 검색, 전체출력
		boolean flag = true;
			
		while (flag) {
			System.out.println("=============== 콘서트 정보 =============");
			System.out.println("1. 가수명으로 콘서트를 검색합니다.");
			System.out.println("2. 콘서트의 모든 정보를 출력합니다.");
			System.out.println("3. 메인 화면으로 돌아가기");
				
			int select = sc.nextInt();
				
				
			switch(select) {
				case 1 : break; // 가수명으로 콘서트 검색
				case 2 : break; // 콘서트의 모든 정보를 출력
				case 3 : flag=false; break; // 메인화면으로 돌아가기 인데, flag를 안쓰면 while로 돌아가니까 flag를 false로 하고 브레이크를 해서 완전히 메인메뉴로 빠져나감.
				default : System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요");
			}
		}
	}
	
	public void listCheck() {
		if(um.isLogin()) {
			System.out.println("유저 **가 가지고 있는 리스트를 표시합니다.");
		
		}else {
			System.out.println("로그인이 필요한 서비스 입니다.");
		}
	}
	
	public void adminMode() {
		
		System.out.println("관리자 모드입니다.");
		System.out.print("ID : ");
		String admin_id = sc.next();
		System.out.print("Password :");
		String admin_pwd = sc.next();
		
		// 매니저로 던져줘서 값을 리턴받고
		
		boolean flag = true;
		
		while(flag) {
			System.out.println("1. 곡 검색"); // 일반 곡검색이랑 같음
			System.out.println("2. 곡 등록");
			System.out.println("3. 곡 수정");
			System.out.println("4. 곡 삭제");
			
			
			System.out.print("번호 입력 : ");
			int num=sc.nextInt();
			
			// if 문 써서 로그인 됬을 때 만 실행하도록
			switch(num) {
				case 1 : break;
				case 2 : break;
				case 3 : break;
				case 4 : break;
				
				
				default : System.out.println("잘못 입력하셨습니다.");
			
			}
		}
	}
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
