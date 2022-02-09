package music.is.mylife.dao;

import java.util.ArrayList;

import music.is.mylife.vo.Tag;

public interface TagMapper {

	
	public ArrayList<Tag> selectTag(int song_id);
	public int updateSongTagRecommend(Tag tag);
}
