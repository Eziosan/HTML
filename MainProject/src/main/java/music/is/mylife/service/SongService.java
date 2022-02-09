package music.is.mylife.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import music.is.mylife.dao.SongDAO;


@Service
public class SongService {
	//Autowired DAO, 세션(선택)
	
	@Autowired
	SongDAO sdao;
	
	// 가장 높은 추천수의 배너를 가져오는 메소드
	public String selectBanner(int song_id) {

		String banner = sdao.selectBanner(song_id);
		
		
		return banner;
	}
}
