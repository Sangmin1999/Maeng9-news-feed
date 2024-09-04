package com.sparta.maeng9newsfeed.entity;

import com.sparta.maeng9newsfeed.dto.FriendResponse;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "friend_demands")
public class FriendDemand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id", name = "sender_id", nullable = false)
    private User sender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id", name = "receiver_id", nullable = false)
    private User receiver;

    public FriendDemand(User sender, User receiver) {
        this.sender = sender;
        this.receiver = receiver;
    }

    public FriendResponse toResponse(){
        return new FriendResponse(
                this.getReceiver().getUserName(),
                this.getReceiver().getEmail()
        );
    }
}
