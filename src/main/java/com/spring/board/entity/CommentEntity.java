package com.spring.board.entity;

import com.spring.board.dto.BoardDTO;
import com.spring.board.dto.CommentDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "comment_table")
public class CommentEntity extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 20, nullable = false)
  private String commentWriter;

  @Column
  private String commentContents;

  /* Board:Comment = 1:N */
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "board_id")
  private BoardEntity boardEntity;


  public static CommentEntity toSaveEntity(CommentDTO commentDTO, BoardEntity boardEntity) {
    CommentEntity commentEntity = new CommentEntity();
    commentEntity.setCommentWriter(commentDTO.getCommentWriter());
    commentEntity.setCommentContents(commentDTO.getCommentContents());
    commentEntity.setBoardEntity(boardEntity);
    return commentEntity;
  }
}
