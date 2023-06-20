package kr.co.tjoeun.bean;

import lombok.Data;

@Data
public class ContentTable {
	private int contentIdx;
	private String contentSubject;
	private String contentText;
	private String contentFile;
	private int contentWriterIdx;
	private int contentBoardIdx;
	private String contentDate;
}
