package com.team20.t4.post;

import com.team20.t4.common.exception.RequestErrorCode;
import com.team20.t4.common.exception.RequestException;
import com.team20.t4.member.MemberService;
import com.team20.t4.member.domain.Member;
import com.team20.t4.plan.PlanService;
import com.team20.t4.plan.domain.Location;
import com.team20.t4.plan.domain.Plan;
import com.team20.t4.plan.domain.PlanRepository;
import com.team20.t4.plan.dto.AppointmentSimpleResponseDto;
import com.team20.t4.plan.dto.ListAppointmentSimpleResponseDto;
import com.team20.t4.plan.dto.RegisterHistorySaveRequestDto;
import com.team20.t4.post.domain.Post;
import com.team20.t4.post.domain.PostRepository;
import com.team20.t4.post.dto.PostResponseDto;
import com.team20.t4.post.dto.PostSaveRequestDto;
import com.team20.t4.post.dto.PostSaveRequestVo;
import com.team20.t4.post.dto.PostUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;
    private final MemberService memberService;
    private final PlanService planService;
    private final PlanRepository planRepository;

    @Transactional
    public Long savePost(PostSaveRequestDto requestDto){
        Member loginedMember = memberService.getLoginedMember();
        Plan plan = planService.createPlan(requestDto.getPlan(), loginedMember);
        planService.sendAppointmentRequestOfWriter(new RegisterHistorySaveRequestDto(loginedMember, plan));

        PostSaveRequestVo saveRequestVo = PostSaveRequestVo.of(requestDto);
        saveRequestVo.updateWriter(loginedMember);
        saveRequestVo.updatePlan(plan);
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

    @Transactional
    public Long updatePost(Long postId, PostUpdateRequestDto requestDto) throws RequestException{
        Member loginedMember = memberService.getLoginedMember();
        Plan plan = planService.updatePlan(getPost(postId).getPlan().getId(), requestDto.getPlan());
        Post post = requestDto.toEntity(postId);
        post.updatePlan(plan);
        post.updateWriter(loginedMember);
        Post updatedPost = postRepository.save(post);
        return updatedPost.getId();
    }

    private Post getPost(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new RequestException(RequestErrorCode.NOT_FOUND, "요청한 Post가 존재하지 않습니다."));
    }

    @Transactional
    public void deletePost(Long postId){
        // plan이 진행중이면 plan도 삭제
        // plan이 완료이면 plan은 삭제하지 않음
        postRepository.deleteById(postId);
    }

    @Transactional
    public ListAppointmentSimpleResponseDto getPostListWrittenByMe(){
        Member loginedMember = memberService.getLoginedMember();
        List<AppointmentSimpleResponseDto> responseDtoList = new ArrayList<>();
        List<Post> postList = postRepository.findAllByWriter(loginedMember);
        for(Post post:postList){
            responseDtoList.add(new AppointmentSimpleResponseDto(post, post.getPlan()));
        }
        return new ListAppointmentSimpleResponseDto(responseDtoList);
    }


    // 리스트 조회
    // 검색 기준 : 위치
    // 정렬 기준 : 최근 수정순
    @Transactional
    public ListAppointmentSimpleResponseDto getPostListByLocation(Location location){
        log.info(location.getGu().getValue());
        List<AppointmentSimpleResponseDto> responseDtoList = new ArrayList<>();
        List<Plan> planList = planRepository.findAllByLocation(location);
        for(Plan plan:planList){
            responseDtoList.add(new AppointmentSimpleResponseDto(plan.getPost(), plan));
        }
        return new ListAppointmentSimpleResponseDto(responseDtoList);
    }

}
