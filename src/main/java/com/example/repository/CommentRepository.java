package com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Comment;

/**
 * コメントテーブルを操作するリポジトリ.
 *
 * @author takahiro.okuma
 *
 */
@Repository
public class CommentRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	private static String TABLE_COMMENTS = "comments";

	/**
	 * コメントを新たにDBに登録する.
	 *
	 * @param comment 登録したいコメントドメイン
	 */
	public void insert(Comment comment) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(comment);
		String sql = "INSERT INTO " + TABLE_COMMENTS + " (name,content,article_id) VALUES (:name,:content,:articleId);";
		template.update(sql, param);
	}
}
