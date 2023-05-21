package com.model;


public class DVD {
	private String title;
	private int releaseDate;
	private String mpAArating;
	private String directorName;
	private String studioName;
	private String userRating;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(int releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getMpAArating() {
		return mpAArating;
	}
	public void setMpAArating(String mpAArating) {
		this.mpAArating = mpAArating;
	}
	public String getDirectorName() {
		return directorName;
	}
	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}
	public String getStudioName() {
		return studioName;
	}
	public void setStudioName(String studioName) {
		this.studioName = studioName;
	}
	public String getUserRating() {
		return userRating;
	}
	public void setUserRating(String userRating) {
		this.userRating = userRating;
	}
	public DVD(String title, int releaseDate, String mpAArating, String directorName, String studioName,
			String userRating) {
		super();
		this.title = title;
		this.releaseDate = releaseDate;
		this.mpAArating = mpAArating;
		this.directorName = directorName;
		this.studioName = studioName;
		this.userRating = userRating;
	}
	

	public DVD(String title, int releaseDate, String mpAArating, String directorName, String studioName) {
		// TODO Auto-generated constructor stub
		super();
		this.title = title;
		this.releaseDate = releaseDate;
		this.mpAArating = mpAArating;
		this.directorName = directorName;
		this.studioName = studioName;
		this.userRating = "N.A.";
	}
	
	public DVD() {
        System.out.println("Data entered is not complete!");
    }
	
	@Override
	public String toString() {
		return "DVD [title=" + title + ", releaseDate=" + releaseDate + ", mpAArating=" + mpAArating + ", directorName="
				+ directorName + ", studioName=" + studioName + ", userRating=" + userRating + "]";
	}
	
	
	
	
}
