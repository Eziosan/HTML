package com.mini.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.mini.control.MusicManager;
import com.mini.control.UserManager;
import com.mini.dao.UserDAO;
import com.mini.vo.Singer;
import com.mini.vo.Song;
import com.mini.vo.UserInfo;

/*
 * UserMapper : 濡쒓렇�씤/ �쉶�썝媛��엯
 * MusicMapper
 * 
 * AdminManager : 愿�由ъ옄紐⑤뱶(�쟾泥� 怨� 寃��깋, 怨�/肄섏꽌�듃 �벑濡�, 怨�/肄섏꽌�듃 �닔�젙, 怨�/ 肄섏꽌�듃 �궘�젣, 由ъ뒪�듃 寃��깋)
 * MusicManager : �굹癒몄� 紐⑤몢
 * UserManager : 濡쒓렇�씤/�쉶�썝媛��엯留�
 * 
 * MusicDAO : Admin, MusicManager�뿉�꽌 �븷�씪 �떎 泥섎━
 * UserDAO : 濡쒓렇�씤 / �쉶�썝媛��엯
 * 
 * �빆�긽 �뿼�몢�뿉 �몮 寃� : �삁�쇅泥섎━ /		//媛��졇�삩 媛앹껜 or 由ъ뒪�듃媛� null�씪 �븣 泥섎━

 */

