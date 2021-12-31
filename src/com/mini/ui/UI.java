package com.mini.ui;

import java.util.*;

import com.mini.control.*;
import com.mini.dao.*;
import com.mini.vo.*;

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
	MusicController mc = new MusicController();
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
				case 6: showList(); break;
				default : System.out.println("잘못 입력했습니다");
			}
		}
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
			case 1: searchSongBySinger(); break;
			case 2: searchMusicByName(); break;
			case 3: searchMusicByLyric(); break;
			case 4: break;
			default : System.out.println("잘못 입력하셨습니다!!");
		}
	}
	
	//가수명으로 곡 검색
	//조회수 : 검색될 때마다 증가
	public void searchSongBySinger() {
		
		//singer_id를 사용자에게 보여주지 않기 위해 HashMap<가져온 곡 리스트 번호(1번부터 시작), 실제 song_id>사용
		/*
		 *  1,  18
		 *  2,  20
		 *  3,  30
		 *  
		 *  1번  -> 18번 노래
		 */
		HashMap<Integer, Singer> singerMap = new HashMap<>();
		//가져온 곡 리스트에 번호를 매기는데 song_id 대신 사용자에게 보여줄 번호 
		int singerNum = 1;
		
		//1. 검색어를 입력받아 해당 가수가 포함된 모든 곡을 가져옴
		System.out.print("가수입력 : ");
		String singer = sc.next();
		//검색어가 포함되어 있는 가수 가져옴
		//null일 경우
		ArrayList<Singer> singerList = mm.getSingersByName(singer);
		
		//가져온 객체 or 리스트가 없을 때 메인화면으로 이동
		if(singerList.size() < 1) {
			System.out.println("검색 결과가 없습니다!");
			return;
		}
		
		
		//2. 가사로 찾은 곡 리스트 출력
		System.out.println("===============================");
		System.out.println("번호\t곡 이름\t가수 이름");
		
		for(Singer singer2 : singerList) {
			System.out.print(singerNum +"\t"+ singer2.getSinger_name()+"\n");
			singerMap.put(singerNum++, singer2);
		}
		
		System.out.println("===============================");
		System.out.println("찾고 싶은 가수 번호 입력 : ");
		int num = sc.nextInt();
		
		
		// 가수객체로 노래리스트를 가져옴
		ArrayList<Song> songs = mc.selectMusicsBySinger(singerMap.get(num));
		
		
		
		
		songPage(printSong(songs));	
	}
	
	// 가수 검색으로 가져온 송리스트를 출력하는 페이지
	public Song printSong(ArrayList<Song> songs) {
		HashMap<Integer, Integer> songMap = new HashMap<>();
		//가져온 곡 리스트에 번호를 매기는데 song_id 대신 사용자에게 보여줄 번호 
		int songNum = 1;
		
		//가수의 리스트 출력
		System.out.println("===============================");
		System.out.println("번호\t곡 이름\t가수 이름");

		for(Song song : songs) {
			System.out.print(songNum +"\t"+ song.getSong_name()+"\n");
			songMap.put(songNum++, song.getSong_id());
		}
		
		System.out.println("===============================");
		System.out.print("찾고 싶은 곡 번호 입력 : ");
		int num = sc.nextInt();
		
		
		return mm.showSong(songMap.get(num));
		
	}

	//가수명으로 검색
	public void searchMusicByName() {
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
		System.out.print("곡입력 : ");
		String songN = sc.next();
		//곡이 포함되어 있는 곡 가져옴
		//null일 경우
		ArrayList<Song> songList = mc.searchMusicByName(songN);
		
		//가져온 객체 or 리스트가 없을 때 메인화면으로 이동
		if(songList.size() < 1) {
			System.out.println("검색 결과가 없습니다!");
			return;
		}
		
		
		//2. 노래로 찾은 곡 리스트 출력
		System.out.println("===============================");
		System.out.println("번호\t곡 이름\t가수 이름");

		for(Song song : songList) {
			System.out.print(lyricNum +"\t"+ song.getSong_name()+"\n");
			songMap.put(lyricNum++, song.getSong_id());
		}
		
		System.out.println("===============================");
		System.out.print("찾고 싶은 곡 번호 입력 : ");
		int num = sc.nextInt();
		
		//사용자가 입력한 song_id로 곡을 가져옴
		Song song = mm.showSong(songMap.get(num));
		//곡 정보 표시
		songPage(song);	
		
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
		System.out.println("번호\t곡 이름\t가수 이름");

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
	// TOP10에서 노래 상세보기 누르면 이 함수를 재활용하게끔 함수를 수정한다. (TOP10 함수)
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
		showStar(song);
		showComment(song);
		//?????? 이것도 함수 하나 만들어서 코멘트 가져와야
//		System.out.println("[코멘트] : 3개 정도 출력");
//		System.out.println("코멘트 옛시(200자)ㄴㅇㅁㄴㅇㄴㅁㅇㅁ\n"
//				+ "글자수채우기 ㅁㅈㄱㅈㄱㅂㅈㄱㅂㅈㄱㅂㅈㄱㅂㅈㄱㅈㄷㄱㅈㄷ \n"
//				+ "잘래라아아아아아아아아ㅏ아아아아아아아ㅏ아아아아아아아아아\n"
//				+ "자고싶다아아아아아아ㅏ앙아아아아아아아앙아아앙아아앙앙아ㅏ\n");
		
		
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
			case 1: showLyric(song);
			case 2: insertStar(song);
			case 3: insertSongToList(song); ; // 리스트에 추가(윤영이가 한다고 함)
			case 4: insertComment(song);
			case 5: return ;
			default : System.out.println("잘못 입력하셨습니다.");
			
		}
		
		
	}
	
	// 노래 받아서 노래 가사 출력
	public void showLyric(Song song) {
		System.out.println("가수 : " + song.getMain_sid());
		System.out.println("노래 : " + song.getSong_name());
		System.out.println("==============<가사>==============");
		System.out.println("==================================");
		System.out.println(song.getLyrics());
		System.out.println();
		
		System.out.println("1. 곡으로 돌아가기");
		System.out.println("2. 메인메뉴로 돌아가기");
		int num = sc.nextInt();
		
		switch(num) {
			case 1: songPage(song);
			//일엽이 형이 만져주기
			case 2: return;
			}
	}
	
	// 별점 계산 및 출력
	public void showStar(Song song) {
		double star = song.getCounting_star();
		double counter = song.getStar_counter();
		// System.out.println("별점 : " + star + "숫자 : " + counter);
		// 평균 계산 후 소수점 셋째 자리에서 반올림
		if (star != 0) {
			double avr1 = star / counter;
			double avr2 = (Math.round(avr1 * 100) / 100.0);
			int avr3 = (int)avr2;
			
			// 팀장님 아이디어(뽐내고 싶어하셨던거 아님)
			System.out.print("별점 ");
			for (int i=0; i<5; i++) {
				if(i < avr3) {
					System.out.print("★");	
				}else {
					System.out.print("☆");
				}
			}
			System.out.println(" " + avr2);
				
		}else {
			System.out.println("별점 : ☆☆☆☆☆☆ 0.0");
		}
		
	}
	
	//2. 점수를 입력받아 song 에 입력함.
	public void insertStar(Song song) {
		

			// 입력 받을 별점
			System.out.println("별점을 입력해 주세요 : ");
			int insertStar = sc.nextInt();
			int origin = song.getCounting_star();
			song.setCounting_star(insertStar + origin);
			
			// System.out.println("입력할 별점 : " + song.getCounting_star());
			
			// 별점을 입력하기
			if ( insertStar <= 5 && insertStar >= 0) {
				mc.insertStar(song);	
				System.out.println("입력이 완료됐습니다.");
				System.out.print("별점 ");
				showStar(song);
			}else {
			// 0~5이 아니면 다시 입력
				System.out.println("잘못 입력했습니다.");
				return;
			}
	}
	
	
	//리스트에 집어 넣기 (윤영이가 할거임)
	public void insertSongToList(Song song) {
		System.out.println("");
		String dd = sc.next();
		
	}
	
	public void insertComment(Song song) {
		SongComment SC = new SongComment();
		SC.setUser_id(um.getLoginId());
		SC.setSong_id(song.getSong_id());
		
		//코멘트 입력 받기
		System.out.println("코멘트를 입력해 주세요 : ");
		String comment = sc.next();
		
		// 코멘트 길이 확인
		if (comment.length() <  90) {
			SC.setUser_comment(comment);
//			System.out.println(SC);
			mc.insertComment(SC);
			
		}else {
			System.out.println("너무 길다고");
			
		}
		
		return;
		
	}
	
	public void showComment(Song song) {
		
		ArrayList<SongComment> sc = mc.selectCommentBySongId(song.getSong_id());
		System.out.println("유저 아이디\t코멘트\t입력 시간");
		
		//코멘트가 null이 아니고 3개보다 적을때
		if(sc.size() < 3 && sc != null) {
			for (int i = 0; i < sc.size(); i++) {

				System.out.println("유저 아이디 : " + sc.get(i).getUser_id() + 
					"\t코멘트 : " + sc.get(i).getUser_comment() + 
					"\t입력 시간 :  " + sc.get(i).getComment_date());
			}
			
		}else{
		//코멘트가 3개 이상일때
			for (int i = 0; i < 3; i++) {
	
				System.out.println("유저 아이디 : " + sc.get(i).getUser_id() + 
					"\t코멘트 : " + sc.get(i).getUser_comment() + 
					"\t입력 시간 :  " + sc.get(i).getComment_date());
			}
			
		}
	}
	
	
	//가수 이름을 입력받아 해당 이름이 포함된 모든 가수 리스트를 출력하고 사용자가 선택한 가수의 sid를 리턴함
	public int return_sid(String singer_name) {
		//가수 번호대신 표시할 메뉴 번호
		int singer_num = 1;
		//곡에 지정할 가수 id
		int main_sid = 0;
		
		//이름으로 가수 검색해서 리스트로 받아옴
		ArrayList<Singer> singerList = mm.getSingersByName(singer_name);
		//메뉴번호(key), 가수 id(value)방식으로 저장해서 사용자가 메뉴번호를 누르면 해당 가수 id를 꺼내서 main_sid에 저장
		HashMap<Integer, Integer> singerMap = new HashMap<>();
		
		//가져온  가수가 없다면 입력받고 singer테이블에 추가
		if(singerList.size() < 1) {
			System.out.println("===================");
			System.out.println("가수가 없습니다! 새로 등록하겠습니다!!");

			System.out.print("가수명 : ");
			String name = sc.next();
			System.out.print("성별 : ");
			String sex = sc.next();
			System.out.print("솔로/그룹 : ");
			String isGrouped = sc.next();
			System.out.print("가수소개 : ");
			String introduce = sc.next();
			System.out.print("데뷔일 : ");
			String debut_date = sc.next();
			
			Singer singer = new Singer(name, sex, isGrouped, introduce, debut_date);
			main_sid = mm.addSinger(singer);

			System.out.println("===================");
			
		}else {
			System.out.println("===============================");
			System.out.println("번호\t가수 이름");

			for(Singer ser : singerList) {
				//메뉴 번호 	가수 이름 	출력
				System.out.println(singer_num + "\t" + ser.getSinger_name());
				singerMap.put(singer_num++, ser.getMain_sid());
			}
			
			System.out.println("===============================");
			System.out.print("가수선택 : ");
			int num = sc.nextInt();
			main_sid = singerMap.get(num);
			
		}
		
		return main_sid;
	}
	
	//3. 곡 등록
	/*
	 * 1. 가수 이름으로 검색 
	 * 2. 가수 리스트 불러옴 / 불러온 가수가 없음 -> 가수 등록 부터
	 * 3. 가수 선택 -> 그 가수의 id를 넣는걸로
	 */
	public void enroll() {
		
		// 가수가 있는지 확인할 필요가 있다.
		int main_sid = 0;
		
		
		if(um.isLogin()) {
			System.out.print("곡명 : ");
			String name = sc.next();
			System.out.print("가수 : ");
			String singer_name = sc.next();
			//가수이름을 매개변수로 줘서 main_sid반환
			main_sid = return_sid(singer_name);
			
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
			Song song = new Song(name, main_sid, date, writer, composer, lyrics);
			
			//곡 등록
			if(mm.enroll(song)) {
				System.out.println("곡 등록 성공!!");
			}else {
				System.out.println("곡 등록 실패!!");
			}
			
			//버퍼 비워줘야 함
			sc.nextLine();
			
		}else {
			System.out.println("로그인이 필요한 서비스 입니다.");
		}
		
	}
	
	//4. top 10, 조회수나 별점 기반으로 지정
	public void top10() {
		
		ArrayList<Song> topSong = tm.topSong();
		int cnt =1;
		
		//곡 상세정보 출력 변수 지정
		HashMap<Integer, Integer> list = new HashMap<Integer, Integer>();
		
		System.out.println("=======================================================");
		for(Song song : topSong) {
			System.out.println("TOP"+cnt);
			System.out.println(song);
			System.out.println("\n");
			
			//1~10번 노래 저장
			list.put(cnt++, song.getSong_id());
		}
		boolean flag=true;
		
		while(flag) {
			
			//곡 상세정보 추가
			System.out.println("1. 곡 상세정보 보기");
			System.out.println("2. 메인화면으로 돌아가기");
			System.out.println("번호를 입력해주세요 : ");
			int num = sc.nextInt();
			
			
			switch(num) {
			case 1 : System.out.println("곡 번호를 입력해 주세요 : ");
			int num2 = sc.nextInt();
			Song song = mm.showSong(list.get(num2));
			songPage(song);
			
			case 2 : flag = false;
			default : System.out.println("잘못 입력하셨습니다. \nY만 입력해주세요.\n");
			}
		}
		
		
		
	}

	
	// 콘서트 정보 확인
	public void concertInfo() {
		// 메뉴 2가지 가수명으로 검색, 전체출력
		boolean flag = true;
		
		HashMap<Integer, Integer> list  = new HashMap<Integer, Integer>();
		
		while (flag) {
			System.out.println("=============== 콘서트 정보 =============");
			System.out.println("1. 가수명으로 콘서트 검색하기.");
			System.out.println("2. 콘서트 검색하기.");
			System.out.println("3. 메인 화면으로 돌아가기");
			System.out.println("번호를 입력해주세요 : ");
			
			int select = sc.nextInt();
			
			
			switch(select) {
			case 1 :
				selectConcert();
				break; // 가수명으로 콘서트 검색
			case 2 : 
				list = AllConcert(); // 콘서트의 모든 정보를 출력
				System.out.println("========================");
				System.out.println("콘서트 번호 선택 : ");
				int num  = sc.nextInt();
				
				Concert c = cm.concertDetail(list.get(num));
				concertPage(c);
				break;
			case 3 : flag=false; break; // 메인화면으로 돌아가기 인데, flag를 안쓰면 while로 돌아가니까 flag를 false로 하고 브레이크를 해서 완전히 메인메뉴로 빠져나감.
			default : System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요");
			}
		}
	}
	
	//가수명으로 콘서트 검색
	public void selectConcert() {
		ArrayList<Concert> slist = new ArrayList<Concert>();
		HashMap<Integer, Integer> list = new HashMap<Integer, Integer>();
		int cnt = 1;
		
		System.out.print("가수명을 입력해주세요 : ");
		String name = sc.next();
		
		slist = cm.concertSinger(name);
		//가수 이름 잘 못 입력했을 때 concertInfo로 돌아가기
		if(slist.size() < 1) return;
		
		
		System.out.println("========================");
		System.out.println("번호\t콘서트명\t가수");
		
		for(Concert singer : slist) {
			System.out.println("No." + cnt + "\t" + singer.getConcert_name() + "\t" + singer.getSinger_name());
			list.put(cnt++, singer.getConcert_id());
		}
		System.out.println("========================");
		System.out.print("번호를 입력해주세요 : ");
		int num = sc.nextInt();
		System.out.println("========================");
		
		Concert c = cm.concertOne(list.get(num));
		
		concertPage(c);
		
	}
	
	//콘서트 상세정보 수정
	public HashMap<Integer, Integer> AllConcert() {
		System.out.println("=======================================================");
		ConcertManager cm = new ConcertManager();
		ArrayList<Concert> concertlist = cm.concertList();
		
		int cnt = 1;
		HashMap<Integer, Integer> list = new HashMap<Integer, Integer>();
		
		for(Concert concert : concertlist) {
			list.put(cnt++, concert.getConcert_id());
			System.out.println(concert);
		}
		
		return list;
		
	}
	
	public void concertPage(Concert c) {
		System.out.println("콘서트명 : " + c.getConcert_name());
		System.out.println("가수 : " + c.getSinger_name());
		System.out.println("장소 : " + c.getPlace());
		System.out.println("일시 : " + c.getConcert_date());
		System.out.println("가격 : " + c.getPrice());
		System.out.println("상영시간 : " + c.getRunning_time());
	}

	
