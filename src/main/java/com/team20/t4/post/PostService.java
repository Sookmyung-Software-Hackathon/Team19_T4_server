package com.team20.t4.post;

import com.team20.t4.common.exception.RequestErrorCode;
import com.team20.t4.common.exception.RequestException;
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

    @Transactional
    public PostResponseDto getSinglePost(Long postId) throws RequestException {
        return PostResponseDto.of(getPostOrElseThrowRequestException(postId));
    }

    private Post getPostOrElseThrowRequestException(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new RequestException(RequestErrorCode.NOT_FOUND, "존재하지 않는 글입니다."));
    }

    // 수정

    
    // 삭제
    
    // 리스트 조회
    // 검색 기준 : 위치
    // 정렬 기준 : 최근 수정순
}
