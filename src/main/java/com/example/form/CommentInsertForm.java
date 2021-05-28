package com.example.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

/**
 * コメントを投稿する際に利用されるフォーム.
 *
 * @author takahiro.okuma
 *
 */
public class CommentInsertForm {

	/** コメント者名 */
	@NotBlank(message = "名前を入力してください")
	@Size(min = 0, max = 50, message = "名前を50字以内で入力してください")
	private String name;
	/** コメント内容 */
	@NotBlank(message = "コメントを入力してください")
	private String content;
	/** コメントした記事のID */
	@Range(min = 0)
	private Integer articleId;

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "CommentInsertForm [name=" + name + ", content=" + content + ", articleId=" + articleId + "]";
	}

}
