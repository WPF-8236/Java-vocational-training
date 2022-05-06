package com.WPF.dao;

import com.WPF.domain.Comment;
import com.WPF.domain.Post;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PostDao {
	List<Post> selectPostListByUId(@Param("u_id") String u_id);

	int insertAPost(Post post);

	int updateAPost(Post post);

	int deletePostByPId(@Param("p_id") String p_id);

	Post selectPostListByPId(@Param("p_id") String p_id);

	List<Post> selectPostListByPPId(@Param("p_p_id") String p_p_id);

	int updatePostStatus(@Param("p_id") String p_id, @Param("tag") String tag);

	void changePostPBrowseCount(@Param("p_id") String p_id);

	void changePostPThumbsCount(@Param("p_id") String p_id);

	int updatePostPCommentCount(Comment comment);
}
