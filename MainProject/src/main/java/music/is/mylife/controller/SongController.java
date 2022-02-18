package music.is.mylife.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import music.is.mylife.service.SongService;
import music.is.mylife.vo.Playlist;
import music.is.mylife.vo.Song;
import music.is.mylife.vo.Tag;

@RequestMapping("song")
@Controller
public class SongController {
	
	private static final Logger logger = LoggerFactory.getLogger(SongController.class);
	
	@Autowired
	SongService ss;
	
	@RequestMapping(value="mainPage",method=RequestMethod.GET)
	public String mainPage(Model model) {
		//
		String banner = ss.selectBanner(9);
		String ai = ss.selectAlbumImg(1);
		Integer sl = ss.selectSongLike(9);
		ss.plusSongLike(1);
		ss.minusSongLike(2);
		Song song = ss.selectSongOne(9);
		ArrayList<Tag> tag = ss.selectTag(1);
		
		//ss.plusSongTagRecommend(1);
		//ss.minusSongTagRecommend(2);
		
		logger.info("banner : {}", banner);
		logger.info("AlbumImg : {}", ai);
		logger.info("sl : {}", sl);
		logger.info("Song : {}", song);
		logger.info("tag : {}", tag);
		
		model.addAttribute("banner", banner);
		model.addAttribute("ai", ai);
		model.addAttribute("Song",song);
		
		return "song/mainPage";
	}
	
	
	@RequestMapping(value="plusStar",method=RequestMethod.GET)
	public String plusStar(int song_id) {
		logger.debug("플러스 스타 실행");
		ss.plusSongLike(song_id);
	
		return "redirect:/song/mainPage";
	
		
	}
	
	
	@RequestMapping(value="minusStar",method=RequestMethod.GET)
	public String minusStar(int song_id) {
		
		logger.debug("마이너스 스타 실행");
		ss.minusSongLike(song_id);
		
		return "redirect:/song/mainPage";
	
		
	}
	
	@RequestMapping(value="selectList", method=RequestMethod.GET)
	public String selectList(Model model) {
		
		String name="aaaa";
		
		ArrayList<Playlist> playlist = ss.selectList(name);
		
		logger.debug("playlist : {}", playlist);
		
		
		model.addAttribute("playlist", playlist);
		
		
		return "song/listPage";
	}
	

	
	
	@RequestMapping(value="insertList", method=RequestMethod.POST)
	public String insertList(Model model, Playlist playlist) {
		
		//여기서 할 거 > 리스트 생성하기
		String url;
		
		Boolean result = ss.insertPlaylist(playlist);
		
		if(result) {
			url="redirect:/main";
			
		}else {
			url="song/listPage";
		}
		
		// 트루면 메인으로
		// 펄스면 listpage로 감
		
		logger.debug("Result : {}", result);
		// 추가 됐으면 true 안됐으면 false.
		// listPage에서 true냐, false냐에 따라 리스트 추가됐는지 안됐는지 코드짜면 될거같음.
		
		return url;
	}
	
	
	/**
	 * 곡페이지에서 로그아웃하기
	 * @param session
	 * @param song
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String lougout(HttpSession session, Song song, Model model) {
		
		session.invalidate();
		
		Song selectSong = ss.selectAllSong(song);
		
		
		model.addAttribute("singer_id", song.getSinger_id());
		model.addAttribute("song_id", song.getSong_id());
		model.addAttribute("Song", selectSong);
		
		return "song/song2";
	}
	
	
	
	
	
	
}
