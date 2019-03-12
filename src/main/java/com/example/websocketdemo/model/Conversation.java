package com.example.websocketdemo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "conversation")
public class Conversation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "create_date")
    @JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime date = LocalDateTime.now();

    @OneToMany(mappedBy = "conversation",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Message> messages;

    @ManyToMany(mappedBy = "conversations")
    private List<Usr> usrs;

    public Conversation() {
    }
}
