package music.is.mylife.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import music.is.mylife.dao.SongDAO;
import music.is.mylife.dao.TagDAO;
import music.is.mylife.vo.Song;
import music.is.mylife.vo.Tag;


@Service
public class SongService {
	//Autowired DAO, 세션(선택)
	
	@Autowired
	SongDAO sdao;
	@Autowired
	TagDAO tdao;
	
	// 해당 곡의 배너를 가져오는 메소드
	public String selectBanner(int song_id) {

		return sdao.selectBanner(song_id);
	}
	
	public String selectAlbumImg(int song_id) {
	
		// 앨범 id 값을 리턴해줌.
		return sdao.selectAlbumImg(song_id);
	}
	
	public Integer selectSongLike(int song_id) {
		
		
		return sdao.selectSongLike(song_id);
		
	}
	
	public void plusSongLike(int song_id) {
		
		sdao.plusSongLike(song_id);
		
	}
	
	public void minusSongLike(int song_id) {
		
		sdao.minusSongLike(song_id);
		
	}
	
	public Song selectSongOne(int song_id) {
		
	
		return sdao.selectSongOne(song_id);
		
	
		
	}
	
	
	
	
	
	
	
	public ArrayList<Tag> selectTag(int song_id){
		
		ArrayList<Tag> tag = tdao.selectTag(song_id);
		return tag;
	}
	
	
	public void plusSongTagRecommend(Tag tag) {
		
		tdao.plusSongTagRecommend(tag);
		
	}
	
	
	public void minusSongTagRecommend(Tag tag) {
		
		tdao.minusSongTagRecommend(tag);
	}
	
	
}