// try - catch???
//UI 珥덈컲
public class UI {
	Scanner sc = new Scanner(System.in);
	// �쑀�� / 怨� / 愿�由ъ옄 留ㅻ땲�� 媛앹껜 媛곴컖 �꽕�젙
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
						//濡쒓렇�븘�썐 �떆耳쒖＜�뒗 硫붿냼�뱶 �떎�뻾
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
				case 7: adminMode(); break;
				default : System.out.println("�옒紐� �엯�젰�뻽�뒿�땲�떎");
			}
		}
	}
	public void newfunc() {
		System.out.println("깃허브 수정 테스트용ㅇ 함수");
	}
	
	//1. �쉶�썝媛��엯, 濡쒓렇�씤 硫붾돱瑜� �몴�떆�븯�뒗 �븿�닔
	public void loginPage() {
		
		
		
			System.out.println("===================");
			System.out.println("1. �쉶�썝媛��엯");
			System.out.println("2. 濡쒓렇�씤");
			System.out.println("3. 硫붿씤�솕硫댁쑝濡� �룎�븘媛�湲�");
			System.out.println("===================");
			int num = sc.nextInt();
			
			// 1. �쉶�썝媛��엯, 2. 濡쒓렇�씤 �떎�뻾
			switch(num) {
				case 1: signUp(); break;
				case 2:	login(); break;
				case 3: break;

				default: System.out.println("�옒紐� �엯�젰�븯�뀲�뒿�땲�떎!!");

			}
			
		}
		
	
	
	//1-1 濡쒓렇�씤
	public void login() {
		
		 boolean flag=true;
		 
		while(flag) {
		System.out.print("ID : ");
		String user_id = sc.next();
		System.out.print("�뙣�뒪�썙�뱶 : ");
		String password = sc.next();
		
		if(um.login(user_id, password)) {
			System.out.println("濡쒓렇�씤 �꽦怨�!!");
			um.login(user_id, password);
			
			flag=false;
			break;
			
		}else {
			System.out.println("濡쒓렇�씤 �떎�뙣!");
			
		}
		}
	}
	
	//1-2 �쉶�썝媛��엯
	public void signUp() {
		System.out.print("ID : ");
		String user_id = sc.next();
		System.out.print("�뙣�뒪�썙�뱶 : ");
		String password = sc.next();
		System.out.print("�씠由� : ");
		String name = sc.next();
		System.out.print("�꽦蹂� : ");
		String sex = sc.next();
		System.out.print("�깮�뀈�썡�씪 : ");
		String birth = sc.next();
		System.out.print("�씠硫붿씪 : ");
		String email = sc.next();
		System.out.print("�쟾�솕踰덊샇 : ");
		String phone = sc.next();
		System.out.print("二쇱냼 : ");
		String address = sc.next();
		
		UserInfo ui = new UserInfo(user_id, password, name, sex, birth, email, phone,
				address);
		
		if(um.signUp(ui)) {
			System.out.println("�쉶�썝媛��엯 �꽦怨�"); 
		}else {
			System.out.println("�쉶�썝媛��엯 �떎�뙣!!");
		}
		
		
	}
	
	// 2. 怨� 寃��깋
	//default�꽕�젙. 硫붿씤�솕硫댁쑝濡� 媛�湲� 異붽�
	public void searchMusic() {
		System.out.println("===================");

		//紐� 湲��옄留� �엯�젰�빐�룄 �씤�떇�빐�꽌 李얠븘二쇰룄濡� -> Like(�꽑�깮??)
		//媛��궗 寃��깋 異붽�??
		System.out.println("1. 媛��닔紐낆쑝濡� 寃��깋");
		System.out.println("2. 怨〓챸�쑝濡� 寃��깋");
		System.out.println("3. 媛��궗濡� 寃��깋");
		System.out.println("===================");

		System.out.print("踰덊샇 �엯�젰 : ");
		int num = sc.nextInt();
		
		switch(num) {
			case 1: searchMusicBySinger(); break;
			case 2: break;
			case 3: searchMusicByLyric(); break;
			default : System.out.println("�옒紐� �엯�젰�븯�뀲�뒿�땲�떎!!");
		}
	}
	
	//媛��닔紐낆쑝濡� 怨� 寃��깋
	//議고쉶�닔 : 寃��깋�맆 �븣留덈떎 利앷�
	public void searchMusicBySinger() {
		
		//�쑋
	}
	//媛��닔紐낆쑝濡� 寃��깋
	public void searchMusicByName() {

	}
	
	/*
	 *  2-3. 媛��궗濡� 怨� 寃��깋. 媛��궗瑜� �엯�젰諛쏆븘 怨� �뀒�씠釉붿뿉�꽌 怨≪쓣 李얠븘�샂
		�빐�떦 媛��궗瑜� �룷�븿�븯怨� �엳�뒗 怨� 由ъ뒪�듃 媛��졇�샂
		洹� 以� 蹂닿퀬 �떢�� 怨≪쓣 �꽑�깮(song_id)
		怨� �젙蹂� �몴�떆!
	 */
	//媛� 怨〓쭏�떎 媛��궗瑜� 蹂댁뿬以섏빞(蹂대쪟)
	public void searchMusicByLyric() {
		//song_id瑜� �궗�슜�옄�뿉寃� 蹂댁뿬二쇱� �븡湲� �쐞�빐 HashMap<媛��졇�삩 怨� 由ъ뒪�듃 踰덊샇(1踰덈��꽣 �떆�옉), �떎�젣 song_id>�궗�슜
		/*
		 *  1,  18
		 *  2,  20
		 *  3,  30
		 *  
		 *  1踰�  -> 18踰� �끂�옒
		 */
		HashMap<Integer, Integer> songMap = new HashMap<>();
		//媛��졇�삩 怨� 由ъ뒪�듃�뿉 踰덊샇瑜� 留ㅺ린�뒗�뜲 song_id ���떊 �궗�슜�옄�뿉寃� 蹂댁뿬以� 踰덊샇 
		int lyricNum = 1;
		
		//1. 媛��궗瑜� �엯�젰諛쏆븘 �빐�떦 媛��궗媛� �룷�븿�맂 紐⑤뱺 怨≪쓣 媛��졇�샂
		System.out.print("媛��궗�엯�젰 : ");
		String lyrics = sc.next();
		//媛��궗媛� �룷�븿�릺�뼱 �엳�뒗 怨� 媛��졇�샂
		//null�씪 寃쎌슦
		ArrayList<Song> songList = mm.musicByLyric(lyrics);
		
		//媛��졇�삩 媛앹껜 or 由ъ뒪�듃媛� �뾾�쓣 �븣 硫붿씤�솕硫댁쑝濡� �씠�룞
		if(songList.size() < 1) {
			System.out.println("寃��깋 寃곌낵媛� �뾾�뒿�땲�떎!");
			return;
		}
		
		
		//2. 媛��궗濡� 李얠� 怨� 由ъ뒪�듃 異쒕젰
		System.out.println("===============================");
		System.out.println("怨� ID\t怨� �씠由�\t媛��닔 �씠由�");

		for(Song song : songList) {
			System.out.print(lyricNum +"\t"+ song.getSong_name()+"\n");
			songMap.put(lyricNum++, song.getSong_id());
		}
		
		System.out.println("===============================");
		System.out.print("李얘퀬 �떢�� 怨� ID �엯�젰 : ");
		int num = sc.nextInt();
		
		//�궗�슜�옄媛� �엯�젰�븳 song_id濡� 怨≪쓣 媛��졇�샂
		Song song = mm.showSong(songMap.get(num));
		//怨� �젙蹂� �몴�떆
		songPage(song);
		
		
	}
	
	//怨� �젙蹂� �몴�떆�븯�뒗 �븿�닔. 怨� 媛앹껜瑜� 諛쏆븘�꽌 怨� �젙蹂� �몴�떆
	public void songPage(Song song) {
		System.out.println("媛��닔紐� �엯�젰諛쏆쑝硫� �븘�옒 �솕硫댁씠 �쑙");
		System.out.println("===================");
		System.out.println("怨� id : " + song.getSong_id());
		System.out.println("怨〓챸 : " + song.getSong_name());
		//媛��닔 id濡� 媛��닔 �씠由꾩쓣 媛��졇�삤�뒗 �븿�닔 �옉�꽦 �븘�슂 ???????????????????
		System.out.println("媛��닔 : " + song.getMain_sid());
		System.out.println("諛쒕ℓ�씪 : " + song.getRelease_date());
		System.out.println("�옉�궗 : " + song.getWriter());
		System.out.println("�옉怨� : " + song.getComposer());
		System.out.println("===================");
		System.out.println("議고쉶�닔 : " + song.getHits());
		//ex) 4�젏���뒗 蹂� 4媛쒕줈 �몴�떆
		System.out.println("�쁾�쁾�쁾�쁾�쁿 " + song.getCounting_star());
		//?????? �씠寃껊룄 �븿�닔 �븯�굹 留뚮뱾�뼱�꽌 肄붾찘�듃 媛��졇���빞
		System.out.println("[肄붾찘�듃] : 3媛� �젙�룄 異쒕젰");
		System.out.println("肄붾찘�듃 �삗�떆(200�옄)�꽩�뀋�뀅�꽩�뀋�꽩�뀅�뀋�뀅\n"
				+ "湲��옄�닔梨꾩슦湲� �뀅�뀍�꽦�뀍�꽦�뀆�뀍�꽦�뀆�뀍�꽦�뀆�뀍�꽦�뀆�뀍�꽦�뀍�꽬�꽦�뀍�꽬 \n"
				+ "�옒�옒�씪�븘�븘�븘�븘�븘�븘�븘�븘�뀖�븘�븘�븘�븘�븘�븘�븘�뀖�븘�븘�븘�븘�븘�븘�븘�븘�븘\n"
				+ "�옄怨좎떢�떎�븘�븘�븘�븘�븘�븘�뀖�븰�븘�븘�븘�븘�븘�븘�븘�븰�븘�븘�븰�븘�븘�븰�븰�븘�뀖\n");
		
		System.out.println("===================");
		//濡쒓렇�씤 �븞�릺�뼱�엳�쑝硫� 踰덊샇瑜� �꽑�깮�빐�룄 紐삵븯�룄濡�
		// 蹂꾩젏 �궓湲곌린 異붽�
		//肄붾찘�듃 �궘�젣 異붽�(蹂대쪟)
		/*[怨좊�쇱쨷]
		 * 蹂꾩젏�쓣 �씠誘� �엯�젰�븳 寃쎌슦  �떎�떆 �엯�젰 湲곕뒫 異붽�???(�씠嫄� �븞�븯�젮硫� 蹂꾩젏 �엯�젰 硫붾돱瑜� �뾾�븷�뱺吏�)
		 */
		//�씠誘� �듅�젙 由ъ뒪�듃�뿉 �씠 怨≪씠 �뱾�뼱媛� �엳�떎硫� 異붽�濡� 紐삳꽔�룄濡� �빐�빞 �맖!!!
		System.out.println("1. 媛��궗 蹂닿린");
		System.out.println("2. 蹂꾩젏 �벑濡�");    // 2,3,4踰덉� 濡쒓렇�씤�쓣 �뻽�쓣�븣留� �븷�닔 �엳�룄濡�.
		System.out.println("3. 由ъ뒪�듃�뿉 異붽�");
		System.out.println("4. 肄붾찘�듃 �궓湲곌린");
		System.out.println("5. 硫붿씤�솕硫댁쑝濡� �씠�룞");
		
		int num = sc.nextInt();
		
		switch(num) {
			case 1: break;
			case 2: return ;
		}
		
		
	}
	
	//濡쒓렇�씤 泥댄겕
	//�엯�젰 諛쏆쓣 嫄� �뜑 異붽�
	//媛��닔�룄 異붽�(媛��닔媛� �씠誘� 議댁옱�븯�뒗吏� 寃��깋�빐�꽌 �솗�씤 �븯怨� �엳�쑝硫� 怨� �뀒�씠釉붿뿉 媛��닔 �씠由� 諛붾줈 �꽔�쑝硫� �릺怨� �뾾�쑝硫� 媛��닔/怨� �뀒�씠釉� �몮 �떎 異붽��븯�룄濡�)
	//3. 怨� �벑濡�
	public void enroll() {
		
		// 媛��닔媛� �엳�뒗吏� �솗�씤�븷 �븘�슂媛� �엳�떎.
		
		
		if(um.isLogin()) {
			System.out.print("怨〓챸 : ");
			String name = sc.next();
//			System.out.print("媛��닔 : ");
//			String singer = sc.next();
			//�뿬湲곗꽌 �솗�씤
			/*
			 * 媛��닔�씠由� : 由ъ뒪�듃 
			 * 
			 * 
			 * �븘�씠 寃��깋
			 *  
			 *  �쑀�븘�씠
			 *  �븘�씠�쑀
			 *  �븘�씠�쑀�떎
			 *  
			 * 
			 * 1. 媛��닔 �씠由꾩쑝濡� 寃��깋 -> �븿�닔 媛��졇�삤怨�
			 * 2. 媛��닔 由ъ뒪�듃 遺덈윭�샂 / 遺덈윭�삩 媛��닔媛� �뾾�쓬 -> 媛��닔 �벑濡� 遺��꽣
			 * 3. 媛��닔 �꽑�깮 -> 洹� 媛��닔�쓽 id瑜� �꽔�뒗嫄몃줈
			 * 
			System.out.print("媛��닔紐� : ");
			String singer_name = sc.next();
			System.out.print("�꽦蹂� : ");
			String sex = sc.next();
			System.out.print("�넄濡�/洹몃９ �뿬遺� : ");
			String isGrouped = sc.next();
			System.out.print("媛��닔�냼媛� : ");
			String introduce = sc.next();
			System.out.print("�뜲酉붿씪 : ");
			String debut_date = sc.next();
			
			Singer singer = new Singer(singer_name, sex, isGrouped, introduce, debut_date);
			
			 */
			
			
			System.out.print("諛쒕ℓ�씪 : ");
			String date = sc.next();
			System.out.print("�옉�궗 : ");
			String writer = sc.next();
			System.out.print("�옉怨� : ");
			String composer = sc.next();
			System.out.print("媛��궗 : ");
			String lyrics = sc.next();
			
			// Song媛앹껜 蹂대궡�꽌 insert �븯硫� �릺�뒗�뜲
			// Song �깮�꽦臾�
			Song song = new Song(name, date, writer, composer, lyrics);
			
			if(mm.enroll(song)) {
				System.out.println("怨� �벑濡� �꽦怨�!!");
			}else {
				System.out.println("怨� �벑濡� �떎�뙣!!");
			}
			
			sc.nextLine();
			
		}else {
			System.out.println("濡쒓렇�씤�씠 �븘�슂�븳 �꽌鍮꾩뒪 �엯�땲�떎.");
		}
		
	}
	
	//4. top 10, 議고쉶�닔�굹 蹂꾩젏 湲곕컲�쑝濡� 吏��젙
	public void top10() {
		System.out.println("============================================");
		System.out.println("1	由щТ吏�");
		System.out.println("2	�쉶�쟾紐⑸쭏");
		System.out.println("3	留뚮궓�� �돺怨� �씠蹂꾩� �뼱�젮�썙");
		System.out.println("4	�돩�뼱");
		System.out.println("5	Wake Up");
		System.out.println("6	MBTI");
		System.out.println("7	strawberry moon");
		System.out.println("8	遺덊삊�솕�쓬");
		System.out.println("9	Savage");
		System.out.println("10	�떎�젙�엳 �궡 �씠由꾩쓣 遺�瑜대㈃");
		System.out.println("�븘�땲硫� 議고쉶�닔�굹 蹂꾩젏 �닚�쑝濡� �빐�꽌 top10 留ㅺ꺼�룄 �릺怨�");
		System.out.println("============================================");
	}
	
	// 肄섏꽌�듃 �젙蹂� �솗�씤
	
	public void concertInfo() {
			// 硫붾돱 2媛�吏� 媛��닔紐낆쑝濡� 寃��깋, �쟾泥댁텧�젰
		boolean flag = true;
			
		while (flag) {
			System.out.println("=============== 肄섏꽌�듃 �젙蹂� =============");
			System.out.println("1. 媛��닔紐낆쑝濡� 肄섏꽌�듃瑜� 寃��깋�빀�땲�떎.");
			System.out.println("2. 肄섏꽌�듃�쓽 紐⑤뱺 �젙蹂대�� 異쒕젰�빀�땲�떎.");
			System.out.println("3. 硫붿씤 �솕硫댁쑝濡� �룎�븘媛�湲�");
				
			int select = sc.nextInt();
				
				
			switch(select) {
				case 1 : break; // 媛��닔紐낆쑝濡� 肄섏꽌�듃 寃��깋
				case 2 : break; // 肄섏꽌�듃�쓽 紐⑤뱺 �젙蹂대�� 異쒕젰
				case 3 : flag=false; break; // 硫붿씤�솕硫댁쑝濡� �룎�븘媛�湲� �씤�뜲, flag瑜� �븞�벐硫� while濡� �룎�븘媛��땲源� flag瑜� false濡� �븯怨� 釉뚮젅�씠�겕瑜� �빐�꽌 �셿�쟾�엳 硫붿씤硫붾돱濡� 鍮좎졇�굹媛�.
				default : System.out.println("�옒紐� �엯�젰�븯�뀲�뒿�땲�떎. �떎�떆 �엯�젰�빐 二쇱꽭�슂");
			}
		}
	}
	
	public void listCheck() {
		if(um.isLogin()) {
			System.out.println("�쑀�� **媛� 媛�吏�怨� �엳�뒗 由ъ뒪�듃瑜� �몴�떆�빀�땲�떎.");
		
		}else {
			System.out.println("濡쒓렇�씤�씠 �븘�슂�븳 �꽌鍮꾩뒪 �엯�땲�떎.");
		}
	}
	
	public void adminMode() {
		
		System.out.println("愿�由ъ옄 紐⑤뱶�엯�땲�떎.");
		System.out.print("ID : ");
		String admin_id = sc.next();
		System.out.print("Password :");
		String admin_pwd = sc.next();
		
		// 留ㅻ땲��濡� �뜕�졇以섏꽌 媛믪쓣 由ы꽩諛쏄퀬
		
		boolean flag = true;
		
		while(flag) {
			System.out.println("1. 怨� 寃��깋"); // �씪諛� 怨↔��깋�씠�옉 媛숈쓬
			System.out.println("2. 怨� �벑濡�");
			System.out.println("3. 怨� �닔�젙");
			System.out.println("4. 怨� �궘�젣");
			
			
			System.out.print("踰덊샇 �엯�젰 : ");
			int num=sc.nextInt();
			
			// if 臾� �뜥�꽌 濡쒓렇�씤 �맟�쓣 �븣 留� �떎�뻾�븯�룄濡�
			switch(num) {
				case 1 : break;
				case 2 : break;
				case 3 : break;
				case 4 : break;
				
				
				default : System.out.println("�옒紐� �엯�젰�븯�뀲�뒿�땲�떎.");
			
			}
		}
	}
	// �븞 留뚮뱾�뼱�졇�엳�뒗 遺�遺� 異붽��빐二쇱꽭�슂!
	//硫붿씤�솕硫�
	public void mainUI() {
		System.out.println("===========================");

		System.out.println("�뀫�뀫�뀫�뀫�뀫�뀫�뀫�뀫 硫붿씤�솕硫� �뀫�뀫�뀫�뀫�뀫�뀫�뀫�뀫");
		if(!um.isLogin()) {
		System.out.println("1. 濡쒓렇�씤/�쉶�썝媛��엯");
		}else {
			System.out.println("1. 濡쒓렇�븘�썐");
		}
		System.out.println("2. 怨� 寃��깋");
		System.out.println("3. 怨� �벑濡�");
		//議고쉶�닔/ 蹂꾩젏 �닚 異붽��빐�빞
		System.out.println("4. TOP10");
		// �쟾泥� 肄섏꽌�듃 / 媛��닔紐낆쑝濡� 寃��깋 異붽��빐�빞
		System.out.println("5. 肄섏꽌�듃 �젙蹂�");
		//蹂몄씤 由ъ뒪�듃 �솗�씤 媛��뒫 . �븯�쐞 硫붾돱 異붽� �빐�빞 �븿
		// 1. 蹂몄씤 �쟾泥대━�뒪�듃 蹂닿린 2. 由ъ뒪�듃 �궘�젣. 
		System.out.println("6. 由ъ뒪�듃 �솗�씤");
		System.out.println("7. 愿�由ъ옄 紐⑤뱶(�벑濡�, 寃��깋, �닔�젙, �궘�젣)");
		System.out.println("===========================");
		System.out.print("踰덊샇 �엯�젰 : ");

	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UI();
	}

}
