package com.ssun.cardquiz.springboot.domain.posts;
//실제 DB테이블과 매칭될 클래스. 보통 entity 클래스라 칭함
//데이터 변경하고 싶을 땐 dto클래스 이용
import com.ssun.cardquiz.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter //getter메소드 자동생성
@NoArgsConstructor //기본생성자 자동 추가
@Entity // 테이블과 링크될 클래스임을 나타냄
//기본 값으로 클래스의 카멜케이스이름을 언더스코어 네이밍으로 테이블을 매칭한다.
//주요 어노테이션을 클래스와 가깝게 위치
public class Posts extends BaseTimeEntity {
    @Id //해당필드의 PK 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK 생성규칙 auto_increment 적용
    private Long id;

    @Column(length = 500, nullable = false) //테이블의 칼럼
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    //칼럼 애노테이션 없이 default : length=255
    private String author;

    @Builder // 해당클래스의 빌더 패턴 클래스 생성
    // 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    //글 수정 위한 method
    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }


}
