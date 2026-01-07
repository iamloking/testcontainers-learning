package com.lokidev.oneliner.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(
        name = "one_liners",
        uniqueConstraints = @UniqueConstraint(columnNames = {"text", "author"})
)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class OneLiner {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(nullable = false, length = 300)
    private String text;

    @Column(nullable = false, length = 100)
    private String author;

    @Column(nullable = false, length = 100)
    private String context;

    public OneLiner(String text, String author, String context) {
        this.text = text;
        this.author = author;
        this.context = context;
    }
}
