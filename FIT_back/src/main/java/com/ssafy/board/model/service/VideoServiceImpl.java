package com.ssafy.board.model.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import com.ssafy.board.config.Json_to_List;
import com.ssafy.board.model.dto.Video;

@Service
public class VideoServiceImpl implements VideoService {

	private static JSONArray total;

	public VideoServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static JSONArray getList() {
		try {
			Object obj = new JSONParser().parse(new FileReader("C:\\Users\\LG\\Desktop\\PJT\\FIT_관통PJT\\221125_8기_서울_7반_관통PTJ_김형균_이윤주\\FIT-back\\src\\main\\resources\\video.json"));
			JSONArray jsonArr = (JSONArray) obj;
			if (jsonArr.size() > 0) {
				for (int i = 1; i < jsonArr.size(); i++) {
					JSONObject jsonObj = (JSONObject) jsonArr.get(i);
				}
				total = jsonArr;
			}

		} catch (FileNotFoundException a) {
			a.printStackTrace();

		} catch (IOException b) {
			b.printStackTrace();

		} catch (org.json.simple.parser.ParseException e) {
			e.printStackTrace();
		}

		return total;
	}

	public static List<Video> selectVideo(JSONArray jsonArr) {
		List<Video> video = new ArrayList<>();
		if (jsonArr.size() > 0) {
			for (int i = 0; i < jsonArr.size(); i++) {
				Video temp = new Video();
				JSONObject jsonObj = (JSONObject) jsonArr.get(i);
				System.out.println(jsonObj);
				temp.setVideoId((String)jsonObj.get("id"));
				temp.setTitle((String) jsonObj.get("title"));
				temp.setName(((String) jsonObj.get("channelName")));
				temp.setPart(((String) jsonObj.get("part")));
				temp.setUrl((((String) jsonObj.get("url"))));
				video.add(temp);
			}
		}
		System.out.println(video);
		return video;
	}
	@Override
	public List<Video> getAllVideoList() {
		return selectVideo(getList());
	}
	
	@Override
	public List<Video> getVideoList(String part) {
		if (part.equals("wholebody")) {
			part="전신";
		}
		else if (part.equals("upperbody")) {
			part="상체";
		}
		else if (part.equals("lowerbody")) {
			part="하체";
		}
		else if (part.equals("abdominalmucles")) {
			part="복부";
		}
		// TODO Auto-generated method stub
		List<Video> allVideos = new ArrayList<>();
		allVideos = getAllVideoList();
		List<Video> partVideo = new ArrayList<>();
		for (int i=0; i<allVideos.size();i++) {
			if (allVideos.get(i).getPart().equals(part)) {
				partVideo.add(allVideos.get(i));
			}
		}
		return partVideo;
	}

	@Override
	public Video getVideo(String id) {
		// TODO Auto-generated method stub
		int idx = -1;
		List<Video> list = getAllVideoList();

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getVideoId().equals(id)) {
				idx = i;
				break;
			}	
		}
		System.out.println(list.get(0));
		return list.get(idx);
	}



}