/*
 * 리스트 ]
 * 1. 현재 유저의 전체 리스트 출력
 * 		- 전체 리스트 목록 출력(list_id는 숨김)
 * 			해쉬맵에 (번호, 리스트Id) 형태로 저장
 * 
 * 		- 메뉴 2개( 리스트 선택 / 리스트 삭제)
 * 			- 리스트 선택
 * 				해당 리스트의 곡 목록 표시
 * 				곡 선택 -> 곡 정보 띄움(songPage 함수 사용)
 * 			- 리스트 삭제 
 * 				- 사용자가 선택한 번호로 해쉬맵에서 listId를 찾아 이걸 이용해서 삭제
 * 		- 곡 선택 -> 곡 정보 띄움(송페이지)
 */
	//6. 리스트 확인
	//현재 로그인한 사용자의 전체리스트 출력 후 번호 입력 받음
	
	// 리스트를 확인한 후 바로 메인화면으로 나가지지 않도록 수정해야할 부분 존재.
	public void showList() {
		if(um.isLogin()) {
			String loginId = um.getLoginId();
			//현재 유저의 리스트 가져옴
			ArrayList<PlayList> playList =  mm.getUserList(loginId);
			
			if(playList.size()<1) {
				System.out.println("유저" + um.getLoginId()+"는 가지고 있는 리스트가 없습니다.");
				return;}
			//리스트 ID 대신 표시할 리스트 목록 번호
			int listNum = 1;
			//(listNum, 해당 리스트의 id)   ex) 1. A    -> (1, A의 listId) 저장
			HashMap<Integer, Integer> playMap = new HashMap<>();
			
			System.out.println("===========================");
			System.out.println("\t전체 리스트 보기 ");
			System.out.println("===========================");
			
			System.out.println("유저 "+ um.getLoginId() + "가 가지고 있는 리스트를 표시합니다.");
			
			
			System.out.println("===============================");
			System.out.println("번호\t리스트 이름");

			for(PlayList play : playList) {
				//메뉴 번호 	리스트 이름 	출력
				System.out.println(listNum + "\t" + play.getList_name());
				playMap.put(listNum++, play.getList_id());
			}
			
			System.out.println("===============================");
			System.out.println("1. 리스트 선택(번호입력)");
			System.out.println("2. 리스트 삭제");
			System.out.println("===============================");
			System.out.print("번호입력 : ");
			int num = sc.nextInt();
			
			boolean flag=true;
			while(flag) {
				switch(num) {
					//리스트 선택 -> 곡 목록 표시
					case 1: 
						System.out.print("리스트 번호 선택 : ");
						int num2 = sc.nextInt();
						//리스트의 id로 해당 리스트의 곡 목록 들고옴
						showSongList(playMap.get(num2));
						flag=false;
						break;
					case 2:
						System.out.print("삭제할 리스트 번호 : ");
						int num3 = sc.nextInt();
						//리스트 id로 삭제
						deleteList(playMap.get(num3));
						flag=false;
						break;
					default : System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
				}
			
			}
			
		}else {
			System.out.println("로그인이 필요한 서비스 입니다.");
		}
	}
	
	//리스트의 id로 해당 리스트의 곡 목록 들고옴 -> 사용자가 선택한 곡의 정보 출력
	public void showSongList(int list_id) {
		//list_id로 해당 리스트의 곡 목록 가져옴
		ArrayList<PlayList> playListD = mm.getUserListSongs(list_id);
		HashMap<Integer, Integer> playMap = new HashMap<>();
		int listNum = 1;
		
		System.out.println("===============================");
		System.out.println("번호\t곡 이름");

		for(PlayList play : playListD) {
			//n번째 곡을 가져옴 songid를 써서
			Song song = mm.showSong(play.getSong_id());
			//메뉴 번호 	곡 이름 	출력
			System.out.println(listNum + "\t" + song.getSong_name());
			//곡 목록 번호, 해당 곡의 song_id 
			playMap.put(listNum++, song.getSong_id());
		}
		
		System.out.println("===============================");
		System.out.print("번호입력 : ");
		int num2 = sc.nextInt();
		
		//사용자가 선택한 곡의 id로 곡을 찾아서 -> 곡 정보 표시
		songPage( mm.showSong(playMap.get(num2)) );
	}
	
	//리스트 id로 삭제( playlist, detail 값 다 삭제)
	public void deleteList(int list_id) {
		if(mm.deleteList(list_id)) {
			System.out.println("삭제 성공!");
		}else {
			System.out.println("삭제 실패!!");
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

