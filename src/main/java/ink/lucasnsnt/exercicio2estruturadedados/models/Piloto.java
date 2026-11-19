package ink.lucasnsnt.exercicio2estruturadedados.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
public class Piloto {

    private LocalDateTime dataHora;

    private String nome;

    private String equipe;

    private LocalTime tempo;




}
