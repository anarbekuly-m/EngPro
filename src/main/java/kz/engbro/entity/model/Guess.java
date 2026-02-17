package kz.engbro.entity.model;

import jakarta.persistence.*;
import kz.engbro.entity.enumuration.GuessLevel;

@Entity
@Table(name = "guess")
public class Guess {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "word")
    private String word;

    @Column(name = "guess_word")
    private String guessWord;

    @Column(name = "guess_type")
    @Enumerated(EnumType.STRING)
    private GuessLevel type;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getGuessWord() {
        return guessWord;
    }

    public void setGuessWord(String guessWord) {
        this.guessWord = guessWord;
    }

    public GuessLevel getType() {
        return type;
    }

    public void setType(GuessLevel type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return
               id+"";
    }
}
