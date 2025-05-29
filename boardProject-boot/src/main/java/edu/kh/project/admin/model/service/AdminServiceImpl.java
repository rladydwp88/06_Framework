package edu.kh.project.admin.model.service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.project.admin.model.mapper.AdminMapper;
import edu.kh.project.board.model.dto.Board;
import edu.kh.project.member.model.dto.Member;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
	
	private final AdminMapper mapper;
	private final BCryptPasswordEncoder bcrypt;
	
	@Override
	public Member login(Member inputMember) {

		Member loginMember = mapper.login(inputMember.getMemberEmail());
		
		if(loginMember == null) {
			return null;
		}
		
		if(!bcrypt.matches(inputMember.getMemberPw(), loginMember.getMemberPw())) {
			return null;
		}
		
		loginMember.setMemberPw(null);
		return loginMember;
		
	}
	
	// 최대 조회수 게시글
	@Override
	public Board maxReadCount() {
		return mapper.maxReadCount();
	}
	
	// 최대 좋아요 수 게시글
	@Override
	public Board maxLikeCount() {
		return mapper.maxLikeCount();
	}
	
	// 최대 댓글 수 게시글
	@Override
	public Board maxCommentCount() {
		return mapper.maxCommentCount();
	}
	
	// 신규가입 회원 조회
	@Override
	public List<Member> memberList() {
		return mapper.memberList();
	}
}
