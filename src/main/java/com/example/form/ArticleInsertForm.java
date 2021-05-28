package com.example.form;

/**
 * 記事を投稿する際に利用されるフォーム.
 *
 * @author takahiro.okuma
 *
 */
public class ArticleInsertForm {

	/** 投稿者名 */
	private String name;
	/** 投稿内容 */
	private String content;

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
		return "ArticleInsertForm [name=" + name + ", content=" + content + "]";
	}

}
