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
     *
     * @param query 검색할 아이템 제목
     * @return 검색된 아이템 객체 또는 null
     * 하나의 아이템만 받아올 때 사용.
     */
    public Item getCallObject(String query) {
        for (Item item : itemList) {
            if (item.getTitle().equals(query)) {
                return item;
            }
        }
        return null;
    }

    /**
     * 모든 아이템 리스트를 ItemResponseDto 객체로 반환합니다.
     *
     * @return ItemResponseDto 객체
     * 여러 개의 아이템을 받아올 때 사용
     */
    public ItemResponseDto getCallList() {
        ItemResponseDto responseDto = new ItemResponseDto();
        for (Item item : itemList) {
            responseDto.setItems(item);
        }
        return responseDto;
    }

    /**
     * 사용자 요청 정보를 받아 특정 아이템을 반환합니다.
     *
     * @param query          검색할 아이템 제목
     * @param userRequestDto 사용자 요청 데이터
     * @return 검색된 아이템 객체 또는 null
     */
    public Item postCall(String query, UserRequestDto userRequestDto) {
        System.out.println("userRequestDto.getUsername() = " + userRequestDto.getUsername());
        System.out.println("userRequestDto.getPassword() = " + userRequestDto.getPassword());

        return getCallObject(query);
    }

    /**
     * 인증 토큰과 사용자 요청 데이터를 받아 아이템 리스트를 반환합니다.
     *
     * @param token       인증 토큰
     * @param requestDto 사용자 요청 데이터
     * @return ItemResponseDto 객체
     */

    public ItemResponseDto exchangeCall(String token, UserRequestDto requestDto) {
        System.out.println("token = " + token);
        System.out.println("requestDto.getUsername() = " + requestDto.getUsername());
        System.out.println("requestDto.getPassword() = " + requestDto.getPassword());

        return getCallList();
    }
}
