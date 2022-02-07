package music.is.mylife.dao;



public interface SongMapper {
	
	public String selectBanner(int song_id);
	public String selectAlbumImg(int album_id);
	public int selectSongLike(String song_name);
	public int plusSongLike(String song_name);
	public int minusSongLike(String song_name);
	
}
