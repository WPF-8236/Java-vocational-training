package com.WPF.dao;

import com.WPF.domain.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentDao {
	List<Comment> selectCommentListByPId(@Param("p_id") String p_id);

	int insertAComment(Comment comment);
}
