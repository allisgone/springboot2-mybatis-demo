package com.taobao.api.response;

import java.util.List;
import com.taobao.api.domain.Tracks;
import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.internal.mapping.ApiListField;

import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.openim.track.getdetails response.
 * 
 * @author top auto create
 * @since 1.0, null
 */
public class OpenimTrackGetdetailsResponse extends TaobaoResponse {

	private static final long serialVersionUID = 5736759517546197296L;

	/** 
	 * 用户轨迹
	 */
	@ApiListField("tracks")
	@ApiField("tracks")
	private List<Tracks> tracks;


	public void setTracks(List<Tracks> tracks) {
		this.tracks = tracks;
	}
	public List<Tracks> getTracks( ) {
		return this.tracks;
	}
	


}
