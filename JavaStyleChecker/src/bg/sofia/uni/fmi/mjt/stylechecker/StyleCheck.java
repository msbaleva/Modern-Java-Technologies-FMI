package bg.sofia.uni.fmi.mjt.stylechecker;

public abstract class StyleCheck {

	private String comment;

	protected StyleCheck(String comment) {
		this.comment = comment;
	}

	public String getComment() {
		return comment;
	}

	public abstract boolean hasError(String line);

}
