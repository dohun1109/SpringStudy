package com.ync.QuizApplication.controller;

import com.ync.QuizApplication.entity.Quiz;
import com.ync.QuizApplication.form.QuizForm;
import com.ync.QuizApplication.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/quiz")
public class QuizController {
    //DI 대상
    @Autowired
    QuizService service;

    //form-backing bean 의 초기화
    @ModelAttribute
    public QuizForm serUpForm() {
        QuizForm form = new QuizForm();
        //라디오 버튼의 초깃값 설정
        form.setAnswer(true);
        return form;
    }

    //Quiz 목록 표시
    @GetMapping
    public String showList(QuizForm quizForm, Model model) {
        //신규 등록 설정
        quizForm.setNewQuiz(true);

        //퀴즈 목록 취득
        Iterable<Quiz> list = service.selectAll();

        //표지용 모델에 저장
        model.addAttribute("list", list);
        model.addAttribute("title", "등록 폼");

        return "crud";
    }

    //Quiz 데이터를 1건 등록
    @PostMapping("/insert")
    public String insert(@Validated QuizForm quizForm, BindingResult bindingResult,
                         Model model, RedirectAttributes redirectAttributes) {
        //Form 에서 Entity 로 넣기
        Quiz quiz = new Quiz();
        quiz.setQuestion(quizForm.getQuestion());
        quiz.setAnswer(quizForm.getAnswer());
        quiz.setAuthor(quizForm.getAuthor());

        //입력 체크
        if (!bindingResult.hasErrors()) {
            service.insertQuiz(quiz);
            redirectAttributes.addFlashAttribute("complete", "등록이 완료되었습니다.");
            return "redirect:/quiz";
        }else{
            //에러가 발생한 경우에는 목록 표시로 변경
            return showList(quizForm, model);
        }
    }

    //Quiz 데이터를 1건 취득해서 폼 안에 표시
    @GetMapping("/{id}")
    public String showUpdate(QuizForm quizForm, @PathVariable Integer id, Model model) {
        //Quiz 를 취득(Optional로 래핑)
        Optional<Quiz> quizOpt = service.selectOneById(id);

        //QuizForm에 채워넣기
        Optional<QuizForm> quizFormOpt = quizOpt.map(t -> makeQuizForm(t));

        //QuizForm이 Null 이 아니라면 값을 취득
        if (quizFormOpt.isPresent()) {
            quizForm = quizFormOpt.get();
        }

        //변경용 모델 생성
        makeUpdateModel(quizForm, model);
        return "crud";
    }

    //변경용 모델 생성
    private void makeUpdateModel(QuizForm quizForm, Model model) {
        model.addAttribute("id", quizForm.getId());
        quizForm.setNewQuiz(false);
        model.addAttribute("quizForm", quizForm);
        model.addAttribute("title", "변경 폼");
    }

    //id 를 키로 사용해 데이터를 변경
    @PostMapping("/update")
    public String update(
            @Validated QuizForm quizForm,
            BindingResult result,
            Model model,
            RedirectAttributes redirectAttributes){
        //QuizForm 에서 quiz 로 채우기
        Quiz quiz = makeQuiz(quizForm);
        //입력 체크
        if (!result.hasErrors()) {
            //변경 처리 , Flash scope를 사용해서 리다이렉트 설정
            service.updateQuiz(quiz);
            redirectAttributes.addFlashAttribute("complete", "변경이 완료되었습니다.");
            //변경화면을 표시
            return "redirect:/quiz/"+quiz.getId();
        }else{
            //변경용 모델을 생성
            makeUpdateModel(quizForm,model);
            return "crud";
        }
    }

    //아래는 Form 과 도메인 객체를 다시 채우기
    //QuizForm 에서 quiz 로 다시 채우기, 반환값으로 돌려줌
    private Quiz makeQuiz(QuizForm quizForm) {
        Quiz quiz = new Quiz();
        quiz.setId(quizForm.getId());
        quiz.setQuestion(quizForm.getQuestion());
        quiz.setAnswer(quizForm.getAnswer());
        quiz.setAuthor(quizForm.getAuthor());
        return quiz;
    }

    //Quiz에서 QuizForm으로 다시 채우기 , 반환값으로 돌려줌
    private QuizForm makeQuizForm(Quiz quiz) {
        QuizForm form = new QuizForm();
        form.setId(quiz.getId());
        form.setQuestion(quiz.getQuestion());
        form.setAnswer(quiz.getAnswer());
        form.setAuthor(quiz.getAuthor());
        form.setNewQuiz(false);
        return form;
    }

    @PostMapping("/delete")
    public String delete(
            @RequestParam("id") String id,
            Model model,
            RedirectAttributes redirectAttributes){

        //퀴즈 정볼르 1건 삭제하고 리다이렉트
        service.deleteQuizById(Integer.parseInt(id));
        redirectAttributes.addFlashAttribute("delcomplete","삭제완료했습니다.");
        return "redirect:/quiz";
    }

    //quiz 데이터를 랜덤으로 한 건 가져와 화면에 표시
    @GetMapping("/play")
    public String showQuiz(QuizForm quizForm, Model model) {
        //quiz 정보 취득(Optional 으로 래핑
        Optional<Quiz> quizOpt = service.selectOneRandomQuiz();

        //값이 있는지 확인
        if (quizOpt.isPresent()) {
            //quizForm 으로 채우기
            Optional<QuizForm> quizFormOpt = quizOpt.map(t -> makeQuizForm(t));
            quizForm = quizFormOpt.get();
        }else{
            model.addAttribute("msg", "등록된 문제가 없습니다.");
            return "index";
        }

        //표시용 모델에 저장
        model.addAttribute("quizForm", quizForm);

        return "index";
    }

    //퀴즈의 정답/오판 판단
    @PostMapping("/check")
    public String checkQuiz(QuizForm quizForm, @RequestParam boolean answer, Model model) {
        if (service.checkQuiz(quizForm.getId(), answer)) {
            model.addAttribute("msg","정답입니다.");
        }else {
            model.addAttribute("msg","오답입니다.");
        }
        return "answer";
    }

    @GetMapping("/main")
    public String mainhtml(){
        return "index";
    }

    @GetMapping("/table")
    public String tablehtml(){
        return "tables";
    }





}
