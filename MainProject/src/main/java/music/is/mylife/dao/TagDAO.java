package music.is.mylife.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import music.is.mylife.vo.Tag;

@Repository
public class TagDAO {
	
	@Autowired
	private SqlSession session;
	
	public ArrayList<Tag> selectTag(int song_id){
		
		TagMapper mapper = session.getMapper(TagMapper.class);
		
		
		ArrayList<Tag> st = mapper.selectTag(song_id);
		
		return st;
	}
	
	//태그 id를 입력받아 태그 목록 가져옴
	public Tag selectTagsById(int tag_id){
		TagMapper mapper = session.getMapper(TagMapper.class);
		
		return mapper.selectTagsById(tag_id);
	}
	
	public int plusSongTagRecommend(Tag tag) {
		
		TagMapper mapper = session.getMapper(TagMapper.class);
		
		int pstr = mapper.plusSongTagRecommend(tag);
		
		return pstr;
	}
	
	public int minusSongTagRecommend(Tag tag) {
		
		TagMapper mapper = session.getMapper(TagMapper.class);
		
		int mstr = mapper.minusSongTagRecommend(tag);
		
		return mstr;
	}
}
