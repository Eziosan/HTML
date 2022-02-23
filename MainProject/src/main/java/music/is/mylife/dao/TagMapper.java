package music.is.mylife.dao;

import java.util.ArrayList;

import music.is.mylife.vo.Tag;

public interface TagMapper {

	//song_id를 입력받아서 해당 곡의 상위 태그 3개를 반환 하는 sql문//
	public ArrayList<Tag> selectTop3TagBySongId(int song_id);
	
	public ArrayList<Tag> selectTop10TagBySongId(int song_id);
	
	//태그 id를 입력받아 태그 리턴
	public Tag selectTagsById(int tag_id);
	
	//song_id, tag_id를 입력받아서 해당곡의 특정 태그의 추천수를 1개 증가시키는 sql문//
	public int plusSongTagRecommend(Tag tag);
	//song_id, tag_id를 입력받아서 해당곡의 특정 태그의 추천수를 1개 감소시키는 sql문//
	public int minusSongTagRecommend(Tag tag);
	
}
