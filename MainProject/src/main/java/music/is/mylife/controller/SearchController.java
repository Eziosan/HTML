package music.is.mylife.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import music.is.mylife.service.HomeService;
import music.is.mylife.service.SearchService;
import music.is.mylife.vo.Song;

@RequestMapping("search")
@Controller
public class SearchController {
	
	@Autowired
	SearchService sServ;
	@Autowired
	HomeService hs;

	@RequestMapping(value="searchResult", method=RequestMethod.GET)
	public String search(String searchText, Model model) {
		ArrayList<Song> searchResult1 = sServ.searchSongsBySongName(searchText);
		ArrayList<Song> searchResult2 = sServ.searchSongsBySingerName(searchText);
		
		model.addAttribute("searchText", searchText);
		//곡명으로 검색 검색 결과
		model.addAttribute("searchResult1", searchResult1);
		//가수명으로 검색
		model.addAttribute("searchResult2", searchResult2);
		
		for(Song s : searchResult1) {
			System.out.println(s);
		}
		System.out.println("======================");
		
		for(Song s : searchResult2) {
			System.out.println(s);
		}
		
		
		
		return "search/searchResult";
	}
	@RequestMapping(value="main", method=RequestMethod.GET)
	public String search() {
		
		
		return "search/searchResult";
	}
	
}
