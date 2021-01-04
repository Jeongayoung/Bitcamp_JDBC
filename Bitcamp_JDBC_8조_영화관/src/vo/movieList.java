package vo;

import java.sql.Date;


public class movieList {
private String moviename;
private Date mdate;
private String section;
private String time;
private String director;
private String actor;

public movieList() {
	
}
public movieList(String moviename, Date mdate, String section, String time, String director, String actor) {
	super();
	this.moviename = moviename;
	this.mdate = mdate;
	this.section = section;
	this.time = time;
	this.director = director;
	this.actor = actor;
}
public String getMoviename() {
	return moviename;
}
public void setMoviename(String moviename) {
	this.moviename = moviename;
}
public Date getMdate() {
	return mdate;
}
public void setMdate(Date mdate) {
	this.mdate = mdate;
}
public String getSection() {
	return section;
}
public void setSection(String section) {
	this.section = section;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
public String getDirector() {
	return director;
}
public void setDirector(String director) {
	this.director = director;
}
public String getActor() {
	return actor;
}
public void setActor(String actor) {
	this.actor = actor;
}
@Override
public String toString() {
	return "상영정보 [제목=" + moviename + ", 시간" + mdate + ", 장르" + section + ", 런타임" + time
			+ ", 감독" + director + ", 출연" + actor + "]";
}



}
