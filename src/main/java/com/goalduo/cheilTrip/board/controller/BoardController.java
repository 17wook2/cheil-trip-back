package com.goalduo.cheilTrip.board.controller;

import com.goalduo.cheilTrip.board.dto.Board;
import com.goalduo.cheilTrip.board.dto.BoardDto;
import com.goalduo.cheilTrip.board.service.BoardService;
import com.goalduo.cheilTrip.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @GetMapping
    public ResponseEntity<?> list(@RequestParam Map<String, String> map) throws Exception {
        List<BoardDto> boards = boardService.searchArticles(map);
        return new ResponseEntity<>(boards,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> writeArticle(@RequestBody Board board,
                                          @RequestHeader("Authorization") String token) {

        boardService.writeArticle(board,token);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{articleNo}")
    public ResponseEntity<?> getArticle(@PathVariable int articleNo){
        Board board = boardService.viewArticle(articleNo);
        return new ResponseEntity<>(board,HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchListBySubject(@RequestParam String subject){
        List<Board> boards = boardService.searchListBySubject(subject);
        return new ResponseEntity<>(boards,HttpStatus.OK);
    }

}
