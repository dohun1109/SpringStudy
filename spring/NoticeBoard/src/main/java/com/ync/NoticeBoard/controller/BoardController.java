package com.ync.NoticeBoard.controller;



import com.ync.NoticeBoard.model.Board;
import com.ync.NoticeBoard.repository.BoardRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;

@Controller
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardRepository boardRepository;

    @GetMapping
    public String boards(Model model) {
        List<Board> boards = boardRepository.findAll();
        model.addAttribute("boards", boards);
        return "/boards";
    }


    @GetMapping("{boardId}")
    public String board(@PathVariable long boardId, Model model) {
        Board board = boardRepository.findById(boardId);
        model.addAttribute("board", board);
        return "/board";
    }

    @GetMapping("/add")
    public String addForm() {
        return "/addForm";
    }

    @PostMapping("/add")
    public String addBoard(Board board, RedirectAttributes redirectAttributes) {
        Board savedBoard = boardRepository.save(board);
        redirectAttributes.addAttribute("boardId", savedBoard.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/boards/{boardId}";
    }


    // 상품 수정
    @GetMapping("/{boardId}/edit")
    public String editForm(@PathVariable Long boardId, Model model) {
        Board board = boardRepository.findById(boardId);
        model.addAttribute("board", board);
        return "/editForm";
    }

    @PostMapping("/{boardId}/edit")
    public String edit(@PathVariable Long boardId, @ModelAttribute Board board) {
        boardRepository.update(boardId, board);
        return "redirect:/boards/{boardId}";
    }

    //Test용 아이템 추가
    @PostConstruct
    public void init() {
        boardRepository.save(new Board("제목1", "내용1"));
        boardRepository.save(new Board("제목2", "내용2"));

    }
}