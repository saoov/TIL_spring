package org.zerock.board.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.board.entity.Board;
import org.zerock.board.entity.Reply;

import java.util.Optional;
import java.util.stream.IntStream;



@SpringBootTest
public class ReplyRepositoryTests {

    @Autowired
    private ReplyRepository replyRepository;

    /*
    무작위 1~100번 게시글에 300개의 댓글 달기
     */
    @Test
    public void insertReply(){
        IntStream.rangeClosed(1,300).forEach(i->{
           long bno = (long)(Math.random() * 100) + 1; //1부터 100까지 임의의 번호

           Board board = Board.builder().bno(bno).build();

           Reply reply = Reply.builder()
                   .text("Reply....."+i)
                   .board(board)
                   .replyer("guest")
                   .build();
            replyRepository.save(reply);
        });
    }

    @Test
    public void readReply1(){
        Optional<Reply> result = replyRepository.findById(1L);

        Reply reply = result.get();

        System.out.println(reply);
        System.out.println(reply.getBoard());
    }
}
