package com.example.quiz.model;

public class Response {
	
	private Integer id;
	private String response;
	
	
	
	/**
	 * @param id
	 * @param response
	 */
	public Response(Integer id, String response) {
		super();
		this.id = id;
		this.response = response;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}

}
