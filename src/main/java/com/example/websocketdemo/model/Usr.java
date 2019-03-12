package com.example.websocketdemo.model;

import com.example.websocketdemo.model.Conversation;
import com.example.websocketdemo.model.Message;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@Table(name = "usr")
public class Usr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "usr",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Message> messages;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,//TODO
            CascadeType.MERGE
    })
    @JoinTable(name = "usr_conversation",
            joinColumns = @JoinColumn(name = "usr_id"),
            inverseJoinColumns = @JoinColumn(name = "conversation_id")
    )
    private List<Conversation> conversations;

    public Usr() {
    }
}
