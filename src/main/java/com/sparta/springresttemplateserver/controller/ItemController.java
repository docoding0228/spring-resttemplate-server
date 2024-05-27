package com.sparta.springresttemplateserver.controller;

import com.sparta.springresttemplateserver.dto.ItemResponseDto;
import com.sparta.springresttemplateserver.dto.UserRequestDto;
import com.sparta.springresttemplateserver.entity.Item;
import com.sparta.springresttemplateserver.service.ItemService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/server")
public class ItemController {

    private final ItemService itemService;

    /**
     * ItemService를 주입받아 초기화합니다.
     * @param itemService 주입될 ItemService 객체
     */
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    /**
     * 아이템 제목(query)을 받아 해당 아이템 객체를 반환합니다.
     * @param query 검색할 아이템 제목
     * @return 검색된 아이템 객체
     */
    @GetMapping("/get-call-obj")
    public Item getCallObject(@RequestParam String query) {
        return itemService.getCallObject(query);
    }

    /**
     * 모든 아이템 리스트를 ItemResponseDto 객체로 반환합니다.
     * @return ItemResponseDto 객체
     */
    @GetMapping("/get-call-list")
    public ItemResponseDto getCallList() {
        return itemService.getCallList();
    }

    /**
     * POST 요청을 처리하여 아이템을 반환합니다.
     * @param query 검색할 아이템 제목
     * @param requestDto 사용자 요청 데이터
     * @return 처리된 아이템 객체
     */
    @PostMapping("/post-call/{query}")
    public Item postCall(@PathVariable String query, @RequestBody UserRequestDto requestDto) {
        return itemService.postCall(query, requestDto);
    }

    /**
     * 인증 토큰과 사용자 요청 데이터를 받아 교환 요청을 처리합니다.
     * @param token 인증 토큰
     * @param requestDto 사용자 요청 데이터
     * @return 처리된 ItemResponseDto 객체
     */

    @PostMapping("/exchange-call")
    public ItemResponseDto exchangeCall(@RequestHeader("X-Authorization") String token, @RequestBody UserRequestDto requestDto) {
        return itemService.exchangeCall(token, requestDto);
    }
}
