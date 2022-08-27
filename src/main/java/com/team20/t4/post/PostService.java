package com.team20.t4.post;

import com.team20.t4.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;
    private final MemberService memberService;

    @Transactional
    public Long savePost(PostSaveRequestDto requestDto){
        // plan을 requestDto에서 가져오기

        PostSaveRequestVo saveRequestVo = PostSaveRequestVo.of(requestDto);
        saveRequestVo.updateWriter(memberService.getLoginedMember());
        Post savedPost = postRepository.save(saveRequestVo.toEntity());
        return savedPost.getId();
    }

    // 조회


    
    // 수정
    
    // 삭제
    
    // 리스트 조회
    // 검색 기준 : 위치
    // 정렬 기준 : 최근 수정순
}
