package project.vilsoncake.BookOnlineStore.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_avatar")
public class UserAvatarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long avatarId;
    @Column(name = "byte_array")
    @Lob
    private byte[] byteArray;
    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public UserAvatarEntity() {}

    public UserAvatarEntity(byte[] byteArray, UserEntity user) {
        this.byteArray = byteArray;
        this.user = user;
    }

    public byte[] getByteArray() {
        return byteArray;
    }

    public void setByteArray(byte[] byteArray) {
        this.byteArray = byteArray;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
