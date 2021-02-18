package org.zerock.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.zerock.board.entity.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

    /*
    특정 bno로 댓글을 삭제하는 메서드
     */
    @Modifying //JPA의 update, delete를 실행하기 위해서는 @Modifying 추가해야 함
    @Query("delete from Reply r where r.board.bno =:bno")
    void deleteByBno(Long bno);
}
