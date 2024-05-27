package com.sparta.springresttemplateserver.service;

import com.sparta.springresttemplateserver.dto.ItemResponseDto;
import com.sparta.springresttemplateserver.dto.UserRequestDto;
import com.sparta.springresttemplateserver.entity.Item;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ItemService {

    // 초기 아이템 리스트를 설정합니다.
    private final List<Item> itemList = Arrays.asList(
            new Item("Mac", 3_888_000),
            new Item("iPad", 1_230_000),
            new Item("iPhone", 1_550_000),
            new Item("Watch", 450_000),
            new Item("AirPods", 350_000)
    );

    /**
     * 아이템 제목(query)을 받아 해당 아이템 객체를 반환합니다.
     * @param query 검색할 아이템 제목
     * @return 검색된 아이템 객체 또는 null
     * 하나의 아이템만 받아올때 사용.
     */
    public Item getCallObject(String query) {
        for (Item item : itemList) {
            if(item.getTitle().equals(query)) {
                return item;
            }
        }
        return null;
    }

    /**
     * 모든 아이템 리스트를 ItemResponseDto 객체로 반환합니다.
     * @return ItemResponseDto 객체
     * 여러개의 아이템을 받아올때 사용
     */
    public ItemResponseDto getCallList() {
        ItemResponseDto responseDto = new ItemResponseDto();
        for (Item item : itemList) {
            responseDto.setItems(item);
        }
        return responseDto;
    }

    /**
     * POST 요청을 처리하는 메소드입니다. 현재는 null을 반환합니다.
     * @param query 검색할 아이템 제목
     * @param requestDto 사용자 요청 데이터
     * @return 현재는 null을 반환합니다.
     */
    public Item postCall(String query, UserRequestDto requestDto) {
        return null;
    }

    /**
     * 교환 요청을 처리하는 메소드입니다. 현재는 null을 반환합니다.
     * @param token 인증 토큰
     * @param requestDto 사용자 요청 데이터
     * @return 현재는 null을 반환합니다.
     */
    public ItemResponseDto exchangeCall(String token, UserRequestDto requestDto) {
        return null;
    }
}
