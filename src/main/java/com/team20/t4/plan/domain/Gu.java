package com.team20.t4.plan.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum Gu {

    JONGROGU("종로구"),
    JUNGGU("중구"),
    YONGSANGU("용산구"),
    SEONGDONGGU("성동구"),
    GWANGJINGU("광진구"),
    DONGDAEMUNGU("동대문구"),
    JUNGANGGU("중랑구"),
    SEONGBUKGU("성북구"),
    GANGBUKGU("강북구"),
    DOBONGGU("도봉구"),
    NOWONGU("노원구"),
    EUNPYEONGGU("은평구"),
    SEODAEMUNGU("서대문구"),
    MAPOGU("마포구"),
    YANGCHEONGU("양천구"),
    GANGSEOGU("강서구"),
    GUROGU("구로구"),
    GEUMCHEONGU("금천구"),
    YEONGDEUNGPOGU("영등포구"),
    DONGJAKGU("동작구"),
    GWANAKGU("관악구"),
    SEOCHOGU("서초구"),
    GANGNAMGU("강남구"),
    SONGPAGU("송파구"),
    GANGDONGGU("강동구");


    @JsonValue
    private String value;

    /**
     *
     *종로구
     * 중구
     * 용산구
     * 성동구
     * 광진구
     * 동대문구
     * 중랑구
     * 성북구
     * 강북구
     * 도봉구
     * 노원구
     * 은평구
     * 서대문구
     * 마포구 양천구 강서구 구로구 금천구 영등포구 동작구 관악구 서초구 강남구 송파구 강동구
     * */

    @JsonCreator
    public static Gu from(String value) {
        for (Gu status : Gu.values()) {
            if (status.getValue().equals(value)) {
                return status;
            }
        }
        return null;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
