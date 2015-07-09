package midterm;

public class Quote {
	
	public Quote(int id, String author, String description) {
		super();
		this.id = id;
		this.author = author;
		this.description = description;
	}

	private int id;
	
	private String author;
	
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
}
