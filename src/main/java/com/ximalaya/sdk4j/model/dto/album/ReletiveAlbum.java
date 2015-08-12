package com.ximalaya.sdk4j.model.dto.album;

import com.ximalaya.sdk4j.http.HttpResponse;
import com.ximalaya.sdk4j.model.XimalayaException;
import com.ximalaya.sdk4j.model.dto.profile.User;
import com.ximalaya.sdk4j.model.dto.track.LastUpTrack;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class ReletiveAlbum {
    private Long id;                   // ID
    private String kind;               // DTO实体类型
    private String albumTitle;         // 专辑标题
    private String albumTags;          // 专辑标签字符串，以英文逗号分隔
    private String albumIntro;         // 专辑简介
    private String coverUrlSmall;      // 专辑封面小图
    private String coverUrlMiddle;     // 专辑封面中图
    private String coverUrlLarge;      // 专辑封面大图
    private User announcer;            // 专辑所属主播
    private Long playCount;            // 专辑播放次数
    private Long favoriteCount;        // 专辑被喜欢次数
    private Long includeTrackCount;    // 专辑包含声音数
    private LastUpTrack lastUpTrack;   // 专辑内最新上传声音
    private Long updatedAt;            // 更新时间
    private Long createdAt;            // 更新时间
    private String recommendSrc;     // 用于统计，推荐来源
    private String recommendTrace;   // 推荐跟踪

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public String getAlbumTags() {
        return albumTags;
    }

    public void setAlbumTags(String albumTags) {
        this.albumTags = albumTags;
    }

    public String getAlbumIntro() {
        return albumIntro;
    }

    public void setAlbumIntro(String albumIntro) {
        this.albumIntro = albumIntro;
    }

    public String getCoverUrlSmall() {
        return coverUrlSmall;
    }

    public void setCoverUrlSmall(String coverUrlSmall) {
        this.coverUrlSmall = coverUrlSmall;
    }

    public String getCoverUrlMiddle() {
        return coverUrlMiddle;
    }

    public void setCoverUrlMiddle(String coverUrlMiddle) {
        this.coverUrlMiddle = coverUrlMiddle;
    }

    public String getCoverUrlLarge() {
        return coverUrlLarge;
    }

    public void setCoverUrlLarge(String coverUrlLarge) {
        this.coverUrlLarge = coverUrlLarge;
    }

    public User getAnnouncer() {
        return announcer;
    }

    public void setAnnouncer(User announcer) {
        this.announcer = announcer;
    }

    public Long getPlayCount() {
        return playCount;
    }

    public void setPlayCount(Long playCount) {
        this.playCount = playCount;
    }

    public Long getFavoriteCount() {
        return favoriteCount;
    }

    public void setFavoriteCount(Long favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    public Long getIncludeTrackCount() {
        return includeTrackCount;
    }

    public void setIncludeTrackCount(Long includeTrackCount) {
        this.includeTrackCount = includeTrackCount;
    }

    public LastUpTrack getLastUpTrack() {
        return lastUpTrack;
    }

    public void setLastUpTrack(LastUpTrack lastUpTrack) {
        this.lastUpTrack = lastUpTrack;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public String getRecommendSrc() {
        return recommendSrc;
    }

    public void setRecommendSrc(String recommendSrc) {
        this.recommendSrc = recommendSrc;
    }

    public String getRecommendTrace() {
        return recommendTrace;
    }

    public void setRecommendTrace(String recommendTrace) {
        this.recommendTrace = recommendTrace;
    }

    public ReletiveAlbum(JSONObject json) throws XimalayaException {

        init(json);


    }

    private void init(JSONObject json) throws XimalayaException {
        if (json != null) {
            try {
                id = json.getLong("id");
                kind = json.getString("kind");
                albumTitle = json.getString("album_title");
                albumTags = json.getString("album_tags");
                albumIntro = json.getString("album_intro");
                coverUrlSmall = json.getString("cover_url_small");
                coverUrlMiddle = json.getString("cover_url_middle");
                coverUrlLarge = json.getString("cover_url_large");
                announcer = new User(json.getJSONObject("announcer"));
                playCount = json.getLong("play_count");
                favoriteCount = json.getLong("favorite_count");
                includeTrackCount = json.getLong("include_track_count");
                lastUpTrack = new LastUpTrack(json.getJSONObject("last_uptrack"));
                updatedAt = json.getLong("updated_at");
                createdAt = json.getLong("created_at");
                recommendSrc = json.getString("recommend_src");
                recommendTrace = json.getString("recommend_trace");
            } catch (JSONException jsone) {
                throw new XimalayaException(jsone.getMessage() + ":" + json.toString(), jsone);
            }
        }

    }

    public static ReletiveAlbumList constructAlbumList(HttpResponse response) throws XimalayaException {
        ReletiveAlbumList reletiveAlbumList = new ReletiveAlbumList();
        JSONObject albumListJsonObject = response.asJSONObject();
        try {
            int totalCount = albumListJsonObject.getInt("total_count");
            if (totalCount > 0) {
                reletiveAlbumList.setTotalPage(albumListJsonObject.getInt("total_page"));
                reletiveAlbumList.setTotalCount(totalCount);
                reletiveAlbumList.setCurrentPage(albumListJsonObject.getInt("current_page"));

                List<ReletiveAlbum> reletiveAlbums = new ArrayList<ReletiveAlbum>();

                JSONArray albumsJsonArray = albumListJsonObject.getJSONArray("reletive_albums");
                int size = albumsJsonArray.length();
                for (int i = 0; i < size; i++) {
                    reletiveAlbums.add(new ReletiveAlbum(albumsJsonArray.getJSONObject(i)));
                }
                reletiveAlbumList.setReletiveAlbum(reletiveAlbums);
            }
        } catch (JSONException jsone) {
            throw new XimalayaException(jsone.getMessage() + ":" + jsone.toString(), jsone);
        }
        return reletiveAlbumList;
    }


}
