package com.ync.QuizApplication.service;

import com.ync.QuizApplication.entity.Quiz;
import com.ync.QuizApplication.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class QuizServiceImpl implements QuizService {

    //Repository : 인젝션
    @Autowired
    QuizRepository repository;

    @Override
    public Iterable<Quiz> selectAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Quiz> selectOneById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Quiz> selectOneRandomQuiz() {
        //랜덤으로 id값을 가져오기
        Integer randId = repository.getRandomId();

        //퀴즈가 없는 경우
        if (randId == null) {
            return Optional.empty();
        }
        return repository.findById(randId);
    }

    @Override
    public Boolean checkQuiz(Integer id, boolean myAnswer) {
        // 퀴즈 정답 / 오답 판단용 변수
        Boolean check = false;

        //대상 퀴즈를 가져오기
        Optional<Quiz> optQuiz = repository.findById(id);

        //퀴즈를 가져왔는지 확인
        if (optQuiz.isPresent()) {
            Quiz quiz = optQuiz.get();
            //퀴즈 정답확인
            if (quiz.getAnswer().equals(myAnswer)) {
                check = true;
            }
        }
        return check;
    }

    @Override
    public void insertQuiz(Quiz quiz) {
        repository.save(quiz);

    }

    @Override
    public void updateQuiz(Quiz quiz) {
        repository.save(quiz);

    }

    @Override
    public void deleteQuizById(Integer id) {
        repository.deleteById(id);
    }
}
