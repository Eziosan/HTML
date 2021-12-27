package com.mini.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.mini.control.ConcertManager;
import com.mini.control.MusicManager;
import com.mini.control.TopSongManager;
import com.mini.control.UserManager;
import com.mini.dao.UserDAO;
import com.mini.vo.Concert;
import com.mini.vo.Singer;
import com.mini.vo.Song;
import com.mini.vo.UserInfo;

/*
 * UserMapper : 로그인/ 회원가입
 * MusicMapper
 * 
 * AdminManager : 관리자모드(전체 곡 검색, 곡/콘서트 등록, 곡/콘서트 수정, 곡/ 콘서트 삭제, 리스트 검색)
 * MusicManager : 나머지 모두
 * UserManager : 로그인/회원가입만
 * TopSongManager : TOP10의 노래들을 가져온다.
 * 
 * MusicDAO : Admin, MusicManager에서 할일 다 처리
 * UserDAO : 로그인 / 회원가입
 * 
 * 항상 염두에 둘 것 : 예외처리 /		//가져온 객체 or 리스트가 null일 때 처리

 */

// try - catch???
//UI 초반
public class UI {
	Scanner sc = new Scanner(System.in);
	// 유저 / 곡 / 관리자 매니저 객체 각각 설정
	UserManager um = new UserManager();
	MusicManager mm = new MusicManager();
	TopSongManager tm = new TopSongManager();
	//콘서트 매니저(추가)
	ConcertManager cm = new ConcertManager();
	
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
						
					}else {
					loginPage(); 
					}
					break;
				case 2: searchMusic(); break;
				case 3: enroll(); break;
				case 4: top10(); break;
				case 5: concertInfo(); break;
				case 6: listCheck(); break;
				default : System.out.println("잘못 입력했습니다");
			}
		}
	}
	
	public void amugona() {
		System.out.println("아무거나 쓰라고해서 씀");
		System.out.println("2번째로 씀");
		System.out.println("3번째로 씀");
	}
	
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
		System.out.println("4. 메인화면으로 돌아가기");
		System.out.println("===================");

		System.out.print("번호 입력 : ");
		int num = sc.nextInt();
		
		switch(num) {
			case 1: searchMusicBySinger(); break;
			case 2: break;
			case 3: searchMusicByLyric(); break;
			case 4: break;
			default : System.out.println("잘못 입력하셨습니다!!");
		}
	}
	
	//가수명으로 곡 검색
	//조회수 : 검색될 때마다 증가
	public void searchMusicBySinger() {
		
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
		//song_id를 사용자에게 보여주지 않기 위해 HashMap<가져온 곡 리스트 번호(1번부터 시작), 실제 song_id>사용
		/*
		 *  1,  18
		 *  2,  20
		 *  3,  30
		 *  
		 *  1번  -> 18번 노래
		 */
		HashMap<Integer, Integer> songMap = new HashMap<>();
		//가져온 곡 리스트에 번호를 매기는데 song_id 대신 사용자에게 보여줄 번호 
		int lyricNum = 1;
		
		//1. 가사를 입력받아 해당 가사가 포함된 모든 곡을 가져옴
		System.out.print("가사입력 : ");
		String lyrics = sc.next();
		//가사가 포함되어 있는 곡 가져옴
		//null일 경우
		ArrayList<Song> songList = mm.musicByLyric(lyrics);
		
		//가져온 객체 or 리스트가 없을 때 메인화면으로 이동
		if(songList.size() < 1) {
			System.out.println("검색 결과가 없습니다!");
			return;
		}
		
		
		//2. 가사로 찾은 곡 리스트 출력
		System.out.println("===============================");
		System.out.println("곡 ID\t곡 이름\t가수 이름");

		for(Song song : songList) {
			System.out.print(lyricNum +"\t"+ song.getSong_name()+"\n");
			songMap.put(lyricNum++, song.getSong_id());
		}
		
		System.out.println("===============================");
		System.out.print("찾고 싶은 곡 ID 입력 : ");
		int num = sc.nextInt();
		
		//사용자가 입력한 song_id로 곡을 가져옴
		Song song = mm.showSong(songMap.get(num));
		//곡 정보 표시
		songPage(song);
		
		
	}
	
	//곡 정보 표시하는 함수. 곡 객체를 받아서 곡 정보 표시
	public void songPage(Song song) {
		System.out.println("가수명 입력받으면 아래 화면이 뜸");
		System.out.println("===================");
		System.out.println("곡 id : " + song.getSong_id());
		System.out.println("곡명 : " + song.getSong_name());
		//가수 id로 가수 이름을 가져오는 함수 작성 필요 ???????????????????
		System.out.println("가수 : " + song.getMain_sid());
		System.out.println("발매일 : " + song.getRelease_date());
		System.out.println("작사 : " + song.getWriter());
		System.out.println("작곡 : " + song.getComposer());
		System.out.println("===================");
		System.out.println("조회수 : " + song.getHits());
		//ex) 4점대는 별 4개로 표시
		System.out.println("★★★★☆ " + song.getCounting_star());
		//?????? 이것도 함수 하나 만들어서 코멘트 가져와야
		System.out.println("[코멘트] : 3개 정도 출력");
		System.out.println("코멘트 옛시(200자)ㄴㅇㅁㄴㅇㄴㅁㅇㅁ\n"
				+ "글자수채우기 ㅁㅈㄱㅈㄱㅂㅈㄱㅂㅈㄱㅂㅈㄱㅂㅈㄱㅈㄷㄱㅈㄷ \n"
				+ "잘래라아아아아아아아아ㅏ아아아아아아아ㅏ아아아아아아아아아\n"
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
//			System.out.print("가수 : ");
//			String singer = sc.next();
			//여기서 확인
			/*
			 * 가수이름 : 리스트 
			 * 
			 * 
			 * 아이 검색
			 *  
			 *  유아이
			 *  아이유
			 *  아이유다
			 *  
			 * 
			 * 1. 가수 이름으로 검색 -> 함수 가져오고
			 * 2. 가수 리스트 불러옴 / 불러온 가수가 없음 -> 가수 등록 부터
			 * 3. 가수 선택 -> 그 가수의 id를 넣는걸로
			 * 
			System.out.print("가수명 : ");
			String singer_name = sc.next();
			System.out.print("성별 : ");
			String sex = sc.next();
			System.out.print("솔로/그룹 여부 : ");
			String isGrouped = sc.next();
			System.out.print("가수소개 : ");
			String introduce = sc.next();
			System.out.print("데뷔일 : ");
			String debut_date = sc.next();
			
			Singer singer = new Singer(singer_name, sex, isGrouped, introduce, debut_date);
			
			 */
			
			
			System.out.print("발매일 : ");
			String date = sc.next();
			System.out.print("작사 : ");
			String writer = sc.next();
			System.out.print("작곡 : ");
			String composer = sc.next();
			System.out.print("가사 : ");
			String lyrics = sc.next();
			
			// Song객체 보내서 insert 하면 되는데
			// Song 생성문
			Song song = new Song(name, date, writer, composer, lyrics);
			
			if(mm.enroll(song)) {
				System.out.println("곡 등록 성공!!");
			}else {
				System.out.println("곡 등록 실패!!");
			}
			
			sc.nextLine();
			
		}else {
			System.out.println("로그인이 필요한 서비스 입니다.");
		}
		
	}
	
	//4. top 10, 조회수나 별점 기반으로 지정
	public void top10() {
		
		ArrayList<Song> topSong = tm.topSong();
		int cnt =1;
		System.out.println("=======================================================");
		for(Song song : topSong) {
			System.out.println("TOP"+cnt);
			System.out.println("\n");
			System.out.println(song);
			System.out.println("\n");
			cnt++;
		}
		boolean flag=true;
		
			while(flag) {
				
				System.out.println("메인화면으로 돌아가시겠습니까? Y");
				System.out.println("문자를 입력하세요 : ");
				String result = sc.next();
				
				switch(result) {
				case "Y" : flag=false; break;
				case "y" : flag=false; break;
				default : System.out.println("잘못 입력하셨습니다. \nY만 입력해주세요.\n");
			}
		}
			
		
		
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
				case 2 : AllConcert(); // 콘서트의 모든 정보를 출력
				case 3 : flag=false; break; // 메인화면으로 돌아가기 인데, flag를 안쓰면 while로 돌아가니까 flag를 false로 하고 브레이크를 해서 완전히 메인메뉴로 빠져나감.
				default : System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요");
			}
		}
	}
	
	public void AllConcert() {
		System.out.println("=======================================================");
		ConcertManager cm = new ConcertManager();
		ArrayList<Concert> concertlist = cm.concertList();
		
		for(Concert concert : concertlist) {
			System.out.println(concert);
		}
	
	}
	
	public void listCheck() {
		if(um.isLogin()) {
			System.out.println("유저 **가 가지고 있는 리스트를 표시합니다.");
		
		}else {
			System.out.println("로그인이 필요한 서비스 입니다.");
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
		System.out.println("===========================");
		System.out.print("번호 입력 : ");

	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UI();
	}

}

